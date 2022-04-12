package ASTVisitors;

import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.*;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.OpNode;
import ASTNodes.ValueNodes.StringNode;

public class BaseVisitor<T> extends AbstractBaseVisitor<T> implements IYATSIVisitor<T> {
    @Override
    public T visitProgramNode(ProgramNode programNode) {
        return null;
    }

    @Override
    public T visitSectionNode(SectionNode sectionNode) {
        return null;
    }

    @Override
    public T visitFunctionNode(FunctionDclNode functionDclNode) {
        return null;
    }

    @Override
    public T visitListNode(ListDclNode listDclNode) {
        return null;
    }

    @Override
    public T visitClassNode(ClassNode classNode) {
        return null;
    }

    @Override
    public T visitConstructorNode(ConstructorDclNode constructorDclNode) {
        return null;
    }

    @Override
    public T visitObjDcl(ObjDclNode objDclNode) {
        return null;
    }

    @Override
    public T visitIfElseNode(IfElseNode ifElseNode) {
        return null;
    }

    @Override
    public T visitElseIfNode(ElseIfNode elseIfNode) {
        return null;
    }

    @Override
    public T visitSwitchNode(SwitchNode switchNode) {
        return null;
    }

    @Override
    public T visitSwitchBodyNode(SwitchBody switchBody) {
        return null;
    }

    @Override
    public T visitCaseNode(CaseNode caseNode) {
        return null;
    }

    @Override
    public T visitForLoopNode(ForLoopNode forLoopNode) {
        return null;
    }

    @Override
    public T visitWhileLoopNode(WhileLoopNode whileLoopNode) {
        return null;
    }

    @Override
    public T visitAssignmentNode(AssignmentNode assignmentNode) {
        return null;
    }

    @Override
    public T visitArrayExprNode(ArrayExprNode arrayExprNode) {
        return null;
    }

    @Override
    public T visitCompareNode(CompareNode compareNode) {
        return null;
    }

    @Override
    public T visitFunctionCallNode(FunctionCallNode functionCallNode) {
        return null;
    }

    @Override
    public T visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        return null;
    }

    @Override
    public T visitInfixExpressionNode(InfixExpressionNode infixExpressionNode) {
        return null;
    }

    @Override
    public T visitLogicalNode(LogicalNode logicalNode) {
        return null;
    }

    @Override
    public T visitMathExpressionNode(MathExpressionNode mathExpressionNode) {
        return null;
    }

    @Override
    public T visitParamNode(ParamNode paramNode) {
        return null;
    }

    @Override
    public T visitBodyNode(BodyNode bodyNode) {
        return null;
    }

    @Override
    public T visitConstructorBodyNode(ConstructorBodyNode constructorBodyNode) {
        return null;
    }

    @Override
    public T visitIdentifierNode(IdentifierNode identifierNode) {
        return null;
    }

    @Override
    public T visitTypeNode(TypeNode typeNode) {
        return null;
    }

    @Override
    public T visitNumberNode(NumberNode numberNode) {
        return null;
    }

    @Override
    public T visitStringNode(StringNode stringNode) {
        return null;
    }

    @Override
    public T visitBoolNode(BoolNode boolNode) {
        return null;
    }

    @Override
    public T visitOpNode(OpNode opNode) {
        return null;
    }
}
