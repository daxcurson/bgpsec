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
		T__9=10, T__10=11, T__11=12, ROUTER=13, NEIGHBOR=14, AUTO=15, INTERNAL=16, 
		EXTERNAL=17, IPV4=18, STRING=19, ID_LETTER=20, INT=21, DIGIT=22, OPENBRACE=23, 
		CLOSEBRACE=24, WS=25;
	public static final int
		RULE_prog = 0, RULE_statement = 1, RULE_statement_interface = 2, RULE_interface_desc = 3, 
		RULE_option_interface = 4, RULE_option_interface_description = 5, RULE_option_interface_ip = 6, 
		RULE_option_interface_netmask = 7, RULE_option_interface_negotiation = 8, 
		RULE_statement_router = 9, RULE_option_router = 10, RULE_option_router_kind = 11, 
		RULE_option_router_asnumber = 12, RULE_option_router_log = 13, RULE_neighbor = 14, 
		RULE_neighbor_description = 15, RULE_neighbor_description_string = 16, 
		RULE_neighbor_ip = 17, RULE_neighbor_type = 18, RULE_remote_as = 19, RULE_full_duplex = 20, 
		RULE_half_duplex = 21;
	public static final String[] ruleNames = {
		"prog", "statement", "statement_interface", "interface_desc", "option_interface", 
		"option_interface_description", "option_interface_ip", "option_interface_netmask", 
		"option_interface_negotiation", "statement_router", "option_router", "option_router_kind", 
		"option_router_asnumber", "option_router_log", "neighbor", "neighbor_description", 
		"neighbor_description_string", "neighbor_ip", "neighbor_type", "remote_as", 
		"full_duplex", "half_duplex"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'interface'", "'description'", "'ip'", "'netmask'", "'negotiation'", 
		"'kind'", "'asnumber'", "'log-neighbor-changes'", "'type'", "'remote_as'", 
		"'full_duplex'", "'half_duplex'", "'router'", "'neighbor'", "'auto'", 
		"'internal'", "'external'", null, null, null, null, null, "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "ROUTER", "NEIGHBOR", "AUTO", "INTERNAL", "EXTERNAL", "IPV4", "STRING", 
		"ID_LETTER", "INT", "DIGIT", "OPENBRACE", "CLOSEBRACE", "WS"
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
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				statement();
				}
				}
				setState(47); 
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
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(49);
				statement_interface();
				}
				break;
			case ROUTER:
				{
				setState(50);
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
			setState(53);
			interface_desc();
			setState(54);
			match(OPENBRACE);
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				option_interface();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4))) != 0) );
			setState(60);
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
			setState(62);
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
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(64);
				option_interface_description();
				}
				break;
			case T__2:
				{
				setState(65);
				option_interface_ip();
				}
				break;
			case T__4:
				{
				setState(66);
				option_interface_negotiation();
				}
				break;
			case T__3:
				{
				setState(67);
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
			setState(70);
			match(T__1);
			setState(71);
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
			setState(73);
			match(T__2);
			setState(74);
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
			setState(76);
			match(T__3);
			setState(77);
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
			setState(79);
			match(T__4);
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AUTO:
				{
				setState(80);
				match(AUTO);
				}
				break;
			case T__10:
				{
				setState(81);
				full_duplex();
				}
				break;
			case T__11:
				{
				setState(82);
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
			setState(85);
			match(ROUTER);
			setState(86);
			match(OPENBRACE);
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				option_router();
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0) );
			setState(93); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92);
				neighbor();
				}
				}
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEIGHBOR );
			setState(97);
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
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(99);
				option_router_kind();
				}
				break;
			case T__6:
				{
				setState(100);
				option_router_asnumber();
				}
				break;
			case T__7:
				{
				setState(101);
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
			setState(104);
			match(T__5);
			setState(105);
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
			setState(107);
			match(T__6);
			setState(108);
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
			setState(110);
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
			setState(112);
			match(NEIGHBOR);
			setState(113);
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
		public List<Neighbor_typeContext> neighbor_type() {
			return getRuleContexts(Neighbor_typeContext.class);
		}
		public Neighbor_typeContext neighbor_type(int i) {
			return getRuleContext(Neighbor_typeContext.class,i);
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
			setState(115);
			match(OPENBRACE);
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(120);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(116);
					neighbor_ip();
					}
					break;
				case T__8:
					{
					setState(117);
					neighbor_type();
					}
					break;
				case T__9:
					{
					setState(118);
					remote_as();
					}
					break;
				case T__1:
					{
					setState(119);
					neighbor_description_string();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__8) | (1L << T__9))) != 0) );
			setState(124);
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
			setState(126);
			match(T__1);
			setState(127);
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
			setState(129);
			match(T__2);
			setState(130);
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

	public static class Neighbor_typeContext extends ParserRuleContext {
		public TerminalNode INTERNAL() { return getToken(ConfigurationParser.INTERNAL, 0); }
		public TerminalNode EXTERNAL() { return getToken(ConfigurationParser.EXTERNAL, 0); }
		public Neighbor_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neighbor_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).enterNeighbor_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConfigurationListener ) ((ConfigurationListener)listener).exitNeighbor_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConfigurationVisitor ) return ((ConfigurationVisitor<? extends T>)visitor).visitNeighbor_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Neighbor_typeContext neighbor_type() throws RecognitionException {
		Neighbor_typeContext _localctx = new Neighbor_typeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_neighbor_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__8);
			setState(133);
			_la = _input.LA(1);
			if ( !(_la==INTERNAL || _la==EXTERNAL) ) {
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
		enterRule(_localctx, 38, RULE_remote_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__9);
			setState(136);
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
		enterRule(_localctx, 40, RULE_full_duplex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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
		enterRule(_localctx, 42, RULE_half_duplex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u0091\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\6\2\60\n\2\r\2"+
		"\16\2\61\3\3\3\3\5\3\66\n\3\3\4\3\4\3\4\6\4;\n\4\r\4\16\4<\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\5\6G\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\5\nV\n\n\3\13\3\13\3\13\6\13[\n\13\r\13\16\13\\\3\13\6\13"+
		"`\n\13\r\13\16\13a\3\13\3\13\3\f\3\f\3\f\5\fi\n\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\6\21{\n\21\r\21"+
		"\16\21|\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,\2\3\3\2\22\23\2\u008a\2/\3\2\2\2\4\65\3\2\2\2\6\67\3"+
		"\2\2\2\b@\3\2\2\2\nF\3\2\2\2\fH\3\2\2\2\16K\3\2\2\2\20N\3\2\2\2\22Q\3"+
		"\2\2\2\24W\3\2\2\2\26h\3\2\2\2\30j\3\2\2\2\32m\3\2\2\2\34p\3\2\2\2\36"+
		"r\3\2\2\2 u\3\2\2\2\"\u0080\3\2\2\2$\u0083\3\2\2\2&\u0086\3\2\2\2(\u0089"+
		"\3\2\2\2*\u008c\3\2\2\2,\u008e\3\2\2\2.\60\5\4\3\2/.\3\2\2\2\60\61\3\2"+
		"\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\3\3\2\2\2\63\66\5\6\4\2\64\66\5\24\13"+
		"\2\65\63\3\2\2\2\65\64\3\2\2\2\66\5\3\2\2\2\678\5\b\5\28:\7\31\2\29;\5"+
		"\n\6\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=>\3\2\2\2>?\7\32\2\2?\7"+
		"\3\2\2\2@A\7\3\2\2A\t\3\2\2\2BG\5\f\7\2CG\5\16\b\2DG\5\22\n\2EG\5\20\t"+
		"\2FB\3\2\2\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2G\13\3\2\2\2HI\7\4\2\2IJ\7\25"+
		"\2\2J\r\3\2\2\2KL\7\5\2\2LM\7\24\2\2M\17\3\2\2\2NO\7\6\2\2OP\7\24\2\2"+
		"P\21\3\2\2\2QU\7\7\2\2RV\7\21\2\2SV\5*\26\2TV\5,\27\2UR\3\2\2\2US\3\2"+
		"\2\2UT\3\2\2\2V\23\3\2\2\2WX\7\17\2\2XZ\7\31\2\2Y[\5\26\f\2ZY\3\2\2\2"+
		"[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^`\5\36\20\2_^\3\2\2\2`a\3"+
		"\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\7\32\2\2d\25\3\2\2\2ei\5\30\r\2"+
		"fi\5\32\16\2gi\5\34\17\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2i\27\3\2\2\2jk\7"+
		"\b\2\2kl\7\25\2\2l\31\3\2\2\2mn\7\t\2\2no\7\27\2\2o\33\3\2\2\2pq\7\n\2"+
		"\2q\35\3\2\2\2rs\7\20\2\2st\5 \21\2t\37\3\2\2\2uz\7\31\2\2v{\5$\23\2w"+
		"{\5&\24\2x{\5(\25\2y{\5\"\22\2zv\3\2\2\2zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2"+
		"{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\32\2\2\177!\3\2\2\2\u0080"+
		"\u0081\7\4\2\2\u0081\u0082\7\25\2\2\u0082#\3\2\2\2\u0083\u0084\7\5\2\2"+
		"\u0084\u0085\7\24\2\2\u0085%\3\2\2\2\u0086\u0087\7\13\2\2\u0087\u0088"+
		"\t\2\2\2\u0088\'\3\2\2\2\u0089\u008a\7\f\2\2\u008a\u008b\7\27\2\2\u008b"+
		")\3\2\2\2\u008c\u008d\7\r\2\2\u008d+\3\2\2\2\u008e\u008f\7\16\2\2\u008f"+
		"-\3\2\2\2\f\61\65<FU\\ahz|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}