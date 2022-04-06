package Visitors;

import ASTNodes.*;
import Main.*;
import com.sun.jdi.Value;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.Console;

public class BuildAstVisitor extends CFGBaseVisitor<ExpressionNode> {
    @Override public ExpressionNode visitProgram(CFGParser.ProgramContext ctx) {
        return visit(ctx.environmentSection());
    }

    @Override public ExpressionNode visitEnvironmentSection(CFGParser.EnvironmentSectionContext ctx) {
        EnvironmentNode environmentNode = new EnvironmentNode();
        for (var line : ctx.line()) {
            environmentNode.nodes.add(visit(line));
        }
        return environmentNode;
    }

    @Override public ExpressionNode visitBehaviorSection(CFGParser.BehaviorSectionContext ctx) {
        return visitChildren(ctx);
    }

    @Override public ExpressionNode visitUpdateSection(CFGParser.UpdateSectionContext ctx) {
        return visitChildren(ctx);
    }

    @Override public ExpressionNode visitOutputSection(CFGParser.OutputSectionContext ctx) {
        return visitChildren(ctx);
    }

    @Override public ExpressionNode visitLineExpr(CFGParser.LineExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override public ExpressionNode visitDcl(CFGParser.DclContext ctx) {
        return visitChildren(ctx);
    }

    @Override public ExpressionNode visitEndCondition(CFGParser.EndConditionContext ctx) { return visitChildren(ctx); }

    @Override public ExpressionNode visitInitCondition(CFGParser.InitConditionContext ctx) { return visitChildren(ctx); }

    @Override public ExpressionNode visitFunctionDcl(CFGParser.FunctionDclContext ctx) { return visitChildren(ctx); }

    @Override public ExpressionNode visitFuncReturnBody(CFGParser.FuncReturnBodyContext ctx) { return visitChildren(ctx); }

    @Override public ExpressionNode visitListDcl(CFGParser.ListDclContext ctx) { return visitChildren(ctx); }

    @Override public ExpressionNode visitClassDcl(CFGParser.ClassDclContext ctx) { return visitChildren(ctx); }

    @Override public ExpressionNode visitClassBody(CFGParser.ClassBodyContext ctx) { return visitChildren(ctx); }

    @Override public ExpressionNode visitClassPropDcl(CFGParser.ClassPropDclContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitContructorDcl(CFGParser.ContructorDclContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitConstructorCall(CFGParser.ConstructorCallContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitObjDcl(CFGParser.ObjDclContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitPrimVarDcl(CFGParser.PrimVarDclContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitStatement(CFGParser.StatementContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitSelectiveCtrl(CFGParser.SelectiveCtrlContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitIfElseStmt(CFGParser.IfElseStmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitElseIfStmt(CFGParser.ElseIfStmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitSwitchStmt(CFGParser.SwitchStmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitSwitchBody(CFGParser.SwitchBodyContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitIterativeCtrl(CFGParser.IterativeCtrlContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitWhileLoop(CFGParser.WhileLoopContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitForLoop(CFGParser.ForLoopContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitStmtBody(CFGParser.StmtBodyContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitAssignment(CFGParser.AssignmentContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitInfixExpr(CFGParser.InfixExprContext ctx) {
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

        node.Left = visit(ctx.getChild(0));

        System.out.println(node.Left);

        node.Right = visit(ctx.getChild(1));

        System.out.println(node.Right);

        return node;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitFuncExpr(CFGParser.FuncExprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitLiteralExpr(CFGParser.LiteralExprContext ctx) {
        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitLogicalExpr(CFGParser.LogicalExprContext ctx) {


        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitArrExpr(CFGParser.ArrExprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitParensExpr(CFGParser.ParensExprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitPvrExpr(CFGParser.PvrExprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitIdentifierExpr(CFGParser.IdentifierExprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitCompareExpr(CFGParser.CompareExprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitFunctionCall(CFGParser.FunctionCallContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitParams(CFGParser.ParamsContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitMultipleParams(CFGParser.MultipleParamsContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitDclParams(CFGParser.DclParamsContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitMultipleDclParams(CFGParser.MultipleDclParamsContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitType(CFGParser.TypeContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitPrimType(CFGParser.PrimTypeContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitComplexType(CFGParser.ComplexTypeContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitIdentifier(CFGParser.IdentifierContext ctx) { return visitChildren(ctx); }

    @Override public ExpressionNode visitLiteral(CFGParser.LiteralContext ctx) {
        if (!ctx.numberLiteral().isEmpty()) {
            NumbernNode test = new NumbernNode();
            test.Value = Float.parseFloat(ctx.numberLiteral().getText());
            return test;
        }
        return null;
    }

    @Override public ExpressionNode visitNumberLiteral(CFGParser.NumberLiteralContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitStringLiteral(CFGParser.StringLiteralContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitBoolLiteral(CFGParser.BoolLiteralContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitBool(CFGParser.BoolContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public ExpressionNode visitCodeBlock(CFGParser.CodeBlockContext ctx) { return visitChildren(ctx); }
}
