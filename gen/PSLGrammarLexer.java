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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, PRIORITY=6, REQUIRE=7, PREFER=8, 
		IF=9, THEN=10, ELIF=11, ELSE=12, WHEN=13, AND=14, OR=15, TAKING=16, BEFORE=17, 
		CREDITS=18, HOURS=19, UPPER=20, DIVISION=21, OF=22, LATER=23, EARLIER=24, 
		LESS=25, MORE_=26, CLASSES=27, COURSES=28, NOT=29, PERIOD=30, NUM=31, 
		NAME=32, WS=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "PRIORITY", "REQUIRE", "PREFER", 
			"IF", "THEN", "ELIF", "ELSE", "WHEN", "AND", "OR", "TAKING", "BEFORE", 
			"CREDITS", "HOURS", "UPPER", "DIVISION", "OF", "LATER", "EARLIER", "LESS", 
			"MORE_", "CLASSES", "COURSES", "NOT", "PERIOD", "NUM", "NAME", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "','", "'priority'", "'require'", "'prefer'", 
			"'if'", "'then'", "'elif'", "'else'", "'when'", "'and'", "'or'", "'taking'", 
			"'before'", "'credits'", "'hours'", "'upper'", "'division'", "'of'", 
			"'later'", "'earlier'", "'less'", "'more'", "'classes'", "'courses'", 
			"'not'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "PRIORITY", "REQUIRE", "PREFER", 
			"IF", "THEN", "ELIF", "ELSE", "WHEN", "AND", "OR", "TAKING", "BEFORE", 
			"CREDITS", "HOURS", "UPPER", "DIVISION", "OF", "LATER", "EARLIER", "LESS", 
			"MORE_", "CLASSES", "COURSES", "NOT", "PERIOD", "NUM", "NAME", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00f4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3 \6 \u00e3\n \r \16 \u00e4"+
		"\3!\3!\7!\u00e9\n!\f!\16!\u00ec\13!\3\"\6\"\u00ef\n\"\r\"\16\"\u00f0\3"+
		"\"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#\3\2\6\3\2\62;\4\2C\\c|\7\2//\62;C\\aac|\4\2\13\f"+
		"\"\"\2\u00f6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2"+
		"\2\5G\3\2\2\2\7I\3\2\2\2\tK\3\2\2\2\13M\3\2\2\2\rO\3\2\2\2\17X\3\2\2\2"+
		"\21`\3\2\2\2\23g\3\2\2\2\25j\3\2\2\2\27o\3\2\2\2\31t\3\2\2\2\33y\3\2\2"+
		"\2\35~\3\2\2\2\37\u0082\3\2\2\2!\u0085\3\2\2\2#\u008c\3\2\2\2%\u0093\3"+
		"\2\2\2\'\u009b\3\2\2\2)\u00a1\3\2\2\2+\u00a7\3\2\2\2-\u00b0\3\2\2\2/\u00b3"+
		"\3\2\2\2\61\u00b9\3\2\2\2\63\u00c1\3\2\2\2\65\u00c6\3\2\2\2\67\u00cb\3"+
		"\2\2\29\u00d3\3\2\2\2;\u00db\3\2\2\2=\u00df\3\2\2\2?\u00e2\3\2\2\2A\u00e6"+
		"\3\2\2\2C\u00ee\3\2\2\2EF\7}\2\2F\4\3\2\2\2GH\7\177\2\2H\6\3\2\2\2IJ\7"+
		"*\2\2J\b\3\2\2\2KL\7+\2\2L\n\3\2\2\2MN\7.\2\2N\f\3\2\2\2OP\7r\2\2PQ\7"+
		"t\2\2QR\7k\2\2RS\7q\2\2ST\7t\2\2TU\7k\2\2UV\7v\2\2VW\7{\2\2W\16\3\2\2"+
		"\2XY\7t\2\2YZ\7g\2\2Z[\7s\2\2[\\\7w\2\2\\]\7k\2\2]^\7t\2\2^_\7g\2\2_\20"+
		"\3\2\2\2`a\7r\2\2ab\7t\2\2bc\7g\2\2cd\7h\2\2de\7g\2\2ef\7t\2\2f\22\3\2"+
		"\2\2gh\7k\2\2hi\7h\2\2i\24\3\2\2\2jk\7v\2\2kl\7j\2\2lm\7g\2\2mn\7p\2\2"+
		"n\26\3\2\2\2op\7g\2\2pq\7n\2\2qr\7k\2\2rs\7h\2\2s\30\3\2\2\2tu\7g\2\2"+
		"uv\7n\2\2vw\7u\2\2wx\7g\2\2x\32\3\2\2\2yz\7y\2\2z{\7j\2\2{|\7g\2\2|}\7"+
		"p\2\2}\34\3\2\2\2~\177\7c\2\2\177\u0080\7p\2\2\u0080\u0081\7f\2\2\u0081"+
		"\36\3\2\2\2\u0082\u0083\7q\2\2\u0083\u0084\7t\2\2\u0084 \3\2\2\2\u0085"+
		"\u0086\7v\2\2\u0086\u0087\7c\2\2\u0087\u0088\7m\2\2\u0088\u0089\7k\2\2"+
		"\u0089\u008a\7p\2\2\u008a\u008b\7i\2\2\u008b\"\3\2\2\2\u008c\u008d\7d"+
		"\2\2\u008d\u008e\7g\2\2\u008e\u008f\7h\2\2\u008f\u0090\7q\2\2\u0090\u0091"+
		"\7t\2\2\u0091\u0092\7g\2\2\u0092$\3\2\2\2\u0093\u0094\7e\2\2\u0094\u0095"+
		"\7t\2\2\u0095\u0096\7g\2\2\u0096\u0097\7f\2\2\u0097\u0098\7k\2\2\u0098"+
		"\u0099\7v\2\2\u0099\u009a\7u\2\2\u009a&\3\2\2\2\u009b\u009c\7j\2\2\u009c"+
		"\u009d\7q\2\2\u009d\u009e\7w\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7u\2\2"+
		"\u00a0(\3\2\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3\7r\2\2\u00a3\u00a4\7r\2"+
		"\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7t\2\2\u00a6*\3\2\2\2\u00a7\u00a8\7"+
		"f\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7x\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac"+
		"\7u\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7p\2\2\u00af"+
		",\3\2\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7h\2\2\u00b2.\3\2\2\2\u00b3\u00b4"+
		"\7n\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7g\2\2\u00b7"+
		"\u00b8\7t\2\2\u00b8\60\3\2\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb\7c\2\2\u00bb"+
		"\u00bc\7t\2\2\u00bc\u00bd\7n\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7g\2\2"+
		"\u00bf\u00c0\7t\2\2\u00c0\62\3\2\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7"+
		"g\2\2\u00c3\u00c4\7u\2\2\u00c4\u00c5\7u\2\2\u00c5\64\3\2\2\2\u00c6\u00c7"+
		"\7o\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7t\2\2\u00c9\u00ca\7g\2\2\u00ca"+
		"\66\3\2\2\2\u00cb\u00cc\7e\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7c\2\2\u00ce"+
		"\u00cf\7u\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7u\2\2"+
		"\u00d28\3\2\2\2\u00d3\u00d4\7e\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6\7w\2"+
		"\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7u\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da"+
		"\7u\2\2\u00da:\3\2\2\2\u00db\u00dc\7p\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de"+
		"\7v\2\2\u00de<\3\2\2\2\u00df\u00e0\7\60\2\2\u00e0>\3\2\2\2\u00e1\u00e3"+
		"\t\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5@\3\2\2\2\u00e6\u00ea\t\3\2\2\u00e7\u00e9\t\4\2\2"+
		"\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00ebB\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ef\t\5\2\2\u00ee"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\b\"\2\2\u00f3D\3\2\2\2\7\2\u00e4"+
		"\u00e8\u00ea\u00f0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}