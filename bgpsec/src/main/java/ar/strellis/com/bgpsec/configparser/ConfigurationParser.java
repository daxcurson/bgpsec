// Generated from ar\strellis\com\bgpsec\configparser\Configuration.g4 by ANTLR 4.7
package ar.strellis.com.bgpsec.configparser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConfigurationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, IPV4=13, STRING=14, ID_LETTER=15, INT=16, 
		DIGIT=17, OPENBRACE=18, CLOSEBRACE=19, WS=20;
	public static final int
		RULE_prog = 0, RULE_statement = 1, RULE_statement_interface = 2, RULE_interface_desc = 3, 
		RULE_option_interface = 4, RULE_option_interface_description = 5, RULE_option_interface_ip = 6, 
		RULE_option_interface_negotiation = 7, RULE_statement_router = 8, RULE_option_router = 9, 
		RULE_kind = 10, RULE_log = 11, RULE_neighbor = 12, RULE_neighbor_description = 13, 
		RULE_neighbor_description_string = 14, RULE_neighbor_ip = 15, RULE_remote_as = 16, 
		RULE_router = 17, RULE_auto = 18, RULE_full_duplex = 19, RULE_half_duplex = 20, 
		RULE_asnumber = 21, RULE_value = 22;
	public static final String[] ruleNames = {
		"prog", "statement", "statement_interface", "interface_desc", "option_interface", 
		"option_interface_description", "option_interface_ip", "option_interface_negotiation", 
		"statement_router", "option_router", "kind", "log", "neighbor", "neighbor_description", 
		"neighbor_description_string", "neighbor_ip", "remote_as", "router", "auto", 
		"full_duplex", "half_duplex", "asnumber", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'interface'", "'description'", "'ip'", "'negotiation'", "'kind'", 
		"'log-neighbor-changes'", "'neighbor'", "'remote_as'", "'router'", "'auto'", 
		"'full_duplex'", "'half_duplex'", null, null, null, null, null, "'{'", 
		"'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "IPV4", "STRING", "ID_LETTER", "INT", "DIGIT", "OPENBRACE", "CLOSEBRACE", 
		"WS"
	};
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
	public String getGrammarFileName() { return "Configuration.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ConfigurationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				statement();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==T__8 );
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
		public Statement_interfaceContext statement_interface() {
			return getRuleContext(Statement_interfaceContext.class,0);
		}
		public Statement_routerContext statement_router() {
			return getRuleContext(Statement_routerContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(51);
				statement_interface();
				}
				break;
			case T__8:
				{
				setState(52);
				statement_router();
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

	public static class Statement_interfaceContext extends ParserRuleContext {
		public Interface_descContext interface_desc() {
			return getRuleContext(Interface_descContext.class,0);
		}
		public TerminalNode OPENBRACE() { return getToken(ConfigurationParser.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(ConfigurationParser.CLOSEBRACE, 0); }
		public List<Option_interfaceContext> option_interface() {
			return getRuleContexts(Option_interfaceContext.class);
		}
		public Option_interfaceContext option_interface(int i) {
			return getRuleContext(Option_interfaceContext.class,i);
		}
		public Statement_interfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_interface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterStatement_interface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitStatement_interface(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitStatement_interface(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_interfaceContext statement_interface() throws RecognitionException {
		Statement_interfaceContext _localctx = new Statement_interfaceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement_interface);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			interface_desc();
			setState(56);
			match(OPENBRACE);
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				option_interface();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3))) != 0) );
			setState(62);
			match(CLOSEBRACE);
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

	public static class Interface_descContext extends ParserRuleContext {
		public Interface_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interface_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterInterface_desc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitInterface_desc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitInterface_desc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Interface_descContext interface_desc() throws RecognitionException {
		Interface_descContext _localctx = new Interface_descContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_interface_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__0);
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

	public static class Option_interfaceContext extends ParserRuleContext {
		public Option_interface_descriptionContext option_interface_description() {
			return getRuleContext(Option_interface_descriptionContext.class,0);
		}
		public Option_interface_ipContext option_interface_ip() {
			return getRuleContext(Option_interface_ipContext.class,0);
		}
		public Option_interface_negotiationContext option_interface_negotiation() {
			return getRuleContext(Option_interface_negotiationContext.class,0);
		}
		public Option_interfaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_interface; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterOption_interface(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitOption_interface(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitOption_interface(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_interfaceContext option_interface() throws RecognitionException {
		Option_interfaceContext _localctx = new Option_interfaceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_option_interface);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(66);
				option_interface_description();
				}
				break;
			case T__2:
				{
				setState(67);
				option_interface_ip();
				}
				break;
			case T__3:
				{
				setState(68);
				option_interface_negotiation();
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

	public static class Option_interface_descriptionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ConfigurationParser.STRING, 0); }
		public Option_interface_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_interface_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterOption_interface_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitOption_interface_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitOption_interface_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_interface_descriptionContext option_interface_description() throws RecognitionException {
		Option_interface_descriptionContext _localctx = new Option_interface_descriptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_option_interface_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__1);
			setState(72);
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

	public static class Option_interface_ipContext extends ParserRuleContext {
		public TerminalNode IPV4() { return getToken(ConfigurationParser.IPV4, 0); }
		public Option_interface_ipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_interface_ip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterOption_interface_ip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitOption_interface_ip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitOption_interface_ip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_interface_ipContext option_interface_ip() throws RecognitionException {
		Option_interface_ipContext _localctx = new Option_interface_ipContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_option_interface_ip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__2);
			setState(75);
			match(IPV4);
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

	public static class Option_interface_negotiationContext extends ParserRuleContext {
		public AutoContext auto() {
			return getRuleContext(AutoContext.class,0);
		}
		public Full_duplexContext full_duplex() {
			return getRuleContext(Full_duplexContext.class,0);
		}
		public Half_duplexContext half_duplex() {
			return getRuleContext(Half_duplexContext.class,0);
		}
		public Option_interface_negotiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_interface_negotiation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterOption_interface_negotiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitOption_interface_negotiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitOption_interface_negotiation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_interface_negotiationContext option_interface_negotiation() throws RecognitionException {
		Option_interface_negotiationContext _localctx = new Option_interface_negotiationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_option_interface_negotiation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__3);
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				{
				setState(78);
				auto();
				}
				break;
			case T__10:
				{
				setState(79);
				full_duplex();
				}
				break;
			case T__11:
				{
				setState(80);
				half_duplex();
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

	public static class Statement_routerContext extends ParserRuleContext {
		public RouterContext router() {
			return getRuleContext(RouterContext.class,0);
		}
		public TerminalNode OPENBRACE() { return getToken(ConfigurationParser.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(ConfigurationParser.CLOSEBRACE, 0); }
		public List<Option_routerContext> option_router() {
			return getRuleContexts(Option_routerContext.class);
		}
		public Option_routerContext option_router(int i) {
			return getRuleContext(Option_routerContext.class,i);
		}
		public Statement_routerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_router; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterStatement_router(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitStatement_router(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitStatement_router(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_routerContext statement_router() throws RecognitionException {
		Statement_routerContext _localctx = new Statement_routerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement_router);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			router();
			setState(84);
			match(OPENBRACE);
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				option_router();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << DIGIT))) != 0) );
			setState(90);
			match(CLOSEBRACE);
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

	public static class Option_routerContext extends ParserRuleContext {
		public KindContext kind() {
			return getRuleContext(KindContext.class,0);
		}
		public AsnumberContext asnumber() {
			return getRuleContext(AsnumberContext.class,0);
		}
		public LogContext log() {
			return getRuleContext(LogContext.class,0);
		}
		public NeighborContext neighbor() {
			return getRuleContext(NeighborContext.class,0);
		}
		public Option_routerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_router; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterOption_router(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitOption_router(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitOption_router(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_routerContext option_router() throws RecognitionException {
		Option_routerContext _localctx = new Option_routerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_option_router);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(92);
				kind();
				}
				break;
			case DIGIT:
				{
				setState(93);
				asnumber();
				}
				break;
			case T__5:
				{
				setState(94);
				log();
				}
				break;
			case T__6:
				{
				setState(95);
				neighbor();
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

	public static class KindContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ConfigurationParser.STRING, 0); }
		public KindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KindContext kind() throws RecognitionException {
		KindContext _localctx = new KindContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_kind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__4);
			setState(99);
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

	public static class LogContext extends ParserRuleContext {
		public LogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_log; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitLog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitLog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogContext log() throws RecognitionException {
		LogContext _localctx = new LogContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_log);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__5);
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

	public static class NeighborContext extends ParserRuleContext {
		public Neighbor_descriptionContext neighbor_description() {
			return getRuleContext(Neighbor_descriptionContext.class,0);
		}
		public NeighborContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neighbor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterNeighbor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitNeighbor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitNeighbor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NeighborContext neighbor() throws RecognitionException {
		NeighborContext _localctx = new NeighborContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_neighbor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__6);
			setState(104);
			neighbor_description();
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

	public static class Neighbor_descriptionContext extends ParserRuleContext {
		public TerminalNode OPENBRACE() { return getToken(ConfigurationParser.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(ConfigurationParser.CLOSEBRACE, 0); }
		public List<Neighbor_ipContext> neighbor_ip() {
			return getRuleContexts(Neighbor_ipContext.class);
		}
		public Neighbor_ipContext neighbor_ip(int i) {
			return getRuleContext(Neighbor_ipContext.class,i);
		}
		public List<Remote_asContext> remote_as() {
			return getRuleContexts(Remote_asContext.class);
		}
		public Remote_asContext remote_as(int i) {
			return getRuleContext(Remote_asContext.class,i);
		}
		public List<Neighbor_description_stringContext> neighbor_description_string() {
			return getRuleContexts(Neighbor_description_stringContext.class);
		}
		public Neighbor_description_stringContext neighbor_description_string(int i) {
			return getRuleContext(Neighbor_description_stringContext.class,i);
		}
		public Neighbor_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neighbor_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterNeighbor_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitNeighbor_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitNeighbor_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Neighbor_descriptionContext neighbor_description() throws RecognitionException {
		Neighbor_descriptionContext _localctx = new Neighbor_descriptionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_neighbor_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(OPENBRACE);
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(110);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(107);
					neighbor_ip();
					}
					break;
				case T__7:
					{
					setState(108);
					remote_as();
					}
					break;
				case T__1:
					{
					setState(109);
					neighbor_description_string();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__7))) != 0) );
			setState(114);
			match(CLOSEBRACE);
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

	public static class Neighbor_description_stringContext extends ParserRuleContext {
		public List<TerminalNode> ID_LETTER() { return getTokens(ConfigurationParser.ID_LETTER); }
		public TerminalNode ID_LETTER(int i) {
			return getToken(ConfigurationParser.ID_LETTER, i);
		}
		public Neighbor_description_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neighbor_description_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterNeighbor_description_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitNeighbor_description_string(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitNeighbor_description_string(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Neighbor_description_stringContext neighbor_description_string() throws RecognitionException {
		Neighbor_description_stringContext _localctx = new Neighbor_description_stringContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_neighbor_description_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__1);
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(117);
				match(ID_LETTER);
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_LETTER );
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

	public static class Neighbor_ipContext extends ParserRuleContext {
		public TerminalNode IPV4() { return getToken(ConfigurationParser.IPV4, 0); }
		public Neighbor_ipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neighbor_ip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterNeighbor_ip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitNeighbor_ip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitNeighbor_ip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Neighbor_ipContext neighbor_ip() throws RecognitionException {
		Neighbor_ipContext _localctx = new Neighbor_ipContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_neighbor_ip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__2);
			setState(123);
			match(IPV4);
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

	public static class Remote_asContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(ConfigurationParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(ConfigurationParser.DIGIT, i);
		}
		public Remote_asContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remote_as; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterRemote_as(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitRemote_as(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitRemote_as(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Remote_asContext remote_as() throws RecognitionException {
		Remote_asContext _localctx = new Remote_asContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_remote_as);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__7);
			setState(127); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				match(DIGIT);
				}
				}
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
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

	public static class RouterContext extends ParserRuleContext {
		public RouterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_router; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterRouter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitRouter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitRouter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RouterContext router() throws RecognitionException {
		RouterContext _localctx = new RouterContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_router);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__8);
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

	public static class AutoContext extends ParserRuleContext {
		public AutoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_auto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterAuto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitAuto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitAuto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AutoContext auto() throws RecognitionException {
		AutoContext _localctx = new AutoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_auto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__9);
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

	public static class Full_duplexContext extends ParserRuleContext {
		public Full_duplexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_full_duplex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterFull_duplex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitFull_duplex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitFull_duplex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Full_duplexContext full_duplex() throws RecognitionException {
		Full_duplexContext _localctx = new Full_duplexContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_full_duplex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
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

	public static class Half_duplexContext extends ParserRuleContext {
		public Half_duplexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_half_duplex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterHalf_duplex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitHalf_duplex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitHalf_duplex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Half_duplexContext half_duplex() throws RecognitionException {
		Half_duplexContext _localctx = new Half_duplexContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_half_duplex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__11);
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

	public static class AsnumberContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(ConfigurationParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(ConfigurationParser.DIGIT, i);
		}
		public AsnumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asnumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterAsnumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitAsnumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitAsnumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsnumberContext asnumber() throws RecognitionException {
		AsnumberContext _localctx = new AsnumberContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_asnumber);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(139);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(142); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class ValueContext extends ParserRuleContext {
		public List<TerminalNode> ID_LETTER() { return getTokens(ConfigurationParser.ID_LETTER); }
		public TerminalNode ID_LETTER(int i) {
			return getToken(ConfigurationParser.ID_LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(ConfigurationParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(ConfigurationParser.DIGIT, i);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(ID_LETTER);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID_LETTER || _la==DIGIT) {
				{
				{
				setState(145);
				_la = _input.LA(1);
				if ( !(_la==ID_LETTER || _la==DIGIT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(150);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u009a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\6\2\62"+
		"\n\2\r\2\16\2\63\3\3\3\3\5\38\n\3\3\4\3\4\3\4\6\4=\n\4\r\4\16\4>\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\6\5\6H\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\5\tT\n\t\3\n\3\n\3\n\6\nY\n\n\r\n\16\nZ\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\5\13c\n\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\6\17"+
		"q\n\17\r\17\16\17r\3\17\3\17\3\20\3\20\6\20y\n\20\r\20\16\20z\3\21\3\21"+
		"\3\21\3\22\3\22\6\22\u0082\n\22\r\22\16\22\u0083\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\6\27\u008f\n\27\r\27\16\27\u0090\3\30\3\30\7\30"+
		"\u0095\n\30\f\30\16\30\u0098\13\30\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\2\3\4\2\21\21\23\23\2\u0094\2\61\3\2\2\2\4\67"+
		"\3\2\2\2\69\3\2\2\2\bB\3\2\2\2\nG\3\2\2\2\fI\3\2\2\2\16L\3\2\2\2\20O\3"+
		"\2\2\2\22U\3\2\2\2\24b\3\2\2\2\26d\3\2\2\2\30g\3\2\2\2\32i\3\2\2\2\34"+
		"l\3\2\2\2\36v\3\2\2\2 |\3\2\2\2\"\177\3\2\2\2$\u0085\3\2\2\2&\u0087\3"+
		"\2\2\2(\u0089\3\2\2\2*\u008b\3\2\2\2,\u008e\3\2\2\2.\u0092\3\2\2\2\60"+
		"\62\5\4\3\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64"+
		"\3\3\2\2\2\658\5\6\4\2\668\5\22\n\2\67\65\3\2\2\2\67\66\3\2\2\28\5\3\2"+
		"\2\29:\5\b\5\2:<\7\24\2\2;=\5\n\6\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3"+
		"\2\2\2?@\3\2\2\2@A\7\25\2\2A\7\3\2\2\2BC\7\3\2\2C\t\3\2\2\2DH\5\f\7\2"+
		"EH\5\16\b\2FH\5\20\t\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2H\13\3\2\2\2IJ\7\4"+
		"\2\2JK\7\20\2\2K\r\3\2\2\2LM\7\5\2\2MN\7\17\2\2N\17\3\2\2\2OS\7\6\2\2"+
		"PT\5&\24\2QT\5(\25\2RT\5*\26\2SP\3\2\2\2SQ\3\2\2\2SR\3\2\2\2T\21\3\2\2"+
		"\2UV\5$\23\2VX\7\24\2\2WY\5\24\13\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3"+
		"\2\2\2[\\\3\2\2\2\\]\7\25\2\2]\23\3\2\2\2^c\5\26\f\2_c\5,\27\2`c\5\30"+
		"\r\2ac\5\32\16\2b^\3\2\2\2b_\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\25\3\2\2\2d"+
		"e\7\7\2\2ef\7\20\2\2f\27\3\2\2\2gh\7\b\2\2h\31\3\2\2\2ij\7\t\2\2jk\5\34"+
		"\17\2k\33\3\2\2\2lp\7\24\2\2mq\5 \21\2nq\5\"\22\2oq\5\36\20\2pm\3\2\2"+
		"\2pn\3\2\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\7\25"+
		"\2\2u\35\3\2\2\2vx\7\4\2\2wy\7\21\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{"+
		"\3\2\2\2{\37\3\2\2\2|}\7\5\2\2}~\7\17\2\2~!\3\2\2\2\177\u0081\7\n\2\2"+
		"\u0080\u0082\7\23\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084#\3\2\2\2\u0085\u0086\7\13\2\2\u0086"+
		"%\3\2\2\2\u0087\u0088\7\f\2\2\u0088\'\3\2\2\2\u0089\u008a\7\r\2\2\u008a"+
		")\3\2\2\2\u008b\u008c\7\16\2\2\u008c+\3\2\2\2\u008d\u008f\7\23\2\2\u008e"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091-\3\2\2\2\u0092\u0096\7\21\2\2\u0093\u0095\t\2\2\2\u0094\u0093"+
		"\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"/\3\2\2\2\u0098\u0096\3\2\2\2\17\63\67>GSZbprz\u0083\u0090\u0096";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}