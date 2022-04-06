package Visitors;
import Parser.*;
import SymbolTable.*;

import javax.imageio.IIOException;
import java.io.IOException;

import static Main.Main.ANSI_RED;
import static Main.Main.ANSI_RESET;

public class SymbolTableVisitor extends CFGBaseVisitor<Object> {
    public SymbolTable SymbolTable;

    public SymbolTableVisitor(SymbolTable symbolTable) {
        SymbolTable = symbolTable;
    }

    @Override public Object visitProgram(CFGParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitEnvironmentSection(CFGParser.EnvironmentSectionContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitBehaviorSection(CFGParser.BehaviorSectionContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitUpdateSection(CFGParser.UpdateSectionContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitOutputSection(CFGParser.OutputSectionContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitDcl(CFGParser.DclContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitEndCondition(CFGParser.EndConditionContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitInitCondition(CFGParser.InitConditionContext ctx) {
        return visitChildren(ctx); 
    }

    @Override public Object visitFunctionDcl(CFGParser.FunctionDclContext ctx) {
        try {
            SymbolTable.AddSymbol(ctx);
        } catch (IOException e) {
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
        }
        return visitChildren(ctx);
    }

    @Override public Object visitFuncReturnBody(CFGParser.FuncReturnBodyContext ctx) { return visitChildren(ctx); }

    @Override public Object visitListDcl(CFGParser.ListDclContext ctx) { return visitChildren(ctx); }


    @Override public Object visitClassDcl(CFGParser.ClassDclContext ctx) { return visitChildren(ctx); }

    @Override public Object visitClassBody(CFGParser.ClassBodyContext ctx) { return visitChildren(ctx); }

    @Override public Object visitClassPropDcl(CFGParser.ClassPropDclContext ctx) { return visitChildren(ctx); }

    @Override public Object visitObjDcl(CFGParser.ObjDclContext ctx) { return visitChildren(ctx); }

    @Override public Object visitContructorDcl(CFGParser.ContructorDclContext ctx) { return visitChildren(ctx); }

    @Override public Object visitConstructorCall(CFGParser.ConstructorCallContext ctx) { return visitChildren(ctx); }

    @Override public Object visitPrimVarDcl(CFGParser.PrimVarDclContext ctx) {
        try {
            SymbolTable.AddSymbol(ctx);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override public Object visitStatement(CFGParser.StatementContext ctx) { return visitChildren(ctx); }

    @Override public Object visitSelectiveCtrl(CFGParser.SelectiveCtrlContext ctx) { return visitChildren(ctx); }

    @Override public Object visitIfElseStmt(CFGParser.IfElseStmtContext ctx) { return visitChildren(ctx); }

    @Override public Object visitElseIfStmt(CFGParser.ElseIfStmtContext ctx) { return visitChildren(ctx); }

    @Override public Object visitSwitchStmt(CFGParser.SwitchStmtContext ctx) { return visitChildren(ctx); }

    @Override public Object visitSwitchBody(CFGParser.SwitchBodyContext ctx) { return visitChildren(ctx); }

    @Override public Object visitIterativeCtrl(CFGParser.IterativeCtrlContext ctx) { return visitChildren(ctx); }

    @Override public Object visitWhileLoop(CFGParser.WhileLoopContext ctx) { return visitChildren(ctx); }

    @Override public Object visitForLoop(CFGParser.ForLoopContext ctx) { return visitChildren(ctx); }

    @Override public Object visitStmtBody(CFGParser.StmtBodyContext ctx) { return visitChildren(ctx); }

    @Override public Object visitAssignment(CFGParser.AssignmentContext ctx) { return visitChildren(ctx); }

    @Override public Object visitFunctionCall(CFGParser.FunctionCallContext ctx) { return visitChildren(ctx); }

    @Override public Object visitParams(CFGParser.ParamsContext ctx) { return visitChildren(ctx); }

    @Override public Object visitType(CFGParser.TypeContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimType(CFGParser.PrimTypeContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitComplexType(CFGParser.ComplexTypeContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIdentifier(CFGParser.IdentifierContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitLiteral(CFGParser.LiteralContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitNumberLiteral(CFGParser.NumberLiteralContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStringLiteral(CFGParser.StringLiteralContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitBoolLiteral(CFGParser.BoolLiteralContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitBool(CFGParser.BoolContext ctx) { return visitChildren(ctx); }
}