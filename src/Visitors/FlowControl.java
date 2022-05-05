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
import Main.ErrorHandler;
import Main.Error;
import SymbolTable.GlobalSymbolTable;
import VisitorHelpers.FlowControlHelper;

public class FlowControl extends BaseVisitor<String> {
    private final FlowControlHelper helper;
    private final GlobalSymbolTable GlobalSymbolTable;
    String scopeName = "Global";
    String prevScopeName;

    public boolean canCreateClass = false;
    public boolean canCreateFunction = false;
    public boolean canCreateInitCondition = false;
    public boolean canCreateEndCondition = false;
    public boolean canCreateVar = false;

    public FlowControl(GlobalSymbolTable globalSymbolTable, ErrorHandler errorHandler) {
        GlobalSymbolTable = globalSymbolTable;
        this.helper = new FlowControlHelper(errorHandler, GlobalSymbolTable, this);
    }

    public void CheckFlow(Node ast) {
        visit(ast);
    }

    @Override
    public String visitProgramNode(ProgramNode programNode) {
        visitChildren(programNode);
        return null;
    }

    @Override
    public String visitSectionNode(SectionNode sectionNode) {
        prevScopeName = scopeName;
        scopeName = sectionNode.Name;

        if(sectionNode.Name.equals("Environment")) {
            canCreateEndCondition = true;
        } else if(sectionNode.Name.equals("Behavior")) {
            canCreateClass = true;
            canCreateInitCondition = true;
        } else {
            helper.ResetOptions();
        }

        visitChildren(sectionNode);

        scopeName = prevScopeName;
        return null;
    }

    @Override
    public String visitEndCondition(EndConditionNode endConditionNode) {
        canCreateClass = false;
        canCreateFunction = false;

        visitChildren(endConditionNode);
        canCreateEndCondition = false;
        return null;
    }

    @Override
    public String visitInitCondition(InitConditionNode initConditionNode) {
        visitChildren(initConditionNode);
        canCreateInitCondition = false;
        return null;
    }

    @Override
    public String visitFunctionNode(FunctionDclNode functionDclNode) {
        prevScopeName = scopeName;
        scopeName = functionDclNode.Name;

        if(!canCreateFunction) {
            helper.AddError(functionDclNode, "cannot declare Function in this scope");
        }
        visitChildren(functionDclNode);

        scopeName = prevScopeName;
        return null;
    }

    @Override
    public String visitListNode(ListDclNode listDclNode) {
        visitChildren(listDclNode);
        return null;
    }

    @Override
    public String visitClassNode(ClassNode classNode) {
        prevScopeName = scopeName;
        scopeName = classNode.Name;

        canCreateFunction = true;
        canCreateVar = true;

        if(!canCreateClass) {
            helper.AddError(classNode, "cannot declare Class in this scope");
        }
        canCreateClass = false;
        visitChildren(classNode.Body);
        canCreateClass = true;
        scopeName = prevScopeName;
        return null;
    }

    @Override
    public String visitConstructorNode(ConstructorDclNode constructorDclNode) {
        visitChildren(constructorDclNode);
        return null;
    }

    @Override
    public String visitObjDcl(ObjDclNode objDclNode) {
        if(!canCreateVar) {
            helper.AddError(objDclNode, "cannot declare variable in this scope");
        }

        if(objDclNode.ObjValue != null)
            visit(objDclNode.ObjValue);

        canCreateVar = false;
        return null;
    }

    @Override
    public String visitIfElseNode(IfElseNode ifElseNode) {
        visitChildren(ifElseNode);
        return null;
    }

    @Override
    public String visitElseIfNode(ElseIfNode elseIfNode) {
        visitChildren(elseIfNode);
        return null;
    }

    @Override
    public String visitSwitchNode(SwitchNode switchNode) {
        visitChildren(switchNode);
        return null;
    }

    @Override
    public String visitSwitchBodyNode(SwitchBody switchBody) {
        visitChildren(switchBody);
        return null;
    }

    @Override
    public String visitCaseNode(CaseNode caseNode) {
        visitChildren(caseNode);
        return null;
    }

    @Override
    public String visitForLoopNode(ForLoopNode forLoopNode) {
        visitChildren(forLoopNode);
        return null;
    }

    @Override
    public String visitWhileLoopNode(WhileLoopNode whileLoopNode) {
        visitChildren(whileLoopNode);
        return null;
    }

    @Override
    public String visitAssignmentNode(AssignmentNode assignmentNode) {
        visitChildren(assignmentNode);
        return null;
    }

    @Override
    public String visitArrayExprNode(ArrayExprNode arrayExprNode) {
        visitChildren(arrayExprNode);
        return null;
    }

    @Override
    public String visitCompareNode(CompareNode compareNode) {
        visitChildren(compareNode);
        return null;
    }

    @Override
    public String visitFunctionCallNode(FunctionCallNode functionCallNode) {
        visitChildren(functionCallNode);
        return null;
    }

    @Override
    public String visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        visitChildren(constructorCallNode);
        return null;
    }

    @Override
    public String visitInfixExpressionNode(InfixExpressionNode infixExpressionNode) {
        visitChildren(infixExpressionNode);
        return null;
    }

    @Override
    public String visitLogicalNode(LogicalNode logicalNode) {
        visitChildren(logicalNode);
        return null;
    }

    @Override
    public String visitMathExpressionNode(MathExpressionNode mathExpressionNode) {
        visitChildren(mathExpressionNode);
        return null;
    }

    @Override
    public String visitReturnNode(ReturnNode returnNode) {
        visitChildren(returnNode);
        return null;
    }

    @Override
    public String visitParamNode(ParamNode paramNode) {
        visitChildren(paramNode);
        return null;
    }

    @Override
    public String visitBodyNode(BodyNode bodyNode) {
        visitChildren(bodyNode);
        return null;
    }

    @Override
    public String visitConstructorBodyNode(ConstructorBodyNode constructorBodyNode) {
        visitChildren(constructorBodyNode);
        return null;
    }

    @Override
    public String visitIdentifierNode(IdentifierNode identifierNode) {
        return null;
    }

    @Override
    public String visitTypeNode(TypeNode typeNode) {
        return null;
    }

    @Override
    public String visitNumberNode(NumberNode numberNode) {
        return null;
    }

    @Override
    public String visitStringNode(StringNode stringNode) {
        return null;
    }

    @Override
    public String visitBoolNode(BoolNode boolNode) {
        return null;
    }

    @Override
    public String visitOpNode(OpNode opNode) {
        return null;
    }
}
