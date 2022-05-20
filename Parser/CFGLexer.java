// Generated from C:/Users/marti/OneDrive/Dokumenter/GitHub/P4-SimulationLanguage\CFG.g4 by ANTLR 4.9.2
package Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CFGLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, OP_POW=36, OP_MUL=37, OP_DIV=38, 
		OP_MOD=39, OP_ADD=40, OP_SUB=41, OP_LTOE=42, OP_GTOE=43, OP_LT=44, OP_GT=45, 
		OP_EQUALS=46, OP_NEQUALS=47, OP_AND=48, OP_AND2=49, OP_OR=50, OP_OR2=51, 
		Number=52, Letter=53, Comma=54, Equals=55, SemiColon=56, Comment=57, MultiComment=58, 
		WS=59;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "OP_POW", "OP_MUL", "OP_DIV", "OP_MOD", "OP_ADD", "OP_SUB", 
			"OP_LTOE", "OP_GTOE", "OP_LT", "OP_GT", "OP_EQUALS", "OP_NEQUALS", "OP_AND", 
			"OP_AND2", "OP_OR", "OP_OR2", "Number", "Letter", "Comma", "Equals", 
			"SemiColon", "Comment", "MultiComment", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Simulation Environment'", "'{'", "'}'", "'Simulation Behavior'", 
			"'Simulation Update'", "'Simulation Output'", "'EndCondition'", "'InitCondition<'", 
			"'function'", "'('", "')'", "'List<'", "'constructor'", "'Create<'", 
			"'return'", "'if'", "'else if'", "'else'", "'switch'", "'case'", "'default'", 
			"'while'", "'for'", "'in range'", "'['", "']'", "'number '", "'string '", 
			"'bool '", "'Vehicle'", "'Node'", "'.'", "'\"'", "'true'", "'false'", 
			"'^'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<='", "'>='", "'<'", "'>'", 
			"'=='", "'!='", "' and '", "'&&'", "' or '", "'||'", null, null, "','", 
			"'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"OP_POW", "OP_MUL", "OP_DIV", "OP_MOD", "OP_ADD", "OP_SUB", "OP_LTOE", 
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


	public CFGLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CFG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u01dd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)"+
		"\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64"+
		"\3\64\3\65\3\65\3\66\6\66\u01b4\n\66\r\66\16\66\u01b5\3\67\3\67\38\38"+
		"\39\39\3:\3:\3:\3:\7:\u01c2\n:\f:\16:\u01c5\13:\3:\3:\3;\3;\3;\3;\7;\u01cd"+
		"\n;\f;\16;\u01d0\13;\3;\3;\3;\3;\3;\3<\6<\u01d8\n<\r<\16<\u01d9\3<\3<"+
		"\3\u01ce\2=\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s;u<w=\3\2\5\5\2C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\""+
		"\2\u01e0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\3y"+
		"\3\2\2\2\5\u0090\3\2\2\2\7\u0092\3\2\2\2\t\u0094\3\2\2\2\13\u00a8\3\2"+
		"\2\2\r\u00ba\3\2\2\2\17\u00cc\3\2\2\2\21\u00d9\3\2\2\2\23\u00e8\3\2\2"+
		"\2\25\u00f1\3\2\2\2\27\u00f3\3\2\2\2\31\u00f5\3\2\2\2\33\u00fb\3\2\2\2"+
		"\35\u0107\3\2\2\2\37\u010f\3\2\2\2!\u0116\3\2\2\2#\u0119\3\2\2\2%\u0121"+
		"\3\2\2\2\'\u0126\3\2\2\2)\u012d\3\2\2\2+\u0132\3\2\2\2-\u013a\3\2\2\2"+
		"/\u0140\3\2\2\2\61\u0144\3\2\2\2\63\u014d\3\2\2\2\65\u014f\3\2\2\2\67"+
		"\u0151\3\2\2\29\u0159\3\2\2\2;\u0161\3\2\2\2=\u0167\3\2\2\2?\u016f\3\2"+
		"\2\2A\u0174\3\2\2\2C\u0176\3\2\2\2E\u0178\3\2\2\2G\u017d\3\2\2\2I\u0183"+
		"\3\2\2\2K\u0185\3\2\2\2M\u0187\3\2\2\2O\u0189\3\2\2\2Q\u018b\3\2\2\2S"+
		"\u018d\3\2\2\2U\u018f\3\2\2\2W\u0192\3\2\2\2Y\u0195\3\2\2\2[\u0197\3\2"+
		"\2\2]\u0199\3\2\2\2_\u019c\3\2\2\2a\u019f\3\2\2\2c\u01a5\3\2\2\2e\u01a8"+
		"\3\2\2\2g\u01ad\3\2\2\2i\u01b0\3\2\2\2k\u01b3\3\2\2\2m\u01b7\3\2\2\2o"+
		"\u01b9\3\2\2\2q\u01bb\3\2\2\2s\u01bd\3\2\2\2u\u01c8\3\2\2\2w\u01d7\3\2"+
		"\2\2yz\7U\2\2z{\7k\2\2{|\7o\2\2|}\7w\2\2}~\7n\2\2~\177\7c\2\2\177\u0080"+
		"\7v\2\2\u0080\u0081\7k\2\2\u0081\u0082\7q\2\2\u0082\u0083\7p\2\2\u0083"+
		"\u0084\7\"\2\2\u0084\u0085\7G\2\2\u0085\u0086\7p\2\2\u0086\u0087\7x\2"+
		"\2\u0087\u0088\7k\2\2\u0088\u0089\7t\2\2\u0089\u008a\7q\2\2\u008a\u008b"+
		"\7p\2\2\u008b\u008c\7o\2\2\u008c\u008d\7g\2\2\u008d\u008e\7p\2\2\u008e"+
		"\u008f\7v\2\2\u008f\4\3\2\2\2\u0090\u0091\7}\2\2\u0091\6\3\2\2\2\u0092"+
		"\u0093\7\177\2\2\u0093\b\3\2\2\2\u0094\u0095\7U\2\2\u0095\u0096\7k\2\2"+
		"\u0096\u0097\7o\2\2\u0097\u0098\7w\2\2\u0098\u0099\7n\2\2\u0099\u009a"+
		"\7c\2\2\u009a\u009b\7v\2\2\u009b\u009c\7k\2\2\u009c\u009d\7q\2\2\u009d"+
		"\u009e\7p\2\2\u009e\u009f\7\"\2\2\u009f\u00a0\7D\2\2\u00a0\u00a1\7g\2"+
		"\2\u00a1\u00a2\7j\2\2\u00a2\u00a3\7c\2\2\u00a3\u00a4\7x\2\2\u00a4\u00a5"+
		"\7k\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7t\2\2\u00a7\n\3\2\2\2\u00a8\u00a9"+
		"\7U\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7o\2\2\u00ab\u00ac\7w\2\2\u00ac"+
		"\u00ad\7n\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7k\2\2"+
		"\u00b0\u00b1\7q\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3\7\"\2\2\u00b3\u00b4"+
		"\7W\2\2\u00b4\u00b5\7r\2\2\u00b5\u00b6\7f\2\2\u00b6\u00b7\7c\2\2\u00b7"+
		"\u00b8\7v\2\2\u00b8\u00b9\7g\2\2\u00b9\f\3\2\2\2\u00ba\u00bb\7U\2\2\u00bb"+
		"\u00bc\7k\2\2\u00bc\u00bd\7o\2\2\u00bd\u00be\7w\2\2\u00be\u00bf\7n\2\2"+
		"\u00bf\u00c0\7c\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3"+
		"\7q\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7\"\2\2\u00c5\u00c6\7Q\2\2\u00c6"+
		"\u00c7\7w\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7r\2\2\u00c9\u00ca\7w\2\2"+
		"\u00ca\u00cb\7v\2\2\u00cb\16\3\2\2\2\u00cc\u00cd\7G\2\2\u00cd\u00ce\7"+
		"p\2\2\u00ce\u00cf\7f\2\2\u00cf\u00d0\7E\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2"+
		"\7p\2\2\u00d2\u00d3\7f\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7v\2\2\u00d5"+
		"\u00d6\7k\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7p\2\2\u00d8\20\3\2\2\2\u00d9"+
		"\u00da\7K\2\2\u00da\u00db\7p\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7v\2\2"+
		"\u00dd\u00de\7E\2\2\u00de\u00df\7q\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1"+
		"\7f\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7k\2\2\u00e4"+
		"\u00e5\7q\2\2\u00e5\u00e6\7p\2\2\u00e6\u00e7\7>\2\2\u00e7\22\3\2\2\2\u00e8"+
		"\u00e9\7h\2\2\u00e9\u00ea\7w\2\2\u00ea\u00eb\7p\2\2\u00eb\u00ec\7e\2\2"+
		"\u00ec\u00ed\7v\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0"+
		"\7p\2\2\u00f0\24\3\2\2\2\u00f1\u00f2\7*\2\2\u00f2\26\3\2\2\2\u00f3\u00f4"+
		"\7+\2\2\u00f4\30\3\2\2\2\u00f5\u00f6\7N\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8"+
		"\7u\2\2\u00f8\u00f9\7v\2\2\u00f9\u00fa\7>\2\2\u00fa\32\3\2\2\2\u00fb\u00fc"+
		"\7e\2\2\u00fc\u00fd\7q\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7u\2\2\u00ff"+
		"\u0100\7v\2\2\u0100\u0101\7t\2\2\u0101\u0102\7w\2\2\u0102\u0103\7e\2\2"+
		"\u0103\u0104\7v\2\2\u0104\u0105\7q\2\2\u0105\u0106\7t\2\2\u0106\34\3\2"+
		"\2\2\u0107\u0108\7E\2\2\u0108\u0109\7t\2\2\u0109\u010a\7g\2\2\u010a\u010b"+
		"\7c\2\2\u010b\u010c\7v\2\2\u010c\u010d\7g\2\2\u010d\u010e\7>\2\2\u010e"+
		"\36\3\2\2\2\u010f\u0110\7t\2\2\u0110\u0111\7g\2\2\u0111\u0112\7v\2\2\u0112"+
		"\u0113\7w\2\2\u0113\u0114\7t\2\2\u0114\u0115\7p\2\2\u0115 \3\2\2\2\u0116"+
		"\u0117\7k\2\2\u0117\u0118\7h\2\2\u0118\"\3\2\2\2\u0119\u011a\7g\2\2\u011a"+
		"\u011b\7n\2\2\u011b\u011c\7u\2\2\u011c\u011d\7g\2\2\u011d\u011e\7\"\2"+
		"\2\u011e\u011f\7k\2\2\u011f\u0120\7h\2\2\u0120$\3\2\2\2\u0121\u0122\7"+
		"g\2\2\u0122\u0123\7n\2\2\u0123\u0124\7u\2\2\u0124\u0125\7g\2\2\u0125&"+
		"\3\2\2\2\u0126\u0127\7u\2\2\u0127\u0128\7y\2\2\u0128\u0129\7k\2\2\u0129"+
		"\u012a\7v\2\2\u012a\u012b\7e\2\2\u012b\u012c\7j\2\2\u012c(\3\2\2\2\u012d"+
		"\u012e\7e\2\2\u012e\u012f\7c\2\2\u012f\u0130\7u\2\2\u0130\u0131\7g\2\2"+
		"\u0131*\3\2\2\2\u0132\u0133\7f\2\2\u0133\u0134\7g\2\2\u0134\u0135\7h\2"+
		"\2\u0135\u0136\7c\2\2\u0136\u0137\7w\2\2\u0137\u0138\7n\2\2\u0138\u0139"+
		"\7v\2\2\u0139,\3\2\2\2\u013a\u013b\7y\2\2\u013b\u013c\7j\2\2\u013c\u013d"+
		"\7k\2\2\u013d\u013e\7n\2\2\u013e\u013f\7g\2\2\u013f.\3\2\2\2\u0140\u0141"+
		"\7h\2\2\u0141\u0142\7q\2\2\u0142\u0143\7t\2\2\u0143\60\3\2\2\2\u0144\u0145"+
		"\7k\2\2\u0145\u0146\7p\2\2\u0146\u0147\7\"\2\2\u0147\u0148\7t\2\2\u0148"+
		"\u0149\7c\2\2\u0149\u014a\7p\2\2\u014a\u014b\7i\2\2\u014b\u014c\7g\2\2"+
		"\u014c\62\3\2\2\2\u014d\u014e\7]\2\2\u014e\64\3\2\2\2\u014f\u0150\7_\2"+
		"\2\u0150\66\3\2\2\2\u0151\u0152\7p\2\2\u0152\u0153\7w\2\2\u0153\u0154"+
		"\7o\2\2\u0154\u0155\7d\2\2\u0155\u0156\7g\2\2\u0156\u0157\7t\2\2\u0157"+
		"\u0158\7\"\2\2\u01588\3\2\2\2\u0159\u015a\7u\2\2\u015a\u015b\7v\2\2\u015b"+
		"\u015c\7t\2\2\u015c\u015d\7k\2\2\u015d\u015e\7p\2\2\u015e\u015f\7i\2\2"+
		"\u015f\u0160\7\"\2\2\u0160:\3\2\2\2\u0161\u0162\7d\2\2\u0162\u0163\7q"+
		"\2\2\u0163\u0164\7q\2\2\u0164\u0165\7n\2\2\u0165\u0166\7\"\2\2\u0166<"+
		"\3\2\2\2\u0167\u0168\7X\2\2\u0168\u0169\7g\2\2\u0169\u016a\7j\2\2\u016a"+
		"\u016b\7k\2\2\u016b\u016c\7e\2\2\u016c\u016d\7n\2\2\u016d\u016e\7g\2\2"+
		"\u016e>\3\2\2\2\u016f\u0170\7P\2\2\u0170\u0171\7q\2\2\u0171\u0172\7f\2"+
		"\2\u0172\u0173\7g\2\2\u0173@\3\2\2\2\u0174\u0175\7\60\2\2\u0175B\3\2\2"+
		"\2\u0176\u0177\7$\2\2\u0177D\3\2\2\2\u0178\u0179\7v\2\2\u0179\u017a\7"+
		"t\2\2\u017a\u017b\7w\2\2\u017b\u017c\7g\2\2\u017cF\3\2\2\2\u017d\u017e"+
		"\7h\2\2\u017e\u017f\7c\2\2\u017f\u0180\7n\2\2\u0180\u0181\7u\2\2\u0181"+
		"\u0182\7g\2\2\u0182H\3\2\2\2\u0183\u0184\7`\2\2\u0184J\3\2\2\2\u0185\u0186"+
		"\7,\2\2\u0186L\3\2\2\2\u0187\u0188\7\61\2\2\u0188N\3\2\2\2\u0189\u018a"+
		"\7\'\2\2\u018aP\3\2\2\2\u018b\u018c\7-\2\2\u018cR\3\2\2\2\u018d\u018e"+
		"\7/\2\2\u018eT\3\2\2\2\u018f\u0190\7>\2\2\u0190\u0191\7?\2\2\u0191V\3"+
		"\2\2\2\u0192\u0193\7@\2\2\u0193\u0194\7?\2\2\u0194X\3\2\2\2\u0195\u0196"+
		"\7>\2\2\u0196Z\3\2\2\2\u0197\u0198\7@\2\2\u0198\\\3\2\2\2\u0199\u019a"+
		"\7?\2\2\u019a\u019b\7?\2\2\u019b^\3\2\2\2\u019c\u019d\7#\2\2\u019d\u019e"+
		"\7?\2\2\u019e`\3\2\2\2\u019f\u01a0\7\"\2\2\u01a0\u01a1\7c\2\2\u01a1\u01a2"+
		"\7p\2\2\u01a2\u01a3\7f\2\2\u01a3\u01a4\7\"\2\2\u01a4b\3\2\2\2\u01a5\u01a6"+
		"\7(\2\2\u01a6\u01a7\7(\2\2\u01a7d\3\2\2\2\u01a8\u01a9\7\"\2\2\u01a9\u01aa"+
		"\7q\2\2\u01aa\u01ab\7t\2\2\u01ab\u01ac\7\"\2\2\u01acf\3\2\2\2\u01ad\u01ae"+
		"\7~\2\2\u01ae\u01af\7~\2\2\u01afh\3\2\2\2\u01b0\u01b1\4\62;\2\u01b1j\3"+
		"\2\2\2\u01b2\u01b4\t\2\2\2\u01b3\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5"+
		"\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6l\3\2\2\2\u01b7\u01b8\7.\2\2\u01b8"+
		"n\3\2\2\2\u01b9\u01ba\7?\2\2\u01bap\3\2\2\2\u01bb\u01bc\7=\2\2\u01bcr"+
		"\3\2\2\2\u01bd\u01be\7\61\2\2\u01be\u01bf\7\61\2\2\u01bf\u01c3\3\2\2\2"+
		"\u01c0\u01c2\n\3\2\2\u01c1\u01c0\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1"+
		"\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6"+
		"\u01c7\b:\2\2\u01c7t\3\2\2\2\u01c8\u01c9\7\61\2\2\u01c9\u01ca\7,\2\2\u01ca"+
		"\u01ce\3\2\2\2\u01cb\u01cd\13\2\2\2\u01cc\u01cb\3\2\2\2\u01cd\u01d0\3"+
		"\2\2\2\u01ce\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0"+
		"\u01ce\3\2\2\2\u01d1\u01d2\7,\2\2\u01d2\u01d3\7\61\2\2\u01d3\u01d4\3\2"+
		"\2\2\u01d4\u01d5\b;\2\2\u01d5v\3\2\2\2\u01d6\u01d8\t\4\2\2\u01d7\u01d6"+
		"\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da"+
		"\u01db\3\2\2\2\u01db\u01dc\b<\2\2\u01dcx\3\2\2\2\b\2\u01b3\u01b5\u01c3"+
		"\u01ce\u01d9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}