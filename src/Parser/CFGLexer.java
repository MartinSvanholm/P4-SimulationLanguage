// Generated from C:/Users/krist/Documents/GitHub/P4-SimulationLanguage\CFG.g4 by ANTLR 4.9.2
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2>\u01e8\b\1\4\2\t"+
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
		"\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 "+
		"\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3"+
		"%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3."+
		"\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\67\6\67"+
		"\u01bf\n\67\r\67\16\67\u01c0\38\38\39\39\3:\3:\3;\3;\3;\3;\7;\u01cd\n"+
		";\f;\16;\u01d0\13;\3;\3;\3<\3<\3<\3<\7<\u01d8\n<\f<\16<\u01db\13<\3<\3"+
		"<\3<\3<\3<\3=\6=\u01e3\n=\r=\16=\u01e4\3=\3=\3\u01d9\2>\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>\3"+
		"\2\5\5\2C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u01eb\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2"+
		"q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\3{\3\2\2\2\5\u0092"+
		"\3\2\2\2\7\u0094\3\2\2\2\t\u0096\3\2\2\2\13\u00aa\3\2\2\2\r\u00bc\3\2"+
		"\2\2\17\u00ce\3\2\2\2\21\u00db\3\2\2\2\23\u00ea\3\2\2\2\25\u00f3\3\2\2"+
		"\2\27\u00f5\3\2\2\2\31\u00f7\3\2\2\2\33\u00fd\3\2\2\2\35\u0109\3\2\2\2"+
		"\37\u0111\3\2\2\2!\u0118\3\2\2\2#\u011b\3\2\2\2%\u0123\3\2\2\2\'\u0128"+
		"\3\2\2\2)\u012f\3\2\2\2+\u0135\3\2\2\2-\u013d\3\2\2\2/\u0143\3\2\2\2\61"+
		"\u0147\3\2\2\2\63\u0150\3\2\2\2\65\u0152\3\2\2\2\67\u0154\3\2\2\29\u015c"+
		"\3\2\2\2;\u0164\3\2\2\2=\u016a\3\2\2\2?\u0173\3\2\2\2A\u0179\3\2\2\2C"+
		"\u017f\3\2\2\2E\u0181\3\2\2\2G\u0183\3\2\2\2I\u0188\3\2\2\2K\u018e\3\2"+
		"\2\2M\u0190\3\2\2\2O\u0192\3\2\2\2Q\u0194\3\2\2\2S\u0196\3\2\2\2U\u0198"+
		"\3\2\2\2W\u019a\3\2\2\2Y\u019d\3\2\2\2[\u01a0\3\2\2\2]\u01a2\3\2\2\2_"+
		"\u01a4\3\2\2\2a\u01a7\3\2\2\2c\u01aa\3\2\2\2e\u01b0\3\2\2\2g\u01b3\3\2"+
		"\2\2i\u01b8\3\2\2\2k\u01bb\3\2\2\2m\u01be\3\2\2\2o\u01c2\3\2\2\2q\u01c4"+
		"\3\2\2\2s\u01c6\3\2\2\2u\u01c8\3\2\2\2w\u01d3\3\2\2\2y\u01e2\3\2\2\2{"+
		"|\7U\2\2|}\7k\2\2}~\7o\2\2~\177\7w\2\2\177\u0080\7n\2\2\u0080\u0081\7"+
		"c\2\2\u0081\u0082\7v\2\2\u0082\u0083\7k\2\2\u0083\u0084\7q\2\2\u0084\u0085"+
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
		"\u0170\7n\2\2\u0170\u0171\7g\2\2\u0171\u0172\7\"\2\2\u0172>\3\2\2\2\u0173"+
		"\u0174\7P\2\2\u0174\u0175\7q\2\2\u0175\u0176\7f\2\2\u0176\u0177\7g\2\2"+
		"\u0177\u0178\7\"\2\2\u0178@\3\2\2\2\u0179\u017a\7T\2\2\u017a\u017b\7q"+
		"\2\2\u017b\u017c\7c\2\2\u017c\u017d\7f\2\2\u017d\u017e\7\"\2\2\u017eB"+
		"\3\2\2\2\u017f\u0180\7\60\2\2\u0180D\3\2\2\2\u0181\u0182\7$\2\2\u0182"+
		"F\3\2\2\2\u0183\u0184\7v\2\2\u0184\u0185\7t\2\2\u0185\u0186\7w\2\2\u0186"+
		"\u0187\7g\2\2\u0187H\3\2\2\2\u0188\u0189\7h\2\2\u0189\u018a\7c\2\2\u018a"+
		"\u018b\7n\2\2\u018b\u018c\7u\2\2\u018c\u018d\7g\2\2\u018dJ\3\2\2\2\u018e"+
		"\u018f\7`\2\2\u018fL\3\2\2\2\u0190\u0191\7,\2\2\u0191N\3\2\2\2\u0192\u0193"+
		"\7\61\2\2\u0193P\3\2\2\2\u0194\u0195\7\'\2\2\u0195R\3\2\2\2\u0196\u0197"+
		"\7-\2\2\u0197T\3\2\2\2\u0198\u0199\7/\2\2\u0199V\3\2\2\2\u019a\u019b\7"+
		">\2\2\u019b\u019c\7?\2\2\u019cX\3\2\2\2\u019d\u019e\7@\2\2\u019e\u019f"+
		"\7?\2\2\u019fZ\3\2\2\2\u01a0\u01a1\7>\2\2\u01a1\\\3\2\2\2\u01a2\u01a3"+
		"\7@\2\2\u01a3^\3\2\2\2\u01a4\u01a5\7?\2\2\u01a5\u01a6\7?\2\2\u01a6`\3"+
		"\2\2\2\u01a7\u01a8\7#\2\2\u01a8\u01a9\7?\2\2\u01a9b\3\2\2\2\u01aa\u01ab"+
		"\7\"\2\2\u01ab\u01ac\7c\2\2\u01ac\u01ad\7p\2\2\u01ad\u01ae\7f\2\2\u01ae"+
		"\u01af\7\"\2\2\u01afd\3\2\2\2\u01b0\u01b1\7(\2\2\u01b1\u01b2\7(\2\2\u01b2"+
		"f\3\2\2\2\u01b3\u01b4\7\"\2\2\u01b4\u01b5\7q\2\2\u01b5\u01b6\7t\2\2\u01b6"+
		"\u01b7\7\"\2\2\u01b7h\3\2\2\2\u01b8\u01b9\7~\2\2\u01b9\u01ba\7~\2\2\u01ba"+
		"j\3\2\2\2\u01bb\u01bc\4\62;\2\u01bcl\3\2\2\2\u01bd\u01bf\t\2\2\2\u01be"+
		"\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2"+
		"\2\2\u01c1n\3\2\2\2\u01c2\u01c3\7.\2\2\u01c3p\3\2\2\2\u01c4\u01c5\7?\2"+
		"\2\u01c5r\3\2\2\2\u01c6\u01c7\7=\2\2\u01c7t\3\2\2\2\u01c8\u01c9\7\61\2"+
		"\2\u01c9\u01ca\7\61\2\2\u01ca\u01ce\3\2\2\2\u01cb\u01cd\n\3\2\2\u01cc"+
		"\u01cb\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2"+
		"\2\2\u01cf\u01d1\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d2\b;\2\2\u01d2"+
		"v\3\2\2\2\u01d3\u01d4\7\61\2\2\u01d4\u01d5\7,\2\2\u01d5\u01d9\3\2\2\2"+
		"\u01d6\u01d8\13\2\2\2\u01d7\u01d6\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01da"+
		"\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da\u01dc\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc"+
		"\u01dd\7,\2\2\u01dd\u01de\7\61\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\b<"+
		"\2\2\u01e0x\3\2\2\2\u01e1\u01e3\t\4\2\2\u01e2\u01e1\3\2\2\2\u01e3\u01e4"+
		"\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e7\b=\2\2\u01e7z\3\2\2\2\b\2\u01be\u01c0\u01ce\u01d9\u01e4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}