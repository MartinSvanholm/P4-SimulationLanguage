package Visitors;

import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.*;
import ASTNodes.Identifier.ObjIdNode;
import ASTNodes.Identifier.SimpleIdNode;
import ASTNodes.Identifier.ThisIdNode;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.OpNode;
import ASTNodes.ValueNodes.StringNode;
import ASTVisitors.BaseVisitor;
import Main.CodeGenIO;
import Main.Error;
import Main.ErrorHandler;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.Symbol;
import VisitorHelpers.TypeCheckHelper;
import hu.webarticum.treeprinter.SimpleTreeNode;

import java.util.ArrayList;

public class CodeGenerationVisitor extends BaseVisitor<String> {
    /* ---------------------------List af ting der mangler---------------------------
    - Lister er basically færdige

    - Environment delen er jeg igang med.
        - Det er ret cancer at splitte op i typer atm, siden der ikke er dedikeret sections til dem.
            - ListDcl bliver nu splittet rigtigt op.
            - Der er mange semicoloner, fordi at den checker igennem HELE behaivour hver gang vi visiter den... sjovt nok
            - Jeg har splittet dem op i Declarations, men ved ikke rigtigt om det er muligt at gøre med assignment
            og functionskald som vi gør det nu...
    - Har ikke testet Update delen endnu, siden vi har en lidt gamle version af type checker osv.
    - Eller virker resten overraskende godt xd.
     */

    private GlobalSymbolTable globalSymbolTable;

    private TypeCheckHelper helper;
    private String currSection = "";
    private String currEnviCheck = "";
    private String scopeName = "Global";
    private  String prevScopeName = "";

    private  ArrayList<String> nodeMethods = new ArrayList<>();
    private  ArrayList<String> vehicleMethods = new ArrayList<>();
    private  ArrayList<String> roadMethods = new ArrayList<>();

    private ArrayList<String> nodeTypes = new ArrayList<>();
    private ArrayList<String> roadTypes = new ArrayList<>();
    private ArrayList<String> vehicleTypes = new ArrayList<>();

    public CodeGenerationVisitor(ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
        this.globalSymbolTable = globalSymbolTable;
        this.helper = new TypeCheckHelper(errorHandler, globalSymbolTable);
    }
    @Override
    public String visitProgramNode(ProgramNode programNode) {
        CodeGenIO io = new CodeGenIO();

        String output = io.ReadFile("Header.txt");

        output += visit(programNode.Behavior);

        output += setupAbstractClasses("Node");
        output += setupAbstractClasses("Road");
        output += setupAbstractClasses("Vehicle");


        output += "\n" +
                "    class Program {\n" +
                "        static void Main(string[] args) {\n" +
                "            Sim Simulation = new Sim();\n" +
                "            Random Rand = new Random();";

        currEnviCheck = "";
        output += visit(programNode.Environment);

        output +=        "            Output output = new Output();\n" +
                "\n" +
                "            while(!EndCondition()) {\n" +
                "                InitVehicles();\n" +
                "                foreach(Vehicle vehicle in Simulation.VehicleList) {";

        output += visit(programNode.Update);

        output += "                    output.Run();\n" +
                "\n" +
                "                }\n" +
                "                Simulation.CurrentTick++;\n" +
                "            }\n" +
                "            output.LogToFile();\n" +
                "\n" +
                "            void InitVehicles() {";
        //Environment (Vehicle init (based on each type))
        currEnviCheck = "initcondition";
        output += visit(programNode.Environment);
        output += "            }\n" +
                "\n" +
                "            bool EndCondition() {";
        //Environment (EndCondition)
        currEnviCheck = "endcondition";
        output += visit(programNode.Environment);


        //<---------Evironment Section End --------->

        output += "            }\n" +
                "        }\n" +
                "        \n" +
                "        public class Output {\n" +
                "            public string fileName = DateTime.Now.ToString(); //Foreslag\n" +
                "            public List<string> dataList = new List<string>();\n" +
                "\n" +
                "            public void Run() {\n" +
                "                string data = \"\";";

        output += visit(programNode.Output);

        output += "                dataList.Add(data);\n" +
                "        }\n" +
                "\n" +
                "            public void LogToFile() {\n" +
                "                //Logic der logger \"dataList\" listen til en fil med navn \"fileName\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        return output;
    }

    @Override
    public String visitSectionNode(SectionNode sectionNode){
        prevScopeName = scopeName;
        scopeName = sectionNode.Name;
        System.out.println("Curr Scope: " + scopeName);

        String output = "";
        System.out.println("Section:) : " + sectionNode.Name);
        currSection = sectionNode.Name;

        for(Node line : sectionNode.Lines) {
            if (sectionNode.Name.equals("Environment")) {
                switch (currEnviCheck) {
                    case "initcondition":
                        if (line.getClass() == InitConditionNode.class) {
                            output += visit(line);
                        }
                        break;
                    case "endcondition":
                        if (line.getClass() == EndConditionNode.class) {
                            output += visit(line);
                        }
                        break;
                    default:
                        if (!(line.getClass() == InitConditionNode.class || line.getClass() == EndConditionNode.class)){
                            //Det her virker teknisk set... Hvis vi får tid skal det fixes så det er turbo ulovligt!!!!!
                            output += visit(line) + ";";
                        }
                        break;
                }
            } else {
                output += visit(line);
                //DET HER ER PÆNT FUCKING GAY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                if (line.getClass().toString().equals("class ASTNodes.ExprNodes.FunctionCallNode")){
                    output += ";";
                }
            }
        }

        scopeName = prevScopeName;
        return output;
    }

    @Override
    public String visitEndCondition(EndConditionNode endConditionNode) {
        return visit(endConditionNode.Body);
    }

    @Override
    public String visitInitCondition(InitConditionNode initConditionNode) {
        return visit(initConditionNode.Body);
    }

    @Override
    public String visitFunctionNode(FunctionDclNode functionDclNode) {
        prevScopeName = scopeName;
        scopeName = functionDclNode.Identifier.Name;
        String savedStr = "";
        String output = "";

        if(currSection.equals("Behavior")){
            savedStr += "virtual ";
        }

        if(functionDclNode.Type == null) {
            output += "void ";
        } else {
            if (visit(functionDclNode.Type).equals("number")) {
                output += "float ";
            } else {
                output += visit(functionDclNode.Type) + " ";
            }
        }

        output += visit(functionDclNode.Identifier) + "(";

        int parAmount = functionDclNode.Parameters.size();
        int currPar = 1;

        for (Node params : functionDclNode.Parameters) {
            output += visit(params);
            if (currPar < parAmount) {
                output += ",";
            }

            currPar++;
        }

        output += "){";

        if (currSection.equals("Behavior")) {
            savedStr += output;
            output = "override " + output;
            if(!visit(functionDclNode.Type).equals("void")){
                switch (visit(functionDclNode.Type)) {
                    case "number":
                        savedStr += "return 0f;";
                        break;
                    case "bool":
                        savedStr += "return false;";
                        break;
                    case "string":
                        savedStr += "return \"\";";
                        break;
                    default:
                        savedStr += "return null;";
                        break;
                }
            }

            savedStr += "}";


            switch (helper.FindTableByName(globalSymbolTable, prevScopeName, 0).Type){
                case "Vehicle":
                    if (!vehicleMethods.contains("public " + savedStr)) vehicleMethods.add("public " + savedStr);
                    break;
                case "Node":
                    if (!nodeMethods.contains("public " + savedStr)) nodeMethods.add("public " + savedStr);
                    break;
                case "Road":
                    if (!roadMethods.contains("public " + savedStr)) roadMethods.add("public " + savedStr);
                    break;
                default:
                    System.out.println("Shit broke");
                    break;
            }

        }

        output += visit(functionDclNode.Body) + "}";

        scopeName = prevScopeName;
        return "public " + output;
    }

    @Override
    public String visitListNode(ListDclNode listDclNode) {
        String output = "";
        String type = helper.GetSymbolByScopeName(visit(listDclNode.Identifier), scopeName).ActualType;

        System.out.println("LISTTING");
        System.out.println("curr: " + scopeName);
        System.out.println("prev: " + prevScopeName);
        if(vehicleTypes.contains(scopeName) || nodeTypes.contains(scopeName) || roadTypes.contains(scopeName)) {
            output += "public ";
        }

        if (visit(listDclNode.Type).equals("number")){
            type = "float";
        } else{
            type = visit(listDclNode.Type);
        }

        output += type + "[] ";
        output += visit(listDclNode.Identifier) + " = new " + type + "[] ";


        int parAmount = listDclNode.Parameters.size();
        int currPar = 1;

        output += "{";
        for (Node params : listDclNode.Parameters) {
            output += visit(params);
            if (currPar < parAmount) {
                output += ",";
            }

            currPar++;
        }

        if(vehicleTypes.contains(scopeName) && !vehicleMethods.contains(output + "};")) {
            vehicleMethods.add(output + "};");
        } else if(nodeTypes.contains(scopeName) && !nodeMethods.contains(output + "};")) {
            nodeMethods.add(output + "};");
        } else if(roadTypes.contains(scopeName) && !roadMethods.contains(output + "};")) {
            roadMethods.add(output + "};");
        }

        return output + "};";
        }

    @Override
    public String visitClassNode(ClassNode classNode) {
        prevScopeName = scopeName;
        scopeName = classNode.Identifier.Name;

        switch (visit(classNode.Type)) {
            case "Road":
                roadTypes.add(visit(classNode.Identifier));
                break;
            case "Vehicle":
                vehicleTypes.add(visit(classNode.Identifier));
                break;
            case "Node":
                nodeTypes.add(visit(classNode.Identifier));
                break;
            default:
                System.out.println("ShitBroke");
                break;
        }

        String output = "public class " + visit(classNode.Identifier);

        output += ":" + visit(classNode.Type) + "{";

        output += visit(classNode.Body);

        scopeName = prevScopeName;
        return output + "}";
    }

    @Override
    public String visitConstructorNode(ConstructorDclNode constructorDclNode) {
        String output = "public " + visit(constructorDclNode.Type);

        int parAmount = constructorDclNode.Parameters.size();
        int currPar = 1;

        output += "(";
        for (Node params : constructorDclNode.Parameters) {
            output += visit(params);
            if (currPar < parAmount) {
                output += ",";
            }

            currPar++;
        }
        output += "){";

        output += visit(constructorDclNode.Body);

        return output + "}";
    }

    //Environment delen af den her kan godt optimeres lidt, så der ikke er redundant kode (lidt som det er gjort i ListDcl).
    @Override
    public String visitObjDcl(ObjDclNode objDclNode) {
        String output = "";
        /*if(currSection.equals("Environment")) {
            if (CheckType(visit(objDclNode.Type))) {
                output += visit(objDclNode.Type) + " " + visit(objDclNode.Identifier);

                if (objDclNode.ObjValue != null) {
                    output += " = " + visit(objDclNode.ObjValue);
                }
            }
            return output + ";";
        }*/

        System.out.println("curr: " + scopeName);
        System.out.println("prev: " + prevScopeName);

        if(vehicleTypes.contains(scopeName) || nodeTypes.contains(scopeName) || roadTypes.contains(scopeName)) {
            output += "public ";
        }

        if (visit(objDclNode.Type).equals("number")) {
            output += "float ";
        } else {
            output += visit(objDclNode.Type) + " ";
        }

        output += visit(objDclNode.Identifier);

        if (objDclNode.ObjValue != null) {
            if (visit(objDclNode.Type).equals("number") && objDclNode.ObjValue.getClass().toString().equals("class ASTNodes.ValueNodes.NumberNode")) {
                output += " = " + visit(objDclNode.ObjValue) + "f";
            } else {
                output += " = " + visit(objDclNode.ObjValue);
            }
        }

        if(vehicleTypes.contains(scopeName) && !vehicleMethods.contains(output + ";")) {
            vehicleMethods.add(output + ";");
        } else if(nodeTypes.contains(scopeName) && !nodeMethods.contains(output + ";")) {
            nodeMethods.add(output + ";");
        } else if(roadTypes.contains(scopeName) && !roadMethods.contains(output + ";")) {
            roadMethods.add(output + ";");
        }


        return output + ";";
    }

    @Override
    public String visitIfElseNode(IfElseNode ifElseNode) {
        String output = "if(" + visit(ifElseNode.condition) + "){";

        output += visit(ifElseNode.Body) + "}";

        if (ifElseNode.ElseIf != null) {
            output += visit(ifElseNode.ElseIf);
        }

        return output;
    }
    @Override
    public String visitElseIfNode(ElseIfNode elseIfNode) {
        String output = "else";
        if (elseIfNode.condition != null) {
            output += " if(" + visit(elseIfNode.condition) + ")";
        }
        output += "{" + visit(elseIfNode.Body) + "}";

        if (elseIfNode.ElseIf != null) {
            output += visit(elseIfNode.ElseIf);
        }

        return output;
    }

    @Override
    public String visitSwitchNode(SwitchNode switchNode) {

        String output = "";
        String switchValue = visit(switchNode.switchValue);

        if (switchValue.contains(".Type")) {
            output += "string[] tempArr = vehicle.GetType().ToString().Split(\".\"); \n";
            output += "string type = tempArr[tempArr.Length - 1]; \n";
            switchValue = "type";
        }

        output += "switch(" + switchValue + "){";
        return output + visit(switchNode.Body) + "}";
    }

    @Override
    public String visitSwitchBodyNode(SwitchBody switchBody){
        String output = "";
        for (Node cases : switchBody.cases) {
            output += visit(cases);
        }

        return output;
    }

    @Override
    public String visitCaseNode(CaseNode caseNode) {
        String output = "";
        if (visit(caseNode.switchValue).equals("default")){
            output += visit(caseNode.switchValue) + ": ";
        } else if (vehicleTypes.contains(visit(caseNode.switchValue)) || nodeTypes.contains(visit(caseNode.switchValue)) || roadTypes.contains(visit(caseNode.switchValue))){
            output = "case \"" + visit(caseNode.switchValue) + "\": ";
        } else {
            output = "case " + visit(caseNode.switchValue) + ": ";
        }


        //String output = "case " + visit(caseNode.switchValue) + ": ";




        return output + visit(caseNode.CaseBody) + " break;";
    }

    @Override
    public String visitForLoopNode(ForLoopNode forLoopNode) {
        String type = visit(forLoopNode.TypeNode);
        String output = "foreach(";

        if(type.equals("number")) {
            output += "float ";
        } else {
            output += type + " ";
        }

        output += visit(forLoopNode.identifier) + " in " + visit(forLoopNode.rangeIdentifier) + "){";

        output += visit(forLoopNode.Body);

        return output + "}";
    }

    @Override
    public String visitWhileLoopNode(WhileLoopNode whileLoopNode) {
        String output = "while(" + visit(whileLoopNode.condition) + "){";
        return output + visit(whileLoopNode.Body) + "}";
    }

    @Override
    public String visitAssignmentNode(AssignmentNode assignmentNode) {
        String type = "";
        if (currSection.equals("Environment")) {
            if(visit(assignmentNode.Identifier).contains(".")) {
                String tempStr = visit(assignmentNode.Identifier);
                String[] str = tempStr.split("\\.");
                type = helper.GetSymbolByScopeName(str[str.length - 2], scopeName).ActualType;
            } else {
                type = helper.GetSymbolByScopeName(visit(assignmentNode.Identifier), scopeName).ActualType;
            }
        }

        return visit(assignmentNode.Identifier) + " " + visit(assignmentNode.Equals) + " " + visit(assignmentNode.ValueNode) + ";";
    }

    @Override
    public String visitArrayExprNode(ArrayExprNode arrayExprNode) {
        return visit(arrayExprNode.Left) + "[" + visit(arrayExprNode.Index) + "]";
    }

    @Override
    public String visitCompareNode(CompareNode compareNode) {
        return visit(compareNode.Left) + visit(compareNode.Operator) + visit(compareNode.Right);
    }

    @Override
    public String visitFunctionCallNode(FunctionCallNode functionCallNode) {
        String output = "";
        boolean breakBool = false;

        if (visit(functionCallNode.Identifier).contains(".")) {
            String[] strs = visit(functionCallNode.Identifier).split("\\.");
            String[] newStr = new String[2];
            String temp = "";

            for (int i = 0; i < strs.length - 1; i++) {
                if(i != 0){
                    temp += ".";
                }
                temp += strs[i];
            }

            newStr[0] = temp;
            newStr[1] = strs[strs.length-1];

            //if(!functionCallNode.Identifier.Name.contains("Simulation")) {
                switch (newStr[1]) {
                    case "Add":
                        output += AddToList(functionCallNode, newStr[0]);
                        break;
                    case "Remove":
                        output += RemoveFromList(functionCallNode, strs[strs.length - 2]);
                        break;
                    default:
                        if(visit(functionCallNode.Identifier).equals("Simulation.Print")){
                            return output + PrintFunction(functionCallNode);
                        }

                        if(visit(functionCallNode.Identifier).equals("Simulation.Random")){
                            return output + RandomFunction(functionCallNode);
                        }

                        //Det her er super fucking redundant
                        output = visit(functionCallNode.Identifier) + "(";

                        int parAmount = functionCallNode.Parameters.size();
                        int currPar = 1;

                        for (Node params : functionCallNode.Parameters) {
                            output += visit(params);
                            if (currPar < parAmount) {
                                output += ",";
                            }

                            currPar++;
                        }

                        return output + ")";
                }



                return output;
            //}
        }


        output = visit(functionCallNode.Identifier) + "(";

        int parAmount = functionCallNode.Parameters.size();
        int currPar = 1;

        for (Node params : functionCallNode.Parameters) {
            output += visit(params);
            if (currPar < parAmount) {
                output += ",";
            }

            currPar++;
        }

        return output + ")";
    }

    @Override
    public String visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        String output = "new " + visit(constructorCallNode.Type) + "(";

        int parAmount = constructorCallNode.Parameters.size();
        int currPar = 1;

        for (Node params : constructorCallNode.Parameters) {
            output += visit(params);
            if (currPar < parAmount) {
                output += ",";
            }

            currPar++;
        }

        return output + ")";
    }

    //Please lav det her til en switch senere....
    @Override
    public String visitInfixExpressionNode(InfixExpressionNode infixExpressionNode) {
        String output = "";

        //switch(visit(infixExpressionNode.Operator))

        if(visit(infixExpressionNode.Operator).equals(("^"))) {
            return "(float)Math.Pow(" + visit(infixExpressionNode.Left) + "," + visit(infixExpressionNode.Right) + ")";
        }
        return visit(infixExpressionNode.Left) + visit(infixExpressionNode.Operator) + visit(infixExpressionNode.Right);
    }

    @Override
    public String visitLogicalNode(LogicalNode logicalNode) {
        String output = visit(logicalNode.Left);
        switch (visit(logicalNode.Operator)) {
            case " and ":
                    output += " &&";
                    break;
            case " or ":
                    output += " ||";
                    break;
            default:
                    output += visit(logicalNode.Operator);
                    break;
        }

        return output + visit(logicalNode.Right);
    }

    @Override
    public String visitMathExpressionNode(MathExpressionNode mathExpressionNode) {
        String output = "";

        //switch(visit(infixExpressionNode.Operator))

        if(visit(mathExpressionNode.Operator).equals(("^"))) {
            return "(float)Math.Pow(" + visit(mathExpressionNode.Left) + "," + visit(mathExpressionNode.Right) + ")";
        }
        return visit(mathExpressionNode.Left) + visit(mathExpressionNode.Operator) + visit(mathExpressionNode.Right);
    }

    @Override
    public String visitReturnNode(ReturnNode returnNode) {
        return "return " + visit(returnNode.expressionNode) + ";";
    }

    @Override
    public String visitParamNode(ParamNode paramNode) {
        String output = "";

        if (paramNode.Type != null) {
            if (visit(paramNode.Type).equals("number")) {
                output += "float ";
            } else {
                output += visit(paramNode.Type) + " ";
            }
        }

        return output + visit(paramNode.Identifier);
    }

    @Override
    public String visitBodyNode(BodyNode bodyNode) {
        String output = "";

        System.out.println("Body Entered!");

        for(Node line : bodyNode.Lines) {
            System.out.println(line.getClass());
            System.out.println(ExpressionNode.class.isAssignableFrom(line.getClass()));
            System.out.println(visit(line));
            System.out.println("");
            output += visit(line);

            if (ExpressionNode.class.isAssignableFrom(line.getClass())) {
                output += ";";
            }
        }
        System.out.println("----------------------------------");
        System.out.println(output);
        System.out.println("----------------------------------");
        return output;
    }

    //Den her bliver ikk brugt, men tilføjede den alligevel siden Martin har den i ASTPrinter xd
    @Override
    public String visitConstructorBodyNode(ConstructorBodyNode constructorBodyNode) { return null; }

    //Den her eksistere ikke mere smile
    /*
    @Override
    public String visitIdentifierNode(IdentifierNode identifierNode) {
        if (identifierNode.Name.contains("Simulation.")) {
            return identifierNode.Name.split("Simulation.")[1];
        }

        return identifierNode.Name;
    } */

    @Override
    public String visitObjIdNode(ObjIdNode objIdNode) {
        String output = "";

        if (visit(objIdNode.ObjectNode).equals("Simulation")){
            int i = 1+2;
        }

        output += visit(objIdNode.ObjectNode) + ".";

        if (objIdNode.ObjIdNode != null) {
            return output + visit(objIdNode.ObjIdNode);

        } else {
            return output + visit(objIdNode.Identifier);
        }

        //Not implemented
        //return "";
        //return visit(objIdNode.ObjectNode) + "." + visit(objIdNode.Identifier);
    }

    @Override
    public String visitThisIdNode(ThisIdNode thisIdNode) {

        String output = "this.";

        if (thisIdNode.ObjNode != null) {
            return output + visit(thisIdNode.ObjNode);
        } else {
            return output + visit(thisIdNode.Identifier);
        }
    }

    @Override
    public String visitSimpleIdNode(SimpleIdNode simpleIdNode) {
        //Not implemented (Midlertidigt den gamle identifier)

        /*if (simpleIdNode.Name.contains("Simulation.")) {
            return simpleIdNode.Name.split("Simulation.")[1];
        } */

        return simpleIdNode.Name;
    }

    @Override
    public String visitTypeNode(TypeNode typeNode) {
        return typeNode.Name;
    }

    @Override
    public String visitNumberNode(NumberNode numberNode) {
        return numberNode.Name;
    }

    @Override
    public String visitStringNode(StringNode stringNode) {
        return stringNode.Name;
    }

    @Override
    public String visitBoolNode(BoolNode boolNode) {
        return boolNode.Name;
    }

    @Override
    public String visitOpNode(OpNode opNode) {
        return opNode.Name;
    }

    public boolean CheckType(String name) {
        switch (currEnviCheck) {
            case "Node":
                if (nodeTypes.contains(name)) return true;
                break;
            case "Road":
                if (roadTypes.contains(name)) return true;
                break;
            default:
                break;
        }
        return false;
    }

    public String RemoveFromList(FunctionCallNode functionCallNode, String name){

        String output = "";


        output += name + " = " + name + ".Where((source, index) => index != " + visit(functionCallNode.Parameters.get(0));

        /*output += name + " = " + name + ".Concat(new ";
        output += type.equals("number") ? "float" : type;
        output += "[]{";*/



        return output + ").ToArray()";
    }

    public String PrintFunction(FunctionCallNode functionCallNode){
        return "Console.WriteLine(" + visit(functionCallNode.Parameters.get(0)) + ");";
    }

    public String RandomFunction(FunctionCallNode functionCallNode){
        return "(float)Rand.NextDouble() * (" + visit(functionCallNode.Parameters.get(1)) + " - " + visit(functionCallNode.Parameters.get(0)) + ") + " + visit(functionCallNode.Parameters.get(0)) +"";
    }

    public String AddToList(FunctionCallNode functionCallNode, String name){

        if(name.contains("Simulation")){
            prevScopeName = scopeName;
            scopeName = "Simulation";
        }

        String[] strArr = name.split("\\.");

        String type = helper.GetSymbolByScopeName(strArr[strArr.length-1], scopeName).ActualType;

        String output = "";

        output += name + " = " + name + ".Concat(new ";
        output += type.equals("number") ? "float" : type;
        output += "[]{";

        int parAmount = functionCallNode.Parameters.size();
        int currPar = 1;

        for (Node params : functionCallNode.Parameters) {
            output += visit(params);
            if (currPar < parAmount) {
                output += ",";
            }

            currPar++;
        }

        if (name.contains("Simulation")) {
            scopeName = prevScopeName;
        }

        return output + "}).ToArray()";
    }

    public String setupAbstractClasses(String type) {
        String output = "";

        output += "abstract public class " + type + " {";

        switch (type) {
            case "Vehicle":
                output += "   public Random Rand = new Random();     public float length;\n" +
                        "        public float acceleration;\n" +
                        "        public List<Node> path;\n";
                for(String s:vehicleMethods){
                    output += s + "\n";
                }
                break;
            case "Node":
                output += "public Random Rand = new Random();public Node[] connections;";
                for(String s:nodeMethods){
                    output += s + "\n";
                }
                break;
            case "Road":
                output += "public Random Rand = new Random();public float length;\n" +
                          "public Node startNode;\n" +
                          "public Node endNode;";
                for(String s:roadMethods){
                    output += s + "\n";
            }
                break;
            default:
                System.out.println("Shit broke");
                break;
        }

        return output + "}";
    }

}
