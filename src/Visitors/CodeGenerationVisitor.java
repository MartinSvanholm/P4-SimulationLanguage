package Visitors;

import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.*;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.OpNode;
import ASTNodes.ValueNodes.StringNode;
import ASTVisitors.BaseVisitor;
import Main.CodeGenIO;
import hu.webarticum.treeprinter.SimpleTreeNode;

import java.util.ArrayList;

public class CodeGenerationVisitor extends BaseVisitor<String> {
    /* ---------------------------List af ting der mangler---------------------------
    - Lister er ikke lavet endnu
    - Environment delen er jeg igang med.
        - Det er ret cancer at splitte op i typer atm, siden der ikke er dedikeret sections til dem.
            - Jeg har splittet dem op i Declarations, men ved ikke rigtigt om det er muligt at gøre med assignment
            og functionskald som vi gør det nu...
            - Derudover har jeg ikk fucket med lister endnu, siden de ikke er implementeret endnu.
            - Honestly tror jeg det er lettest at lave nye sections til init af nodes og roads (lidt som end- og initcondition)
    - Har ikke testet Update delen endnu, siden vi har en lidt gamle version af type checker osv.
    - Eller virker resten overraskende godt xd.
     */

    private String currSection = "";
    private String currEnviCheck = "";

    private ArrayList<String> nodeTypes = new ArrayList<>();
    private ArrayList<String> roadTypes = new ArrayList<>();
    private ArrayList<String> vehicleTypes = new ArrayList<>();
    @Override
    public String visitProgramNode(ProgramNode programNode) {
        CodeGenIO io = new CodeGenIO();

        String output = io.ReadFile("Header.txt");

        output += visit(programNode.Behavior);

        output += "\n" +
                "    class Program {\n" +
                "        static void Main(string[] args) {\n" +
                "            List<Vehicle> vehicleList = new List<Vehicle>();\n" +
                "            List<Node> nodeList = InitNodes();\n" +
                "            List<Road> roadList = InitRoads();\n" +
                "            Output output = new Output();\n" +
                "\n" +
                "            int CurrentTick = 0;\n" +
                "\n" +
                "            while(!EndCondition()) {\n" +
                "                vehicleList = InitVehicles(vehicleList);\n" +
                "                foreach(Vehicle vehicle in vehicleList) {";

        output += visit(programNode.Update);

        output += "                    output.Run();\n" +
                "\n" +
                "                }\n" +
                "                CurrentTick++;\n" +
                "            }\n" +
                "            output.LogToFile();\n" +
                "            List<Node> InitNodes() {";
        //<---------Evironment Section Begin --------->
        //Environment (Node init)
        currEnviCheck = "Node";
        output += visit(programNode.Environment);

        output += "            }\n" +
                "            \n" +
                "            List<Road> InitRoads() {";
        //Environment (Road init)
        currEnviCheck = "Road";
        output += visit(programNode.Environment);

        output += "            }\n" +
                "\n" +
                "            List<Vehicle> InitVehicles(List<Vehicle> Vehicles) {";
        //Environment (Vehicle init (based on each type))
        currEnviCheck = "initcondition";
        output += visit(programNode.Environment);
        output += "                return vehicleList;\n" +
                "            }\n" +
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
                "            public List<string> dataList = new();\n" +
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
                            output += visit(line);
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
        String output = "public ";

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

        output += visit(functionDclNode.Body) + "}";

        return output;
    }

    @Override
    public String visitListNode(ListDclNode listDclNode) {
        //<---------------Den her venter lige til senere--------------->

        return "ListDcl; ";
    }

    @Override
    public String visitClassNode(ClassNode classNode) {
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

        System.out.println(visit(classNode.Type) + " " + visit(classNode.Identifier) + " Class body start");
        output += visit(classNode.Body);

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

    @Override
    public String visitObjDcl(ObjDclNode objDclNode) {
        String output = "";
        if(currSection.equals("Environment")) {
            if (CheckType(objDclNode)) {
                output += visit(objDclNode.Type) + " " + visit(objDclNode.Identifier);

                if (objDclNode.ObjValue != null) {
                    output += " = " + visit(objDclNode.ObjValue);
                }
            }
            return output;
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
        String output = "switch(" + visit(switchNode.switchValue) + "){";
        return output + visit(switchNode.Body) + "}";
    }

    @Override
    public String visitSwitchBodyNode(SwitchBody switchBody){
        String output = "";
        for (Node cases : switchBody.cases) {
            output += "case " + visit(cases) + ": ";
            //Her skal den visit body'en af vores case, men af en eller anden grund er det ikk gemt i vores node...
            output += " break;";
        }

        return output;
    }

    @Override
    public String visitCaseNode(CaseNode caseNode) {
        //Har legit ikk rigtig nogen ide om hvad det her overhovedet er xd....
        //<---------------Den her venter lige til senere--------------->
        return "";
    }

    @Override
    public String visitForLoopNode(ForLoopNode forLoopNode) {
        //<---------------Den her venter lige til senere--------------->
        return "";
    }

    @Override
    public String visitWhileLoopNode(WhileLoopNode whileLoopNode) {
        String output = "while(" + visit(whileLoopNode.condition) + "){";
        return output + visit(whileLoopNode.Body) + "}";
    }

    @Override
    public String visitAssignmentNode(AssignmentNode assignmentNode) {
        System.out.println("HALLI HALLO!: " + assignmentNode.ValueNode.getClass());
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
        String output = visit(functionCallNode.Identifier) + "(";

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

    @Override
    public String visitInfixExpressionNode(InfixExpressionNode infixExpressionNode) {
        System.out.println("POOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOG");
        System.out.println(infixExpressionNode.Left.getClass());
        return visit(infixExpressionNode.Left) + visit(infixExpressionNode.Operator) + visit(infixExpressionNode.Right);
    }

    @Override
    public String visitLogicalNode(LogicalNode logicalNode) {
        String output = visit(logicalNode.Left);

        switch (visit(logicalNode.Operator)) {
            case "and":
                    output += " &&";
                    break;
            case "or":
                    output += " ||";
            default:
                    output += visit(logicalNode.Operator);
        }

        return output + visit(logicalNode.Right);
    }

    @Override
    public String visitMathExpressionNode(MathExpressionNode mathExpressionNode) {
        String output = "";

        if (visit(mathExpressionNode.Operator) == "^") {
            output += "Math.Pow(" + visit(mathExpressionNode.Left) + "," + visit(mathExpressionNode.Right) + ")";
        } else {
            output += visit(mathExpressionNode.Left) + visit(mathExpressionNode.Operator) + visit(mathExpressionNode.Right);
        }

        return output;
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

    @Override
    public String visitIdentifierNode(IdentifierNode identifierNode) {
        if (identifierNode.Name.contains("Simulation.")) {
            identifierNode.Name = identifierNode.Name.split("Simulation.")[1];
        }

        return identifierNode.Name;
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

    public boolean CheckType(DclNode node) {
        switch (currEnviCheck) {
            case "Node":
                if (nodeTypes.contains(visit(node.Type))) return true;
                break;
            case "Road":
                if (roadTypes.contains(visit(node.Type))) return true;
                break;
            default:
                break;
        }
        return false;
    }

}
