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
		T__9=10, T__10=11, ROUTER=12, NEIGHBOR=13, AUTO=14, IPV4=15, STRING=16, 
		ID_LETTER=17, INT=18, DIGIT=19, OPENBRACE=20, CLOSEBRACE=21, WS=22;
	public static final int
		RULE_prog = 0, RULE_statement = 1, RULE_statement_interface = 2, RULE_interface_desc = 3, 
		RULE_option_interface = 4, RULE_option_interface_description = 5, RULE_option_interface_ip = 6, 
		RULE_option_interface_netmask = 7, RULE_option_interface_negotiation = 8, 
		RULE_statement_router = 9, RULE_option_router = 10, RULE_option_router_kind = 11, 
		RULE_option_router_asnumber = 12, RULE_option_router_log = 13, RULE_neighbor = 14, 
		RULE_neighbor_description = 15, RULE_neighbor_description_string = 16, 
		RULE_neighbor_ip = 17, RULE_remote_as = 18, RULE_full_duplex = 19, RULE_half_duplex = 20;
	public static final String[] ruleNames = {
		"prog", "statement", "statement_interface", "interface_desc", "option_interface", 
		"option_interface_description", "option_interface_ip", "option_interface_netmask", 
		"option_interface_negotiation", "statement_router", "option_router", "option_router_kind", 
		"option_router_asnumber", "option_router_log", "neighbor", "neighbor_description", 
		"neighbor_description_string", "neighbor_ip", "remote_as", "full_duplex", 
		"half_duplex"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'interface'", "'description'", "'ip'", "'netmask'", "'negotiation'", 
		"'kind'", "'asnumber'", "'log-neighbor-changes'", "'remote_as'", "'full_duplex'", 
		"'half_duplex'", "'router'", "'neighbor'", "'auto'", null, null, null, 
		null, null, "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ROUTER", "NEIGHBOR", "AUTO", "IPV4", "STRING", "ID_LETTER", "INT", "DIGIT", 
		"OPENBRACE", "CLOSEBRACE", "WS"
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
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42);
				statement();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==ROUTER );
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
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(47);
				statement_interface();
				}
				break;
			case ROUTER:
				{
				setState(48);
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
			setState(51);
			interface_desc();
			setState(52);
			match(OPENBRACE);
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(53);
				option_interface();
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4))) != 0) );
			setState(58);
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
			setState(60);
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
		public Option_interface_netmaskContext option_interface_netmask() {
			return getRuleContext(Option_interface_netmaskContext.class,0);
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
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(62);
				option_interface_description();
				}
				break;
			case T__2:
				{
				setState(63);
				option_interface_ip();
				}
				break;
			case T__4:
				{
				setState(64);
				option_interface_negotiation();
				}
				break;
			case T__3:
				{
				setState(65);
				option_interface_netmask();
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
			setState(68);
			match(T__1);
			setState(69);
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
			setState(71);
			match(T__2);
			setState(72);
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

	public static class Option_interface_netmaskContext extends ParserRuleContext {
		public TerminalNode IPV4() { return getToken(ConfigurationParser.IPV4, 0); }
		public Option_interface_netmaskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_interface_netmask; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterOption_interface_netmask(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitOption_interface_netmask(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitOption_interface_netmask(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_interface_netmaskContext option_interface_netmask() throws RecognitionException {
		Option_interface_netmaskContext _localctx = new Option_interface_netmaskContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_option_interface_netmask);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__3);
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
		public TerminalNode AUTO() { return getToken(ConfigurationParser.AUTO, 0); }
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
		enterRule(_localctx, 16, RULE_option_interface_negotiation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__4);
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AUTO:
				{
				setState(78);
				match(AUTO);
				}
				break;
			case T__9:
				{
				setState(79);
				full_duplex();
				}
				break;
			case T__10:
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
		public TerminalNode ROUTER() { return getToken(ConfigurationParser.ROUTER, 0); }
		public TerminalNode OPENBRACE() { return getToken(ConfigurationParser.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(ConfigurationParser.CLOSEBRACE, 0); }
		public List<Option_routerContext> option_router() {
			return getRuleContexts(Option_routerContext.class);
		}
		public Option_routerContext option_router(int i) {
			return getRuleContext(Option_routerContext.class,i);
		}
		public List<NeighborContext> neighbor() {
			return getRuleContexts(NeighborContext.class);
		}
		public NeighborContext neighbor(int i) {
			return getRuleContext(NeighborContext.class,i);
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
		enterRule(_localctx, 18, RULE_statement_router);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(ROUTER);
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0) );
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(90);
				neighbor();
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEIGHBOR );
			setState(95);
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
		public Option_router_kindContext option_router_kind() {
			return getRuleContext(Option_router_kindContext.class,0);
		}
		public Option_router_asnumberContext option_router_asnumber() {
			return getRuleContext(Option_router_asnumberContext.class,0);
		}
		public Option_router_logContext option_router_log() {
			return getRuleContext(Option_router_logContext.class,0);
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
		enterRule(_localctx, 20, RULE_option_router);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(97);
				option_router_kind();
				}
				break;
			case T__6:
				{
				setState(98);
				option_router_asnumber();
				}
				break;
			case T__7:
				{
				setState(99);
				option_router_log();
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

	public static class Option_router_kindContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ConfigurationParser.STRING, 0); }
		public Option_router_kindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_router_kind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterOption_router_kind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitOption_router_kind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitOption_router_kind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_router_kindContext option_router_kind() throws RecognitionException {
		Option_router_kindContext _localctx = new Option_router_kindContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_option_router_kind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__5);
			setState(103);
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

	public static class Option_router_asnumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ConfigurationParser.INT, 0); }
		public Option_router_asnumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_router_asnumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterOption_router_asnumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitOption_router_asnumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitOption_router_asnumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_router_asnumberContext option_router_asnumber() throws RecognitionException {
		Option_router_asnumberContext _localctx = new Option_router_asnumberContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_option_router_asnumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__6);
			setState(106);
			match(INT);
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

	public static class Option_router_logContext extends ParserRuleContext {
		public Option_router_logContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option_router_log; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterOption_router_log(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitOption_router_log(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitOption_router_log(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Option_router_logContext option_router_log() throws RecognitionException {
		Option_router_logContext _localctx = new Option_router_logContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_option_router_log);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__7);
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
		public TerminalNode NEIGHBOR() { return getToken(ConfigurationParser.NEIGHBOR, 0); }
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
		enterRule(_localctx, 28, RULE_neighbor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(NEIGHBOR);
			setState(111);
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
		enterRule(_localctx, 30, RULE_neighbor_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(OPENBRACE);
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(117);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(114);
					neighbor_ip();
					}
					break;
				case T__8:
					{
					setState(115);
					remote_as();
					}
					break;
				case T__1:
					{
					setState(116);
					neighbor_description_string();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__8))) != 0) );
			setState(121);
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
		public TerminalNode STRING() { return getToken(ConfigurationParser.STRING, 0); }
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
		enterRule(_localctx, 32, RULE_neighbor_description_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__1);
			setState(124);
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
		enterRule(_localctx, 34, RULE_neighbor_ip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__2);
			setState(127);
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
		public TerminalNode INT() { return getToken(ConfigurationParser.INT, 0); }
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
		enterRule(_localctx, 36, RULE_remote_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__8);
			setState(130);
			match(INT);
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
			setState(132);
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
			setState(134);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u008b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\6\2.\n\2\r\2\16\2/\3\3\3"+
		"\3\5\3\64\n\3\3\4\3\4\3\4\6\49\n\4\r\4\16\4:\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\5\6E\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5"+
		"\nT\n\n\3\13\3\13\3\13\6\13Y\n\13\r\13\16\13Z\3\13\6\13^\n\13\r\13\16"+
		"\13_\3\13\3\13\3\f\3\f\3\f\5\fg\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\6\21x\n\21\r\21\16\21y\3\21\3\21"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\2\2\u0084\2-\3"+
		"\2\2\2\4\63\3\2\2\2\6\65\3\2\2\2\b>\3\2\2\2\nD\3\2\2\2\fF\3\2\2\2\16I"+
		"\3\2\2\2\20L\3\2\2\2\22O\3\2\2\2\24U\3\2\2\2\26f\3\2\2\2\30h\3\2\2\2\32"+
		"k\3\2\2\2\34n\3\2\2\2\36p\3\2\2\2 s\3\2\2\2\"}\3\2\2\2$\u0080\3\2\2\2"+
		"&\u0083\3\2\2\2(\u0086\3\2\2\2*\u0088\3\2\2\2,.\5\4\3\2-,\3\2\2\2./\3"+
		"\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\3\3\2\2\2\61\64\5\6\4\2\62\64\5\24\13"+
		"\2\63\61\3\2\2\2\63\62\3\2\2\2\64\5\3\2\2\2\65\66\5\b\5\2\668\7\26\2\2"+
		"\679\5\n\6\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\27"+
		"\2\2=\7\3\2\2\2>?\7\3\2\2?\t\3\2\2\2@E\5\f\7\2AE\5\16\b\2BE\5\22\n\2C"+
		"E\5\20\t\2D@\3\2\2\2DA\3\2\2\2DB\3\2\2\2DC\3\2\2\2E\13\3\2\2\2FG\7\4\2"+
		"\2GH\7\22\2\2H\r\3\2\2\2IJ\7\5\2\2JK\7\21\2\2K\17\3\2\2\2LM\7\6\2\2MN"+
		"\7\21\2\2N\21\3\2\2\2OS\7\7\2\2PT\7\20\2\2QT\5(\25\2RT\5*\26\2SP\3\2\2"+
		"\2SQ\3\2\2\2SR\3\2\2\2T\23\3\2\2\2UV\7\16\2\2VX\7\26\2\2WY\5\26\f\2XW"+
		"\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\^\5\36\20\2]\\\3\2\2"+
		"\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\27\2\2b\25\3\2\2\2cg\5"+
		"\30\r\2dg\5\32\16\2eg\5\34\17\2fc\3\2\2\2fd\3\2\2\2fe\3\2\2\2g\27\3\2"+
		"\2\2hi\7\b\2\2ij\7\22\2\2j\31\3\2\2\2kl\7\t\2\2lm\7\24\2\2m\33\3\2\2\2"+
		"no\7\n\2\2o\35\3\2\2\2pq\7\17\2\2qr\5 \21\2r\37\3\2\2\2sw\7\26\2\2tx\5"+
		"$\23\2ux\5&\24\2vx\5\"\22\2wt\3\2\2\2wu\3\2\2\2wv\3\2\2\2xy\3\2\2\2yw"+
		"\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\27\2\2|!\3\2\2\2}~\7\4\2\2~\177\7\22"+
		"\2\2\177#\3\2\2\2\u0080\u0081\7\5\2\2\u0081\u0082\7\21\2\2\u0082%\3\2"+
		"\2\2\u0083\u0084\7\13\2\2\u0084\u0085\7\24\2\2\u0085\'\3\2\2\2\u0086\u0087"+
		"\7\f\2\2\u0087)\3\2\2\2\u0088\u0089\7\r\2\2\u0089+\3\2\2\2\f/\63:DSZ_"+
		"fwy";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}