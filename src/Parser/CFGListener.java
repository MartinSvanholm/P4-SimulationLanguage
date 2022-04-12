// Generated from C:/Users/Martin Svanholm/Documents/GitHub/P4-SimulationLanguage\CFG.g4 by ANTLR 4.9.2
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CFGParser}.
 */
public interface CFGListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CFGParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CFGParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CFGParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#environmentSection}.
	 * @param ctx the parse tree
	 */
	void enterEnvironmentSection(CFGParser.EnvironmentSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#environmentSection}.
	 * @param ctx the parse tree
	 */
	void exitEnvironmentSection(CFGParser.EnvironmentSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#behaviorSection}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorSection(CFGParser.BehaviorSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#behaviorSection}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorSection(CFGParser.BehaviorSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#updateSection}.
	 * @param ctx the parse tree
	 */
	void enterUpdateSection(CFGParser.UpdateSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#updateSection}.
	 * @param ctx the parse tree
	 */
	void exitUpdateSection(CFGParser.UpdateSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#outputSection}.
	 * @param ctx the parse tree
	 */
	void enterOutputSection(CFGParser.OutputSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#outputSection}.
	 * @param ctx the parse tree
	 */
	void exitOutputSection(CFGParser.OutputSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(CFGParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(CFGParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(CFGParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(CFGParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#endCondition}.
	 * @param ctx the parse tree
	 */
	void enterEndCondition(CFGParser.EndConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#endCondition}.
	 * @param ctx the parse tree
	 */
	void exitEndCondition(CFGParser.EndConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#initCondition}.
	 * @param ctx the parse tree
	 */
	void enterInitCondition(CFGParser.InitConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#initCondition}.
	 * @param ctx the parse tree
	 */
	void exitInitCondition(CFGParser.InitConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#functionDcl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDcl(CFGParser.FunctionDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#functionDcl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDcl(CFGParser.FunctionDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#procedureDcl}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDcl(CFGParser.ProcedureDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#procedureDcl}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDcl(CFGParser.ProcedureDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#listDcl}.
	 * @param ctx the parse tree
	 */
	void enterListDcl(CFGParser.ListDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#listDcl}.
	 * @param ctx the parse tree
	 */
	void exitListDcl(CFGParser.ListDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#classDcl}.
	 * @param ctx the parse tree
	 */
	void enterClassDcl(CFGParser.ClassDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#classDcl}.
	 * @param ctx the parse tree
	 */
	void exitClassDcl(CFGParser.ClassDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#contructorDcl}.
	 * @param ctx the parse tree
	 */
	void enterContructorDcl(CFGParser.ContructorDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#contructorDcl}.
	 * @param ctx the parse tree
	 */
	void exitContructorDcl(CFGParser.ContructorDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#constructorCall}.
	 * @param ctx the parse tree
	 */
	void enterConstructorCall(CFGParser.ConstructorCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#constructorCall}.
	 * @param ctx the parse tree
	 */
	void exitConstructorCall(CFGParser.ConstructorCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#objDcl}.
	 * @param ctx the parse tree
	 */
	void enterObjDcl(CFGParser.ObjDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#objDcl}.
	 * @param ctx the parse tree
	 */
	void exitObjDcl(CFGParser.ObjDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CFGParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CFGParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#selectiveCtrl}.
	 * @param ctx the parse tree
	 */
	void enterSelectiveCtrl(CFGParser.SelectiveCtrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#selectiveCtrl}.
	 * @param ctx the parse tree
	 */
	void exitSelectiveCtrl(CFGParser.SelectiveCtrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#ifElseStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStmt(CFGParser.IfElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#ifElseStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStmt(CFGParser.IfElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#elseIfStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStmt(CFGParser.ElseIfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#elseIfStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStmt(CFGParser.ElseIfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseStmt(CFGParser.ElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseStmt(CFGParser.ElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStmt(CFGParser.SwitchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStmt(CFGParser.SwitchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#switchBody}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBody(CFGParser.SwitchBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#switchBody}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBody(CFGParser.SwitchBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#switchcase}.
	 * @param ctx the parse tree
	 */
	void enterSwitchcase(CFGParser.SwitchcaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#switchcase}.
	 * @param ctx the parse tree
	 */
	void exitSwitchcase(CFGParser.SwitchcaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#iterativeCtrl}.
	 * @param ctx the parse tree
	 */
	void enterIterativeCtrl(CFGParser.IterativeCtrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#iterativeCtrl}.
	 * @param ctx the parse tree
	 */
	void exitIterativeCtrl(CFGParser.IterativeCtrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(CFGParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(CFGParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(CFGParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(CFGParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(CFGParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(CFGParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(CFGParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(CFGParser.InfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(CFGParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(CFGParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(CFGParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(CFGParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpr(CFGParser.LogicalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpr(CFGParser.LogicalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrExpr(CFGParser.ArrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrExpr(CFGParser.ArrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(CFGParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(CFGParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(CFGParser.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(CFGParser.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(CFGParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link CFGParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(CFGParser.CompareExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(CFGParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(CFGParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(CFGParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(CFGParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#dclParams}.
	 * @param ctx the parse tree
	 */
	void enterDclParams(CFGParser.DclParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#dclParams}.
	 * @param ctx the parse tree
	 */
	void exitDclParams(CFGParser.DclParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CFGParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CFGParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#primType}.
	 * @param ctx the parse tree
	 */
	void enterPrimType(CFGParser.PrimTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#primType}.
	 * @param ctx the parse tree
	 */
	void exitPrimType(CFGParser.PrimTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#complexType}.
	 * @param ctx the parse tree
	 */
	void enterComplexType(CFGParser.ComplexTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#complexType}.
	 * @param ctx the parse tree
	 */
	void exitComplexType(CFGParser.ComplexTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(CFGParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(CFGParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CFGParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CFGParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(CFGParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(CFGParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(CFGParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(CFGParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(CFGParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(CFGParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(CFGParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(CFGParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(CFGParser.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(CFGParser.CodeBlockContext ctx);
}