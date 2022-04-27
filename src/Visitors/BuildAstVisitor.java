package Visitors;

import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.*;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.OpNode;
import ASTNodes.ValueNodes.StringNode;
import Parser.*;

public class BuildAstVisitor extends CFGBaseVisitor<Node> {

    @Override public Node visitProgram(CFGParser.ProgramContext ctx) {
        ProgramNode node = new ProgramNode();

        node.Environment = (SectionNode) visit(ctx.environmentSection());
        node.Behavior = (SectionNode) visit(ctx.behaviorSection());
        node.Update = (SectionNode) visit(ctx.updateSection());
        node.Output = (SectionNode) visit(ctx.outputSection());

        node.Line = ctx.getStart().getLine();

        return node;
    }

    @Override public Node visitEnvironmentSection(CFGParser.EnvironmentSectionContext ctx) {
        SectionNode node = new SectionNode();
        node.Line = ctx.getStart().getLine();

        node.Name = "Environment";

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            node.Lines.add(visit(child));
        }

        return node;
    }

    @Override public Node visitBehaviorSection(CFGParser.BehaviorSectionContext ctx) {
        SectionNode sectionNode = new SectionNode();
        sectionNode.Line = ctx.getStart().getLine();

        sectionNode.Name = "Behavior";

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            sectionNode.Lines.add(visit(child));
        }

        return sectionNode;
    }

    @Override public Node visitUpdateSection(CFGParser.UpdateSectionContext ctx) {
        SectionNode sectionNode = new SectionNode();
        sectionNode.Line = ctx.getStart().getLine();
        sectionNode.Name = "Update";

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            sectionNode.Lines.add(visit(child));
        }

        return sectionNode;
    }

    @Override public Node visitOutputSection(CFGParser.OutputSectionContext ctx) {
        SectionNode sectionNode = new SectionNode();
        sectionNode.Line = ctx.getStart().getLine();
        sectionNode.Name = "Output";

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            sectionNode.Lines.add(visit(child));
        }

        return sectionNode;
    }

    @Override public Node visitLine(CFGParser.LineContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override public Node visitDcl(CFGParser.DclContext ctx) {
        return visitChildren(ctx);}

    @Override public Node visitFunctionDcl(CFGParser.FunctionDclContext ctx) {
        FunctionDclNode node = new FunctionDclNode();
        node.Line = ctx.getStart().getLine();

        node.Type = visit(ctx.type());
        node.Identifier = (IdentifierNode) visit(ctx.identifier());

        for(var paramChild : ctx.dclParams()) {
            node.Parameters.add((ParamNode) visit(paramChild));
        }

        node.Body = (BodyNode) visit(ctx.codeBlock());

        return node;
    }

    @Override public Node visitProcedureDcl(CFGParser.ProcedureDclContext ctx) {
        FunctionDclNode node = new FunctionDclNode();
        node.Line = ctx.getStart().getLine();

        node.Identifier = (IdentifierNode) visit(ctx.identifier());

        for(var paramChild : ctx.dclParams()) {
            node.Parameters.add((ParamNode) visit(paramChild));
        }

        node.Body = (BodyNode) visit(ctx.codeBlock());

        return node;
    }

    @Override public Node visitListDcl(CFGParser.ListDclContext ctx) {
        ListDclNode node = new ListDclNode();
        node.Line = ctx.getStart().getLine();

        node.Type = visit(ctx.type());
        node.Identifier = (IdentifierNode) visit(ctx.identifier());

        for(var paramChild : ctx.params()) {
            node.Parameters.add((ParamNode) visit(paramChild));
        }

        return node;
    }

    @Override public Node visitClassDcl(CFGParser.ClassDclContext ctx) {
        ClassNode node = new ClassNode();
        node.Line = ctx.getStart().getLine();

        node.Type = visit(ctx.type());
        node.Identifier = (IdentifierNode) visit(ctx.identifier());
        node.Body = (BodyNode) visit(ctx.codeBlock());

        return node;
    }

    @Override public Node visitContructorDcl(CFGParser.ContructorDclContext ctx) {
        ConstructorDclNode node = new ConstructorDclNode();
        node.Line = ctx.getStart().getLine();

        node.Type = visit(ctx.type());

        for(var paramChild : ctx.dclParams()) {
            node.Parameters.add((ParamNode) visit(paramChild));
        }

        node.Body = (BodyNode) visit(ctx.codeBlock());

        return node;
    }

    @Override public Node visitConstructorCall(CFGParser.ConstructorCallContext ctx) {
        ConstructorCallNode node = new ConstructorCallNode();
        node.Line = ctx.getStart().getLine();

        node.Type = visit(ctx.type());

        for(var paramChild : ctx.params()) {
            node.Parameters.add((ParamNode) visit(paramChild));
        }
        
        return node;
    }

    @Override public Node visitObjDcl(CFGParser.ObjDclContext ctx) {
        ObjDclNode node = new ObjDclNode();
        node.Name = "dcl";
        node.Line = ctx.getStart().getLine();

        node.Type = visit(ctx.type());
        node.Identifier = (IdentifierNode) visit(ctx.identifier());

        if(ctx.constructorCall() != null) {
            node.ObjValue = visit(ctx.constructorCall());
        } else if(ctx.expr() != null) {
            node.ObjValue = visit(ctx.expr());
        }

        return node;
    }

    @Override public Node visitStatement(CFGParser.StatementContext ctx) {

        if(ctx.expr() != null) {
            ReturnNode node = new ReturnNode();
            node.Line = ctx.getStart().getLine();
            node.expressionNode = (ExpressionNode) visit(ctx.expr());

            return node;
        }

        return visitChildren(ctx);
    }

    @Override public Node visitSelectiveCtrl(CFGParser.SelectiveCtrlContext ctx) { return visitChildren(ctx); }

    @Override public Node visitIfElseStmt(CFGParser.IfElseStmtContext ctx) {
        IfElseNode node = new IfElseNode();
        node.Line = ctx.getStart().getLine();

        node.condition = (ExpressionNode) visit(ctx.expr());
        node.Body = (BodyNode) visit(ctx.codeBlock());

        if(ctx.right != null)
            node.ElseIf = (ElseIfNode) visitElseIfStmt(ctx.right);

        return node;
    }

    @Override public Node visitElseIfStmt(CFGParser.ElseIfStmtContext ctx) {
        ElseIfNode node = new ElseIfNode();
        node.Line = ctx.getStart().getLine();

        if(ctx.elseStmt() != null) {
            node.Body = (BodyNode) visit(ctx.elseStmt());
        } else {
            node.condition = (ExpressionNode) visit(ctx.expr());
            node.Body = (BodyNode) visit(ctx.codeBlock());
            node.ElseIf = (ElseIfNode) visitElseIfStmt(ctx.right);
        }

        return node;
    }

    @Override public Node visitElseStmt(CFGParser.ElseStmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitSwitchStmt(CFGParser.SwitchStmtContext ctx) {
        SwitchNode node = new SwitchNode();
        node.Line = ctx.getStart().getLine();

        node.switchValue = visit(ctx.expr());
        node.Body = (SwitchBody) visit(ctx.switchBody());

        return node;
    }

    @Override public Node visitSwitchBody(CFGParser.SwitchBodyContext ctx) {
        SwitchBody node = new SwitchBody();
        node.Line = ctx.getStart().getLine();

        for(var switchCase : ctx.switchcase()) {
            node.cases.add(visit(switchCase));
        }

        return node;
    }

    @Override public Node visitIterativeCtrl(CFGParser.IterativeCtrlContext ctx) { return visitChildren(ctx); }

    @Override public Node visitWhileLoop(CFGParser.WhileLoopContext ctx) {
        WhileLoopNode node = new WhileLoopNode();
        node.Line = ctx.getStart().getLine();

        node.condition = visit(ctx.expr());
        node.Body = (BodyNode) visit(ctx.codeBlock());

        return node;
    }

    @Override public Node visitForLoop(CFGParser.ForLoopContext ctx) {
        ForLoopNode node = new ForLoopNode();
        node.Line = ctx.getStart().getLine();

        node.identifier = (IdentifierNode) visit(ctx.loopNumber);
        if(ctx.numberLiteral() != null)
            node.rangeInt = (NumberNode) visit(ctx.numberLiteral());
        else
            node.rangeIdentifier = (IdentifierNode) visit(ctx.rangeNumber);

        node.Body = (BodyNode) visit(ctx.codeBlock());

        return node;
    }

    @Override public Node visitAssignment(CFGParser.AssignmentContext ctx) {
        AssignmentNode node = new AssignmentNode();
        node.Line = ctx.getStart().getLine();

        node.Identifier = (IdentifierNode) visit(ctx.identifier(0));
        node.Equals.Name = "=";

        if(ctx.value != null)
            node.ValueNode = visit(ctx.value);

        if(ctx.expr() != null)
            node.ValueNode = visit(ctx.expr());

        return node;
    }

    @Override public Node visitInfixExpr(CFGParser.InfixExprContext ctx) {
        InfixExpressionNode node = new InfixExpressionNode();
        node.Line = ctx.getStart().getLine();

        switch (ctx.op.getType()) {
            case CFGLexer.OP_ADD:
                node.Name = "Expr: add";
                break;

            case CFGLexer.OP_SUB:
                node.Name = "Expr: sub";
                break;

            case CFGLexer.OP_MUL:
                node.Name = "Expr: mul";
                break;

            case CFGLexer.OP_DIV:
                node.Name = "Expr: div";
                break;
            case CFGLexer.OP_POW:
                node.Name = "Expr: pow";
                break;
            case CFGLexer.OP_MOD:
                node.Name = "Expr: mod";
                break;
        }

        node.Left = visit(ctx.left);
        node.Right = visit(ctx.right);
        node.Operator = new OpNode();
        node.Operator.Name = ctx.op.getText();

        return node;
    }

    @Override public Node visitFuncExpr(CFGParser.FuncExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitLiteralExpr(CFGParser.LiteralExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitLogicalExpr(CFGParser.LogicalExprContext ctx) {
        LogicalNode node = new LogicalNode();
        node.Line = ctx.getStart().getLine();

        switch (ctx.op.getType()) {
            case CFGLexer.OP_AND:
            case CFGLexer.OP_AND2:
                node.Name = "Expr: and";
                break;
            case CFGLexer.OP_OR:
            case CFGLexer.OP_OR2:
                node.Name = "Expr: or";
                break;
            default:
                return null;
        }

        node.Left = (ExpressionNode) visit(ctx.left);
        node.Right = (ExpressionNode) visit(ctx.right);
        node.Operator = new OpNode();
        node.Operator.Name = ctx.op.getText();



        return node;
    }

    @Override public Node visitArrExpr(CFGParser.ArrExprContext ctx) {
        ArrayExprNode node = new ArrayExprNode();
        node.Line = ctx.getStart().getLine();

        node.Left = visit(ctx.left);
        node.Index = visit(ctx.index);

        if(ctx.right != null)
            node.Right = visit(ctx.right);

        return node;
    }

    @Override public Node visitParensExpr(CFGParser.ParensExprContext ctx) {
        return visit(ctx.middel);
    }

    @Override public Node visitIdentifierExpr(CFGParser.IdentifierExprContext ctx) { return visitChildren(ctx); }

    @Override public Node visitCompareExpr(CFGParser.CompareExprContext ctx) {
        CompareNode node = new CompareNode();
        node.Line = ctx.getStart().getLine();

        switch (ctx.op.getType()) {
            case CFGLexer.OP_LTOE:
                node.Name = "Expr: LTOE";
                break;

            case CFGLexer.OP_GTOE:
                node.Name = "Expr: GTOE";
                break;

            case CFGLexer.OP_LT:
                node.Name = "Expr: LT";
                break;

            case CFGLexer.OP_GT:
                node.Name = "Expr: GT";
                break;
            case CFGLexer.OP_EQUALS:
                node.Name = "Expr: EQUALS";
                break;
            case CFGLexer.OP_NEQUALS:
                node.Name = "Expr: NEQUALS";
                break;
        }

        node.Operator = new OpNode();
        node.Operator.Name = ctx.op.getText();

        node.Left = visit(ctx.left);
        node.Right = visit(ctx.right);

        return node;
    }

    @Override public Node visitFunctionCall(CFGParser.FunctionCallContext ctx) {
        FunctionCallNode node = new FunctionCallNode();
        node.Line = ctx.getStart().getLine();

        node.Identifier = (IdentifierNode) visit(ctx.identifier());

        for(var paramChild : ctx.params()) {
            node.Parameters.add((ParamNode) visit(paramChild));
        }
        
        return node;
    }

    @Override public Node visitParams(CFGParser.ParamsContext ctx) {
        ParamNode node = new ParamNode();
        node.Line = ctx.getStart().getLine();

        node.Identifier = visitChildren(ctx);

        return node;
    }

    @Override public Node visitDclParams(CFGParser.DclParamsContext ctx) {
        ParamNode node = new ParamNode();
        node.Line = ctx.getStart().getLine();

        node.Type = (TypeNode) visit(ctx.type());
        node.Identifier = visit(ctx.identifier());

        return node;
    }

    @Override public Node visitType(CFGParser.TypeContext ctx) { return visitChildren(ctx); }

    @Override public Node visitPrimType(CFGParser.PrimTypeContext ctx) {
        TypeNode node = new TypeNode();
        node.Line = ctx.getStart().getLine();

        node.Name = ctx.getText();

        return node;
    }

    @Override public Node visitComplexType(CFGParser.ComplexTypeContext ctx) {
        TypeNode node = new TypeNode();
        node.Line = ctx.getStart().getLine();

        if(ctx.listType != null) {
            node.Name = "List<" + visit(ctx.type()).Value + ">";
        } else {
            node.Name = ctx.getText();
        }

        return node;
    }

    @Override public Node visitIdentifier(CFGParser.IdentifierContext ctx) {
        IdentifierNode node = new IdentifierNode();
        node.Line = ctx.getStart().getLine();

        node.Name = ctx.getText();

        return node;
    }

    @Override public Node visitLiteral(CFGParser.LiteralContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Node visitNumberLiteral(CFGParser.NumberLiteralContext ctx) {
        NumberNode numberNode = new NumberNode();
        numberNode.Line = ctx.getStart().getLine();

        numberNode.Name = ctx.getText();

        return numberNode;
    }

    @Override public Node visitStringLiteral(CFGParser.StringLiteralContext ctx) {
        StringNode stringNode = new StringNode();
        stringNode.Line = ctx.getStart().getLine();
        stringNode.Name = "\"" + ctx.getChild(1).getText() + "\"";

        return stringNode;
    }

    @Override public Node visitBoolLiteral(CFGParser.BoolLiteralContext ctx) {
        BoolNode boolNode = new BoolNode();
        boolNode.Line = ctx.getStart().getLine();
        boolNode.Name = ctx.getText();

        return boolNode;
    }

    @Override public Node visitBool(CFGParser.BoolContext ctx) { return visitChildren(ctx); }

    @Override public Node visitCodeBlock(CFGParser.CodeBlockContext ctx) {
        BodyNode node = new BodyNode();
        node.Line = ctx.getStart().getLine();

        for(var child : ctx.children) {
            if(child.getClass().getSimpleName().equals("TerminalNodeImpl"))
                continue;
            node.Lines.add(visit(child));
        }

        return node;
    }

    @Override public Node visitEndCondition(CFGParser.EndConditionContext ctx){
        EndConditionNode node = new EndConditionNode();
        node.Line = ctx.getStart().getLine();

        node.Body = (BodyNode) visit(ctx.codeBlock());

        return node;
    }

    @Override public Node visitInitCondition(CFGParser.InitConditionContext ctx) {
        InitConditionNode node = new InitConditionNode();
        node.Line = ctx.getStart().getLine();
        node.Body = (BodyNode) visit(ctx.codeBlock());
        node.type = visit(ctx.type());

        return node;
    }
}
