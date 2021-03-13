// Generated from /Users/robertswanson/dev/dsl/src/PSLGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PSLGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, PRIORITY=4, REQUIRE=5, PREFER=6, IF=7, THEN=8, 
		OTHERWISE=9, WHEN=10, AND=11, OR=12, TAKING=13, BEFORE=14, CREDITS=15, 
		HOURS=16, UPPER=17, DIVISION=18, OF=19, LATER=20, EARLIER=21, LESS=22, 
		MORE_=23, CLASSES=24, COURSES=25, NOT=26, STRING=27, PERIOD=28, OPENPAREND=29, 
		CLOSEPAREND=30, NUM=31, NAME=32, WS=33;
	public static final int
		RULE_start = 0, RULE_block = 1, RULE_body = 2, RULE_statement = 3, RULE_priority = 4, 
		RULE_require = 5, RULE_prefer = 6, RULE_if_ = 7, RULE_otherwiseIf = 8, 
		RULE_otherwise = 9, RULE_when = 10, RULE_condition = 11, RULE_constraint = 12, 
		RULE_courseNameList = 13, RULE_courseName = 14, RULE_credit_hours = 15, 
		RULE_course_classes = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "block", "body", "statement", "priority", "require", "prefer", 
			"if_", "otherwiseIf", "otherwise", "when", "condition", "constraint", 
			"courseNameList", "courseName", "credit_hours", "course_classes"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "','", "'priority'", "'require'", "'prefer'", "'if'", 
			"'then'", "'otherwise'", "'when'", "'and'", "'or'", "'taking'", "'before'", 
			"'credits'", "'hours'", "'upper'", "'division'", "'of'", "'later'", "'earlier'", 
			"'less'", "'more'", "'classes'", "'courses'", "'not'", null, "'.'", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "PRIORITY", "REQUIRE", "PREFER", "IF", "THEN", 
			"OTHERWISE", "WHEN", "AND", "OR", "TAKING", "BEFORE", "CREDITS", "HOURS", 
			"UPPER", "DIVISION", "OF", "LATER", "EARLIER", "LESS", "MORE_", "CLASSES", 
			"COURSES", "NOT", "STRING", "PERIOD", "OPENPAREND", "CLOSEPAREND", "NUM", 
			"NAME", "WS"
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
	public String getGrammarFileName() { return "PSLGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PSLGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PSLGrammarParser.EOF, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				block();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
			setState(39);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(PSLGrammarParser.NAME, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(NAME);
			setState(42);
			body();
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

	public static class BodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__0);
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				statement();
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIORITY) | (1L << REQUIRE) | (1L << PREFER) | (1L << IF) | (1L << WHEN))) != 0) );
			setState(50);
			match(T__1);
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
		public RequireContext require() {
			return getRuleContext(RequireContext.class,0);
		}
		public PriorityContext priority() {
			return getRuleContext(PriorityContext.class,0);
		}
		public PreferContext prefer() {
			return getRuleContext(PreferContext.class,0);
		}
		public If_Context if_() {
			return getRuleContext(If_Context.class,0);
		}
		public WhenContext when() {
			return getRuleContext(WhenContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REQUIRE:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				require();
				}
				break;
			case PRIORITY:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				priority();
				}
				break;
			case PREFER:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				prefer();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				if_();
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 5);
				{
				setState(56);
				when();
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

	public static class PriorityContext extends ParserRuleContext {
		public TerminalNode PRIORITY() { return getToken(PSLGrammarParser.PRIORITY, 0); }
		public TerminalNode NAME() { return getToken(PSLGrammarParser.NAME, 0); }
		public TerminalNode NUM() { return getToken(PSLGrammarParser.NUM, 0); }
		public TerminalNode PERIOD() { return getToken(PSLGrammarParser.PERIOD, 0); }
		public PriorityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_priority; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterPriority(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitPriority(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitPriority(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PriorityContext priority() throws RecognitionException {
		PriorityContext _localctx = new PriorityContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_priority);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(PRIORITY);
			setState(60);
			match(NAME);
			setState(61);
			match(NUM);
			setState(62);
			match(PERIOD);
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

	public static class RequireContext extends ParserRuleContext {
		public TerminalNode REQUIRE() { return getToken(PSLGrammarParser.REQUIRE, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(PSLGrammarParser.PERIOD, 0); }
		public RequireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_require; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterRequire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitRequire(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitRequire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequireContext require() throws RecognitionException {
		RequireContext _localctx = new RequireContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_require);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(REQUIRE);
			setState(65);
			constraint();
			setState(66);
			match(PERIOD);
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

	public static class PreferContext extends ParserRuleContext {
		public TerminalNode PREFER() { return getToken(PSLGrammarParser.PREFER, 0); }
		public TerminalNode NAME() { return getToken(PSLGrammarParser.NAME, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(PSLGrammarParser.PERIOD, 0); }
		public PreferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterPrefer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitPrefer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitPrefer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreferContext prefer() throws RecognitionException {
		PreferContext _localctx = new PreferContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_prefer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(PREFER);
			setState(69);
			match(NAME);
			setState(70);
			constraint();
			setState(71);
			match(PERIOD);
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

	public static class If_Context extends ParserRuleContext {
		public TerminalNode IF() { return getToken(PSLGrammarParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(PSLGrammarParser.THEN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<OtherwiseIfContext> otherwiseIf() {
			return getRuleContexts(OtherwiseIfContext.class);
		}
		public OtherwiseIfContext otherwiseIf(int i) {
			return getRuleContext(OtherwiseIfContext.class,i);
		}
		public OtherwiseContext otherwise() {
			return getRuleContext(OtherwiseContext.class,0);
		}
		public If_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterIf_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitIf_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitIf_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_Context if_() throws RecognitionException {
		If_Context _localctx = new If_Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_if_);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(IF);
			setState(74);
			condition();
			setState(75);
			match(THEN);
			setState(76);
			body();
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(77);
					otherwiseIf();
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTHERWISE) {
				{
				setState(83);
				otherwise();
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

	public static class OtherwiseIfContext extends ParserRuleContext {
		public TerminalNode OTHERWISE() { return getToken(PSLGrammarParser.OTHERWISE, 0); }
		public TerminalNode IF() { return getToken(PSLGrammarParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(PSLGrammarParser.THEN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public OtherwiseIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherwiseIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterOtherwiseIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitOtherwiseIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitOtherwiseIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherwiseIfContext otherwiseIf() throws RecognitionException {
		OtherwiseIfContext _localctx = new OtherwiseIfContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_otherwiseIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(OTHERWISE);
			setState(87);
			match(IF);
			setState(88);
			condition();
			setState(89);
			match(THEN);
			setState(90);
			body();
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

	public static class OtherwiseContext extends ParserRuleContext {
		public TerminalNode OTHERWISE() { return getToken(PSLGrammarParser.OTHERWISE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public OtherwiseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherwise; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterOtherwise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitOtherwise(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitOtherwise(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherwiseContext otherwise() throws RecognitionException {
		OtherwiseContext _localctx = new OtherwiseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_otherwise);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(OTHERWISE);
			setState(93);
			body();
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

	public static class WhenContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(PSLGrammarParser.WHEN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public WhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_when; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitWhen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitWhen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenContext when() throws RecognitionException {
		WhenContext _localctx = new WhenContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_when);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(WHEN);
			setState(96);
			condition();
			setState(97);
			body();
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode TAKING() { return getToken(PSLGrammarParser.TAKING, 0); }
		public TerminalNode STRING() { return getToken(PSLGrammarParser.STRING, 0); }
		public TerminalNode NOT() { return getToken(PSLGrammarParser.NOT, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode OPENPAREND() { return getToken(PSLGrammarParser.OPENPAREND, 0); }
		public TerminalNode AND() { return getToken(PSLGrammarParser.AND, 0); }
		public TerminalNode CLOSEPAREND() { return getToken(PSLGrammarParser.CLOSEPAREND, 0); }
		public TerminalNode OR() { return getToken(PSLGrammarParser.OR, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condition);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(TAKING);
				setState(100);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(NOT);
				setState(102);
				condition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				match(OPENPAREND);
				setState(104);
				condition();
				setState(105);
				match(AND);
				setState(106);
				condition();
				setState(107);
				match(CLOSEPAREND);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(OPENPAREND);
				setState(110);
				condition();
				setState(111);
				match(OR);
				setState(112);
				condition();
				setState(113);
				match(CLOSEPAREND);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				match(OPENPAREND);
				setState(116);
				condition();
				setState(117);
				match(CLOSEPAREND);
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

	public static class ConstraintContext extends ParserRuleContext {
		public CourseNameListContext courseNameList() {
			return getRuleContext(CourseNameListContext.class,0);
		}
		public TerminalNode TAKING() { return getToken(PSLGrammarParser.TAKING, 0); }
		public TerminalNode NUM() { return getToken(PSLGrammarParser.NUM, 0); }
		public Credit_hoursContext credit_hours() {
			return getRuleContext(Credit_hoursContext.class,0);
		}
		public TerminalNode OF() { return getToken(PSLGrammarParser.OF, 0); }
		public TerminalNode UPPER() { return getToken(PSLGrammarParser.UPPER, 0); }
		public TerminalNode DIVISION() { return getToken(PSLGrammarParser.DIVISION, 0); }
		public TerminalNode BEFORE() { return getToken(PSLGrammarParser.BEFORE, 0); }
		public CourseNameContext courseName() {
			return getRuleContext(CourseNameContext.class,0);
		}
		public TerminalNode LATER() { return getToken(PSLGrammarParser.LATER, 0); }
		public Course_classesContext course_classes() {
			return getRuleContext(Course_classesContext.class,0);
		}
		public TerminalNode EARLIER() { return getToken(PSLGrammarParser.EARLIER, 0); }
		public TerminalNode MORE_() { return getToken(PSLGrammarParser.MORE_, 0); }
		public TerminalNode LESS() { return getToken(PSLGrammarParser.LESS, 0); }
		public TerminalNode NOT() { return getToken(PSLGrammarParser.NOT, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constraint);
		int _la;
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TAKING) {
					{
					setState(121);
					match(TAKING);
					}
				}

				setState(124);
				courseNameList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(NUM);
				setState(126);
				credit_hours();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(NUM);
				setState(128);
				match(OF);
				setState(129);
				courseNameList();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(NUM);
				setState(131);
				match(UPPER);
				setState(132);
				match(DIVISION);
				setState(133);
				credit_hours();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(134);
				match(TAKING);
				setState(135);
				courseNameList();
				setState(136);
				match(BEFORE);
				setState(137);
				courseName();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(139);
				match(LATER);
				setState(140);
				course_classes();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(141);
				match(EARLIER);
				setState(142);
				course_classes();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(143);
				match(MORE_);
				setState(144);
				course_classes();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(145);
				match(LESS);
				setState(146);
				course_classes();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(147);
				match(MORE_);
				setState(148);
				credit_hours();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(149);
				match(LESS);
				setState(150);
				credit_hours();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(151);
				match(NOT);
				setState(152);
				constraint();
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

	public static class CourseNameListContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(PSLGrammarParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(PSLGrammarParser.STRING, i);
		}
		public CourseNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_courseNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterCourseNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitCourseNameList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitCourseNameList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CourseNameListContext courseNameList() throws RecognitionException {
		CourseNameListContext _localctx = new CourseNameListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_courseNameList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(155);
					match(STRING);
					setState(156);
					match(T__2);
					}
					} 
				}
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(162);
			match(STRING);
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

	public static class CourseNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PSLGrammarParser.STRING, 0); }
		public CourseNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_courseName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterCourseName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitCourseName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitCourseName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CourseNameContext courseName() throws RecognitionException {
		CourseNameContext _localctx = new CourseNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_courseName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(STRING);
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

	public static class Credit_hoursContext extends ParserRuleContext {
		public TerminalNode CREDITS() { return getToken(PSLGrammarParser.CREDITS, 0); }
		public TerminalNode HOURS() { return getToken(PSLGrammarParser.HOURS, 0); }
		public Credit_hoursContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_credit_hours; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterCredit_hours(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitCredit_hours(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitCredit_hours(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Credit_hoursContext credit_hours() throws RecognitionException {
		Credit_hoursContext _localctx = new Credit_hoursContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_credit_hours);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if ( !(_la==CREDITS || _la==HOURS) ) {
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

	public static class Course_classesContext extends ParserRuleContext {
		public TerminalNode COURSES() { return getToken(PSLGrammarParser.COURSES, 0); }
		public TerminalNode CLASSES() { return getToken(PSLGrammarParser.CLASSES, 0); }
		public Course_classesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_course_classes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).enterCourse_classes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLGrammarListener ) ((PSLGrammarListener)listener).exitCourse_classes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLGrammarVisitor ) return ((PSLGrammarVisitor<? extends T>)visitor).visitCourse_classes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Course_classesContext course_classes() throws RecognitionException {
		Course_classesContext _localctx = new Course_classesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_course_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if ( !(_la==CLASSES || _la==COURSES) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00ad\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\2\3\2\3\3\3\3\3\3\3\4\3\4\6\4\61\n\4\r\4\16"+
		"\4\62\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5<\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\tQ\n\t\f\t\16\tT\13"+
		"\t\3\t\5\tW\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\rz\n\r\3\16\5\16}\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009c\n\16\3\17\3\17\7\17"+
		"\u00a0\n\17\f\17\16\17\u00a3\13\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\4\3\2\21"+
		"\22\3\2\32\33\2\u00b4\2%\3\2\2\2\4+\3\2\2\2\6.\3\2\2\2\b;\3\2\2\2\n=\3"+
		"\2\2\2\fB\3\2\2\2\16F\3\2\2\2\20K\3\2\2\2\22X\3\2\2\2\24^\3\2\2\2\26a"+
		"\3\2\2\2\30y\3\2\2\2\32\u009b\3\2\2\2\34\u00a1\3\2\2\2\36\u00a6\3\2\2"+
		"\2 \u00a8\3\2\2\2\"\u00aa\3\2\2\2$&\5\4\3\2%$\3\2\2\2&\'\3\2\2\2\'%\3"+
		"\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\2\2\3*\3\3\2\2\2+,\7\"\2\2,-\5\6\4\2-"+
		"\5\3\2\2\2.\60\7\3\2\2/\61\5\b\5\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2"+
		"\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\4\2\2\65\7\3\2\2\2\66<\5\f\7"+
		"\2\67<\5\n\6\28<\5\16\b\29<\5\20\t\2:<\5\26\f\2;\66\3\2\2\2;\67\3\2\2"+
		"\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<\t\3\2\2\2=>\7\6\2\2>?\7\"\2\2?@\7!\2"+
		"\2@A\7\36\2\2A\13\3\2\2\2BC\7\7\2\2CD\5\32\16\2DE\7\36\2\2E\r\3\2\2\2"+
		"FG\7\b\2\2GH\7\"\2\2HI\5\32\16\2IJ\7\36\2\2J\17\3\2\2\2KL\7\t\2\2LM\5"+
		"\30\r\2MN\7\n\2\2NR\5\6\4\2OQ\5\22\n\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2R"+
		"S\3\2\2\2SV\3\2\2\2TR\3\2\2\2UW\5\24\13\2VU\3\2\2\2VW\3\2\2\2W\21\3\2"+
		"\2\2XY\7\13\2\2YZ\7\t\2\2Z[\5\30\r\2[\\\7\n\2\2\\]\5\6\4\2]\23\3\2\2\2"+
		"^_\7\13\2\2_`\5\6\4\2`\25\3\2\2\2ab\7\f\2\2bc\5\30\r\2cd\5\6\4\2d\27\3"+
		"\2\2\2ef\7\17\2\2fz\7\35\2\2gh\7\34\2\2hz\5\30\r\2ij\7\37\2\2jk\5\30\r"+
		"\2kl\7\r\2\2lm\5\30\r\2mn\7 \2\2nz\3\2\2\2op\7\37\2\2pq\5\30\r\2qr\7\16"+
		"\2\2rs\5\30\r\2st\7 \2\2tz\3\2\2\2uv\7\37\2\2vw\5\30\r\2wx\7 \2\2xz\3"+
		"\2\2\2ye\3\2\2\2yg\3\2\2\2yi\3\2\2\2yo\3\2\2\2yu\3\2\2\2z\31\3\2\2\2{"+
		"}\7\17\2\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\u009c\5\34\17\2\177\u0080\7"+
		"!\2\2\u0080\u009c\5 \21\2\u0081\u0082\7!\2\2\u0082\u0083\7\25\2\2\u0083"+
		"\u009c\5\34\17\2\u0084\u0085\7!\2\2\u0085\u0086\7\23\2\2\u0086\u0087\7"+
		"\24\2\2\u0087\u009c\5 \21\2\u0088\u0089\7\17\2\2\u0089\u008a\5\34\17\2"+
		"\u008a\u008b\7\20\2\2\u008b\u008c\5\36\20\2\u008c\u009c\3\2\2\2\u008d"+
		"\u008e\7\26\2\2\u008e\u009c\5\"\22\2\u008f\u0090\7\27\2\2\u0090\u009c"+
		"\5\"\22\2\u0091\u0092\7\31\2\2\u0092\u009c\5\"\22\2\u0093\u0094\7\30\2"+
		"\2\u0094\u009c\5\"\22\2\u0095\u0096\7\31\2\2\u0096\u009c\5 \21\2\u0097"+
		"\u0098\7\30\2\2\u0098\u009c\5 \21\2\u0099\u009a\7\34\2\2\u009a\u009c\5"+
		"\32\16\2\u009b|\3\2\2\2\u009b\177\3\2\2\2\u009b\u0081\3\2\2\2\u009b\u0084"+
		"\3\2\2\2\u009b\u0088\3\2\2\2\u009b\u008d\3\2\2\2\u009b\u008f\3\2\2\2\u009b"+
		"\u0091\3\2\2\2\u009b\u0093\3\2\2\2\u009b\u0095\3\2\2\2\u009b\u0097\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009c\33\3\2\2\2\u009d\u009e\7\35\2\2\u009e\u00a0"+
		"\7\5\2\2\u009f\u009d\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7\35"+
		"\2\2\u00a5\35\3\2\2\2\u00a6\u00a7\7\35\2\2\u00a7\37\3\2\2\2\u00a8\u00a9"+
		"\t\2\2\2\u00a9!\3\2\2\2\u00aa\u00ab\t\3\2\2\u00ab#\3\2\2\2\13\'\62;RV"+
		"y|\u009b\u00a1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}