// Generated from C:/Users/marti/OneDrive/Dokumenter/GitHub/P4-SimulationLanguage\CFG.g4 by ANTLR 4.9.2
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
		RULE_endCondition = 7, RULE_initCondition = 8, RULE_functionDcl = 9, RULE_listDcl = 10, 
		RULE_classDcl = 11, RULE_contructorDcl = 12, RULE_constructorCall = 13, 
		RULE_objDcl = 14, RULE_statement = 15, RULE_selectiveCtrl = 16, RULE_ifElseStmt = 17, 
		RULE_elseIfStmt = 18, RULE_elseStmt = 19, RULE_switchStmt = 20, RULE_switchBody = 21, 
		RULE_switchcase = 22, RULE_iterativeCtrl = 23, RULE_whileLoop = 24, RULE_forLoop = 25, 
		RULE_assignment = 26, RULE_expr = 27, RULE_params = 28, RULE_dclParams = 29, 
		RULE_type = 30, RULE_primType = 31, RULE_complexType = 32, RULE_identifier = 33, 
		RULE_objIdentifier = 34, RULE_thisIdentifier = 35, RULE_simpleIdentifier = 36, 
		RULE_functionCall = 37, RULE_literal = 38, RULE_numberLiteral = 39, RULE_stringLiteral = 40, 
		RULE_boolLiteral = 41, RULE_bool = 42, RULE_codeBlock = 43;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "environmentSection", "behaviorSection", "updateSection", 
			"outputSection", "line", "dcl", "endCondition", "initCondition", "functionDcl", 
			"listDcl", "classDcl", "contructorDcl", "constructorCall", "objDcl", 
			"statement", "selectiveCtrl", "ifElseStmt", "elseIfStmt", "elseStmt", 
			"switchStmt", "switchBody", "switchcase", "iterativeCtrl", "whileLoop", 
			"forLoop", "assignment", "expr", "params", "dclParams", "type", "primType", 
			"complexType", "identifier", "objIdentifier", "thisIdentifier", "simpleIdentifier", 
			"functionCall", "literal", "numberLiteral", "stringLiteral", "boolLiteral", 
			"bool", "codeBlock"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Simulation Environment'", "'{'", "'}'", "'Simulation Behavior'", 
			"'Simulation Update'", "'Simulation Output'", "'EndCondition'", "'InitCondition<'", 
			"'function'", "'('", "')'", "'List<'", "'constructor'", "'Create<'", 
			"'return'", "'if'", "'else if'", "'else'", "'switch'", "'case '", "'default'", 
			"'while'", "'for'", "'in range'", "'['", "']'", "'number '", "'string '", 
			"'bool '", "'Vehicle'", "'Node'", "'.'", "'this'", "'\"'", "'true'", 
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
			setState(88);
			environmentSection();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(89);
				behaviorSection();
				}
			}

			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(92);
				updateSection();
				}
			}

			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(95);
				outputSection();
				}
			}

			setState(98);
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
			setState(100);
			match(T__0);
			setState(101);
			match(T__1);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter) | (1L << Comment) | (1L << MultiComment))) != 0)) {
				{
				{
				setState(102);
				line();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(108);
				endCondition();
				}
			}

			setState(111);
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
			setState(113);
			match(T__3);
			setState(114);
			match(T__1);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter) | (1L << Comment) | (1L << MultiComment))) != 0)) {
				{
				{
				setState(115);
				line();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
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
			setState(123);
			match(T__4);
			setState(124);
			match(T__1);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter) | (1L << Comment) | (1L << MultiComment))) != 0)) {
				{
				{
				setState(125);
				line();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
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
			setState(133);
			match(T__5);
			setState(134);
			match(T__1);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter) | (1L << Comment) | (1L << MultiComment))) != 0)) {
				{
				{
				setState(135);
				line();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
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
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				initCondition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				dcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				assignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				expr(0);
				setState(148);
				match(SemiColon);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
				match(Comment);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(151);
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
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				functionDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				listDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				classDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
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
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__6);
			setState(161);
			codeBlock();
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
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__7);
			setState(164);
			type();
			setState(165);
			match(OP_GT);
			setState(166);
			codeBlock();
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public List<DclParamsContext> dclParams() {
			return getRuleContexts(DclParamsContext.class);
		}
		public DclParamsContext dclParams(int i) {
			return getRuleContext(DclParamsContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CFGParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CFGParser.Comma, i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__8);
			setState(169);
			type();
			setState(170);
			identifier();
			setState(171);
			match(T__9);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__32) | (1L << Letter))) != 0)) {
				{
				setState(172);
				dclParams();
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(173);
					match(Comma);
					setState(174);
					dclParams();
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(182);
			match(T__10);
			setState(183);
			codeBlock();
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
		enterRule(_localctx, 20, RULE_listDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__11);
			setState(186);
			type();
			setState(187);
			match(OP_GT);
			setState(188);
			identifier();
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(189);
				match(T__1);
				setState(190);
				params();
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(191);
					match(Comma);
					setState(192);
					params();
					}
					}
					setState(197);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(198);
				match(T__2);
				}
			}

			setState(202);
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
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
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
		enterRule(_localctx, 22, RULE_classDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			type();
			setState(205);
			identifier();
			setState(206);
			codeBlock();
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
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public List<DclParamsContext> dclParams() {
			return getRuleContexts(DclParamsContext.class);
		}
		public DclParamsContext dclParams(int i) {
			return getRuleContext(DclParamsContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CFGParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CFGParser.Comma, i);
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
		enterRule(_localctx, 24, RULE_contructorDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__12);
			setState(209);
			match(T__13);
			setState(210);
			type();
			setState(211);
			match(OP_GT);
			setState(212);
			match(T__9);
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__32) | (1L << Letter))) != 0)) {
				{
				setState(213);
				dclParams();
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(214);
					match(Comma);
					setState(215);
					dclParams();
					}
					}
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(223);
			match(T__10);
			setState(224);
			codeBlock();
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
		enterRule(_localctx, 26, RULE_constructorCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(T__13);
			setState(227);
			type();
			setState(228);
			match(OP_GT);
			setState(229);
			match(T__9);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__13) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
				{
				setState(230);
				params();
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(231);
					match(Comma);
					setState(232);
					params();
					}
					}
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(240);
			match(T__10);
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
		public TerminalNode SemiColon() { return getToken(CFGParser.SemiColon, 0); }
		public TerminalNode Equals() { return getToken(CFGParser.Equals, 0); }
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
		enterRule(_localctx, 28, RULE_objDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			type();
			setState(243);
			identifier();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Equals) {
				{
				setState(244);
				match(Equals);
				setState(247);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(245);
					constructorCall();
					}
					break;
				case T__9:
				case T__32:
				case T__33:
				case T__34:
				case T__35:
				case Number:
				case Letter:
					{
					setState(246);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(251);
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
		enterRule(_localctx, 30, RULE_statement);
		try {
			setState(259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				selectiveCtrl();
				}
				break;
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				iterativeCtrl();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				match(T__14);
				setState(256);
				expr(0);
				setState(257);
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
		enterRule(_localctx, 32, RULE_selectiveCtrl);
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				ifElseStmt();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
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
		public ExprContext left;
		public CodeBlockContext index;
		public ElseIfStmtContext right;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
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
		enterRule(_localctx, 34, RULE_ifElseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__15);
			setState(266);
			match(T__9);
			setState(267);
			((IfElseStmtContext)_localctx).left = expr(0);
			setState(268);
			match(T__10);
			setState(269);
			((IfElseStmtContext)_localctx).index = codeBlock();
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16 || _la==T__17) {
				{
				setState(270);
				((IfElseStmtContext)_localctx).right = elseIfStmt();
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
		public ElseStmtContext left;
		public ExprContext index;
		public CodeBlockContext body;
		public ElseIfStmtContext right;
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
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
		enterRule(_localctx, 36, RULE_elseIfStmt);
		int _la;
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				((ElseIfStmtContext)_localctx).left = elseStmt();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				match(T__16);
				setState(275);
				match(T__9);
				setState(276);
				((ElseIfStmtContext)_localctx).index = expr(0);
				setState(277);
				match(T__10);
				setState(278);
				((ElseIfStmtContext)_localctx).body = codeBlock();
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16 || _la==T__17) {
					{
					setState(279);
					((ElseIfStmtContext)_localctx).right = elseIfStmt();
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

	public static class ElseStmtContext extends ParserRuleContext {
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_elseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__17);
			setState(285);
			codeBlock();
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
		enterRule(_localctx, 40, RULE_switchStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(T__18);
			setState(288);
			match(T__9);
			setState(289);
			expr(0);
			setState(290);
			match(T__10);
			setState(291);
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
		public CodeBlockContext defaultCode;
		public List<SwitchcaseContext> switchcase() {
			return getRuleContexts(SwitchcaseContext.class);
		}
		public SwitchcaseContext switchcase(int i) {
			return getRuleContext(SwitchcaseContext.class,i);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
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
		enterRule(_localctx, 42, RULE_switchBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(T__1);
			setState(298); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(294);
				match(T__19);
				setState(295);
				switchcase();
				setState(296);
				codeBlock();
				}
				}
				setState(300); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__19 );
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(302);
				match(T__20);
				setState(303);
				((SwitchBodyContext)_localctx).defaultCode = codeBlock();
				}
			}

			setState(306);
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

	public static class SwitchcaseContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SwitchcaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchcase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterSwitchcase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitSwitchcase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitSwitchcase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchcaseContext switchcase() throws RecognitionException {
		SwitchcaseContext _localctx = new SwitchcaseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_switchcase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			expr(0);
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
		enterRule(_localctx, 46, RULE_iterativeCtrl);
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				whileLoop();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
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
		public ExprContext left;
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 48, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(T__21);
			setState(315);
			match(T__9);
			setState(316);
			((WhileLoopContext)_localctx).left = expr(0);
			setState(317);
			match(T__10);
			setState(318);
			codeBlock();
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
		public IdentifierContext loopNumber;
		public IdentifierContext rangeNumber;
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
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
		enterRule(_localctx, 50, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(T__22);
			setState(321);
			match(T__9);
			setState(322);
			((ForLoopContext)_localctx).loopNumber = identifier();
			setState(323);
			match(T__23);
			setState(326);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				{
				setState(324);
				numberLiteral();
				}
				break;
			case T__32:
			case Letter:
				{
				setState(325);
				((ForLoopContext)_localctx).rangeNumber = identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(328);
			match(T__10);
			setState(329);
			codeBlock();
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
		public IdentifierContext value;
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
		enterRule(_localctx, 52, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			identifier();
			setState(332);
			match(Equals);
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(333);
				((AssignmentContext)_localctx).value = identifier();
				}
				break;
			case 2:
				{
				setState(334);
				expr(0);
				}
				break;
			}
			setState(337);
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(340);
				functionCall();
				}
				break;
			case 2:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(341);
				match(T__9);
				setState(342);
				((ParensExprContext)_localctx).middel = expr(0);
				setState(343);
				match(T__10);
				}
				break;
			case 3:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(345);
				literal();
				}
				break;
			case 4:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(346);
				identifier();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(377);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(349);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(350);
						((InfixExprContext)_localctx).op = match(OP_POW);
						setState(351);
						((InfixExprContext)_localctx).right = expr(10);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(352);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(353);
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
						setState(354);
						((InfixExprContext)_localctx).right = expr(9);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(355);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(356);
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
						setState(357);
						((InfixExprContext)_localctx).right = expr(8);
						}
						break;
					case 4:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						((CompareExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(358);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(359);
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
						setState(360);
						((CompareExprContext)_localctx).right = expr(7);
						}
						break;
					case 5:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						((CompareExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(361);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(362);
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
						setState(363);
						((CompareExprContext)_localctx).right = expr(6);
						}
						break;
					case 6:
						{
						_localctx = new LogicalExprContext(new ExprContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(364);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(365);
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
						setState(366);
						((LogicalExprContext)_localctx).right = expr(5);
						}
						break;
					case 7:
						{
						_localctx = new LogicalExprContext(new ExprContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(367);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(368);
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
						setState(369);
						((LogicalExprContext)_localctx).right = expr(4);
						}
						break;
					case 8:
						{
						_localctx = new ArrExprContext(new ExprContext(_parentctx, _parentState));
						((ArrExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(370);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(371);
						match(T__24);
						setState(372);
						((ArrExprContext)_localctx).index = expr(0);
						setState(373);
						match(T__25);
						setState(375);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
						case 1:
							{
							setState(374);
							((ArrExprContext)_localctx).right = expr(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		enterRule(_localctx, 56, RULE_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case Number:
			case Letter:
				{
				setState(382);
				expr(0);
				}
				break;
			case T__13:
				{
				setState(383);
				constructorCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 58, RULE_dclParams);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(386);
			type();
			setState(387);
			identifier();
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
		enterRule(_localctx, 60, RULE_type);
		try {
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				primType();
				}
				break;
			case T__11:
			case T__29:
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
				complexType();
				}
				break;
			case T__32:
			case Letter:
				enterOuterAlt(_localctx, 3);
				{
				setState(391);
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
		enterRule(_localctx, 62, RULE_primType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
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
		enterRule(_localctx, 64, RULE_complexType);
		try {
			setState(402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				match(T__29);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				match(T__30);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(398);
				((ComplexTypeContext)_localctx).listType = match(T__11);
				setState(399);
				type();
				setState(400);
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
		public ObjIdentifierContext objIdentifier() {
			return getRuleContext(ObjIdentifierContext.class,0);
		}
		public ThisIdentifierContext thisIdentifier() {
			return getRuleContext(ThisIdentifierContext.class,0);
		}
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
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
		enterRule(_localctx, 66, RULE_identifier);
		try {
			setState(407);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(404);
				objIdentifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(405);
				thisIdentifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(406);
				simpleIdentifier();
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

	public static class ObjIdentifierContext extends ParserRuleContext {
		public SimpleIdentifierContext objName;
		public SimpleIdentifierContext id;
		public List<SimpleIdentifierContext> simpleIdentifier() {
			return getRuleContexts(SimpleIdentifierContext.class);
		}
		public SimpleIdentifierContext simpleIdentifier(int i) {
			return getRuleContext(SimpleIdentifierContext.class,i);
		}
		public ObjIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterObjIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitObjIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitObjIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjIdentifierContext objIdentifier() throws RecognitionException {
		ObjIdentifierContext _localctx = new ObjIdentifierContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_objIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			((ObjIdentifierContext)_localctx).objName = simpleIdentifier();
			setState(410);
			match(T__31);
			setState(411);
			((ObjIdentifierContext)_localctx).id = simpleIdentifier();
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

	public static class ThisIdentifierContext extends ParserRuleContext {
		public ObjIdentifierContext objIdentifier() {
			return getRuleContext(ObjIdentifierContext.class,0);
		}
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public ThisIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thisIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterThisIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitThisIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitThisIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThisIdentifierContext thisIdentifier() throws RecognitionException {
		ThisIdentifierContext _localctx = new ThisIdentifierContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_thisIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(T__32);
			setState(414);
			match(T__31);
			setState(417);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(415);
				objIdentifier();
				}
				break;
			case 2:
				{
				setState(416);
				simpleIdentifier();
				}
				break;
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

	public static class SimpleIdentifierContext extends ParserRuleContext {
		public List<TerminalNode> Letter() { return getTokens(CFGParser.Letter); }
		public TerminalNode Letter(int i) {
			return getToken(CFGParser.Letter, i);
		}
		public List<TerminalNode> Number() { return getTokens(CFGParser.Number); }
		public TerminalNode Number(int i) {
			return getToken(CFGParser.Number, i);
		}
		public SimpleIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterSimpleIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitSimpleIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitSimpleIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleIdentifierContext simpleIdentifier() throws RecognitionException {
		SimpleIdentifierContext _localctx = new SimpleIdentifierContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_simpleIdentifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(Letter);
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(420);
				match(Letter);
				}
				break;
			case 2:
				{
				setState(424);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(421);
						match(Number);
						}
						} 
					}
					setState(426);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				}
				}
				break;
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
		enterRule(_localctx, 74, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			identifier();
			setState(430);
			match(T__9);
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__13) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
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
			match(T__10);
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
		enterRule(_localctx, 76, RULE_literal);
		try {
			setState(446);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				numberLiteral();
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(444);
				stringLiteral();
				}
				break;
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(445);
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
		enterRule(_localctx, 78, RULE_numberLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(452); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(452);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						setState(448);
						match(Number);
						}
						break;
					case 2:
						{
						setState(449);
						match(Number);
						setState(450);
						match(T__31);
						setState(451);
						match(Number);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(454); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		enterRule(_localctx, 80, RULE_stringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			match(T__33);
			setState(458); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(457);
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
				setState(460); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Number || _la==Letter );
			setState(462);
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
		enterRule(_localctx, 82, RULE_boolLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
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
		enterRule(_localctx, 84, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
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
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SemiColon() { return getTokens(CFGParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(CFGParser.SemiColon, i);
		}
		public List<ContructorDclContext> contructorDcl() {
			return getRuleContexts(ContructorDclContext.class);
		}
		public ContructorDclContext contructorDcl(int i) {
			return getRuleContext(ContructorDclContext.class,i);
		}
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
		enterRule(_localctx, 86, RULE_codeBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(T__1);
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << Number) | (1L << Letter))) != 0)) {
				{
				setState(476);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(469);
					dcl();
					}
					break;
				case 2:
					{
					setState(470);
					statement();
					}
					break;
				case 3:
					{
					setState(471);
					assignment();
					}
					break;
				case 4:
					{
					setState(472);
					expr(0);
					setState(473);
					match(SemiColon);
					}
					break;
				case 5:
					{
					setState(475);
					contructorDcl();
					}
					break;
				}
				}
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(481);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 27:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3>\u01e6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\5\2]\n\2\3\2\5\2`\n\2\3\2\5\2c\n\2\3\2\3\2\3\3\3\3"+
		"\3\3\7\3j\n\3\f\3\16\3m\13\3\3\3\5\3p\n\3\3\3\3\3\3\4\3\4\3\4\7\4w\n\4"+
		"\f\4\16\4z\13\4\3\4\3\4\3\5\3\5\3\5\7\5\u0081\n\5\f\5\16\5\u0084\13\5"+
		"\3\5\3\5\3\6\3\6\3\6\7\6\u008b\n\6\f\6\16\6\u008e\13\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u009b\n\7\3\b\3\b\3\b\3\b\5\b\u00a1\n"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u00b2\n\13\f\13\16\13\u00b5\13\13\5\13\u00b7\n\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c4\n\f\f\f\16\f\u00c7\13\f\3\f"+
		"\3\f\5\f\u00cb\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\7\16\u00db\n\16\f\16\16\16\u00de\13\16\5\16\u00e0\n\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00ec\n\17\f\17"+
		"\16\17\u00ef\13\17\5\17\u00f1\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00fa\n\20\5\20\u00fc\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\5\21\u0106\n\21\3\22\3\22\5\22\u010a\n\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0112\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u011b\n"+
		"\24\5\24\u011d\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\6\27\u012d\n\27\r\27\16\27\u012e\3\27\3\27\5\27\u0133"+
		"\n\27\3\27\3\27\3\30\3\30\3\31\3\31\5\31\u013b\n\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0149\n\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\5\34\u0152\n\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u015e\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\5\35\u017a\n\35\7\35\u017c\n\35\f\35\16\35\u017f"+
		"\13\35\3\36\3\36\5\36\u0183\n\36\3\37\3\37\3\37\3 \3 \3 \5 \u018b\n \3"+
		"!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0195\n\"\3#\3#\3#\5#\u019a\n#\3$\3$"+
		"\3$\3$\3%\3%\3%\3%\5%\u01a4\n%\3&\3&\3&\7&\u01a9\n&\f&\16&\u01ac\13&\5"+
		"&\u01ae\n&\3\'\3\'\3\'\3\'\3\'\7\'\u01b5\n\'\f\'\16\'\u01b8\13\'\5\'\u01ba"+
		"\n\'\3\'\3\'\3(\3(\3(\5(\u01c1\n(\3)\3)\3)\3)\6)\u01c7\n)\r)\16)\u01c8"+
		"\3*\3*\6*\u01cd\n*\r*\16*\u01ce\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\3-\3-\3"+
		"-\3-\7-\u01df\n-\f-\16-\u01e2\13-\3-\3-\3-\2\38.\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX\2\13\3\2(*\3"+
		"\2+,\3\2-\60\3\2\61\62\3\2\63\64\3\2\65\66\3\2\35\37\3\2\678\3\2%&\2\u0201"+
		"\2Z\3\2\2\2\4f\3\2\2\2\6s\3\2\2\2\b}\3\2\2\2\n\u0087\3\2\2\2\f\u009a\3"+
		"\2\2\2\16\u00a0\3\2\2\2\20\u00a2\3\2\2\2\22\u00a5\3\2\2\2\24\u00aa\3\2"+
		"\2\2\26\u00bb\3\2\2\2\30\u00ce\3\2\2\2\32\u00d2\3\2\2\2\34\u00e4\3\2\2"+
		"\2\36\u00f4\3\2\2\2 \u0105\3\2\2\2\"\u0109\3\2\2\2$\u010b\3\2\2\2&\u011c"+
		"\3\2\2\2(\u011e\3\2\2\2*\u0121\3\2\2\2,\u0127\3\2\2\2.\u0136\3\2\2\2\60"+
		"\u013a\3\2\2\2\62\u013c\3\2\2\2\64\u0142\3\2\2\2\66\u014d\3\2\2\28\u015d"+
		"\3\2\2\2:\u0182\3\2\2\2<\u0184\3\2\2\2>\u018a\3\2\2\2@\u018c\3\2\2\2B"+
		"\u0194\3\2\2\2D\u0199\3\2\2\2F\u019b\3\2\2\2H\u019f\3\2\2\2J\u01a5\3\2"+
		"\2\2L\u01af\3\2\2\2N\u01c0\3\2\2\2P\u01c6\3\2\2\2R\u01ca\3\2\2\2T\u01d2"+
		"\3\2\2\2V\u01d4\3\2\2\2X\u01d6\3\2\2\2Z\\\5\4\3\2[]\5\6\4\2\\[\3\2\2\2"+
		"\\]\3\2\2\2]_\3\2\2\2^`\5\b\5\2_^\3\2\2\2_`\3\2\2\2`b\3\2\2\2ac\5\n\6"+
		"\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\2\2\3e\3\3\2\2\2fg\7\3\2\2gk\7\4"+
		"\2\2hj\5\f\7\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2lo\3\2\2\2mk\3\2"+
		"\2\2np\5\20\t\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\7\5\2\2r\5\3\2\2\2st\7"+
		"\6\2\2tx\7\4\2\2uw\5\f\7\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3"+
		"\2\2\2zx\3\2\2\2{|\7\5\2\2|\7\3\2\2\2}~\7\7\2\2~\u0082\7\4\2\2\177\u0081"+
		"\5\f\7\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\5"+
		"\2\2\u0086\t\3\2\2\2\u0087\u0088\7\b\2\2\u0088\u008c\7\4\2\2\u0089\u008b"+
		"\5\f\7\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\5"+
		"\2\2\u0090\13\3\2\2\2\u0091\u009b\5\22\n\2\u0092\u009b\5\16\b\2\u0093"+
		"\u009b\5 \21\2\u0094\u009b\5\66\34\2\u0095\u0096\58\35\2\u0096\u0097\7"+
		";\2\2\u0097\u009b\3\2\2\2\u0098\u009b\7<\2\2\u0099\u009b\7=\2\2\u009a"+
		"\u0091\3\2\2\2\u009a\u0092\3\2\2\2\u009a\u0093\3\2\2\2\u009a\u0094\3\2"+
		"\2\2\u009a\u0095\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b"+
		"\r\3\2\2\2\u009c\u00a1\5\24\13\2\u009d\u00a1\5\26\f\2\u009e\u00a1\5\30"+
		"\r\2\u009f\u00a1\5\36\20\2\u00a0\u009c\3\2\2\2\u00a0\u009d\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\17\3\2\2\2\u00a2\u00a3\7\t\2"+
		"\2\u00a3\u00a4\5X-\2\u00a4\21\3\2\2\2\u00a5\u00a6\7\n\2\2\u00a6\u00a7"+
		"\5> \2\u00a7\u00a8\7\60\2\2\u00a8\u00a9\5X-\2\u00a9\23\3\2\2\2\u00aa\u00ab"+
		"\7\13\2\2\u00ab\u00ac\5> \2\u00ac\u00ad\5D#\2\u00ad\u00b6\7\f\2\2\u00ae"+
		"\u00b3\5<\37\2\u00af\u00b0\79\2\2\u00b0\u00b2\5<\37\2\u00b1\u00af\3\2"+
		"\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00ae\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\r\2\2\u00b9\u00ba\5X-\2\u00ba\25"+
		"\3\2\2\2\u00bb\u00bc\7\16\2\2\u00bc\u00bd\5> \2\u00bd\u00be\7\60\2\2\u00be"+
		"\u00ca\5D#\2\u00bf\u00c0\7\4\2\2\u00c0\u00c5\5:\36\2\u00c1\u00c2\79\2"+
		"\2\u00c2\u00c4\5:\36\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8"+
		"\u00c9\7\5\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00bf\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\7;\2\2\u00cd\27\3\2\2\2\u00ce\u00cf"+
		"\5> \2\u00cf\u00d0\5D#\2\u00d0\u00d1\5X-\2\u00d1\31\3\2\2\2\u00d2\u00d3"+
		"\7\17\2\2\u00d3\u00d4\7\20\2\2\u00d4\u00d5\5> \2\u00d5\u00d6\7\60\2\2"+
		"\u00d6\u00df\7\f\2\2\u00d7\u00dc\5<\37\2\u00d8\u00d9\79\2\2\u00d9\u00db"+
		"\5<\37\2\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00d7\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\7\r\2\2\u00e2"+
		"\u00e3\5X-\2\u00e3\33\3\2\2\2\u00e4\u00e5\7\20\2\2\u00e5\u00e6\5> \2\u00e6"+
		"\u00e7\7\60\2\2\u00e7\u00f0\7\f\2\2\u00e8\u00ed\5:\36\2\u00e9\u00ea\7"+
		"9\2\2\u00ea\u00ec\5:\36\2\u00eb\u00e9\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2"+
		"\2\2\u00f0\u00e8\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f3\7\r\2\2\u00f3\35\3\2\2\2\u00f4\u00f5\5> \2\u00f5\u00fb\5D#\2\u00f6"+
		"\u00f9\7:\2\2\u00f7\u00fa\5\34\17\2\u00f8\u00fa\58\35\2\u00f9\u00f7\3"+
		"\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f6\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\7;\2\2\u00fe\37\3\2\2\2"+
		"\u00ff\u0106\5\"\22\2\u0100\u0106\5\60\31\2\u0101\u0102\7\21\2\2\u0102"+
		"\u0103\58\35\2\u0103\u0104\7;\2\2\u0104\u0106\3\2\2\2\u0105\u00ff\3\2"+
		"\2\2\u0105\u0100\3\2\2\2\u0105\u0101\3\2\2\2\u0106!\3\2\2\2\u0107\u010a"+
		"\5$\23\2\u0108\u010a\5*\26\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a"+
		"#\3\2\2\2\u010b\u010c\7\22\2\2\u010c\u010d\7\f\2\2\u010d\u010e\58\35\2"+
		"\u010e\u010f\7\r\2\2\u010f\u0111\5X-\2\u0110\u0112\5&\24\2\u0111\u0110"+
		"\3\2\2\2\u0111\u0112\3\2\2\2\u0112%\3\2\2\2\u0113\u011d\5(\25\2\u0114"+
		"\u0115\7\23\2\2\u0115\u0116\7\f\2\2\u0116\u0117\58\35\2\u0117\u0118\7"+
		"\r\2\2\u0118\u011a\5X-\2\u0119\u011b\5&\24\2\u011a\u0119\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u0113\3\2\2\2\u011c\u0114\3\2"+
		"\2\2\u011d\'\3\2\2\2\u011e\u011f\7\24\2\2\u011f\u0120\5X-\2\u0120)\3\2"+
		"\2\2\u0121\u0122\7\25\2\2\u0122\u0123\7\f\2\2\u0123\u0124\58\35\2\u0124"+
		"\u0125\7\r\2\2\u0125\u0126\5,\27\2\u0126+\3\2\2\2\u0127\u012c\7\4\2\2"+
		"\u0128\u0129\7\26\2\2\u0129\u012a\5.\30\2\u012a\u012b\5X-\2\u012b\u012d"+
		"\3\2\2\2\u012c\u0128\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u0131\7\27\2\2\u0131\u0133\5"+
		"X-\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0135\7\5\2\2\u0135-\3\2\2\2\u0136\u0137\58\35\2\u0137/\3\2\2\2\u0138"+
		"\u013b\5\62\32\2\u0139\u013b\5\64\33\2\u013a\u0138\3\2\2\2\u013a\u0139"+
		"\3\2\2\2\u013b\61\3\2\2\2\u013c\u013d\7\30\2\2\u013d\u013e\7\f\2\2\u013e"+
		"\u013f\58\35\2\u013f\u0140\7\r\2\2\u0140\u0141\5X-\2\u0141\63\3\2\2\2"+
		"\u0142\u0143\7\31\2\2\u0143\u0144\7\f\2\2\u0144\u0145\5D#\2\u0145\u0148"+
		"\7\32\2\2\u0146\u0149\5P)\2\u0147\u0149\5D#\2\u0148\u0146\3\2\2\2\u0148"+
		"\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\7\r\2\2\u014b\u014c\5X"+
		"-\2\u014c\65\3\2\2\2\u014d\u014e\5D#\2\u014e\u0151\7:\2\2\u014f\u0152"+
		"\5D#\2\u0150\u0152\58\35\2\u0151\u014f\3\2\2\2\u0151\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0154\7;\2\2\u0154\67\3\2\2\2\u0155\u0156\b\35\1"+
		"\2\u0156\u015e\5L\'\2\u0157\u0158\7\f\2\2\u0158\u0159\58\35\2\u0159\u015a"+
		"\7\r\2\2\u015a\u015e\3\2\2\2\u015b\u015e\5N(\2\u015c\u015e\5D#\2\u015d"+
		"\u0155\3\2\2\2\u015d\u0157\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015c\3\2"+
		"\2\2\u015e\u017d\3\2\2\2\u015f\u0160\f\13\2\2\u0160\u0161\7\'\2\2\u0161"+
		"\u017c\58\35\f\u0162\u0163\f\n\2\2\u0163\u0164\t\2\2\2\u0164\u017c\58"+
		"\35\13\u0165\u0166\f\t\2\2\u0166\u0167\t\3\2\2\u0167\u017c\58\35\n\u0168"+
		"\u0169\f\b\2\2\u0169\u016a\t\4\2\2\u016a\u017c\58\35\t\u016b\u016c\f\7"+
		"\2\2\u016c\u016d\t\5\2\2\u016d\u017c\58\35\b\u016e\u016f\f\6\2\2\u016f"+
		"\u0170\t\6\2\2\u0170\u017c\58\35\7\u0171\u0172\f\5\2\2\u0172\u0173\t\7"+
		"\2\2\u0173\u017c\58\35\6\u0174\u0175\f\r\2\2\u0175\u0176\7\33\2\2\u0176"+
		"\u0177\58\35\2\u0177\u0179\7\34\2\2\u0178\u017a\58\35\2\u0179\u0178\3"+
		"\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c\3\2\2\2\u017b\u015f\3\2\2\2\u017b"+
		"\u0162\3\2\2\2\u017b\u0165\3\2\2\2\u017b\u0168\3\2\2\2\u017b\u016b\3\2"+
		"\2\2\u017b\u016e\3\2\2\2\u017b\u0171\3\2\2\2\u017b\u0174\3\2\2\2\u017c"+
		"\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e9\3\2\2\2"+
		"\u017f\u017d\3\2\2\2\u0180\u0183\58\35\2\u0181\u0183\5\34\17\2\u0182\u0180"+
		"\3\2\2\2\u0182\u0181\3\2\2\2\u0183;\3\2\2\2\u0184\u0185\5> \2\u0185\u0186"+
		"\5D#\2\u0186=\3\2\2\2\u0187\u018b\5@!\2\u0188\u018b\5B\"\2\u0189\u018b"+
		"\5D#\2\u018a\u0187\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u0189\3\2\2\2\u018b"+
		"?\3\2\2\2\u018c\u018d\t\b\2\2\u018dA\3\2\2\2\u018e\u0195\7 \2\2\u018f"+
		"\u0195\7!\2\2\u0190\u0191\7\16\2\2\u0191\u0192\5> \2\u0192\u0193\7\60"+
		"\2\2\u0193\u0195\3\2\2\2\u0194\u018e\3\2\2\2\u0194\u018f\3\2\2\2\u0194"+
		"\u0190\3\2\2\2\u0195C\3\2\2\2\u0196\u019a\5F$\2\u0197\u019a\5H%\2\u0198"+
		"\u019a\5J&\2\u0199\u0196\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u0198\3\2\2"+
		"\2\u019aE\3\2\2\2\u019b\u019c\5J&\2\u019c\u019d\7\"\2\2\u019d\u019e\5"+
		"J&\2\u019eG\3\2\2\2\u019f\u01a0\7#\2\2\u01a0\u01a3\7\"\2\2\u01a1\u01a4"+
		"\5F$\2\u01a2\u01a4\5J&\2\u01a3\u01a1\3\2\2\2\u01a3\u01a2\3\2\2\2\u01a4"+
		"I\3\2\2\2\u01a5\u01ad\78\2\2\u01a6\u01ae\78\2\2\u01a7\u01a9\7\67\2\2\u01a8"+
		"\u01a7\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2"+
		"\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01a6\3\2\2\2\u01ad"+
		"\u01aa\3\2\2\2\u01aeK\3\2\2\2\u01af\u01b0\5D#\2\u01b0\u01b9\7\f\2\2\u01b1"+
		"\u01b6\5:\36\2\u01b2\u01b3\79\2\2\u01b3\u01b5\5:\36\2\u01b4\u01b2\3\2"+
		"\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7"+
		"\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01b1\3\2\2\2\u01b9\u01ba\3\2"+
		"\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\7\r\2\2\u01bcM\3\2\2\2\u01bd\u01c1"+
		"\5P)\2\u01be\u01c1\5R*\2\u01bf\u01c1\5T+\2\u01c0\u01bd\3\2\2\2\u01c0\u01be"+
		"\3\2\2\2\u01c0\u01bf\3\2\2\2\u01c1O\3\2\2\2\u01c2\u01c7\7\67\2\2\u01c3"+
		"\u01c4\7\67\2\2\u01c4\u01c5\7\"\2\2\u01c5\u01c7\7\67\2\2\u01c6\u01c2\3"+
		"\2\2\2\u01c6\u01c3\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c9Q\3\2\2\2\u01ca\u01cc\7$\2\2\u01cb\u01cd\t\t\2\2\u01cc"+
		"\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2"+
		"\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\7$\2\2\u01d1S\3\2\2\2\u01d2\u01d3"+
		"\5V,\2\u01d3U\3\2\2\2\u01d4\u01d5\t\n\2\2\u01d5W\3\2\2\2\u01d6\u01e0\7"+
		"\4\2\2\u01d7\u01df\5\16\b\2\u01d8\u01df\5 \21\2\u01d9\u01df\5\66\34\2"+
		"\u01da\u01db\58\35\2\u01db\u01dc\7;\2\2\u01dc\u01df\3\2\2\2\u01dd\u01df"+
		"\5\32\16\2\u01de\u01d7\3\2\2\2\u01de\u01d8\3\2\2\2\u01de\u01d9\3\2\2\2"+
		"\u01de\u01da\3\2\2\2\u01de\u01dd\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01de"+
		"\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e3"+
		"\u01e4\7\5\2\2\u01e4Y\3\2\2\2\63\\_bkox\u0082\u008c\u009a\u00a0\u00b3"+
		"\u00b6\u00c5\u00ca\u00dc\u00df\u00ed\u00f0\u00f9\u00fb\u0105\u0109\u0111"+
		"\u011a\u011c\u012e\u0132\u013a\u0148\u0151\u015d\u0179\u017b\u017d\u0182"+
		"\u018a\u0194\u0199\u01a3\u01aa\u01ad\u01b6\u01b9\u01c0\u01c6\u01c8\u01ce"+
		"\u01de\u01e0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}