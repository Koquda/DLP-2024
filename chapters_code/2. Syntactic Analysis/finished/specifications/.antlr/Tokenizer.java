// Generated from c:/Users/aleja/Desktop/chapters_code/2. Syntactic Analysis/finished/specifications/Tokenizer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Tokenizer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT_LITERAL=1, FLOAT_LITERAL=2, IDENT=3, LINE_COMMENT=4, MULTILINE_COMMENT=5, 
		WHITESPACE=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT_LITERAL", "FLOAT_LITERAL", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", 
			"WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT_LITERAL", "FLOAT_LITERAL", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", 
			"WHITESPACE"
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


	public Tokenizer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tokenizer.g4"; }

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
		"\u0004\u0000\u0006G\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0001\u0000\u0004\u0000\u000f\b\u0000"+
		"\u000b\u0000\f\u0000\u0010\u0001\u0001\u0004\u0001\u0014\b\u0001\u000b"+
		"\u0001\f\u0001\u0015\u0001\u0001\u0001\u0001\u0004\u0001\u001a\b\u0001"+
		"\u000b\u0001\f\u0001\u001b\u0001\u0002\u0001\u0002\u0005\u0002 \b\u0002"+
		"\n\u0002\f\u0002#\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003)\b\u0003\n\u0003\f\u0003,\t\u0003\u0001\u0003\u0003\u0003"+
		"/\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u00047\b\u0004\n\u0004\f\u0004:\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005"+
		"B\b\u0005\u000b\u0005\f\u0005C\u0001\u0005\u0001\u0005\u0002*8\u0000\u0006"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\u0001"+
		"\u0000\u0005\u0001\u000009\u0002\u0000AZaz\u0004\u000009AZ__az\u0001\u0001"+
		"\n\n\u0003\u0000\t\n\r\r  M\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0001\u000e\u0001\u0000\u0000\u0000\u0003\u0013"+
		"\u0001\u0000\u0000\u0000\u0005\u001d\u0001\u0000\u0000\u0000\u0007$\u0001"+
		"\u0000\u0000\u0000\t2\u0001\u0000\u0000\u0000\u000bA\u0001\u0000\u0000"+
		"\u0000\r\u000f\u0007\u0000\u0000\u0000\u000e\r\u0001\u0000\u0000\u0000"+
		"\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u000e\u0001\u0000\u0000\u0000"+
		"\u0010\u0011\u0001\u0000\u0000\u0000\u0011\u0002\u0001\u0000\u0000\u0000"+
		"\u0012\u0014\u0007\u0000\u0000\u0000\u0013\u0012\u0001\u0000\u0000\u0000"+
		"\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000"+
		"\u0017\u0019\u0005.\u0000\u0000\u0018\u001a\u0007\u0000\u0000\u0000\u0019"+
		"\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b"+
		"\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c"+
		"\u0004\u0001\u0000\u0000\u0000\u001d!\u0007\u0001\u0000\u0000\u001e \u0007"+
		"\u0002\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000"+
		"\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0006"+
		"\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0005/\u0000\u0000"+
		"%&\u0005/\u0000\u0000&*\u0001\u0000\u0000\u0000\')\t\u0000\u0000\u0000"+
		"(\'\u0001\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000*(\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000"+
		"\u0000\u0000-/\u0007\u0003\u0000\u0000.-\u0001\u0000\u0000\u0000/0\u0001"+
		"\u0000\u0000\u000001\u0006\u0003\u0000\u00001\b\u0001\u0000\u0000\u0000"+
		"23\u0005/\u0000\u000034\u0005*\u0000\u000048\u0001\u0000\u0000\u00005"+
		"7\t\u0000\u0000\u000065\u0001\u0000\u0000\u00007:\u0001\u0000\u0000\u0000"+
		"89\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u00009;\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000;<\u0005*\u0000\u0000<=\u0005/\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000>?\u0006\u0004\u0000\u0000?\n\u0001\u0000\u0000"+
		"\u0000@B\u0007\u0004\u0000\u0000A@\u0001\u0000\u0000\u0000BC\u0001\u0000"+
		"\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EF\u0006\u0005\u0000\u0000F\f\u0001\u0000\u0000\u0000"+
		"\t\u0000\u0010\u0015\u001b!*.8C\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}