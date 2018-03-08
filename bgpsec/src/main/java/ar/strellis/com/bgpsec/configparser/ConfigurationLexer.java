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
		T__9=10, T__10=11, T__11=12, IPV4=13, STRING=14, ID_LETTER=15, INT=16, 
		DIGIT=17, OPENBRACE=18, CLOSEBRACE=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "IPV4", "STRING", "ID_LETTER", "INT", "DIGIT", 
		"OPENBRACE", "CLOSEBRACE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00c2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\6\17\u00ab\n\17\r\17\16\17\u00ac\3\20\3\20\3\21\6\21\u00b2\n\21\r\21"+
		"\16\21\u00b3\3\22\3\22\3\23\3\23\3\24\3\24\3\25\6\25\u00bd\n\25\r\25\16"+
		"\25\u00be\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\5\5\2C\\aac|"+
		"\3\2\62;\5\2\13\f\17\17\"\"\2\u00c4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\3+\3\2\2\2\5\65\3\2\2\2\7A\3\2\2\2\tD\3\2\2\2\13P\3\2\2\2\rU\3\2"+
		"\2\2\17j\3\2\2\2\21s\3\2\2\2\23}\3\2\2\2\25\u0084\3\2\2\2\27\u0089\3\2"+
		"\2\2\31\u0095\3\2\2\2\33\u00a1\3\2\2\2\35\u00aa\3\2\2\2\37\u00ae\3\2\2"+
		"\2!\u00b1\3\2\2\2#\u00b5\3\2\2\2%\u00b7\3\2\2\2\'\u00b9\3\2\2\2)\u00bc"+
		"\3\2\2\2+,\7k\2\2,-\7p\2\2-.\7v\2\2./\7g\2\2/\60\7t\2\2\60\61\7h\2\2\61"+
		"\62\7c\2\2\62\63\7e\2\2\63\64\7g\2\2\64\4\3\2\2\2\65\66\7f\2\2\66\67\7"+
		"g\2\2\678\7u\2\289\7e\2\29:\7t\2\2:;\7k\2\2;<\7r\2\2<=\7v\2\2=>\7k\2\2"+
		">?\7q\2\2?@\7p\2\2@\6\3\2\2\2AB\7k\2\2BC\7r\2\2C\b\3\2\2\2DE\7p\2\2EF"+
		"\7g\2\2FG\7i\2\2GH\7q\2\2HI\7v\2\2IJ\7k\2\2JK\7c\2\2KL\7v\2\2LM\7k\2\2"+
		"MN\7q\2\2NO\7p\2\2O\n\3\2\2\2PQ\7m\2\2QR\7k\2\2RS\7p\2\2ST\7f\2\2T\f\3"+
		"\2\2\2UV\7n\2\2VW\7q\2\2WX\7i\2\2XY\7/\2\2YZ\7p\2\2Z[\7g\2\2[\\\7k\2\2"+
		"\\]\7i\2\2]^\7j\2\2^_\7d\2\2_`\7q\2\2`a\7t\2\2ab\7/\2\2bc\7e\2\2cd\7j"+
		"\2\2de\7c\2\2ef\7p\2\2fg\7i\2\2gh\7g\2\2hi\7u\2\2i\16\3\2\2\2jk\7p\2\2"+
		"kl\7g\2\2lm\7k\2\2mn\7i\2\2no\7j\2\2op\7d\2\2pq\7q\2\2qr\7t\2\2r\20\3"+
		"\2\2\2st\7t\2\2tu\7g\2\2uv\7o\2\2vw\7q\2\2wx\7v\2\2xy\7g\2\2yz\7a\2\2"+
		"z{\7c\2\2{|\7u\2\2|\22\3\2\2\2}~\7t\2\2~\177\7q\2\2\177\u0080\7w\2\2\u0080"+
		"\u0081\7v\2\2\u0081\u0082\7g\2\2\u0082\u0083\7t\2\2\u0083\24\3\2\2\2\u0084"+
		"\u0085\7c\2\2\u0085\u0086\7w\2\2\u0086\u0087\7v\2\2\u0087\u0088\7q\2\2"+
		"\u0088\26\3\2\2\2\u0089\u008a\7h\2\2\u008a\u008b\7w\2\2\u008b\u008c\7"+
		"n\2\2\u008c\u008d\7n\2\2\u008d\u008e\7a\2\2\u008e\u008f\7f\2\2\u008f\u0090"+
		"\7w\2\2\u0090\u0091\7r\2\2\u0091\u0092\7n\2\2\u0092\u0093\7g\2\2\u0093"+
		"\u0094\7z\2\2\u0094\30\3\2\2\2\u0095\u0096\7j\2\2\u0096\u0097\7c\2\2\u0097"+
		"\u0098\7n\2\2\u0098\u0099\7h\2\2\u0099\u009a\7a\2\2\u009a\u009b\7f\2\2"+
		"\u009b\u009c\7w\2\2\u009c\u009d\7r\2\2\u009d\u009e\7n\2\2\u009e\u009f"+
		"\7g\2\2\u009f\u00a0\7z\2\2\u00a0\32\3\2\2\2\u00a1\u00a2\5!\21\2\u00a2"+
		"\u00a3\7\60\2\2\u00a3\u00a4\5!\21\2\u00a4\u00a5\7\60\2\2\u00a5\u00a6\5"+
		"!\21\2\u00a6\u00a7\7\60\2\2\u00a7\u00a8\5!\21\2\u00a8\34\3\2\2\2\u00a9"+
		"\u00ab\5\37\20\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3"+
		"\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\36\3\2\2\2\u00ae\u00af\t\2\2\2\u00af"+
		" \3\2\2\2\u00b0\u00b2\5#\22\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2"+
		"\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\"\3\2\2\2\u00b5\u00b6\t"+
		"\3\2\2\u00b6$\3\2\2\2\u00b7\u00b8\7}\2\2\u00b8&\3\2\2\2\u00b9\u00ba\7"+
		"\177\2\2\u00ba(\3\2\2\2\u00bb\u00bd\t\4\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c1\b\25\2\2\u00c1*\3\2\2\2\6\2\u00ac\u00b3\u00be\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}