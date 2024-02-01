// Generated from src/parser/Lexicon.g4 by ANTLR 4.7.2
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
public class Lexicon extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LITENT=1, LITREAL=2, WHITESPACE=3, READ=4, PRINT=5, INT=6, FLOAT=7, IDENT=8, 
		ARITHMETIC=9, PCOMA=10, LINE_COMMENT=11, BLOCK_COMMENT=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LITENT", "LITREAL", "WHITESPACE", "READ", "PRINT", "INT", "FLOAT", "IDENT", 
			"ARITHMETIC", "PCOMA", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'read'", "'print'", "'int'", "'float'", null, 
			null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LITENT", "LITREAL", "WHITESPACE", "READ", "PRINT", "INT", "FLOAT", 
			"IDENT", "ARITHMETIC", "PCOMA", "LINE_COMMENT", "BLOCK_COMMENT"
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


	public Lexicon(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lexicon.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16i\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\6\2\35\n\2\r\2\16\2\36\3\3\3\3\3\3\3\3\3\4\6\4"+
		"&\n\4\r\4\16\4\'\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\7\tC\n\t\f\t\16\tF\13\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\7\fP\n\f\f\f\16\fS\13\f\3\f\3\f\3\f"+
		"\5\fX\n\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r`\n\r\f\r\16\rc\13\r\3\r\3\r\3\r"+
		"\3\r\3\r\4Qa\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\3\2\7\3\2\62;\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\5\2--//?"+
		"?\2n\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2"+
		"\2\2\2\31\3\2\2\2\3\34\3\2\2\2\5 \3\2\2\2\7%\3\2\2\2\t+\3\2\2\2\13\60"+
		"\3\2\2\2\r\66\3\2\2\2\17:\3\2\2\2\21@\3\2\2\2\23G\3\2\2\2\25I\3\2\2\2"+
		"\27K\3\2\2\2\31[\3\2\2\2\33\35\t\2\2\2\34\33\3\2\2\2\35\36\3\2\2\2\36"+
		"\34\3\2\2\2\36\37\3\2\2\2\37\4\3\2\2\2 !\5\3\2\2!\"\7\60\2\2\"#\5\3\2"+
		"\2#\6\3\2\2\2$&\t\3\2\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()\3"+
		"\2\2\2)*\b\4\2\2*\b\3\2\2\2+,\7t\2\2,-\7g\2\2-.\7c\2\2./\7f\2\2/\n\3\2"+
		"\2\2\60\61\7r\2\2\61\62\7t\2\2\62\63\7k\2\2\63\64\7p\2\2\64\65\7v\2\2"+
		"\65\f\3\2\2\2\66\67\7k\2\2\678\7p\2\289\7v\2\29\16\3\2\2\2:;\7h\2\2;<"+
		"\7n\2\2<=\7q\2\2=>\7c\2\2>?\7v\2\2?\20\3\2\2\2@D\t\4\2\2AC\t\5\2\2BA\3"+
		"\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\22\3\2\2\2FD\3\2\2\2GH\t\6\2\2H"+
		"\24\3\2\2\2IJ\7=\2\2J\26\3\2\2\2KL\7\61\2\2LM\7\61\2\2MQ\3\2\2\2NP\13"+
		"\2\2\2ON\3\2\2\2PS\3\2\2\2QR\3\2\2\2QO\3\2\2\2RW\3\2\2\2SQ\3\2\2\2TU\7"+
		"\61\2\2UX\7p\2\2VX\7\2\2\3WT\3\2\2\2WV\3\2\2\2XY\3\2\2\2YZ\b\f\2\2Z\30"+
		"\3\2\2\2[\\\7\61\2\2\\]\7,\2\2]a\3\2\2\2^`\13\2\2\2_^\3\2\2\2`c\3\2\2"+
		"\2ab\3\2\2\2a_\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\7,\2\2ef\7\61\2\2fg\3\2\2"+
		"\2gh\b\r\2\2h\32\3\2\2\2\t\2\36\'DQWa\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}