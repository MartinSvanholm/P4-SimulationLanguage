// Generated from C:/Users/marti/OneDrive/Dokumenter/GitHub/P4-SimulationLanguage\CFG.g4 by ANTLR 4.9.2
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CFGParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CFGVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CFGParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CFGParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#environmentSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvironmentSection(CFGParser.EnvironmentSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#behaviorSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorSection(CFGParser.BehaviorSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#updateSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSection(CFGParser.UpdateSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#outputSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputSection(CFGParser.OutputSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(CFGParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(CFGParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#endCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndCondition(CFGParser.EndConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#initCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitCondition(CFGParser.InitConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#functionDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDcl(CFGParser.FunctionDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#funcReturnBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncReturnBody(CFGParser.FuncReturnBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#listDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListDcl(CFGParser.ListDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#classDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDcl(CFGParser.ClassDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(CFGParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#classPropDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassPropDcl(CFGParser.ClassPropDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#contructorDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContructorDcl(CFGParser.ContructorDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#constructorCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorCall(CFGParser.ConstructorCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#objDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjDcl(CFGParser.ObjDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CFGParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#selectiveCtrl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectiveCtrl(CFGParser.SelectiveCtrlContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#ifElseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStmt(CFGParser.IfElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#elseIfStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStmt(CFGParser.ElseIfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#elseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStmt(CFGParser.ElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#switchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStmt(CFGParser.SwitchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#switchBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBody(CFGParser.SwitchBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#iterativeCtrl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterativeCtrl(CFGParser.IterativeCtrlContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(CFGParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(CFGParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#stmtBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtBody(CFGParser.StmtBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(CFGParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixExpr(CFGParser.InfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(CFGParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(CFGParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpr(CFGParser.LogicalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrExpr(CFGParser.ArrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(CFGParser.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(CFGParser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(CFGParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(CFGParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(CFGParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#dclParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclParams(CFGParser.DclParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CFGParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#primType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimType(CFGParser.PrimTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#complexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexType(CFGParser.ComplexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(CFGParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CFGParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(CFGParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(CFGParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(CFGParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(CFGParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#codeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(CFGParser.CodeBlockContext ctx);
}