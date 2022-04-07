// Generated from C:/Users/Martin Svanholm/Documents/GitHub/P4-SimulationLanguage\CFG.g4 by ANTLR 4.9.2
package Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CFGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, OP_POW=37, OP_MUL=38, 
		OP_DIV=39, OP_MOD=40, OP_ADD=41, OP_SUB=42, OP_LTOE=43, OP_GTOE=44, OP_LT=45, 
		OP_GT=46, OP_EQUALS=47, OP_NEQUALS=48, OP_AND=49, OP_AND2=50, OP_OR=51, 
		OP_OR2=52, Number=53, Letter=54, Comma=55, Equals=56, SemiColon=57, Comment=58, 
		MultiComment=59, WS=60;
	public static final int
		RULE_program = 0, RULE_environmentSection = 1, RULE_behaviorSection = 2, 
		RULE_updateSection = 3, RULE_outputSection = 4, RULE_line = 5, RULE_dcl = 6, 
		RULE_endCondition = 7, RULE_initCondition = 8, RULE_functionDcl = 9, RULE_funcReturnBody = 10, 
		RULE_listDcl = 11, RULE_classDcl = 12, RULE_classBody = 13, RULE_classPropDcl = 14, 
		RULE_contructorDcl = 15, RULE_constructorCall = 16, RULE_objDcl = 17, 
		RULE_statement = 18, RULE_selectiveCtrl = 19, RULE_ifElseStmt = 20, RULE_elseIfStmt = 21, 
		RULE_switchStmt = 22, RULE_switchBody = 23, RULE_iterativeCtrl = 24, RULE_whileLoop = 25, 
		RULE_forLoop = 26, RULE_stmtBody = 27, RULE_assignment = 28, RULE_expr = 29, 
		RULE_functionCall = 30, RULE_params = 31, RULE_multipleParams = 32, RULE_dclParams = 33, 
		RULE_multipleDclParams = 34, RULE_type = 35, RULE_primType = 36, RULE_complexType = 37, 
		RULE_identifier = 38, RULE_literal = 39, RULE_numberLiteral = 40, RULE_stringLiteral = 41, 
		RULE_boolLiteral = 42, RULE_bool = 43, RULE_codeBlock = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "environmentSection", "behaviorSection", "updateSection", 
			"outputSection", "line", "dcl", "endCondition", "initCondition", "functionDcl", 
			"funcReturnBody", "listDcl", "classDcl", "classBody", "classPropDcl", 
			"contructorDcl", "constructorCall", "objDcl", "statement", "selectiveCtrl", 
			"ifElseStmt", "elseIfStmt", "switchStmt", "switchBody", "iterativeCtrl", 
			"whileLoop", "forLoop", "stmtBody", "assignment", "expr", "functionCall", 
			"params", "multipleParams", "dclParams", "multipleDclParams", "type", 
			"primType", "complexType", "identifier", "literal", "numberLiteral", 
			"stringLiteral", "boolLiteral", "bool", "codeBlock"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Simulation Environment'", "'{'", "'}'", "'Simulation Behavior'", 
			"'Simulation Update'", "'Simulation Output'", "'EndCondition'", "'return'", 
			"'InitCondition<'", "'function'", "'List<'", "'constructor'", "'Create<'", 
			"'('", "')'", "'if'", "'else'", "'else if'", "'switch'", "'case'", "':'", 
			"'default:'", "'while'", "'for'", "'in range'", "'['", "']'", "' number '", 
			"'string'", "'bool'", "'Vehicle'", "'Node'", "'.'", "'\"'", "'true'", 
			"'false'", "'^'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<='", "'>='", 
			"'<'", "'>'", "'=='", "'!='", "' and '", "'&&'", "' or '", "'||'", null, 
			null, "','", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "OP_POW", "OP_MUL", "OP_DIV", "OP_MOD", "OP_ADD", "OP_SUB", "OP_LTOE", 
			"OP_GTOE", "OP_LT", "OP_GT", "OP_EQUALS", "OP_NEQUALS", "OP_AND", "OP_AND2", 
			"OP_OR", "OP_OR2", "Number", "Letter", "Comma", "Equals", "SemiColon", 
			"Comment", "MultiComment", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CFG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CFGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public EnvironmentSectionContext environmentSection() {
			return getRuleContext(EnvironmentSectionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CFGParser.EOF, 0); }
		public BehaviorSectionContext behaviorSection() {
			return getRuleContext(BehaviorSectionContext.class,0);
		}
		public UpdateSectionContext updateSection() {
			return getRuleContext(UpdateSectionContext.class,0);
		}
		public OutputSectionContext outputSection() {
			return getRuleContext(OutputSectionContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			environmentSection();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(91);
				behaviorSection();
				}
			}

			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(94);
				updateSection();
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(97);
				outputSection();
				}
			}

			setState(100);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnvironmentSectionContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public EndConditionContext endCondition() {
			return getRuleContext(EndConditionContext.class,0);
		}
		public EnvironmentSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_environmentSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterEnvironmentSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitEnvironmentSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitEnvironmentSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvironmentSectionContext environmentSection() throws RecognitionException {
		EnvironmentSectionContext _localctx = new EnvironmentSectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_environmentSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__0);
			setState(103);
			match(T__1);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__22) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter) | (1L << Comment) | (1L << MultiComment))) != 0)) {
				{
				{
				setState(104);
				line();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(110);
				endCondition();
				}
			}

			setState(113);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BehaviorSectionContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public BehaviorSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behaviorSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterBehaviorSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitBehaviorSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitBehaviorSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BehaviorSectionContext behaviorSection() throws RecognitionException {
		BehaviorSectionContext _localctx = new BehaviorSectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_behaviorSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__3);
			setState(116);
			match(T__1);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__22) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter) | (1L << Comment) | (1L << MultiComment))) != 0)) {
				{
				{
				setState(117);
				line();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateSectionContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public UpdateSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterUpdateSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitUpdateSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitUpdateSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateSectionContext updateSection() throws RecognitionException {
		UpdateSectionContext _localctx = new UpdateSectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_updateSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__4);
			setState(126);
			match(T__1);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__22) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter) | (1L << Comment) | (1L << MultiComment))) != 0)) {
				{
				{
				setState(127);
				line();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputSectionContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public OutputSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterOutputSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitOutputSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitOutputSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputSectionContext outputSection() throws RecognitionException {
		OutputSectionContext _localctx = new OutputSectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_outputSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__5);
			setState(136);
			match(T__1);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__22) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter) | (1L << Comment) | (1L << MultiComment))) != 0)) {
				{
				{
				setState(137);
				line();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public InitConditionContext initCondition() {
			return getRuleContext(InitConditionContext.class,0);
		}
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public TerminalNode Comment() { return getToken(CFGParser.Comment, 0); }
		public TerminalNode MultiComment() { return getToken(CFGParser.MultiComment, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_line);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				initCondition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				dcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				assignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				expr(0);
				setState(150);
				match(SemiColon);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(152);
				match(Comment);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(153);
				match(MultiComment);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DclContext extends ParserRuleContext {
		public FunctionDclContext functionDcl() {
			return getRuleContext(FunctionDclContext.class,0);
		}
		public ListDclContext listDcl() {
			return getRuleContext(ListDclContext.class,0);
		}
		public ClassDclContext classDcl() {
			return getRuleContext(ClassDclContext.class,0);
		}
		public ObjDclContext objDcl() {
			return getRuleContext(ObjDclContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dcl);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				functionDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				listDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				classDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(159);
				objDcl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndConditionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public EndConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterEndCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitEndCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitEndCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndConditionContext endCondition() throws RecognitionException {
		EndConditionContext _localctx = new EndConditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_endCondition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__6);
			setState(163);
			match(T__1);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(164);
					codeBlock();
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(170);
			match(T__7);
			setState(171);
			expr(0);
			setState(172);
			match(SemiColon);
			setState(173);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitConditionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OP_GT() { return getToken(CFGParser.OP_GT, 0); }
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public InitConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterInitCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitInitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitInitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitConditionContext initCondition() throws RecognitionException {
		InitConditionContext _localctx = new InitConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_initCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__8);
			setState(176);
			type();
			setState(177);
			match(OP_GT);
			setState(178);
			match(T__1);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__22) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
				{
				{
				setState(179);
				codeBlock();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDclContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DclParamsContext dclParams() {
			return getRuleContext(DclParamsContext.class,0);
		}
		public StmtBodyContext stmtBody() {
			return getRuleContext(StmtBodyContext.class,0);
		}
		public PrimTypeContext primType() {
			return getRuleContext(PrimTypeContext.class,0);
		}
		public FuncReturnBodyContext funcReturnBody() {
			return getRuleContext(FuncReturnBodyContext.class,0);
		}
		public FunctionDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterFunctionDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitFunctionDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitFunctionDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDclContext functionDcl() throws RecognitionException {
		FunctionDclContext _localctx = new FunctionDclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDcl);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(T__9);
				setState(188);
				identifier();
				setState(189);
				dclParams();
				setState(190);
				stmtBody();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(T__9);
				setState(193);
				primType();
				setState(194);
				identifier();
				setState(195);
				dclParams();
				setState(196);
				funcReturnBody();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncReturnBodyContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public FuncReturnBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcReturnBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterFuncReturnBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitFuncReturnBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitFuncReturnBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncReturnBodyContext funcReturnBody() throws RecognitionException {
		FuncReturnBodyContext _localctx = new FuncReturnBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcReturnBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(201);
					codeBlock();
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(207);
			match(T__7);
			setState(208);
			expr(0);
			setState(209);
			match(SemiColon);
			setState(210);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListDclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OP_GT() { return getToken(CFGParser.OP_GT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public MultipleParamsContext multipleParams() {
			return getRuleContext(MultipleParamsContext.class,0);
		}
		public ListDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterListDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitListDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitListDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListDclContext listDcl() throws RecognitionException {
		ListDclContext _localctx = new ListDclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(T__10);
			setState(213);
			type();
			setState(214);
			match(OP_GT);
			setState(215);
			identifier();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(216);
				match(T__1);
				setState(217);
				params();
				setState(218);
				multipleParams();
				setState(219);
				match(T__2);
				}
			}

			setState(223);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterClassDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitClassDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitClassDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDclContext classDcl() throws RecognitionException {
		ClassDclContext _localctx = new ClassDclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			type();
			setState(226);
			identifier();
			setState(227);
			classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassPropDclContext> classPropDcl() {
			return getRuleContexts(ClassPropDclContext.class);
		}
		public ClassPropDclContext classPropDcl(int i) {
			return getRuleContext(ClassPropDclContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__1);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__22) | (1L << T__23) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
				{
				{
				setState(230);
				classPropDcl();
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(236);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassPropDclContext extends ParserRuleContext {
		public ContructorDclContext contructorDcl() {
			return getRuleContext(ContructorDclContext.class,0);
		}
		public FunctionDclContext functionDcl() {
			return getRuleContext(FunctionDclContext.class,0);
		}
		public ListDclContext listDcl() {
			return getRuleContext(ListDclContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public ClassPropDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classPropDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterClassPropDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitClassPropDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitClassPropDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassPropDclContext classPropDcl() throws RecognitionException {
		ClassPropDclContext _localctx = new ClassPropDclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_classPropDcl);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				contructorDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				functionDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				listDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(241);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(242);
				assignment();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(243);
				expr(0);
				setState(244);
				match(SemiColon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContructorDclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OP_GT() { return getToken(CFGParser.OP_GT, 0); }
		public DclParamsContext dclParams() {
			return getRuleContext(DclParamsContext.class,0);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public ContructorDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contructorDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterContructorDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitContructorDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitContructorDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContructorDclContext contructorDcl() throws RecognitionException {
		ContructorDclContext _localctx = new ContructorDclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_contructorDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(T__11);
			setState(249);
			match(T__12);
			setState(250);
			type();
			setState(251);
			match(OP_GT);
			setState(252);
			dclParams();
			setState(253);
			match(T__1);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__22) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
				{
				{
				setState(254);
				codeBlock();
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(260);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorCallContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OP_GT() { return getToken(CFGParser.OP_GT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public MultipleParamsContext multipleParams() {
			return getRuleContext(MultipleParamsContext.class,0);
		}
		public ConstructorCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterConstructorCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitConstructorCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitConstructorCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorCallContext constructorCall() throws RecognitionException {
		ConstructorCallContext _localctx = new ConstructorCallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constructorCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(T__12);
			setState(263);
			type();
			setState(264);
			match(OP_GT);
			setState(265);
			match(T__13);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
				{
				setState(266);
				params();
				setState(267);
				multipleParams();
				}
			}

			setState(271);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjDclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Equals() { return getToken(CFGParser.Equals, 0); }
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public ConstructorCallContext constructorCall() {
			return getRuleContext(ConstructorCallContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ObjDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterObjDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitObjDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitObjDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjDclContext objDcl() throws RecognitionException {
		ObjDclContext _localctx = new ObjDclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_objDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			type();
			setState(274);
			identifier();
			setState(275);
			match(Equals);
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				{
				setState(276);
				constructorCall();
				}
				break;
			case T__13:
			case T__33:
			case T__34:
			case T__35:
			case Number:
			case Letter:
				{
				setState(277);
				expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(280);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public SelectiveCtrlContext selectiveCtrl() {
			return getRuleContext(SelectiveCtrlContext.class,0);
		}
		public IterativeCtrlContext iterativeCtrl() {
			return getRuleContext(IterativeCtrlContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statement);
		try {
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				selectiveCtrl();
				}
				break;
			case T__22:
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				iterativeCtrl();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				match(T__7);
				setState(285);
				expr(0);
				setState(286);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectiveCtrlContext extends ParserRuleContext {
		public IfElseStmtContext ifElseStmt() {
			return getRuleContext(IfElseStmtContext.class,0);
		}
		public SwitchStmtContext switchStmt() {
			return getRuleContext(SwitchStmtContext.class,0);
		}
		public SelectiveCtrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectiveCtrl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterSelectiveCtrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitSelectiveCtrl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitSelectiveCtrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectiveCtrlContext selectiveCtrl() throws RecognitionException {
		SelectiveCtrlContext _localctx = new SelectiveCtrlContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_selectiveCtrl);
		try {
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				ifElseStmt();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				switchStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtBodyContext stmtBody() {
			return getRuleContext(StmtBodyContext.class,0);
		}
		public ElseIfStmtContext elseIfStmt() {
			return getRuleContext(ElseIfStmtContext.class,0);
		}
		public IfElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterIfElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitIfElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitIfElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseStmtContext ifElseStmt() throws RecognitionException {
		IfElseStmtContext _localctx = new IfElseStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ifElseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(T__15);
			setState(295);
			match(T__13);
			setState(296);
			expr(0);
			setState(297);
			match(T__14);
			setState(298);
			stmtBody();
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16 || _la==T__17) {
				{
				setState(299);
				elseIfStmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseIfStmtContext extends ParserRuleContext {
		public StmtBodyContext stmtBody() {
			return getRuleContext(StmtBodyContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ElseIfStmtContext elseIfStmt() {
			return getRuleContext(ElseIfStmtContext.class,0);
		}
		public ElseIfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterElseIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitElseIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitElseIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStmtContext elseIfStmt() throws RecognitionException {
		ElseIfStmtContext _localctx = new ElseIfStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_elseIfStmt);
		int _la;
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				match(T__16);
				setState(303);
				stmtBody();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				match(T__17);
				setState(305);
				match(T__13);
				setState(306);
				expr(0);
				setState(307);
				match(T__14);
				setState(308);
				stmtBody();
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16 || _la==T__17) {
					{
					setState(309);
					elseIfStmt();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SwitchBodyContext switchBody() {
			return getRuleContext(SwitchBodyContext.class,0);
		}
		public SwitchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterSwitchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitSwitchStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitSwitchStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStmtContext switchStmt() throws RecognitionException {
		SwitchStmtContext _localctx = new SwitchStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_switchStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(T__18);
			setState(315);
			match(T__13);
			setState(316);
			expr(0);
			setState(317);
			match(T__14);
			setState(318);
			switchBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBodyContext extends ParserRuleContext {
		public List<NumberLiteralContext> numberLiteral() {
			return getRuleContexts(NumberLiteralContext.class);
		}
		public NumberLiteralContext numberLiteral(int i) {
			return getRuleContext(NumberLiteralContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SwitchBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterSwitchBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitSwitchBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitSwitchBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBodyContext switchBody() throws RecognitionException {
		SwitchBodyContext _localctx = new SwitchBodyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_switchBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(T__1);
			setState(333); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(321);
				match(T__19);
				setState(324);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Number:
					{
					setState(322);
					numberLiteral();
					}
					break;
				case T__10:
				case T__27:
				case T__28:
				case T__29:
				case T__30:
				case T__31:
				case Letter:
					{
					setState(323);
					type();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(326);
				match(T__20);
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__22) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
					{
					{
					setState(327);
					codeBlock();
					}
					}
					setState(332);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(335); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__19 );
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(337);
				match(T__21);
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
					{
					{
					setState(338);
					expr(0);
					}
					}
					setState(343);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(346);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterativeCtrlContext extends ParserRuleContext {
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public IterativeCtrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterativeCtrl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterIterativeCtrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitIterativeCtrl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitIterativeCtrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeCtrlContext iterativeCtrl() throws RecognitionException {
		IterativeCtrlContext _localctx = new IterativeCtrlContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_iterativeCtrl);
		try {
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				whileLoop();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				forLoop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileLoopContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtBodyContext stmtBody() {
			return getRuleContext(StmtBodyContext.class,0);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(T__22);
			setState(353);
			match(T__13);
			setState(354);
			expr(0);
			setState(355);
			match(T__14);
			setState(356);
			stmtBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForLoopContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public StmtBodyContext stmtBody() {
			return getRuleContext(StmtBodyContext.class,0);
		}
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(T__23);
			setState(359);
			identifier();
			setState(360);
			match(T__24);
			setState(361);
			match(T__13);
			setState(364);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				{
				setState(362);
				numberLiteral();
				}
				break;
			case Letter:
				{
				setState(363);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(366);
			match(T__14);
			setState(367);
			stmtBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtBodyContext extends ParserRuleContext {
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public StmtBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterStmtBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitStmtBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitStmtBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtBodyContext stmtBody() throws RecognitionException {
		StmtBodyContext _localctx = new StmtBodyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_stmtBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(T__1);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__22) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
				{
				{
				setState(370);
				codeBlock();
				}
				}
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(376);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode Equals() { return getToken(CFGParser.Equals, 0); }
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			identifier();
			setState(379);
			match(Equals);
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(380);
				identifier();
				}
				break;
			case 2:
				{
				setState(381);
				expr(0);
				}
				break;
			}
			setState(384);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InfixExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_POW() { return getToken(CFGParser.OP_POW, 0); }
		public TerminalNode OP_MUL() { return getToken(CFGParser.OP_MUL, 0); }
		public TerminalNode OP_DIV() { return getToken(CFGParser.OP_DIV, 0); }
		public TerminalNode OP_MOD() { return getToken(CFGParser.OP_MOD, 0); }
		public TerminalNode OP_ADD() { return getToken(CFGParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(CFGParser.OP_SUB, 0); }
		public InfixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterInfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitInfixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitInfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncExprContext extends ExprContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitFuncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExprContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_AND2() { return getToken(CFGParser.OP_AND2, 0); }
		public TerminalNode OP_AND() { return getToken(CFGParser.OP_AND, 0); }
		public TerminalNode OP_OR2() { return getToken(CFGParser.OP_OR2, 0); }
		public TerminalNode OP_OR() { return getToken(CFGParser.OP_OR, 0); }
		public LogicalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterLogicalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitLogicalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitLogicalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext index;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterArrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitArrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitArrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensExprContext extends ExprContext {
		public ExprContext middel;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExprContext extends ExprContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IdentifierExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterIdentifierExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitIdentifierExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitIdentifierExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_LTOE() { return getToken(CFGParser.OP_LTOE, 0); }
		public TerminalNode OP_GTOE() { return getToken(CFGParser.OP_GTOE, 0); }
		public TerminalNode OP_LT() { return getToken(CFGParser.OP_LT, 0); }
		public TerminalNode OP_GT() { return getToken(CFGParser.OP_GT, 0); }
		public TerminalNode OP_EQUALS() { return getToken(CFGParser.OP_EQUALS, 0); }
		public TerminalNode OP_NEQUALS() { return getToken(CFGParser.OP_NEQUALS, 0); }
		public CompareExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterCompareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitCompareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(387);
				functionCall();
				}
				break;
			case 2:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(388);
				match(T__13);
				setState(389);
				((ParensExprContext)_localctx).middel = expr(0);
				setState(390);
				match(T__14);
				}
				break;
			case 3:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(392);
				literal();
				}
				break;
			case 4:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(393);
				identifier();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(426);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(424);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(396);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(397);
						((InfixExprContext)_localctx).op = match(OP_POW);
						setState(398);
						((InfixExprContext)_localctx).right = expr(10);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(399);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(400);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_MUL) | (1L << OP_DIV) | (1L << OP_MOD))) != 0)) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(401);
						((InfixExprContext)_localctx).right = expr(9);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(402);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(403);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_ADD || _la==OP_SUB) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(404);
						((InfixExprContext)_localctx).right = expr(8);
						}
						break;
					case 4:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						((CompareExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(405);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(406);
						((CompareExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OP_LTOE) | (1L << OP_GTOE) | (1L << OP_LT) | (1L << OP_GT))) != 0)) ) {
							((CompareExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(407);
						((CompareExprContext)_localctx).right = expr(7);
						}
						break;
					case 5:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						((CompareExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(408);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(409);
						((CompareExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_EQUALS || _la==OP_NEQUALS) ) {
							((CompareExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(410);
						((CompareExprContext)_localctx).right = expr(6);
						}
						break;
					case 6:
						{
						_localctx = new LogicalExprContext(new ExprContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(411);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(412);
						((LogicalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_AND || _la==OP_AND2) ) {
							((LogicalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(413);
						((LogicalExprContext)_localctx).right = expr(5);
						}
						break;
					case 7:
						{
						_localctx = new LogicalExprContext(new ExprContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(414);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(415);
						((LogicalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_OR || _la==OP_OR2) ) {
							((LogicalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(416);
						((LogicalExprContext)_localctx).right = expr(4);
						}
						break;
					case 8:
						{
						_localctx = new ArrExprContext(new ExprContext(_parentctx, _parentState));
						((ArrExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(417);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(418);
						match(T__25);
						setState(419);
						((ArrExprContext)_localctx).index = expr(0);
						setState(420);
						match(T__26);
						setState(422);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
						case 1:
							{
							setState(421);
							((ArrExprContext)_localctx).right = expr(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(428);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CFGParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CFGParser.Comma, i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			identifier();
			setState(430);
			match(T__13);
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
				{
				setState(431);
				params();
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(432);
					match(Comma);
					setState(433);
					params();
					}
					}
					setState(438);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(441);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConstructorCallContext constructorCall() {
			return getRuleContext(ConstructorCallContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_params);
		try {
			setState(445);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case T__33:
			case T__34:
			case T__35:
			case Number:
			case Letter:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				expr(0);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(444);
				constructorCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleParamsContext extends ParserRuleContext {
		public List<TerminalNode> Comma() { return getTokens(CFGParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CFGParser.Comma, i);
		}
		public List<ConstructorCallContext> constructorCall() {
			return getRuleContexts(ConstructorCallContext.class);
		}
		public ConstructorCallContext constructorCall(int i) {
			return getRuleContext(ConstructorCallContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultipleParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterMultipleParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitMultipleParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitMultipleParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleParamsContext multipleParams() throws RecognitionException {
		MultipleParamsContext _localctx = new MultipleParamsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_multipleParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(447);
				match(Comma);
				setState(450);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__12:
					{
					setState(448);
					constructorCall();
					}
					break;
				case T__13:
				case T__33:
				case T__34:
				case T__35:
				case Number:
				case Letter:
					{
					setState(449);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(456);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DclParamsContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MultipleDclParamsContext multipleDclParams() {
			return getRuleContext(MultipleDclParamsContext.class,0);
		}
		public DclParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dclParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterDclParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitDclParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitDclParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclParamsContext dclParams() throws RecognitionException {
		DclParamsContext _localctx = new DclParamsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_dclParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(T__13);
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << Letter))) != 0)) {
				{
				setState(458);
				type();
				setState(459);
				identifier();
				setState(460);
				multipleDclParams();
				}
			}

			setState(464);
			match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleDclParamsContext extends ParserRuleContext {
		public List<TerminalNode> Comma() { return getTokens(CFGParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CFGParser.Comma, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public MultipleDclParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleDclParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterMultipleDclParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitMultipleDclParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitMultipleDclParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleDclParamsContext multipleDclParams() throws RecognitionException {
		MultipleDclParamsContext _localctx = new MultipleDclParamsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_multipleDclParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(466);
				match(Comma);
				setState(467);
				type();
				setState(468);
				identifier();
				}
				}
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public PrimTypeContext primType() {
			return getRuleContext(PrimTypeContext.class,0);
		}
		public ComplexTypeContext complexType() {
			return getRuleContext(ComplexTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_type);
		try {
			setState(478);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				primType();
				}
				break;
			case T__10:
			case T__30:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(476);
				complexType();
				}
				break;
			case Letter:
				enterOuterAlt(_localctx, 3);
				{
				setState(477);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimTypeContext extends ParserRuleContext {
		public PrimTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterPrimType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitPrimType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitPrimType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimTypeContext primType() throws RecognitionException {
		PrimTypeContext _localctx = new PrimTypeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_primType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplexTypeContext extends ParserRuleContext {
		public Token listType;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OP_GT() { return getToken(CFGParser.OP_GT, 0); }
		public ComplexTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterComplexType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitComplexType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitComplexType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexTypeContext complexType() throws RecognitionException {
		ComplexTypeContext _localctx = new ComplexTypeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_complexType);
		try {
			setState(488);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(482);
				match(T__30);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(483);
				match(T__31);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(484);
				((ComplexTypeContext)_localctx).listType = match(T__10);
				setState(485);
				type();
				setState(486);
				match(OP_GT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> Letter() { return getTokens(CFGParser.Letter); }
		public TerminalNode Letter(int i) {
			return getToken(CFGParser.Letter, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Number() { return getTokens(CFGParser.Number); }
		public TerminalNode Number(int i) {
			return getToken(CFGParser.Number, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(Letter);
			setState(498);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(491);
				match(Letter);
				}
				break;
			case 2:
				{
				setState(495);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(492);
						match(Number);
						}
						} 
					}
					setState(497);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
				}
				}
				break;
			}
			setState(504);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(500);
					match(T__32);
					setState(501);
					identifier();
					}
					} 
				}
				setState(506);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_literal);
		try {
			setState(510);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(507);
				numberLiteral();
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(508);
				stringLiteral();
				}
				break;
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(509);
				boolLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberLiteralContext extends ParserRuleContext {
		public List<TerminalNode> Number() { return getTokens(CFGParser.Number); }
		public TerminalNode Number(int i) {
			return getToken(CFGParser.Number, i);
		}
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_numberLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(516); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(516);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						setState(512);
						match(Number);
						}
						break;
					case 2:
						{
						setState(513);
						match(Number);
						setState(514);
						match(T__32);
						setState(515);
						match(Number);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(518); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> Letter() { return getTokens(CFGParser.Letter); }
		public TerminalNode Letter(int i) {
			return getToken(CFGParser.Letter, i);
		}
		public List<TerminalNode> Number() { return getTokens(CFGParser.Number); }
		public TerminalNode Number(int i) {
			return getToken(CFGParser.Number, i);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_stringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			match(T__33);
			setState(522); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(521);
				_la = _input.LA(1);
				if ( !(_la==Number || _la==Letter) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(524); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Number || _la==Letter );
			setState(526);
			match(T__33);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolLiteralContext extends ParserRuleContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitBoolLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_boolLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			bool();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			_la = _input.LA(1);
			if ( !(_la==T__34 || _la==T__35) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeBlockContext extends ParserRuleContext {
		public DclContext dcl() {
			return getRuleContext(DclContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitCodeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitCodeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_codeBlock);
		try {
			setState(538);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(532);
				dcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(533);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(534);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(535);
				expr(0);
				setState(536);
				match(SemiColon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 29:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3>\u021f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\5\2_\n\2\3\2\5\2b\n\2\3\2\5\2e\n\2\3\2\3\2\3"+
		"\3\3\3\3\3\7\3l\n\3\f\3\16\3o\13\3\3\3\5\3r\n\3\3\3\3\3\3\4\3\4\3\4\7"+
		"\4y\n\4\f\4\16\4|\13\4\3\4\3\4\3\5\3\5\3\5\7\5\u0083\n\5\f\5\16\5\u0086"+
		"\13\5\3\5\3\5\3\6\3\6\3\6\7\6\u008d\n\6\f\6\16\6\u0090\13\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u009d\n\7\3\b\3\b\3\b\3\b\5\b\u00a3"+
		"\n\b\3\t\3\t\3\t\7\t\u00a8\n\t\f\t\16\t\u00ab\13\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\7\n\u00b7\n\n\f\n\16\n\u00ba\13\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c9\n\13\3\f\3"+
		"\f\7\f\u00cd\n\f\f\f\16\f\u00d0\13\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u00e0\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\7\17\u00ea\n\17\f\17\16\17\u00ed\13\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00f9\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\7\21\u0102\n\21\f\21\16\21\u0105\13\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u0110\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0119\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0123\n"+
		"\24\3\25\3\25\5\25\u0127\n\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u012f"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0139\n\27\5\27\u013b"+
		"\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u0147\n\31"+
		"\3\31\3\31\7\31\u014b\n\31\f\31\16\31\u014e\13\31\6\31\u0150\n\31\r\31"+
		"\16\31\u0151\3\31\3\31\7\31\u0156\n\31\f\31\16\31\u0159\13\31\5\31\u015b"+
		"\n\31\3\31\3\31\3\32\3\32\5\32\u0161\n\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u016f\n\34\3\34\3\34\3\34\3\35\3\35"+
		"\7\35\u0176\n\35\f\35\16\35\u0179\13\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\5\36\u0181\n\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u018d\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\5\37\u01a9\n\37\7\37\u01ab\n\37\f\37\16\37\u01ae\13\37\3 \3 \3 \3 \3"+
		" \7 \u01b5\n \f \16 \u01b8\13 \5 \u01ba\n \3 \3 \3!\3!\5!\u01c0\n!\3\""+
		"\3\"\3\"\5\"\u01c5\n\"\7\"\u01c7\n\"\f\"\16\"\u01ca\13\"\3#\3#\3#\3#\3"+
		"#\5#\u01d1\n#\3#\3#\3$\3$\3$\3$\7$\u01d9\n$\f$\16$\u01dc\13$\3%\3%\3%"+
		"\5%\u01e1\n%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01eb\n\'\3(\3(\3(\7(\u01f0"+
		"\n(\f(\16(\u01f3\13(\5(\u01f5\n(\3(\3(\7(\u01f9\n(\f(\16(\u01fc\13(\3"+
		")\3)\3)\5)\u0201\n)\3*\3*\3*\3*\6*\u0207\n*\r*\16*\u0208\3+\3+\6+\u020d"+
		"\n+\r+\16+\u020e\3+\3+\3,\3,\3-\3-\3.\3.\3.\3.\3.\3.\5.\u021d\n.\3.\2"+
		"\3</\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@"+
		"BDFHJLNPRTVXZ\2\13\3\2(*\3\2+,\3\2-\60\3\2\61\62\3\2\63\64\3\2\65\66\3"+
		"\2\36 \3\2\678\3\2%&\2\u0241\2\\\3\2\2\2\4h\3\2\2\2\6u\3\2\2\2\b\177\3"+
		"\2\2\2\n\u0089\3\2\2\2\f\u009c\3\2\2\2\16\u00a2\3\2\2\2\20\u00a4\3\2\2"+
		"\2\22\u00b1\3\2\2\2\24\u00c8\3\2\2\2\26\u00ca\3\2\2\2\30\u00d6\3\2\2\2"+
		"\32\u00e3\3\2\2\2\34\u00e7\3\2\2\2\36\u00f8\3\2\2\2 \u00fa\3\2\2\2\"\u0108"+
		"\3\2\2\2$\u0113\3\2\2\2&\u0122\3\2\2\2(\u0126\3\2\2\2*\u0128\3\2\2\2,"+
		"\u013a\3\2\2\2.\u013c\3\2\2\2\60\u0142\3\2\2\2\62\u0160\3\2\2\2\64\u0162"+
		"\3\2\2\2\66\u0168\3\2\2\28\u0173\3\2\2\2:\u017c\3\2\2\2<\u018c\3\2\2\2"+
		">\u01af\3\2\2\2@\u01bf\3\2\2\2B\u01c8\3\2\2\2D\u01cb\3\2\2\2F\u01da\3"+
		"\2\2\2H\u01e0\3\2\2\2J\u01e2\3\2\2\2L\u01ea\3\2\2\2N\u01ec\3\2\2\2P\u0200"+
		"\3\2\2\2R\u0206\3\2\2\2T\u020a\3\2\2\2V\u0212\3\2\2\2X\u0214\3\2\2\2Z"+
		"\u021c\3\2\2\2\\^\5\4\3\2]_\5\6\4\2^]\3\2\2\2^_\3\2\2\2_a\3\2\2\2`b\5"+
		"\b\5\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2ce\5\n\6\2dc\3\2\2\2de\3\2\2\2ef\3"+
		"\2\2\2fg\7\2\2\3g\3\3\2\2\2hi\7\3\2\2im\7\4\2\2jl\5\f\7\2kj\3\2\2\2lo"+
		"\3\2\2\2mk\3\2\2\2mn\3\2\2\2nq\3\2\2\2om\3\2\2\2pr\5\20\t\2qp\3\2\2\2"+
		"qr\3\2\2\2rs\3\2\2\2st\7\5\2\2t\5\3\2\2\2uv\7\6\2\2vz\7\4\2\2wy\5\f\7"+
		"\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7\5\2"+
		"\2~\7\3\2\2\2\177\u0080\7\7\2\2\u0080\u0084\7\4\2\2\u0081\u0083\5\f\7"+
		"\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\5\2\2\u0088"+
		"\t\3\2\2\2\u0089\u008a\7\b\2\2\u008a\u008e\7\4\2\2\u008b\u008d\5\f\7\2"+
		"\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7\5\2\2\u0092"+
		"\13\3\2\2\2\u0093\u009d\5\22\n\2\u0094\u009d\5\16\b\2\u0095\u009d\5&\24"+
		"\2\u0096\u009d\5:\36\2\u0097\u0098\5<\37\2\u0098\u0099\7;\2\2\u0099\u009d"+
		"\3\2\2\2\u009a\u009d\7<\2\2\u009b\u009d\7=\2\2\u009c\u0093\3\2\2\2\u009c"+
		"\u0094\3\2\2\2\u009c\u0095\3\2\2\2\u009c\u0096\3\2\2\2\u009c\u0097\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\r\3\2\2\2\u009e\u00a3"+
		"\5\24\13\2\u009f\u00a3\5\30\r\2\u00a0\u00a3\5\32\16\2\u00a1\u00a3\5$\23"+
		"\2\u00a2\u009e\3\2\2\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1"+
		"\3\2\2\2\u00a3\17\3\2\2\2\u00a4\u00a5\7\t\2\2\u00a5\u00a9\7\4\2\2\u00a6"+
		"\u00a8\5Z.\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2"+
		"\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad"+
		"\7\n\2\2\u00ad\u00ae\5<\37\2\u00ae\u00af\7;\2\2\u00af\u00b0\7\5\2\2\u00b0"+
		"\21\3\2\2\2\u00b1\u00b2\7\13\2\2\u00b2\u00b3\5H%\2\u00b3\u00b4\7\60\2"+
		"\2\u00b4\u00b8\7\4\2\2\u00b5\u00b7\5Z.\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba"+
		"\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00bb\u00bc\7\5\2\2\u00bc\23\3\2\2\2\u00bd\u00be\7\f\2"+
		"\2\u00be\u00bf\5N(\2\u00bf\u00c0\5D#\2\u00c0\u00c1\58\35\2\u00c1\u00c9"+
		"\3\2\2\2\u00c2\u00c3\7\f\2\2\u00c3\u00c4\5J&\2\u00c4\u00c5\5N(\2\u00c5"+
		"\u00c6\5D#\2\u00c6\u00c7\5\26\f\2\u00c7\u00c9\3\2\2\2\u00c8\u00bd\3\2"+
		"\2\2\u00c8\u00c2\3\2\2\2\u00c9\25\3\2\2\2\u00ca\u00ce\7\4\2\2\u00cb\u00cd"+
		"\5Z.\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7\n"+
		"\2\2\u00d2\u00d3\5<\37\2\u00d3\u00d4\7;\2\2\u00d4\u00d5\7\5\2\2\u00d5"+
		"\27\3\2\2\2\u00d6\u00d7\7\r\2\2\u00d7\u00d8\5H%\2\u00d8\u00d9\7\60\2\2"+
		"\u00d9\u00df\5N(\2\u00da\u00db\7\4\2\2\u00db\u00dc\5@!\2\u00dc\u00dd\5"+
		"B\"\2\u00dd\u00de\7\5\2\2\u00de\u00e0\3\2\2\2\u00df\u00da\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\7;\2\2\u00e2\31\3\2\2\2"+
		"\u00e3\u00e4\5H%\2\u00e4\u00e5\5N(\2\u00e5\u00e6\5\34\17\2\u00e6\33\3"+
		"\2\2\2\u00e7\u00eb\7\4\2\2\u00e8\u00ea\5\36\20\2\u00e9\u00e8\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2"+
		"\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7\5\2\2\u00ef\35\3\2\2\2\u00f0\u00f9"+
		"\5 \21\2\u00f1\u00f9\5\24\13\2\u00f2\u00f9\5\30\r\2\u00f3\u00f9\5&\24"+
		"\2\u00f4\u00f9\5:\36\2\u00f5\u00f6\5<\37\2\u00f6\u00f7\7;\2\2\u00f7\u00f9"+
		"\3\2\2\2\u00f8\u00f0\3\2\2\2\u00f8\u00f1\3\2\2\2\u00f8\u00f2\3\2\2\2\u00f8"+
		"\u00f3\3\2\2\2\u00f8\u00f4\3\2\2\2\u00f8\u00f5\3\2\2\2\u00f9\37\3\2\2"+
		"\2\u00fa\u00fb\7\16\2\2\u00fb\u00fc\7\17\2\2\u00fc\u00fd\5H%\2\u00fd\u00fe"+
		"\7\60\2\2\u00fe\u00ff\5D#\2\u00ff\u0103\7\4\2\2\u0100\u0102\5Z.\2\u0101"+
		"\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\7\5\2\2\u0107"+
		"!\3\2\2\2\u0108\u0109\7\17\2\2\u0109\u010a\5H%\2\u010a\u010b\7\60\2\2"+
		"\u010b\u010f\7\20\2\2\u010c\u010d\5@!\2\u010d\u010e\5B\"\2\u010e\u0110"+
		"\3\2\2\2\u010f\u010c\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		"\u0112\7\21\2\2\u0112#\3\2\2\2\u0113\u0114\5H%\2\u0114\u0115\5N(\2\u0115"+
		"\u0118\7:\2\2\u0116\u0119\5\"\22\2\u0117\u0119\5<\37\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\7;\2\2\u011b"+
		"%\3\2\2\2\u011c\u0123\5(\25\2\u011d\u0123\5\62\32\2\u011e\u011f\7\n\2"+
		"\2\u011f\u0120\5<\37\2\u0120\u0121\7;\2\2\u0121\u0123\3\2\2\2\u0122\u011c"+
		"\3\2\2\2\u0122\u011d\3\2\2\2\u0122\u011e\3\2\2\2\u0123\'\3\2\2\2\u0124"+
		"\u0127\5*\26\2\u0125\u0127\5.\30\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2"+
		"\2\2\u0127)\3\2\2\2\u0128\u0129\7\22\2\2\u0129\u012a\7\20\2\2\u012a\u012b"+
		"\5<\37\2\u012b\u012c\7\21\2\2\u012c\u012e\58\35\2\u012d\u012f\5,\27\2"+
		"\u012e\u012d\3\2\2\2\u012e\u012f\3\2\2\2\u012f+\3\2\2\2\u0130\u0131\7"+
		"\23\2\2\u0131\u013b\58\35\2\u0132\u0133\7\24\2\2\u0133\u0134\7\20\2\2"+
		"\u0134\u0135\5<\37\2\u0135\u0136\7\21\2\2\u0136\u0138\58\35\2\u0137\u0139"+
		"\5,\27\2\u0138\u0137\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\3\2\2\2\u013a"+
		"\u0130\3\2\2\2\u013a\u0132\3\2\2\2\u013b-\3\2\2\2\u013c\u013d\7\25\2\2"+
		"\u013d\u013e\7\20\2\2\u013e\u013f\5<\37\2\u013f\u0140\7\21\2\2\u0140\u0141"+
		"\5\60\31\2\u0141/\3\2\2\2\u0142\u014f\7\4\2\2\u0143\u0146\7\26\2\2\u0144"+
		"\u0147\5R*\2\u0145\u0147\5H%\2\u0146\u0144\3\2\2\2\u0146\u0145\3\2\2\2"+
		"\u0147\u0148\3\2\2\2\u0148\u014c\7\27\2\2\u0149\u014b\5Z.\2\u014a\u0149"+
		"\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0143\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u015a\3\2\2\2\u0153"+
		"\u0157\7\30\2\2\u0154\u0156\5<\37\2\u0155\u0154\3\2\2\2\u0156\u0159\3"+
		"\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015b\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u0153\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c\u015d\7\5\2\2\u015d\61\3\2\2\2\u015e\u0161\5\64\33\2\u015f"+
		"\u0161\5\66\34\2\u0160\u015e\3\2\2\2\u0160\u015f\3\2\2\2\u0161\63\3\2"+
		"\2\2\u0162\u0163\7\31\2\2\u0163\u0164\7\20\2\2\u0164\u0165\5<\37\2\u0165"+
		"\u0166\7\21\2\2\u0166\u0167\58\35\2\u0167\65\3\2\2\2\u0168\u0169\7\32"+
		"\2\2\u0169\u016a\5N(\2\u016a\u016b\7\33\2\2\u016b\u016e\7\20\2\2\u016c"+
		"\u016f\5R*\2\u016d\u016f\5N(\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2\2"+
		"\u016f\u0170\3\2\2\2\u0170\u0171\7\21\2\2\u0171\u0172\58\35\2\u0172\67"+
		"\3\2\2\2\u0173\u0177\7\4\2\2\u0174\u0176\5Z.\2\u0175\u0174\3\2\2\2\u0176"+
		"\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017a\3\2"+
		"\2\2\u0179\u0177\3\2\2\2\u017a\u017b\7\5\2\2\u017b9\3\2\2\2\u017c\u017d"+
		"\5N(\2\u017d\u0180\7:\2\2\u017e\u0181\5N(\2\u017f\u0181\5<\37\2\u0180"+
		"\u017e\3\2\2\2\u0180\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\7;"+
		"\2\2\u0183;\3\2\2\2\u0184\u0185\b\37\1\2\u0185\u018d\5> \2\u0186\u0187"+
		"\7\20\2\2\u0187\u0188\5<\37\2\u0188\u0189\7\21\2\2\u0189\u018d\3\2\2\2"+
		"\u018a\u018d\5P)\2\u018b\u018d\5N(\2\u018c\u0184\3\2\2\2\u018c\u0186\3"+
		"\2\2\2\u018c\u018a\3\2\2\2\u018c\u018b\3\2\2\2\u018d\u01ac\3\2\2\2\u018e"+
		"\u018f\f\13\2\2\u018f\u0190\7\'\2\2\u0190\u01ab\5<\37\f\u0191\u0192\f"+
		"\n\2\2\u0192\u0193\t\2\2\2\u0193\u01ab\5<\37\13\u0194\u0195\f\t\2\2\u0195"+
		"\u0196\t\3\2\2\u0196\u01ab\5<\37\n\u0197\u0198\f\b\2\2\u0198\u0199\t\4"+
		"\2\2\u0199\u01ab\5<\37\t\u019a\u019b\f\7\2\2\u019b\u019c\t\5\2\2\u019c"+
		"\u01ab\5<\37\b\u019d\u019e\f\6\2\2\u019e\u019f\t\6\2\2\u019f\u01ab\5<"+
		"\37\7\u01a0\u01a1\f\5\2\2\u01a1\u01a2\t\7\2\2\u01a2\u01ab\5<\37\6\u01a3"+
		"\u01a4\f\r\2\2\u01a4\u01a5\7\34\2\2\u01a5\u01a6\5<\37\2\u01a6\u01a8\7"+
		"\35\2\2\u01a7\u01a9\5<\37\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9"+
		"\u01ab\3\2\2\2\u01aa\u018e\3\2\2\2\u01aa\u0191\3\2\2\2\u01aa\u0194\3\2"+
		"\2\2\u01aa\u0197\3\2\2\2\u01aa\u019a\3\2\2\2\u01aa\u019d\3\2\2\2\u01aa"+
		"\u01a0\3\2\2\2\u01aa\u01a3\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2"+
		"\2\2\u01ac\u01ad\3\2\2\2\u01ad=\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b0"+
		"\5N(\2\u01b0\u01b9\7\20\2\2\u01b1\u01b6\5@!\2\u01b2\u01b3\79\2\2\u01b3"+
		"\u01b5\5@!\2\u01b4\u01b2\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2"+
		"\2\u01b6\u01b7\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01b1"+
		"\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\7\21\2\2"+
		"\u01bc?\3\2\2\2\u01bd\u01c0\5<\37\2\u01be\u01c0\5\"\22\2\u01bf\u01bd\3"+
		"\2\2\2\u01bf\u01be\3\2\2\2\u01c0A\3\2\2\2\u01c1\u01c4\79\2\2\u01c2\u01c5"+
		"\5\"\22\2\u01c3\u01c5\5<\37\2\u01c4\u01c2\3\2\2\2\u01c4\u01c3\3\2\2\2"+
		"\u01c5\u01c7\3\2\2\2\u01c6\u01c1\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6"+
		"\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9C\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb"+
		"\u01d0\7\20\2\2\u01cc\u01cd\5H%\2\u01cd\u01ce\5N(\2\u01ce\u01cf\5F$\2"+
		"\u01cf\u01d1\3\2\2\2\u01d0\u01cc\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2"+
		"\3\2\2\2\u01d2\u01d3\7\21\2\2\u01d3E\3\2\2\2\u01d4\u01d5\79\2\2\u01d5"+
		"\u01d6\5H%\2\u01d6\u01d7\5N(\2\u01d7\u01d9\3\2\2\2\u01d8\u01d4\3\2\2\2"+
		"\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01dbG\3"+
		"\2\2\2\u01dc\u01da\3\2\2\2\u01dd\u01e1\5J&\2\u01de\u01e1\5L\'\2\u01df"+
		"\u01e1\5N(\2\u01e0\u01dd\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0\u01df\3\2\2"+
		"\2\u01e1I\3\2\2\2\u01e2\u01e3\t\b\2\2\u01e3K\3\2\2\2\u01e4\u01eb\7!\2"+
		"\2\u01e5\u01eb\7\"\2\2\u01e6\u01e7\7\r\2\2\u01e7\u01e8\5H%\2\u01e8\u01e9"+
		"\7\60\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01e4\3\2\2\2\u01ea\u01e5\3\2\2\2"+
		"\u01ea\u01e6\3\2\2\2\u01ebM\3\2\2\2\u01ec\u01f4\78\2\2\u01ed\u01f5\78"+
		"\2\2\u01ee\u01f0\7\67\2\2\u01ef\u01ee\3\2\2\2\u01f0\u01f3\3\2\2\2\u01f1"+
		"\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f5\3\2\2\2\u01f3\u01f1\3\2"+
		"\2\2\u01f4\u01ed\3\2\2\2\u01f4\u01f1\3\2\2\2\u01f5\u01fa\3\2\2\2\u01f6"+
		"\u01f7\7#\2\2\u01f7\u01f9\5N(\2\u01f8\u01f6\3\2\2\2\u01f9\u01fc\3\2\2"+
		"\2\u01fa\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fbO\3\2\2\2\u01fc\u01fa"+
		"\3\2\2\2\u01fd\u0201\5R*\2\u01fe\u0201\5T+\2\u01ff\u0201\5V,\2\u0200\u01fd"+
		"\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u01ff\3\2\2\2\u0201Q\3\2\2\2\u0202"+
		"\u0207\7\67\2\2\u0203\u0204\7\67\2\2\u0204\u0205\7#\2\2\u0205\u0207\7"+
		"\67\2\2\u0206\u0202\3\2\2\2\u0206\u0203\3\2\2\2\u0207\u0208\3\2\2\2\u0208"+
		"\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209S\3\2\2\2\u020a\u020c\7$\2\2\u020b"+
		"\u020d\t\t\2\2\u020c\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u020c\3\2"+
		"\2\2\u020e\u020f\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\7$\2\2\u0211"+
		"U\3\2\2\2\u0212\u0213\5X-\2\u0213W\3\2\2\2\u0214\u0215\t\n\2\2\u0215Y"+
		"\3\2\2\2\u0216\u021d\5\16\b\2\u0217\u021d\5&\24\2\u0218\u021d\5:\36\2"+
		"\u0219\u021a\5<\37\2\u021a\u021b\7;\2\2\u021b\u021d\3\2\2\2\u021c\u0216"+
		"\3\2\2\2\u021c\u0217\3\2\2\2\u021c\u0218\3\2\2\2\u021c\u0219\3\2\2\2\u021d"+
		"[\3\2\2\29^admqz\u0084\u008e\u009c\u00a2\u00a9\u00b8\u00c8\u00ce\u00df"+
		"\u00eb\u00f8\u0103\u010f\u0118\u0122\u0126\u012e\u0138\u013a\u0146\u014c"+
		"\u0151\u0157\u015a\u0160\u016e\u0177\u0180\u018c\u01a8\u01aa\u01ac\u01b6"+
		"\u01b9\u01bf\u01c4\u01c8\u01d0\u01da\u01e0\u01ea\u01f1\u01f4\u01fa\u0200"+
		"\u0206\u0208\u020e\u021c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}