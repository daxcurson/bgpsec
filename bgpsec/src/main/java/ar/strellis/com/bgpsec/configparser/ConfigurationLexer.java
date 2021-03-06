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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ROUTER=15, NEIGHBOR=16, 
		AUTO=17, INTERNAL=18, EXTERNAL=19, IPV4=20, STRING=21, ID_LETTER=22, INT=23, 
		DIGIT=24, OPENBRACE=25, CLOSEBRACE=26, FILEPATH=27, WS=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "ROUTER", "NEIGHBOR", "AUTO", 
		"INTERNAL", "EXTERNAL", "IPV4", "STRING", "ID_LETTER", "INT", "DIGIT", 
		"OPENBRACE", "CLOSEBRACE", "FILEPATH", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'interface'", "'description'", "'ip'", "'netmask'", "'negotiation'", 
		"'kind'", "'asnumber'", "'log-neighbor-changes'", "'type'", "'remote_as'", 
		"'options'", "'zebra_socket'", "'full_duplex'", "'half_duplex'", "'router'", 
		"'neighbor'", "'auto'", "'internal'", "'external'", null, null, null, 
		null, null, "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "ROUTER", "NEIGHBOR", "AUTO", "INTERNAL", "EXTERNAL", 
		"IPV4", "STRING", "ID_LETTER", "INT", "DIGIT", "OPENBRACE", "CLOSEBRACE", 
		"FILEPATH", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u0117\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u00fa\n\26\f\26"+
		"\16\26\u00fd\13\26\3\27\3\27\3\30\6\30\u0102\n\30\r\30\16\30\u0103\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\6\34\u010d\n\34\r\34\16\34\u010e\3\35\6"+
		"\35\u0112\n\35\r\35\16\35\u0113\3\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\6\6\2\60\60C\\aac|\3"+
		"\2\62;\5\2/;C\\c|\5\2\13\f\17\17\"\"\2\u011b\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5E\3\2\2\2\7Q\3\2\2"+
		"\2\tT\3\2\2\2\13\\\3\2\2\2\rh\3\2\2\2\17m\3\2\2\2\21v\3\2\2\2\23\u008b"+
		"\3\2\2\2\25\u0090\3\2\2\2\27\u009a\3\2\2\2\31\u00a2\3\2\2\2\33\u00af\3"+
		"\2\2\2\35\u00bb\3\2\2\2\37\u00c7\3\2\2\2!\u00ce\3\2\2\2#\u00d7\3\2\2\2"+
		"%\u00dc\3\2\2\2\'\u00e5\3\2\2\2)\u00ee\3\2\2\2+\u00f6\3\2\2\2-\u00fe\3"+
		"\2\2\2/\u0101\3\2\2\2\61\u0105\3\2\2\2\63\u0107\3\2\2\2\65\u0109\3\2\2"+
		"\2\67\u010c\3\2\2\29\u0111\3\2\2\2;<\7k\2\2<=\7p\2\2=>\7v\2\2>?\7g\2\2"+
		"?@\7t\2\2@A\7h\2\2AB\7c\2\2BC\7e\2\2CD\7g\2\2D\4\3\2\2\2EF\7f\2\2FG\7"+
		"g\2\2GH\7u\2\2HI\7e\2\2IJ\7t\2\2JK\7k\2\2KL\7r\2\2LM\7v\2\2MN\7k\2\2N"+
		"O\7q\2\2OP\7p\2\2P\6\3\2\2\2QR\7k\2\2RS\7r\2\2S\b\3\2\2\2TU\7p\2\2UV\7"+
		"g\2\2VW\7v\2\2WX\7o\2\2XY\7c\2\2YZ\7u\2\2Z[\7m\2\2[\n\3\2\2\2\\]\7p\2"+
		"\2]^\7g\2\2^_\7i\2\2_`\7q\2\2`a\7v\2\2ab\7k\2\2bc\7c\2\2cd\7v\2\2de\7"+
		"k\2\2ef\7q\2\2fg\7p\2\2g\f\3\2\2\2hi\7m\2\2ij\7k\2\2jk\7p\2\2kl\7f\2\2"+
		"l\16\3\2\2\2mn\7c\2\2no\7u\2\2op\7p\2\2pq\7w\2\2qr\7o\2\2rs\7d\2\2st\7"+
		"g\2\2tu\7t\2\2u\20\3\2\2\2vw\7n\2\2wx\7q\2\2xy\7i\2\2yz\7/\2\2z{\7p\2"+
		"\2{|\7g\2\2|}\7k\2\2}~\7i\2\2~\177\7j\2\2\177\u0080\7d\2\2\u0080\u0081"+
		"\7q\2\2\u0081\u0082\7t\2\2\u0082\u0083\7/\2\2\u0083\u0084\7e\2\2\u0084"+
		"\u0085\7j\2\2\u0085\u0086\7c\2\2\u0086\u0087\7p\2\2\u0087\u0088\7i\2\2"+
		"\u0088\u0089\7g\2\2\u0089\u008a\7u\2\2\u008a\22\3\2\2\2\u008b\u008c\7"+
		"v\2\2\u008c\u008d\7{\2\2\u008d\u008e\7r\2\2\u008e\u008f\7g\2\2\u008f\24"+
		"\3\2\2\2\u0090\u0091\7t\2\2\u0091\u0092\7g\2\2\u0092\u0093\7o\2\2\u0093"+
		"\u0094\7q\2\2\u0094\u0095\7v\2\2\u0095\u0096\7g\2\2\u0096\u0097\7a\2\2"+
		"\u0097\u0098\7c\2\2\u0098\u0099\7u\2\2\u0099\26\3\2\2\2\u009a\u009b\7"+
		"q\2\2\u009b\u009c\7r\2\2\u009c\u009d\7v\2\2\u009d\u009e\7k\2\2\u009e\u009f"+
		"\7q\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7u\2\2\u00a1\30\3\2\2\2\u00a2\u00a3"+
		"\7|\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7d\2\2\u00a5\u00a6\7t\2\2\u00a6"+
		"\u00a7\7c\2\2\u00a7\u00a8\7a\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7q\2\2"+
		"\u00aa\u00ab\7e\2\2\u00ab\u00ac\7m\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae"+
		"\7v\2\2\u00ae\32\3\2\2\2\u00af\u00b0\7h\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2"+
		"\7n\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7a\2\2\u00b4\u00b5\7f\2\2\u00b5"+
		"\u00b6\7w\2\2\u00b6\u00b7\7r\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7g\2\2"+
		"\u00b9\u00ba\7z\2\2\u00ba\34\3\2\2\2\u00bb\u00bc\7j\2\2\u00bc\u00bd\7"+
		"c\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7h\2\2\u00bf\u00c0\7a\2\2\u00c0\u00c1"+
		"\7f\2\2\u00c1\u00c2\7w\2\2\u00c2\u00c3\7r\2\2\u00c3\u00c4\7n\2\2\u00c4"+
		"\u00c5\7g\2\2\u00c5\u00c6\7z\2\2\u00c6\36\3\2\2\2\u00c7\u00c8\7t\2\2\u00c8"+
		"\u00c9\7q\2\2\u00c9\u00ca\7w\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7g\2\2"+
		"\u00cc\u00cd\7t\2\2\u00cd \3\2\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7g\2"+
		"\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7i\2\2\u00d2\u00d3\7j\2\2\u00d3\u00d4"+
		"\7d\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6\7t\2\2\u00d6\"\3\2\2\2\u00d7\u00d8"+
		"\7c\2\2\u00d8\u00d9\7w\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7q\2\2\u00db"+
		"$\3\2\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7v\2\2\u00df"+
		"\u00e0\7g\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7c\2\2"+
		"\u00e3\u00e4\7n\2\2\u00e4&\3\2\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7z\2"+
		"\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb"+
		"\7p\2\2\u00eb\u00ec\7c\2\2\u00ec\u00ed\7n\2\2\u00ed(\3\2\2\2\u00ee\u00ef"+
		"\5/\30\2\u00ef\u00f0\7\60\2\2\u00f0\u00f1\5/\30\2\u00f1\u00f2\7\60\2\2"+
		"\u00f2\u00f3\5/\30\2\u00f3\u00f4\7\60\2\2\u00f4\u00f5\5/\30\2\u00f5*\3"+
		"\2\2\2\u00f6\u00fb\5-\27\2\u00f7\u00fa\5-\27\2\u00f8\u00fa\5\61\31\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc,\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff"+
		"\t\2\2\2\u00ff.\3\2\2\2\u0100\u0102\5\61\31\2\u0101\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\60\3\2\2"+
		"\2\u0105\u0106\t\3\2\2\u0106\62\3\2\2\2\u0107\u0108\7}\2\2\u0108\64\3"+
		"\2\2\2\u0109\u010a\7\177\2\2\u010a\66\3\2\2\2\u010b\u010d\t\4\2\2\u010c"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f8\3\2\2\2\u0110\u0112\t\5\2\2\u0111\u0110\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"\u0116\b\35\2\2\u0116:\3\2\2\2\b\2\u00f9\u00fb\u0103\u010e\u0113\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}