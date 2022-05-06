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

public class CodeGenerationVisitor extends BaseVisitor<String> {
    /* ---------------------------List af ting der mangler---------------------------
    - Der er noget fuckery med semicolon... Det er mest ved et InfixExpression, hvis den ikke er del af at større expression/statement
    - Lister er ikke lavet endnu
    - Hele Environment delen er ikk lavet endnu
    - Har ikke testet Update delen endnu, siden vi har en lidt gamle version af type checker osv.
    - Eller virker resten overraskende godt xd.
     */
    @Override
    public String visitProgramNode(ProgramNode programNode) {
        CodeGenIO io = new CodeGenIO();

        String output = io.ReadFile("Header.txt");

        output += visit(programNode.Update);

        output += "                    output.Run();\n" +
                "\n" +
                "                }\n" +
                "                tick++;\n" +
                "            }\n" +
                "            output.LogToFile();\n" +
                "            List<Node> InitNodes() {";

        //Her skal environment (og mere hardcoding) shit ske, men det kigger vi lige på lidt senere.

        output += "            }\n" +
                "        }";

        output += visit(programNode.Behavior);

        output += "        public class Output {\n" +
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

        for(Node line : sectionNode.Lines) {
            output += visit(line);
            //DET HER ER PÆNT FUCKING GAY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            if (line.getClass().toString().equals("class ASTNodes.ExprNodes.FunctionCallNode")){
                output += ";";
            }
        }
        return output;
    }

    @Override
    public String visitEndCondition(EndConditionNode endConditionNode) {
        String output = "bool EndCondition() {";

        output += visit(endConditionNode.Body);
        output += "}";

        return output;
    }

    @Override
    public String visitInitCondition(InitConditionNode initConditionNode) {
        //<---------------Den her venter lige til senere--------------->

        return "";
    }

    @Override
    public String visitFunctionNode(FunctionDclNode functionDclNode) {
        String output = "public ";

        if(functionDclNode.Type == null) {
            output += "void ";
        } else {
            if (visit(functionDclNode.Type).equals("number ")) {
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

        if (visit(objDclNode.Type).equals("number ")) {
            output += "float ";
        } else {
            output += visit(objDclNode.Type) + " ";
        }

        output += visit(objDclNode.Identifier);

        if (objDclNode.ObjValue != null) {
            if (visit(objDclNode.Type).equals("number ") && objDclNode.ObjValue.getClass().toString().equals("class ASTNodes.ValueNodes.NumberNode")) {
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
        //<---------------Den her venter lige til senere--------------->
        return "";
    }

    @Override
    public String visitSwitchBodyNode(SwitchBody switchBody){
        //<---------------Den her venter lige til senere--------------->
        return "";
    }

    @Override
    public String visitCaseNode(CaseNode caseNode) {
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
        String output = visit(constructorCallNode.Type) + "(";

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
            if (visit(paramNode.Type).equals("number ")) {
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
            System.out.println(visit(line));
            System.out.println("");
            output += visit(line);
            if (line.getClass().toString().equals("class ASTNodes.ExprNodes.FunctionCallNode")){
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

}
