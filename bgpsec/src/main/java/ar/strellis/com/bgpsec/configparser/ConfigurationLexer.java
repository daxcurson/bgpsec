// Generated from ar\strellis\com\bgpsec\configparser\Configuration.g4 by ANTLR 4.7
package ar.strellis.com.bgpsec.configparser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConfigurationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, ROUTER=13, NEIGHBOR=14, AUTO=15, INTERNAL=16, 
		EXTERNAL=17, IPV4=18, STRING=19, ID_LETTER=20, INT=21, DIGIT=22, OPENBRACE=23, 
		CLOSEBRACE=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "ROUTER", "NEIGHBOR", "AUTO", "INTERNAL", "EXTERNAL", 
		"IPV4", "STRING", "ID_LETTER", "INT", "DIGIT", "OPENBRACE", "CLOSEBRACE", 
		"WS"
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


	public ConfigurationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Configuration.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00f7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u00df\n\24"+
		"\f\24\16\24\u00e2\13\24\3\25\3\25\3\26\6\26\u00e7\n\26\r\26\16\26\u00e8"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\6\32\u00f2\n\32\r\32\16\32\u00f3\3"+
		"\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2"+
		"\5\5\2C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\2\u00fa\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\3\65\3\2\2\2\5?\3\2\2\2\7K\3\2\2\2\tN\3\2\2\2\13V\3\2\2\2\rb\3"+
		"\2\2\2\17g\3\2\2\2\21p\3\2\2\2\23\u0085\3\2\2\2\25\u008a\3\2\2\2\27\u0094"+
		"\3\2\2\2\31\u00a0\3\2\2\2\33\u00ac\3\2\2\2\35\u00b3\3\2\2\2\37\u00bc\3"+
		"\2\2\2!\u00c1\3\2\2\2#\u00ca\3\2\2\2%\u00d3\3\2\2\2\'\u00db\3\2\2\2)\u00e3"+
		"\3\2\2\2+\u00e6\3\2\2\2-\u00ea\3\2\2\2/\u00ec\3\2\2\2\61\u00ee\3\2\2\2"+
		"\63\u00f1\3\2\2\2\65\66\7k\2\2\66\67\7p\2\2\678\7v\2\289\7g\2\29:\7t\2"+
		"\2:;\7h\2\2;<\7c\2\2<=\7e\2\2=>\7g\2\2>\4\3\2\2\2?@\7f\2\2@A\7g\2\2AB"+
		"\7u\2\2BC\7e\2\2CD\7t\2\2DE\7k\2\2EF\7r\2\2FG\7v\2\2GH\7k\2\2HI\7q\2\2"+
		"IJ\7p\2\2J\6\3\2\2\2KL\7k\2\2LM\7r\2\2M\b\3\2\2\2NO\7p\2\2OP\7g\2\2PQ"+
		"\7v\2\2QR\7o\2\2RS\7c\2\2ST\7u\2\2TU\7m\2\2U\n\3\2\2\2VW\7p\2\2WX\7g\2"+
		"\2XY\7i\2\2YZ\7q\2\2Z[\7v\2\2[\\\7k\2\2\\]\7c\2\2]^\7v\2\2^_\7k\2\2_`"+
		"\7q\2\2`a\7p\2\2a\f\3\2\2\2bc\7m\2\2cd\7k\2\2de\7p\2\2ef\7f\2\2f\16\3"+
		"\2\2\2gh\7c\2\2hi\7u\2\2ij\7p\2\2jk\7w\2\2kl\7o\2\2lm\7d\2\2mn\7g\2\2"+
		"no\7t\2\2o\20\3\2\2\2pq\7n\2\2qr\7q\2\2rs\7i\2\2st\7/\2\2tu\7p\2\2uv\7"+
		"g\2\2vw\7k\2\2wx\7i\2\2xy\7j\2\2yz\7d\2\2z{\7q\2\2{|\7t\2\2|}\7/\2\2}"+
		"~\7e\2\2~\177\7j\2\2\177\u0080\7c\2\2\u0080\u0081\7p\2\2\u0081\u0082\7"+
		"i\2\2\u0082\u0083\7g\2\2\u0083\u0084\7u\2\2\u0084\22\3\2\2\2\u0085\u0086"+
		"\7v\2\2\u0086\u0087\7{\2\2\u0087\u0088\7r\2\2\u0088\u0089\7g\2\2\u0089"+
		"\24\3\2\2\2\u008a\u008b\7t\2\2\u008b\u008c\7g\2\2\u008c\u008d\7o\2\2\u008d"+
		"\u008e\7q\2\2\u008e\u008f\7v\2\2\u008f\u0090\7g\2\2\u0090\u0091\7a\2\2"+
		"\u0091\u0092\7c\2\2\u0092\u0093\7u\2\2\u0093\26\3\2\2\2\u0094\u0095\7"+
		"h\2\2\u0095\u0096\7w\2\2\u0096\u0097\7n\2\2\u0097\u0098\7n\2\2\u0098\u0099"+
		"\7a\2\2\u0099\u009a\7f\2\2\u009a\u009b\7w\2\2\u009b\u009c\7r\2\2\u009c"+
		"\u009d\7n\2\2\u009d\u009e\7g\2\2\u009e\u009f\7z\2\2\u009f\30\3\2\2\2\u00a0"+
		"\u00a1\7j\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7h\2\2"+
		"\u00a4\u00a5\7a\2\2\u00a5\u00a6\7f\2\2\u00a6\u00a7\7w\2\2\u00a7\u00a8"+
		"\7r\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7z\2\2\u00ab"+
		"\32\3\2\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7w\2\2\u00af"+
		"\u00b0\7v\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7t\2\2\u00b2\34\3\2\2\2\u00b3"+
		"\u00b4\7p\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7i\2\2"+
		"\u00b7\u00b8\7j\2\2\u00b8\u00b9\7d\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb"+
		"\7t\2\2\u00bb\36\3\2\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7w\2\2\u00be\u00bf"+
		"\7v\2\2\u00bf\u00c0\7q\2\2\u00c0 \3\2\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3"+
		"\7p\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7t\2\2\u00c6"+
		"\u00c7\7p\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7n\2\2\u00c9\"\3\2\2\2\u00ca"+
		"\u00cb\7g\2\2\u00cb\u00cc\7z\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7g\2\2"+
		"\u00ce\u00cf\7t\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2"+
		"\7n\2\2\u00d2$\3\2\2\2\u00d3\u00d4\5+\26\2\u00d4\u00d5\7\60\2\2\u00d5"+
		"\u00d6\5+\26\2\u00d6\u00d7\7\60\2\2\u00d7\u00d8\5+\26\2\u00d8\u00d9\7"+
		"\60\2\2\u00d9\u00da\5+\26\2\u00da&\3\2\2\2\u00db\u00e0\5)\25\2\u00dc\u00df"+
		"\5)\25\2\u00dd\u00df\5-\27\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df"+
		"\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1(\3\2\2\2"+
		"\u00e2\u00e0\3\2\2\2\u00e3\u00e4\t\2\2\2\u00e4*\3\2\2\2\u00e5\u00e7\5"+
		"-\27\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9,\3\2\2\2\u00ea\u00eb\t\3\2\2\u00eb.\3\2\2\2\u00ec"+
		"\u00ed\7}\2\2\u00ed\60\3\2\2\2\u00ee\u00ef\7\177\2\2\u00ef\62\3\2\2\2"+
		"\u00f0\u00f2\t\4\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\b\32\2\2"+
		"\u00f6\64\3\2\2\2\7\2\u00de\u00e0\u00e8\u00f3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}