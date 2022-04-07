package Visitors;

import ASTNodes.*;
import ASTNodes.ExprNodes.*;
import Parser.CFGParser;
import Parser.CFGBaseVisitor;
import Parser.CFGLexer;

public class BuildAstVisitor extends CFGBaseVisitor<Node> {
    @Override public Node visitProgram(CFGParser.ProgramContext ctx) {
        ProgramNode programNode = new ProgramNode();

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            programNode.Nodes.add(visit(child));
        }

        return programNode;
    }

    @Override public Node visitEnvironmentSection(CFGParser.EnvironmentSectionContext ctx) {
        SectionNode sectionNode = new SectionNode();

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            //System.out.println(child.getClass().getSimpleName());
            sectionNode.Nodes.add(visit(child));
        }

        /*for (Node node : sectionNode.Nodes)
            System.out.println(node);*/

        return sectionNode;
    }

    @Override public Node visitBehaviorSection(CFGParser.BehaviorSectionContext ctx) {
        SectionNode sectionNode = new SectionNode();

        for(var child : ctx.children) {
            sectionNode.Nodes.add(visit(child));
        }

        return sectionNode;
    }

    @Override public Node visitUpdateSection(CFGParser.UpdateSectionContext ctx) {
        SectionNode sectionNode = new SectionNode();

        for(var child : ctx.children) {
            sectionNode.Nodes.add(visit(child));
        }

        return sectionNode;
    }

    @Override public Node visitOutputSection(CFGParser.OutputSectionContext ctx) {
        SectionNode sectionNode = new SectionNode();

        for(var child : ctx.children) {
            sectionNode.Nodes.add(visit(child));
        }

        return sectionNode;
    }

    @Override public Node visitLine(CFGParser.LineContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override public Node visitDcl(CFGParser.DclContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitEndCondition(CFGParser.EndConditionContext ctx) { return visitChildren(ctx); }

    @Override public Node visitInitCondition(CFGParser.InitConditionContext ctx) { return visitChildren(ctx); }

    @Override public Node visitFunctionDcl(CFGParser.FunctionDclContext ctx) { return visitChildren(ctx); }

    @Override public Node visitFuncReturnBody(CFGParser.FuncReturnBodyContext ctx) { return visitChildren(ctx); }

    @Override public Node visitListDcl(CFGParser.ListDclContext ctx) { return visitChildren(ctx); }

    @Override public Node visitClassDcl(CFGParser.ClassDclContext ctx) { return visitChildren(ctx); }

    @Override public Node visitClassBody(CFGParser.ClassBodyContext ctx) { return visitChildren(ctx); }

    @Override public Node visitClassPropDcl(CFGParser.ClassPropDclContext ctx) { return visitChildren(ctx); }

    @Override public Node visitContructorDcl(CFGParser.ContructorDclContext ctx) { return visitChildren(ctx); }

    @Override public Node visitConstructorCall(CFGParser.ConstructorCallContext ctx) { return visitChildren(ctx); }

    @Override public Node visitObjDcl(CFGParser.ObjDclContext ctx) { return visitChildren(ctx); }

    @Override public Node visitPrimVarDcl(CFGParser.PrimVarDclContext ctx) { return visitChildren(ctx); }

    @Override public Node visitStatement(CFGParser.StatementContext ctx) { return visitChildren(ctx); }

    @Override public Node visitSelectiveCtrl(CFGParser.SelectiveCtrlContext ctx) { return visitChildren(ctx); }

    @Override public Node visitIfElseStmt(CFGParser.IfElseStmtContext ctx) { return visitChildren(ctx); }

    @Override public Node visitElseIfStmt(CFGParser.ElseIfStmtContext ctx) { return visitChildren(ctx); }

    @Override public Node visitSwitchStmt(CFGParser.SwitchStmtContext ctx) { return visitChildren(ctx); }

    @Override public Node visitSwitchBody(CFGParser.SwitchBodyContext ctx) { return visitChildren(ctx); }

    @Override public Node visitIterativeCtrl(CFGParser.IterativeCtrlContext ctx) { return visitChildren(ctx); }

    @Override public Node visitWhileLoop(CFGParser.WhileLoopContext ctx) { return visitChildren(ctx); }

    @Override public Node visitForLoop(CFGParser.ForLoopContext ctx) { return visitChildren(ctx); }

    @Override public Node visitStmtBody(CFGParser.StmtBodyContext ctx) { return visitChildren(ctx); }

    @Override public Node visitAssignment(CFGParser.AssignmentContext ctx) { return visitChildren(ctx); }

    @Override public Node visitInfixExpr(CFGParser.InfixExprContext ctx) {
        InfixExpressionNode node;

        switch (ctx.op.getType()) {
            case CFGLexer.OP_ADD:
                node = new AdditionNode();
                break;

            case CFGLexer.OP_SUB:
                node = new SubtractionNode();
                break;

            case CFGLexer.OP_MUL:
                node = new MultiplicationNode();
                break;

            case CFGLexer.OP_DIV:
                node = new DivisionNode();
                break;
            default:
                return null;
        }

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            //System.out.println(child.getClass().getSimpleName());
            node.Nodes.add(visit(child));
        }

        return node;
    }

    @Override public Node visitFuncExpr(CFGParser.FuncExprContext ctx) { return visitChildren(ctx); }

    @Override public Node visitLiteralExpr(CFGParser.LiteralExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitLogicalExpr(CFGParser.LogicalExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitArrExpr(CFGParser.ArrExprContext ctx) { return visitChildren(ctx); }

    @Override public Node visitParensExpr(CFGParser.ParensExprContext ctx) { return visitChildren(ctx); }

    @Override public Node visitPvrExpr(CFGParser.PvrExprContext ctx) { return visitChildren(ctx); }

    @Override public Node visitIdentifierExpr(CFGParser.IdentifierExprContext ctx) { return visitChildren(ctx); }

    @Override public Node visitCompareExpr(CFGParser.CompareExprContext ctx) { return visitChildren(ctx); }

    @Override public Node visitFunctionCall(CFGParser.FunctionCallContext ctx) { return visitChildren(ctx); }

    @Override public Node visitParams(CFGParser.ParamsContext ctx) { return visitChildren(ctx); }

    @Override public Node visitMultipleParams(CFGParser.MultipleParamsContext ctx) { return visitChildren(ctx); }

    @Override public Node visitDclParams(CFGParser.DclParamsContext ctx) { return visitChildren(ctx); }

    @Override public Node visitMultipleDclParams(CFGParser.MultipleDclParamsContext ctx) { return visitChildren(ctx); }

    @Override public Node visitType(CFGParser.TypeContext ctx) { return visitChildren(ctx); }

    @Override public Node visitPrimType(CFGParser.PrimTypeContext ctx) { return visitChildren(ctx); }

    @Override public Node visitComplexType(CFGParser.ComplexTypeContext ctx) { return visitChildren(ctx); }

    @Override public Node visitIdentifier(CFGParser.IdentifierContext ctx) { return visitChildren(ctx); }

    @Override public Node visitLiteral(CFGParser.LiteralContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitNumberLiteral(CFGParser.NumberLiteralContext ctx) {
        NumbernNode numbernNode = new NumbernNode();

        numbernNode.Value = Float.parseFloat(ctx.getText());

        return numbernNode;
    }

    @Override public Node visitStringLiteral(CFGParser.StringLiteralContext ctx) {
        StringNode stringNode = new StringNode();

        stringNode.Value = ctx.getText();

        return stringNode;
    }

    @Override public Node visitBoolLiteral(CFGParser.BoolLiteralContext ctx) {
        BoolNode boolNode = new BoolNode();

        String boolText = ctx.getText();

        if(boolText.equals("true"))
            boolNode.Value = true;
         else if(boolText.equals("false"))
            boolNode.Value = false;
         else
             System.out.println("Bool node text is neither true or false?");


        return boolNode;
    }

    @Override public Node visitBool(CFGParser.BoolContext ctx) { return visitChildren(ctx); }

    @Override public Node visitCodeBlock(CFGParser.CodeBlockContext ctx) { return visitChildren(ctx); }
}
