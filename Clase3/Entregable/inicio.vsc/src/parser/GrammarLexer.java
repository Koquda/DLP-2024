// Generated from src/parser/Grammar.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, LITENT=19, LITREAL=20, COMMENT=21, REAL=22, INT=23, IDENT=24, 
		WS=25;
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
			"T__17", "LITENT", "LITREAL", "COMMENT", "REAL", "INT", "IDENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'DATA'", "'CODE'", "';'", "'+'", "'('", "')'", "'<'", "'>('", 
			"'if ('", "'{'", "'}'", "'else'", "'while ('", "'!='", "'read '", "'print '", 
			"'='", "','", null, null, null, "'real'", "'int'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "LITENT", "LITREAL", "COMMENT", 
			"REAL", "INT", "IDENT", "WS"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00ab\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\6\24x\n\24\r\24\16\24y\3\25\6\25}\n\25"+
		"\r\25\16\25~\3\25\3\25\6\25\u0083\n\25\r\25\16\25\u0084\3\26\3\26\3\26"+
		"\3\26\7\26\u008b\n\26\f\26\16\26\u008e\13\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\7\31\u00a0\n\31"+
		"\f\31\16\31\u00a3\13\31\3\32\6\32\u00a6\n\32\r\32\16\32\u00a7\3\32\3\32"+
		"\3\u008c\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\6"+
		"\3\2\62;\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00b0\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5:\3\2\2\2\7?\3\2\2\2\tA\3\2\2\2\13C\3"+
		"\2\2\2\rE\3\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23L\3\2\2\2\25Q\3\2\2\2\27S"+
		"\3\2\2\2\31U\3\2\2\2\33Z\3\2\2\2\35b\3\2\2\2\37e\3\2\2\2!k\3\2\2\2#r\3"+
		"\2\2\2%t\3\2\2\2\'w\3\2\2\2)|\3\2\2\2+\u0086\3\2\2\2-\u0094\3\2\2\2/\u0099"+
		"\3\2\2\2\61\u009d\3\2\2\2\63\u00a5\3\2\2\2\65\66\7F\2\2\66\67\7C\2\2\67"+
		"8\7V\2\289\7C\2\29\4\3\2\2\2:;\7E\2\2;<\7Q\2\2<=\7F\2\2=>\7G\2\2>\6\3"+
		"\2\2\2?@\7=\2\2@\b\3\2\2\2AB\7-\2\2B\n\3\2\2\2CD\7*\2\2D\f\3\2\2\2EF\7"+
		"+\2\2F\16\3\2\2\2GH\7>\2\2H\20\3\2\2\2IJ\7@\2\2JK\7*\2\2K\22\3\2\2\2L"+
		"M\7k\2\2MN\7h\2\2NO\7\"\2\2OP\7*\2\2P\24\3\2\2\2QR\7}\2\2R\26\3\2\2\2"+
		"ST\7\177\2\2T\30\3\2\2\2UV\7g\2\2VW\7n\2\2WX\7u\2\2XY\7g\2\2Y\32\3\2\2"+
		"\2Z[\7y\2\2[\\\7j\2\2\\]\7k\2\2]^\7n\2\2^_\7g\2\2_`\7\"\2\2`a\7*\2\2a"+
		"\34\3\2\2\2bc\7#\2\2cd\7?\2\2d\36\3\2\2\2ef\7t\2\2fg\7g\2\2gh\7c\2\2h"+
		"i\7f\2\2ij\7\"\2\2j \3\2\2\2kl\7r\2\2lm\7t\2\2mn\7k\2\2no\7p\2\2op\7v"+
		"\2\2pq\7\"\2\2q\"\3\2\2\2rs\7?\2\2s$\3\2\2\2tu\7.\2\2u&\3\2\2\2vx\t\2"+
		"\2\2wv\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z(\3\2\2\2{}\t\2\2\2|{\3\2"+
		"\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\7"+
		"\60\2\2\u0081\u0083\t\2\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085*\3\2\2\2\u0086\u0087\7\61\2\2"+
		"\u0087\u0088\7,\2\2\u0088\u008c\3\2\2\2\u0089\u008b\13\2\2\2\u008a\u0089"+
		"\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7,\2\2\u0090\u0091\7\61"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\26\2\2\u0093,\3\2\2\2\u0094\u0095"+
		"\7t\2\2\u0095\u0096\7g\2\2\u0096\u0097\7c\2\2\u0097\u0098\7n\2\2\u0098"+
		".\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7p\2\2\u009b\u009c\7v\2\2\u009c"+
		"\60\3\2\2\2\u009d\u00a1\t\3\2\2\u009e\u00a0\t\4\2\2\u009f\u009e\3\2\2"+
		"\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\62"+
		"\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\t\5\2\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\u00aa\b\32\2\2\u00aa\64\3\2\2\2\t\2y~\u0084\u008c\u00a1\u00a7"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}