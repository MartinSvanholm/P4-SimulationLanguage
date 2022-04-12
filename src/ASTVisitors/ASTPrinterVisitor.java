package ASTVisitors;

import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.*;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.OpNode;
import ASTNodes.ValueNodes.StringNode;
import hu.webarticum.treeprinter.SimpleTreeNode;

public class ASTPrinterVisitor extends BaseVisitor<SimpleTreeNode>{
    @Override
    public SimpleTreeNode visitProgramNode(ProgramNode programNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(programNode.Name);

        treeNode.addChild(visit(programNode.Environment));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitSectionNode(SectionNode sectionNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(sectionNode.Name);

        for(Node line : sectionNode.Lines) {
            treeNode.addChild(visit(line));
        }

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitFunctionNode(FunctionDclNode functionDclNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitListNode(ListDclNode listDclNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitClassNode(ClassNode classNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitConstructorNode(ConstructorDclNode constructorDclNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitObjDcl(ObjDclNode objDclNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitIfElseNode(IfElseNode ifElseNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitElseIfNode(ElseIfNode elseIfNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitSwitchNode(SwitchNode switchNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitSwitchBodyNode(SwitchBody switchBody) {
        return null;
    }

    @Override
    public SimpleTreeNode visitCaseNode(CaseNode caseNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitForLoopNode(ForLoopNode forLoopNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitWhileLoopNode(WhileLoopNode whileLoopNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitAssignmentNode(AssignmentNode assignmentNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitArrayExprNode(ArrayExprNode arrayExprNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitCompareNode(CompareNode compareNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitFunctionCallNode(FunctionCallNode functionCallNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitInfixExpressionNode(InfixExpressionNode infixExpressionNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitLogicalNode(LogicalNode logicalNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitMathExpressionNode(MathExpressionNode mathExpressionNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitParamNode(ParamNode paramNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitBodyNode(BodyNode bodyNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitConstructorBodyNode(ConstructorBodyNode constructorBodyNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitIdentifierNode(IdentifierNode identifierNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitTypeNode(TypeNode typeNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitNumberNode(NumberNode numberNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitStringNode(StringNode stringNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitBoolNode(BoolNode boolNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitOpNode(OpNode opNode) {
        return null;
    }

}
