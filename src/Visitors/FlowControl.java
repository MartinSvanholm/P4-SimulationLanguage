package Visitors;

import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.*;
import ASTNodes.Identifier.IdentifierNode;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.OpNode;
import ASTNodes.ValueNodes.StringNode;
import ASTVisitors.BaseVisitor;
import Main.ErrorHandler;
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
    public boolean canCreateLogic = false;

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
        helper.ResetOptions();
        prevScopeName = scopeName;
        scopeName = sectionNode.Name;

        switch (sectionNode.Name) {
            case "Environment" -> {
                canCreateEndCondition = true;
                canCreateFunction = true;
                canCreateVar = true;
            }
            case "Behavior" -> {
                canCreateClass = true;
                canCreateInitCondition = true;
            }
            case "Update", "Output" -> {
                canCreateVar = true;
                canCreateLogic = true;
            }
        }

        visitChildren(sectionNode);

        scopeName = prevScopeName;
        return null;
    }

    @Override
    public String visitEndCondition(EndConditionNode endConditionNode) {
        canCreateClass = false;
        canCreateFunction = false;
        canCreateVar = true;
        canCreateLogic = true;

        visitChildren(endConditionNode);
        canCreateVar = false;
        canCreateLogic = false;
        canCreateEndCondition = false;
        return null;
    }

    @Override
    public String visitInitCondition(InitConditionNode initConditionNode) {
        canCreateVar = true;
        canCreateLogic = true;
        canCreateClass = false;
        canCreateFunction = false;

        visitChildren(initConditionNode);

        canCreateVar = false;
        canCreateLogic = false;
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

        canCreateFunction = false;
        canCreateLogic = true;
        visit(functionDclNode.Body);
        canCreateFunction = true;
        canCreateLogic = false;
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

        if(!canCreateClass) {
            helper.AddError(classNode, "cannot declare Class in this scope");
        }

        canCreateFunction = true;
        canCreateVar = true;
        canCreateClass = false;

        visitChildren(classNode.Body);

        canCreateClass = true;
        canCreateVar = false;
        scopeName = prevScopeName;
        return null;
    }

    @Override
    public String visitConstructorNode(ConstructorDclNode constructorDclNode) {
        canCreateLogic = true;
        visit(constructorDclNode.Body);
        canCreateLogic = false;
        return null;
    }

    @Override
    public String visitObjDcl(ObjDclNode objDclNode) {
        if(!canCreateVar) {
            helper.AddError(objDclNode, "cannot declare variable in this scope");
        }

        if(objDclNode.ObjValue != null)
            visit(objDclNode.ObjValue);

        return null;
    }

    @Override
    public String visitIfElseNode(IfElseNode ifElseNode) {
        if(!canCreateLogic) {
            helper.AddError(ifElseNode, "cannot declare if-statement in this scope");
        }

        visit(ifElseNode.Body);

        if(ifElseNode.ElseIf != null)
            visit(ifElseNode.ElseIf);
        return null;
    }

    @Override
    public String visitElseIfNode(ElseIfNode elseIfNode) {
        visit(elseIfNode.Body);

        if(elseIfNode.ElseIf != null)
            visit(elseIfNode.Body);
        return null;
    }

    @Override
    public String visitSwitchNode(SwitchNode switchNode) {
        if(!canCreateLogic){
            helper.AddError(switchNode, "can not declare switch-statement in this scope");
        }

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
        if(!canCreateLogic){
            helper.AddError(forLoopNode, "can not declare a for-loop in this scope");
        }

        visit(forLoopNode.Body);
        return null;
    }

    @Override
    public String visitWhileLoopNode(WhileLoopNode whileLoopNode) {
        if (!canCreateLogic){
            helper.AddError(whileLoopNode, "can not declare a while-loop in this scope");
        }

        visitChildren(whileLoopNode);
        return null;
    }

    @Override
    public String visitAssignmentNode(AssignmentNode assignmentNode) {
        return null;
    }

    @Override
    public String visitArrayExprNode(ArrayExprNode arrayExprNode) {
        return null;
    }

    @Override
    public String visitCompareNode(CompareNode compareNode) {
        return null;
    }

    @Override
    public String visitFunctionCallNode(FunctionCallNode functionCallNode) {
        if(!canCreateVar) {
            helper.AddError(functionCallNode, "cannot use function-call in this scope");
        }
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
