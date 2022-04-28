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
        treeNode.addChild(visit(programNode.Behavior));
        treeNode.addChild(visit(programNode.Update));
        treeNode.addChild(visit(programNode.Output));

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
    public SimpleTreeNode visitEndCondition(EndConditionNode endConditionNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(endConditionNode.Name);

        treeNode.addChild(visit(endConditionNode.Body));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitInitCondition(InitConditionNode initConditionNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(initConditionNode.Name);

        treeNode.addChild(visit(initConditionNode.type));
        treeNode.addChild(visit(initConditionNode.Body));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitFunctionNode(FunctionDclNode functionDclNode) {

        if(functionDclNode.Type != null)
            functionDclNode.Name = "function";
        else
            functionDclNode.Name = "procedure";

        SimpleTreeNode treeNode = new SimpleTreeNode(functionDclNode.Name);

        if(functionDclNode.Type != null)
            treeNode.addChild(visit(functionDclNode.Type));

        treeNode.addChild(visit(functionDclNode.Identifier));

        for(Node params : functionDclNode.Parameters) {
            treeNode.addChild(visit(params));
        }

        treeNode.addChild(visit(functionDclNode.Body));


        return treeNode;
    }

    @Override
    public SimpleTreeNode visitListNode(ListDclNode listDclNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(listDclNode.Name);

        treeNode.addChild(visit(listDclNode.Type));
        treeNode.addChild(visit(listDclNode.Identifier));

        for(Node params : listDclNode.Parameters) {
            treeNode.addChild(visit(params));
        }

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitClassNode(ClassNode classNode) {

        SimpleTreeNode treeNode = new SimpleTreeNode(classNode.Name);

        treeNode.addChild(visit(classNode.Type));
        treeNode.addChild(visit(classNode.Identifier));

        treeNode.addChild(visit(classNode.Body));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitConstructorNode(ConstructorDclNode constructorDclNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(constructorDclNode.Name);

        treeNode.addChild(visit(constructorDclNode.Type));

        for(Node params : constructorDclNode.Parameters) {
            treeNode.addChild(visit(params));
        }

        treeNode.addChild(visit(constructorDclNode.Body));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitObjDcl(ObjDclNode objDclNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(objDclNode.Name);

        treeNode.addChild(visit(objDclNode.Type));
        treeNode.addChild(visit(objDclNode.Identifier));

        if(objDclNode.ObjValue != null)
            treeNode.addChild(visit(objDclNode.ObjValue));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitIfElseNode(IfElseNode ifElseNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(ifElseNode.Name);

        treeNode.addChild(visit(ifElseNode.condition));
        treeNode.addChild(visit(ifElseNode.Body));

        if(ifElseNode.ElseIf != null)
            treeNode.addChild(visit(ifElseNode.ElseIf));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitElseIfNode(ElseIfNode elseIfNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(elseIfNode.Name);

        if(elseIfNode.condition != null)
            treeNode.addChild(visit(elseIfNode.condition));

        treeNode.addChild(visit(elseIfNode.Body));

        if(elseIfNode.ElseIf != null)
            treeNode.addChild(visit(elseIfNode.ElseIf));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitSwitchNode(SwitchNode switchNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(switchNode.Name);

        treeNode.addChild(visit(switchNode.switchValue));
        treeNode.addChild(visit(switchNode.Body));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitSwitchBodyNode(SwitchBody switchBody) {
        SimpleTreeNode treeNode = new SimpleTreeNode(switchBody.Name);

        for(Node cases : switchBody.cases) {
            treeNode.addChild(visit(cases));
        }

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitCaseNode(CaseNode caseNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(caseNode.Name);

        treeNode.addChild(visit(caseNode.switchValue));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitForLoopNode(ForLoopNode forLoopNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(forLoopNode.Name);

        treeNode.addChild(visit(forLoopNode.identifier));

        //if(forLoopNode.rangeInt != null)
        //    treeNode.addChild(visit(forLoopNode.rangeInt));
        treeNode.addChild(visit(forLoopNode.listIdentifier));
        //treeNode.addChild(visit(forLoopNode.Type));
        treeNode.addChild(visit(forLoopNode.Body));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitWhileLoopNode(WhileLoopNode whileLoopNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(whileLoopNode.Name);

        treeNode.addChild(visit(whileLoopNode.condition));
        treeNode.addChild(visit(whileLoopNode.Body));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitAssignmentNode(AssignmentNode assignmentNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(assignmentNode.Name);

        treeNode.addChild(visit(assignmentNode.Identifier));
        treeNode.addChild(visit(assignmentNode.Equals));
        treeNode.addChild(visit(assignmentNode.ValueNode));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitArrayExprNode(ArrayExprNode arrayExprNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(arrayExprNode.Name);

        treeNode.addChild(visit(arrayExprNode.Left));
        treeNode.addChild(visit(arrayExprNode.Index));

        if(arrayExprNode.Right != null)
         treeNode.addChild(visit(arrayExprNode.Right));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitCompareNode(CompareNode compareNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(compareNode.Name);

        treeNode.addChild(visit(compareNode.Left));
        treeNode.addChild(visit(compareNode.Operator));
        treeNode.addChild(visit(compareNode.Right));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitFunctionCallNode(FunctionCallNode functionCallNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(functionCallNode.Name);

        treeNode.addChild(visit(functionCallNode.Identifier));
        for(Node params : functionCallNode.Parameters) {
            treeNode.addChild(visit(params));
        }

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(constructorCallNode.Name);

        treeNode.addChild(visit(constructorCallNode.Type));
        for(Node params : constructorCallNode.Parameters) {
            treeNode.addChild(visit(params));
        }

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitInfixExpressionNode(InfixExpressionNode infixExpressionNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(infixExpressionNode.Name);

        treeNode.addChild(visit(infixExpressionNode.Left));
        treeNode.addChild(visit(infixExpressionNode.Operator));
        treeNode.addChild(visit(infixExpressionNode.Right));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitLogicalNode(LogicalNode logicalNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(logicalNode.Name);

        treeNode.addChild(visit(logicalNode.Left));
        treeNode.addChild(visit(logicalNode.Operator));
        treeNode.addChild(visit(logicalNode.Right));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitMathExpressionNode(MathExpressionNode mathExpressionNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(mathExpressionNode.Name);

        treeNode.addChild(visit(mathExpressionNode.Left));
        treeNode.addChild(visit(mathExpressionNode.Operator));
        treeNode.addChild(visit(mathExpressionNode.Right));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitReturnNode(ReturnNode returnNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(returnNode.Name);

        treeNode.addChild(visit(returnNode.expressionNode));

        return treeNode;
    }


    @Override
    public SimpleTreeNode visitParamNode(ParamNode paramNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(paramNode.Name);

        if(paramNode.Type != null)
            treeNode.addChild(visit(paramNode.Type));
        treeNode.addChild(visit(paramNode.Identifier));

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitBodyNode(BodyNode bodyNode) {
        SimpleTreeNode treeNode = new SimpleTreeNode(bodyNode.Name);

        int i = 0;

        for(Node line : bodyNode.Lines) {
            treeNode.addChild(visit(line));
        }

        return treeNode;
    }

    @Override
    public SimpleTreeNode visitConstructorBodyNode(ConstructorBodyNode constructorBodyNode) {
        return null;
    }

    @Override
    public SimpleTreeNode visitIdentifierNode(IdentifierNode identifierNode) {
        return new SimpleTreeNode(identifierNode.Name);
    }

    @Override
    public SimpleTreeNode visitTypeNode(TypeNode typeNode) {
        return new SimpleTreeNode(typeNode.Name);
    }

    @Override
    public SimpleTreeNode visitNumberNode(NumberNode numberNode) {
        return new SimpleTreeNode(numberNode.Name);
    }

    @Override
    public SimpleTreeNode visitStringNode(StringNode stringNode) {
        return new SimpleTreeNode(stringNode.Name);
    }

    @Override
    public SimpleTreeNode visitBoolNode(BoolNode boolNode) {
        return new SimpleTreeNode(boolNode.Name);
    }

    @Override
    public SimpleTreeNode visitOpNode(OpNode opNode) {
        return new SimpleTreeNode(opNode.Name);
    }

}
