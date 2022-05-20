package ASTVisitors;

import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.*;
import ASTNodes.Identifier.IdentifierNode;
import ASTNodes.Identifier.ObjIdNode;
import ASTNodes.Identifier.SimpleIdNode;
import ASTNodes.Identifier.ThisIdNode;
import ASTNodes.ValueNodes.*;

public interface IYATSIVisitor<T> extends IBaseVisitor<T> {
    T visitProgramNode(ProgramNode programNode);

    T visitSectionNode(SectionNode sectionNode);

    T visitEndCondition(EndConditionNode endConditionNode);

    T visitInitCondition(InitConditionNode initConditionNode);

    T visitFunctionNode(FunctionDclNode functionDclNode);

    T visitListNode(ListDclNode listDclNode);

    T visitClassNode(ClassNode classNode);

    T visitConstructorNode(ConstructorDclNode constructorDclNode);

    T visitObjDcl(ObjDclNode objDclNode);

    T visitIfElseNode(IfElseNode ifElseNode);

    T visitElseIfNode(ElseIfNode elseIfNode);

    T visitSwitchNode(SwitchNode switchNode);

    T visitSwitchBodyNode(SwitchBody switchBody);

    T visitCaseNode(CaseNode caseNode);

    T visitForLoopNode(ForLoopNode forLoopNode);

    T visitWhileLoopNode(WhileLoopNode whileLoopNode);

    T visitAssignmentNode(AssignmentNode assignmentNode);

    T visitArrayExprNode(ArrayExprNode arrayExprNode);

    T visitCompareNode(CompareNode compareNode);

    T visitFunctionCallNode(FunctionCallNode functionCallNode);

    T visitConstructorCallNode(ConstructorCallNode constructorCallNode);

    T visitInfixExpressionNode(InfixExpressionNode infixExpressionNode);

    T visitLogicalNode(LogicalNode logicalNode);

    T visitMathExpressionNode(MathExpressionNode mathExpressionNode);

    T visitReturnNode(ReturnNode returnNode);

    T visitParamNode(ParamNode paramNode);

    T visitBodyNode(BodyNode bodyNode);

    T visitConstructorBodyNode(ConstructorBodyNode constructorBodyNode);

    T visitObjIdNode(ObjIdNode objIdNode);

    T visitThisIdNode(ThisIdNode thisIdNode);

    T visitSimpleIdNode(SimpleIdNode simpleIdNode);

    T visitTypeNode(TypeNode typeNode);

    T visitNumberNode(NumberNode numberNode);

    T visitStringNode(StringNode stringNode);

    T visitBoolNode(BoolNode boolNode);

    T visitOpNode(OpNode opNode);
}
