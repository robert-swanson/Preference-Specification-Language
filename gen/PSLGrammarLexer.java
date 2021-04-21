// Generated from /Users/elizabethyeiter/Desktop/COS 382/dsl/src/PSLGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PSLGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, PRIORITY=4, REQUIRE=5, PREFER=6, IF=7, THEN=8, 
		OTHERWISE=9, WHEN=10, AND=11, OR=12, TAKING=13, BEFORE=14, CREDITS=15, 
		HOURS=16, IN=17, UPPER=18, DIVISION=19, OF=20, LATER=21, EARLIER=22, LESS=23, 
		MORE_=24, SEMESTER=25, PLAN=26, CLASSES=27, COURSES=28, NOT=29, STRING=30, 
		PERIOD=31, OPENPAREND=32, CLOSEPAREND=33, NUM=34, NAME=35, WS=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "PRIORITY", "REQUIRE", "PREFER", "IF", "THEN", 
			"OTHERWISE", "WHEN", "AND", "OR", "TAKING", "BEFORE", "CREDITS", "HOURS", 
			"IN", "UPPER", "DIVISION", "OF", "LATER", "EARLIER", "LESS", "MORE_", 
			"SEMESTER", "PLAN", "CLASSES", "COURSES", "NOT", "STRING", "PERIOD", 
			"OPENPAREND", "CLOSEPAREND", "NUM", "NAME", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "','", "'priority'", "'require'", "'prefer'", "'if'", 
			"'then'", "'otherwise'", "'when'", "'and'", "'or'", "'taking'", "'before'", 
			"'credits'", "'hours'", "'in'", "'upper'", "'division'", "'of'", "'later'", 
			"'earlier'", "'less'", "'more'", "'semester'", "'plan'", "'classes'", 
			"'courses'", "'not'", null, "'.'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "PRIORITY", "REQUIRE", "PREFER", "IF", "THEN", 
			"OTHERWISE", "WHEN", "AND", "OR", "TAKING", "BEFORE", "CREDITS", "HOURS", 
			"IN", "UPPER", "DIVISION", "OF", "LATER", "EARLIER", "LESS", "MORE_", 
			"SEMESTER", "PLAN", "CLASSES", "COURSES", "NOT", "STRING", "PERIOD", 
			"OPENPAREND", "CLOSEPAREND", "NUM", "NAME", "WS"
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


	public PSLGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PSLGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u0114\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\7\37\u00f5\n\37\f\37"+
		"\16\37\u00f8\13\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\6#\u0103\n#\r#\16"+
		"#\u0104\3$\3$\7$\u0109\n$\f$\16$\u010c\13$\3%\6%\u010f\n%\r%\16%\u0110"+
		"\3%\3%\3\u00f6\2&\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&\3\2\6\3\2\62;\4\2C\\c|\7\2//\62;C\\a"+
		"ac|\4\2\13\f\"\"\2\u0117\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3K\3\2\2\2\5M\3\2\2\2\7O\3\2\2\2\t"+
		"Q\3\2\2\2\13Z\3\2\2\2\rb\3\2\2\2\17i\3\2\2\2\21l\3\2\2\2\23q\3\2\2\2\25"+
		"{\3\2\2\2\27\u0080\3\2\2\2\31\u0084\3\2\2\2\33\u0087\3\2\2\2\35\u008e"+
		"\3\2\2\2\37\u0095\3\2\2\2!\u009d\3\2\2\2#\u00a3\3\2\2\2%\u00a6\3\2\2\2"+
		"\'\u00ac\3\2\2\2)\u00b5\3\2\2\2+\u00b8\3\2\2\2-\u00be\3\2\2\2/\u00c6\3"+
		"\2\2\2\61\u00cb\3\2\2\2\63\u00d0\3\2\2\2\65\u00d9\3\2\2\2\67\u00de\3\2"+
		"\2\29\u00e6\3\2\2\2;\u00ee\3\2\2\2=\u00f2\3\2\2\2?\u00fb\3\2\2\2A\u00fd"+
		"\3\2\2\2C\u00ff\3\2\2\2E\u0102\3\2\2\2G\u0106\3\2\2\2I\u010e\3\2\2\2K"+
		"L\7}\2\2L\4\3\2\2\2MN\7\177\2\2N\6\3\2\2\2OP\7.\2\2P\b\3\2\2\2QR\7r\2"+
		"\2RS\7t\2\2ST\7k\2\2TU\7q\2\2UV\7t\2\2VW\7k\2\2WX\7v\2\2XY\7{\2\2Y\n\3"+
		"\2\2\2Z[\7t\2\2[\\\7g\2\2\\]\7s\2\2]^\7w\2\2^_\7k\2\2_`\7t\2\2`a\7g\2"+
		"\2a\f\3\2\2\2bc\7r\2\2cd\7t\2\2de\7g\2\2ef\7h\2\2fg\7g\2\2gh\7t\2\2h\16"+
		"\3\2\2\2ij\7k\2\2jk\7h\2\2k\20\3\2\2\2lm\7v\2\2mn\7j\2\2no\7g\2\2op\7"+
		"p\2\2p\22\3\2\2\2qr\7q\2\2rs\7v\2\2st\7j\2\2tu\7g\2\2uv\7t\2\2vw\7y\2"+
		"\2wx\7k\2\2xy\7u\2\2yz\7g\2\2z\24\3\2\2\2{|\7y\2\2|}\7j\2\2}~\7g\2\2~"+
		"\177\7p\2\2\177\26\3\2\2\2\u0080\u0081\7c\2\2\u0081\u0082\7p\2\2\u0082"+
		"\u0083\7f\2\2\u0083\30\3\2\2\2\u0084\u0085\7q\2\2\u0085\u0086\7t\2\2\u0086"+
		"\32\3\2\2\2\u0087\u0088\7v\2\2\u0088\u0089\7c\2\2\u0089\u008a\7m\2\2\u008a"+
		"\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c\u008d\7i\2\2\u008d\34\3\2\2\2\u008e"+
		"\u008f\7d\2\2\u008f\u0090\7g\2\2\u0090\u0091\7h\2\2\u0091\u0092\7q\2\2"+
		"\u0092\u0093\7t\2\2\u0093\u0094\7g\2\2\u0094\36\3\2\2\2\u0095\u0096\7"+
		"e\2\2\u0096\u0097\7t\2\2\u0097\u0098\7g\2\2\u0098\u0099\7f\2\2\u0099\u009a"+
		"\7k\2\2\u009a\u009b\7v\2\2\u009b\u009c\7u\2\2\u009c \3\2\2\2\u009d\u009e"+
		"\7j\2\2\u009e\u009f\7q\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7t\2\2\u00a1"+
		"\u00a2\7u\2\2\u00a2\"\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7p\2\2\u00a5"+
		"$\3\2\2\2\u00a6\u00a7\7w\2\2\u00a7\u00a8\7r\2\2\u00a8\u00a9\7r\2\2\u00a9"+
		"\u00aa\7g\2\2\u00aa\u00ab\7t\2\2\u00ab&\3\2\2\2\u00ac\u00ad\7f\2\2\u00ad"+
		"\u00ae\7k\2\2\u00ae\u00af\7x\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7u\2\2"+
		"\u00b1\u00b2\7k\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7p\2\2\u00b4(\3\2\2"+
		"\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7h\2\2\u00b7*\3\2\2\2\u00b8\u00b9\7"+
		"n\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd"+
		"\7t\2\2\u00bd,\3\2\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1"+
		"\7t\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\u00c5\7t\2\2\u00c5.\3\2\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7g\2\2\u00c8"+
		"\u00c9\7u\2\2\u00c9\u00ca\7u\2\2\u00ca\60\3\2\2\2\u00cb\u00cc\7o\2\2\u00cc"+
		"\u00cd\7q\2\2\u00cd\u00ce\7t\2\2\u00ce\u00cf\7g\2\2\u00cf\62\3\2\2\2\u00d0"+
		"\u00d1\7u\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7o\2\2\u00d3\u00d4\7g\2\2"+
		"\u00d4\u00d5\7u\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8"+
		"\7t\2\2\u00d8\64\3\2\2\2\u00d9\u00da\7r\2\2\u00da\u00db\7n\2\2\u00db\u00dc"+
		"\7c\2\2\u00dc\u00dd\7p\2\2\u00dd\66\3\2\2\2\u00de\u00df\7e\2\2\u00df\u00e0"+
		"\7n\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7u\2\2\u00e3"+
		"\u00e4\7g\2\2\u00e4\u00e5\7u\2\2\u00e58\3\2\2\2\u00e6\u00e7\7e\2\2\u00e7"+
		"\u00e8\7q\2\2\u00e8\u00e9\7w\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7u\2\2"+
		"\u00eb\u00ec\7g\2\2\u00ec\u00ed\7u\2\2\u00ed:\3\2\2\2\u00ee\u00ef\7p\2"+
		"\2\u00ef\u00f0\7q\2\2\u00f0\u00f1\7v\2\2\u00f1<\3\2\2\2\u00f2\u00f6\7"+
		"$\2\2\u00f3\u00f5\13\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f6\3\2"+
		"\2\2\u00f9\u00fa\7$\2\2\u00fa>\3\2\2\2\u00fb\u00fc\7\60\2\2\u00fc@\3\2"+
		"\2\2\u00fd\u00fe\7*\2\2\u00feB\3\2\2\2\u00ff\u0100\7+\2\2\u0100D\3\2\2"+
		"\2\u0101\u0103\t\2\2\2\u0102\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0102"+
		"\3\2\2\2\u0104\u0105\3\2\2\2\u0105F\3\2\2\2\u0106\u010a\t\3\2\2\u0107"+
		"\u0109\t\4\2\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010bH\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010f"+
		"\t\5\2\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u010e\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\b%\2\2\u0113J\3\2\2\2\b"+
		"\2\u00f6\u0104\u0108\u010a\u0110\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}