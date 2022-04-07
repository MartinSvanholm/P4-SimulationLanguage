package Visitors;

import ASTNodes.*;
import ASTNodes.DclNodes.ObjDclNode;
import ASTNodes.ExprNodes.*;
import ASTNodes.ExprNodes.CompareNodes.*;
import ASTNodes.ExprNodes.LogicalNodes.AndNode;
import ASTNodes.ExprNodes.LogicalNodes.LogicalNode;
import ASTNodes.ExprNodes.LogicalNodes.ORNode;
import Parser.CFGParser;
import Parser.CFGBaseVisitor;
import Parser.CFGLexer;

public class BuildAstVisitor extends CFGBaseVisitor<Node> {
    @Override public Node visitProgram(CFGParser.ProgramContext ctx) {
        ProgramNode programNode = new ProgramNode();

        programNode.Value = "Program";

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            programNode.Nodes.add(visit(child));
        }

        return programNode;
    }

    @Override public Node visitEnvironmentSection(CFGParser.EnvironmentSectionContext ctx) {
        SectionNode sectionNode = new SectionNode();

        sectionNode.Value = "Environment";

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

    @Override public Node visitObjDcl(CFGParser.ObjDclContext ctx) {
        ObjDclNode node = new ObjDclNode();

        node.Nodes.add(visit(ctx.identifier()));

        if(ctx.constructorCall() != null) {
            node.Nodes.add(visit(ctx.constructorCall()));
        } else if(ctx.expr() != null) {
            node.Nodes.add(visit(ctx.expr()));
        }

        node.Value = visit(ctx.type()).Value;

        return node;
    }

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

    @Override public Node visitAssignment(CFGParser.AssignmentContext ctx) {
        AssignmentNode node = new AssignmentNode();

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            node.Nodes.add(visit(child));
        }

        node.Value = "=";

        return node;
    }

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
            case CFGLexer.OP_POW:
                node = new PowNode();
                break;
            case CFGLexer.OP_MOD:
                node = new ModNode();
                break;
            default:
                return null;
        }

        node.Value = ctx.op.getText();

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            //System.out.println(child.getClass().getSimpleName());
            node.Nodes.add(visit(child));
        }

        return node;
    }

    @Override public Node visitFuncExpr(CFGParser.FuncExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitLiteralExpr(CFGParser.LiteralExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitLogicalExpr(CFGParser.LogicalExprContext ctx) {
        LogicalNode node;

        switch (ctx.op.getType()) {
            case CFGLexer.OP_AND:
            case CFGLexer.OP_AND2:
                node = new AndNode();
                break;
            case CFGLexer.OP_OR:
            case CFGLexer.OP_OR2:
                node = new ORNode();
                break;
            default:
                return null;
        }

        node.Value = ctx.op.getText();

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            //System.out.println(child.getClass().getSimpleName());
            node.Nodes.add(visit(child));
        }

        return node;
    }

    @Override public Node visitArrExpr(CFGParser.ArrExprContext ctx) {
        ArrayExprNode arrayExprNode = new ArrayExprNode();

        arrayExprNode.Nodes.add(visit(ctx.left));

        if(ctx.right != null)
            arrayExprNode.Nodes.add(visit(ctx.right));

        arrayExprNode.Value = "[" + visit(ctx.index).Value + "]";

        return arrayExprNode;
    }

    @Override public Node visitParensExpr(CFGParser.ParensExprContext ctx) {
        return visit(ctx.middel);
    }

    @Override public Node visitIdentifierExpr(CFGParser.IdentifierExprContext ctx) { return visitChildren(ctx); }

    @Override public Node visitCompareExpr(CFGParser.CompareExprContext ctx) {
        CompareNode node;

        switch (ctx.op.getType()) {
            case CFGLexer.OP_LTOE:
                node = new LTOENode();
                break;

            case CFGLexer.OP_GTOE:
                node = new GTOENode();
                break;

            case CFGLexer.OP_LT:
                node = new LTNode();
                break;

            case CFGLexer.OP_GT:
                node = new GTNode();
                break;
            case CFGLexer.OP_EQUALS:
                node = new EqualsNode();
                break;
            case CFGLexer.OP_NEQUALS:
                node = new NEqualsNode();
                break;
            default:
                return null;
        }

        node.Value = ctx.op.getText();

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            //System.out.println(child.getClass().getSimpleName());
            node.Nodes.add(visit(child));
        }

        return node;
    }

    @Override public Node visitFunctionCall(CFGParser.FunctionCallContext ctx) { return visitChildren(ctx); }

    @Override public Node visitParams(CFGParser.ParamsContext ctx) { return visitChildren(ctx); }

    @Override public Node visitMultipleParams(CFGParser.MultipleParamsContext ctx) { return visitChildren(ctx); }

    @Override public Node visitDclParams(CFGParser.DclParamsContext ctx) { return visitChildren(ctx); }

    @Override public Node visitMultipleDclParams(CFGParser.MultipleDclParamsContext ctx) { return visitChildren(ctx); }

    @Override public Node visitType(CFGParser.TypeContext ctx) { return visitChildren(ctx); }

    @Override public Node visitPrimType(CFGParser.PrimTypeContext ctx) {
        TypeNode node = new TypeNode();

        node.Value = ctx.getText();

        return node;
    }

    @Override public Node visitComplexType(CFGParser.ComplexTypeContext ctx) {
        TypeNode node = new TypeNode();

        if(ctx.listType != null) {
            node.Value = "List<" + visit(ctx.type()).Value + ">";
        } else {
            node.Value = ctx.getText();
        }

        return node;
    }

    @Override public Node visitIdentifier(CFGParser.IdentifierContext ctx) {
        IdentifierNode node = new IdentifierNode();

        node.Value = ctx.getText();

        return node;
    }

    @Override public Node visitLiteral(CFGParser.LiteralContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitNumberLiteral(CFGParser.NumberLiteralContext ctx) {
        NumberNode numberNode = new NumberNode();

        numberNode.Value = ctx.getText();

        return numberNode;
    }

    @Override public Node visitStringLiteral(CFGParser.StringLiteralContext ctx) {
        StringNode stringNode = new StringNode();

        stringNode.Value = ctx.getChild(1).getText();

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
