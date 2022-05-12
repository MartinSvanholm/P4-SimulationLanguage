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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, OP_POW=37, OP_MUL=38, 
		OP_DIV=39, OP_MOD=40, OP_ADD=41, OP_SUB=42, OP_LTOE=43, OP_GTOE=44, OP_LT=45, 
		OP_GT=46, OP_EQUALS=47, OP_NEQUALS=48, OP_AND=49, OP_AND2=50, OP_OR=51, 
		OP_OR2=52, Number=53, Letter=54, Comma=55, Equals=56, SemiColon=57, Comment=58, 
		MultiComment=59, WS=60;
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
			"T__33", "T__34", "T__35", "OP_POW", "OP_MUL", "OP_DIV", "OP_MOD", "OP_ADD", 
			"OP_SUB", "OP_LTOE", "OP_GTOE", "OP_LT", "OP_GT", "OP_EQUALS", "OP_NEQUALS", 
			"OP_AND", "OP_AND2", "OP_OR", "OP_OR2", "Number", "Letter", "Comma", 
			"Equals", "SemiColon", "Comment", "MultiComment", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2>\u01e5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		" \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%"+
		"\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3"+
		"\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\67\6\67\u01bc"+
		"\n\67\r\67\16\67\u01bd\38\38\39\39\3:\3:\3;\3;\3;\3;\7;\u01ca\n;\f;\16"+
		";\u01cd\13;\3;\3;\3<\3<\3<\3<\7<\u01d5\n<\f<\16<\u01d8\13<\3<\3<\3<\3"+
		"<\3<\3=\6=\u01e0\n=\r=\16=\u01e1\3=\3=\3\u01d6\2>\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>\3\2\5\5\2"+
		"C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u01e8\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\3{\3\2\2\2\5\u0092\3\2"+
		"\2\2\7\u0094\3\2\2\2\t\u0096\3\2\2\2\13\u00aa\3\2\2\2\r\u00bc\3\2\2\2"+
		"\17\u00ce\3\2\2\2\21\u00db\3\2\2\2\23\u00ea\3\2\2\2\25\u00f3\3\2\2\2\27"+
		"\u00f5\3\2\2\2\31\u00f7\3\2\2\2\33\u00fd\3\2\2\2\35\u0109\3\2\2\2\37\u0111"+
		"\3\2\2\2!\u0118\3\2\2\2#\u011b\3\2\2\2%\u0123\3\2\2\2\'\u0128\3\2\2\2"+
		")\u012f\3\2\2\2+\u0135\3\2\2\2-\u013d\3\2\2\2/\u0143\3\2\2\2\61\u0147"+
		"\3\2\2\2\63\u0150\3\2\2\2\65\u0152\3\2\2\2\67\u0154\3\2\2\29\u015c\3\2"+
		"\2\2;\u0164\3\2\2\2=\u016a\3\2\2\2?\u0172\3\2\2\2A\u0177\3\2\2\2C\u0179"+
		"\3\2\2\2E\u017e\3\2\2\2G\u0180\3\2\2\2I\u0185\3\2\2\2K\u018b\3\2\2\2M"+
		"\u018d\3\2\2\2O\u018f\3\2\2\2Q\u0191\3\2\2\2S\u0193\3\2\2\2U\u0195\3\2"+
		"\2\2W\u0197\3\2\2\2Y\u019a\3\2\2\2[\u019d\3\2\2\2]\u019f\3\2\2\2_\u01a1"+
		"\3\2\2\2a\u01a4\3\2\2\2c\u01a7\3\2\2\2e\u01ad\3\2\2\2g\u01b0\3\2\2\2i"+
		"\u01b5\3\2\2\2k\u01b8\3\2\2\2m\u01bb\3\2\2\2o\u01bf\3\2\2\2q\u01c1\3\2"+
		"\2\2s\u01c3\3\2\2\2u\u01c5\3\2\2\2w\u01d0\3\2\2\2y\u01df\3\2\2\2{|\7U"+
		"\2\2|}\7k\2\2}~\7o\2\2~\177\7w\2\2\177\u0080\7n\2\2\u0080\u0081\7c\2\2"+
		"\u0081\u0082\7v\2\2\u0082\u0083\7k\2\2\u0083\u0084\7q\2\2\u0084\u0085"+
		"\7p\2\2\u0085\u0086\7\"\2\2\u0086\u0087\7G\2\2\u0087\u0088\7p\2\2\u0088"+
		"\u0089\7x\2\2\u0089\u008a\7k\2\2\u008a\u008b\7t\2\2\u008b\u008c\7q\2\2"+
		"\u008c\u008d\7p\2\2\u008d\u008e\7o\2\2\u008e\u008f\7g\2\2\u008f\u0090"+
		"\7p\2\2\u0090\u0091\7v\2\2\u0091\4\3\2\2\2\u0092\u0093\7}\2\2\u0093\6"+
		"\3\2\2\2\u0094\u0095\7\177\2\2\u0095\b\3\2\2\2\u0096\u0097\7U\2\2\u0097"+
		"\u0098\7k\2\2\u0098\u0099\7o\2\2\u0099\u009a\7w\2\2\u009a\u009b\7n\2\2"+
		"\u009b\u009c\7c\2\2\u009c\u009d\7v\2\2\u009d\u009e\7k\2\2\u009e\u009f"+
		"\7q\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7\"\2\2\u00a1\u00a2\7D\2\2\u00a2"+
		"\u00a3\7g\2\2\u00a3\u00a4\7j\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7x\2\2"+
		"\u00a6\u00a7\7k\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7t\2\2\u00a9\n\3\2"+
		"\2\2\u00aa\u00ab\7U\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7o\2\2\u00ad\u00ae"+
		"\7w\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7v\2\2\u00b1"+
		"\u00b2\7k\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7\"\2"+
		"\2\u00b5\u00b6\7W\2\2\u00b6\u00b7\7r\2\2\u00b7\u00b8\7f\2\2\u00b8\u00b9"+
		"\7c\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7g\2\2\u00bb\f\3\2\2\2\u00bc\u00bd"+
		"\7U\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7o\2\2\u00bf\u00c0\7w\2\2\u00c0"+
		"\u00c1\7n\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7k\2\2"+
		"\u00c4\u00c5\7q\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7\"\2\2\u00c7\u00c8"+
		"\7Q\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7r\2\2\u00cb"+
		"\u00cc\7w\2\2\u00cc\u00cd\7v\2\2\u00cd\16\3\2\2\2\u00ce\u00cf\7G\2\2\u00cf"+
		"\u00d0\7p\2\2\u00d0\u00d1\7f\2\2\u00d1\u00d2\7E\2\2\u00d2\u00d3\7q\2\2"+
		"\u00d3\u00d4\7p\2\2\u00d4\u00d5\7f\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7"+
		"\7v\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7q\2\2\u00d9\u00da\7p\2\2\u00da"+
		"\20\3\2\2\2\u00db\u00dc\7K\2\2\u00dc\u00dd\7p\2\2\u00dd\u00de\7k\2\2\u00de"+
		"\u00df\7v\2\2\u00df\u00e0\7E\2\2\u00e0\u00e1\7q\2\2\u00e1\u00e2\7p\2\2"+
		"\u00e2\u00e3\7f\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6"+
		"\7k\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7>\2\2\u00e9"+
		"\22\3\2\2\2\u00ea\u00eb\7h\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7p\2\2\u00ed"+
		"\u00ee\7e\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7q\2\2"+
		"\u00f1\u00f2\7p\2\2\u00f2\24\3\2\2\2\u00f3\u00f4\7*\2\2\u00f4\26\3\2\2"+
		"\2\u00f5\u00f6\7+\2\2\u00f6\30\3\2\2\2\u00f7\u00f8\7N\2\2\u00f8\u00f9"+
		"\7k\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fb\7v\2\2\u00fb\u00fc\7>\2\2\u00fc"+
		"\32\3\2\2\2\u00fd\u00fe\7e\2\2\u00fe\u00ff\7q\2\2\u00ff\u0100\7p\2\2\u0100"+
		"\u0101\7u\2\2\u0101\u0102\7v\2\2\u0102\u0103\7t\2\2\u0103\u0104\7w\2\2"+
		"\u0104\u0105\7e\2\2\u0105\u0106\7v\2\2\u0106\u0107\7q\2\2\u0107\u0108"+
		"\7t\2\2\u0108\34\3\2\2\2\u0109\u010a\7E\2\2\u010a\u010b\7t\2\2\u010b\u010c"+
		"\7g\2\2\u010c\u010d\7c\2\2\u010d\u010e\7v\2\2\u010e\u010f\7g\2\2\u010f"+
		"\u0110\7>\2\2\u0110\36\3\2\2\2\u0111\u0112\7t\2\2\u0112\u0113\7g\2\2\u0113"+
		"\u0114\7v\2\2\u0114\u0115\7w\2\2\u0115\u0116\7t\2\2\u0116\u0117\7p\2\2"+
		"\u0117 \3\2\2\2\u0118\u0119\7k\2\2\u0119\u011a\7h\2\2\u011a\"\3\2\2\2"+
		"\u011b\u011c\7g\2\2\u011c\u011d\7n\2\2\u011d\u011e\7u\2\2\u011e\u011f"+
		"\7g\2\2\u011f\u0120\7\"\2\2\u0120\u0121\7k\2\2\u0121\u0122\7h\2\2\u0122"+
		"$\3\2\2\2\u0123\u0124\7g\2\2\u0124\u0125\7n\2\2\u0125\u0126\7u\2\2\u0126"+
		"\u0127\7g\2\2\u0127&\3\2\2\2\u0128\u0129\7u\2\2\u0129\u012a\7y\2\2\u012a"+
		"\u012b\7k\2\2\u012b\u012c\7v\2\2\u012c\u012d\7e\2\2\u012d\u012e\7j\2\2"+
		"\u012e(\3\2\2\2\u012f\u0130\7e\2\2\u0130\u0131\7c\2\2\u0131\u0132\7u\2"+
		"\2\u0132\u0133\7g\2\2\u0133\u0134\7\"\2\2\u0134*\3\2\2\2\u0135\u0136\7"+
		"f\2\2\u0136\u0137\7g\2\2\u0137\u0138\7h\2\2\u0138\u0139\7c\2\2\u0139\u013a"+
		"\7w\2\2\u013a\u013b\7n\2\2\u013b\u013c\7v\2\2\u013c,\3\2\2\2\u013d\u013e"+
		"\7y\2\2\u013e\u013f\7j\2\2\u013f\u0140\7k\2\2\u0140\u0141\7n\2\2\u0141"+
		"\u0142\7g\2\2\u0142.\3\2\2\2\u0143\u0144\7h\2\2\u0144\u0145\7q\2\2\u0145"+
		"\u0146\7t\2\2\u0146\60\3\2\2\2\u0147\u0148\7k\2\2\u0148\u0149\7p\2\2\u0149"+
		"\u014a\7\"\2\2\u014a\u014b\7t\2\2\u014b\u014c\7c\2\2\u014c\u014d\7p\2"+
		"\2\u014d\u014e\7i\2\2\u014e\u014f\7g\2\2\u014f\62\3\2\2\2\u0150\u0151"+
		"\7]\2\2\u0151\64\3\2\2\2\u0152\u0153\7_\2\2\u0153\66\3\2\2\2\u0154\u0155"+
		"\7p\2\2\u0155\u0156\7w\2\2\u0156\u0157\7o\2\2\u0157\u0158\7d\2\2\u0158"+
		"\u0159\7g\2\2\u0159\u015a\7t\2\2\u015a\u015b\7\"\2\2\u015b8\3\2\2\2\u015c"+
		"\u015d\7u\2\2\u015d\u015e\7v\2\2\u015e\u015f\7t\2\2\u015f\u0160\7k\2\2"+
		"\u0160\u0161\7p\2\2\u0161\u0162\7i\2\2\u0162\u0163\7\"\2\2\u0163:\3\2"+
		"\2\2\u0164\u0165\7d\2\2\u0165\u0166\7q\2\2\u0166\u0167\7q\2\2\u0167\u0168"+
		"\7n\2\2\u0168\u0169\7\"\2\2\u0169<\3\2\2\2\u016a\u016b\7X\2\2\u016b\u016c"+
		"\7g\2\2\u016c\u016d\7j\2\2\u016d\u016e\7k\2\2\u016e\u016f\7e\2\2\u016f"+
		"\u0170\7n\2\2\u0170\u0171\7g\2\2\u0171>\3\2\2\2\u0172\u0173\7P\2\2\u0173"+
		"\u0174\7q\2\2\u0174\u0175\7f\2\2\u0175\u0176\7g\2\2\u0176@\3\2\2\2\u0177"+
		"\u0178\7\60\2\2\u0178B\3\2\2\2\u0179\u017a\7v\2\2\u017a\u017b\7j\2\2\u017b"+
		"\u017c\7k\2\2\u017c\u017d\7u\2\2\u017dD\3\2\2\2\u017e\u017f\7$\2\2\u017f"+
		"F\3\2\2\2\u0180\u0181\7v\2\2\u0181\u0182\7t\2\2\u0182\u0183\7w\2\2\u0183"+
		"\u0184\7g\2\2\u0184H\3\2\2\2\u0185\u0186\7h\2\2\u0186\u0187\7c\2\2\u0187"+
		"\u0188\7n\2\2\u0188\u0189\7u\2\2\u0189\u018a\7g\2\2\u018aJ\3\2\2\2\u018b"+
		"\u018c\7`\2\2\u018cL\3\2\2\2\u018d\u018e\7,\2\2\u018eN\3\2\2\2\u018f\u0190"+
		"\7\61\2\2\u0190P\3\2\2\2\u0191\u0192\7\'\2\2\u0192R\3\2\2\2\u0193\u0194"+
		"\7-\2\2\u0194T\3\2\2\2\u0195\u0196\7/\2\2\u0196V\3\2\2\2\u0197\u0198\7"+
		">\2\2\u0198\u0199\7?\2\2\u0199X\3\2\2\2\u019a\u019b\7@\2\2\u019b\u019c"+
		"\7?\2\2\u019cZ\3\2\2\2\u019d\u019e\7>\2\2\u019e\\\3\2\2\2\u019f\u01a0"+
		"\7@\2\2\u01a0^\3\2\2\2\u01a1\u01a2\7?\2\2\u01a2\u01a3\7?\2\2\u01a3`\3"+
		"\2\2\2\u01a4\u01a5\7#\2\2\u01a5\u01a6\7?\2\2\u01a6b\3\2\2\2\u01a7\u01a8"+
		"\7\"\2\2\u01a8\u01a9\7c\2\2\u01a9\u01aa\7p\2\2\u01aa\u01ab\7f\2\2\u01ab"+
		"\u01ac\7\"\2\2\u01acd\3\2\2\2\u01ad\u01ae\7(\2\2\u01ae\u01af\7(\2\2\u01af"+
		"f\3\2\2\2\u01b0\u01b1\7\"\2\2\u01b1\u01b2\7q\2\2\u01b2\u01b3\7t\2\2\u01b3"+
		"\u01b4\7\"\2\2\u01b4h\3\2\2\2\u01b5\u01b6\7~\2\2\u01b6\u01b7\7~\2\2\u01b7"+
		"j\3\2\2\2\u01b8\u01b9\4\62;\2\u01b9l\3\2\2\2\u01ba\u01bc\t\2\2\2\u01bb"+
		"\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2"+
		"\2\2\u01ben\3\2\2\2\u01bf\u01c0\7.\2\2\u01c0p\3\2\2\2\u01c1\u01c2\7?\2"+
		"\2\u01c2r\3\2\2\2\u01c3\u01c4\7=\2\2\u01c4t\3\2\2\2\u01c5\u01c6\7\61\2"+
		"\2\u01c6\u01c7\7\61\2\2\u01c7\u01cb\3\2\2\2\u01c8\u01ca\n\3\2\2\u01c9"+
		"\u01c8\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2"+
		"\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01cf\b;\2\2\u01cf"+
		"v\3\2\2\2\u01d0\u01d1\7\61\2\2\u01d1\u01d2\7,\2\2\u01d2\u01d6\3\2\2\2"+
		"\u01d3\u01d5\13\2\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d7"+
		"\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9"+
		"\u01da\7,\2\2\u01da\u01db\7\61\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\b<"+
		"\2\2\u01ddx\3\2\2\2\u01de\u01e0\t\4\2\2\u01df\u01de\3\2\2\2\u01e0\u01e1"+
		"\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3"+
		"\u01e4\b=\2\2\u01e4z\3\2\2\2\b\2\u01bb\u01bd\u01cb\u01d6\u01e1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}