package Visitors;

import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.*;
import ASTVisitors.BaseVisitor;
import hu.webarticum.treeprinter.SimpleTreeNode;

public class CodeGenerationVisitor extends BaseVisitor<String> {
    @Override
    public String visitProgramNode(ProgramNode programNode) {

        /*
        String output = readfile(header.txt);

        output = output + visit(programNode.Update);

         */



        return visit(programNode.Environment) + visit(programNode.Behavior) + visit(programNode.Update) + visit(programNode.Output);
    }

    @Override
    public String visitSectionNode(SectionNode sectionNode){
        String output = "";

        for(Node line : sectionNode.Lines) {
            output += visit(line);
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
            output += visit(functionDclNode.Type) + " ";
        }

        output += visit(functionDclNode.Identifier) + "(";

        int parAmount = functionDclNode.Parameters.size();
        int currPar = 1;

        for (Node params : functionDclNode.Parameters) {
            output += visit(params);
            if (currPar < parAmount) {
                output += ",";
            }
        }

        output += "){";

        return output;
    }

    @Override
    public String visitListNode(ListDclNode listDclNode) {
        //<---------------Den her venter lige til senere--------------->

        return "";
    }

    @Override
    public String visitClassNode(ClassNode classNode) {
        String output = "public class " + visit(classNode.Identifier);

        output += ":" + visit(classNode.Type) + "{";

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
        }
        output += "){";

        output += visit(constructorDclNode.Body);

        return output + "}";
    }

    @Override
    public String visitObjDcl(ObjDclNode objDclNode) {
        //<---------------Den her venter lige til senere--------------->

        return "";
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


}
