// Generated from c:/Users/aleja/Desktop/DLP-2024/Compiler/specifications/Grammar.g4 by ANTLR 4.13.1

	import ast.*;
	import ast.expression.*;
	import ast.statement.*;
	import ast.definition.*;
	import ast.type.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		IDENT=39, INT_LITERAL=40, REAL_LITERAL=41, CHAR_LITERAL=42, LINE_COMMENT=43, 
		MULTILINE_COMMENT=44, WHITESPACE=45;
	public static final int
		RULE_program = 0, RULE_definition = 1, RULE_structField = 2, RULE_param = 3, 
		RULE_statement = 4, RULE_expression = 5, RULE_type = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definition", "structField", "param", "statement", "expression", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "';'", "'struct'", "'{'", "'}'", "'('", "','", 
			"')'", "'='", "'if'", "'else'", "'while'", "'read'", "'print'", "'printsp'", 
			"'println'", "'return'", "'*'", "'/'", "'+'", "'-'", "'%'", "'<'", "'>'", 
			"'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'['", "']'", 
			"'.'", "'int'", "'float'", "'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "IDENT", "INT_LITERAL", "REAL_LITERAL", "CHAR_LITERAL", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionContext definition;
		public List<DefinitionContext> definitions = new ArrayList<DefinitionContext>();
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549755813906L) != 0)) {
				{
				{
				setState(14);
				((ProgramContext)_localctx).definition = definition();
				((ProgramContext)_localctx).definitions.add(((ProgramContext)_localctx).definition);
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
			match(EOF);
			 ((ProgramContext)_localctx).ast =  new Program(((ProgramContext)_localctx).definitions); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public Definition ast;
		public Type t;
		public Token IDENT;
		public TypeContext type;
		public StructFieldContext structField;
		public List<StructFieldContext> fields = new ArrayList<StructFieldContext>();
		public ParamContext param;
		public List<ParamContext> paramList = new ArrayList<ParamContext>();
		public DefinitionContext definition;
		public List<DefinitionContext> definitions = new ArrayList<DefinitionContext>();
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<StructFieldContext> structField() {
			return getRuleContexts(StructFieldContext.class);
		}
		public StructFieldContext structField(int i) {
			return getRuleContext(StructFieldContext.class,i);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		int _la;
		try {
			int _alt;
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				match(T__0);
				setState(24);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(25);
				match(T__1);
				setState(26);
				((DefinitionContext)_localctx).type = type();
				setState(27);
				match(T__2);
				 ((DefinitionContext)_localctx).ast =  new VarDefinition(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).type.ast); 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				match(T__3);
				setState(31);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(32);
				match(T__4);
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(33);
					((DefinitionContext)_localctx).structField = structField();
					((DefinitionContext)_localctx).fields.add(((DefinitionContext)_localctx).structField);
					}
					}
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(39);
				match(T__5);
				 ((DefinitionContext)_localctx).ast =  new StructDefinition(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).fields); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(42);
				match(T__6);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(43);
					((DefinitionContext)_localctx).param = param();
					((DefinitionContext)_localctx).paramList.add(((DefinitionContext)_localctx).param);
					setState(48);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(44);
						match(T__7);
						setState(45);
						((DefinitionContext)_localctx).param = param();
						((DefinitionContext)_localctx).paramList.add(((DefinitionContext)_localctx).param);
						}
						}
						setState(50);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(53);
				match(T__8);
				 ((DefinitionContext)_localctx).t =  new VoidType();
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(55);
					match(T__1);
					setState(56);
					((DefinitionContext)_localctx).type = type();
					 ((DefinitionContext)_localctx).t =  ((DefinitionContext)_localctx).type.ast;
					}
				}

				setState(61);
				match(T__4);
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(62);
						((DefinitionContext)_localctx).definition = definition();
						((DefinitionContext)_localctx).definitions.add(((DefinitionContext)_localctx).definition);
						}
						} 
					}
					setState(67);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8250649471104L) != 0)) {
					{
					{
					setState(68);
					((DefinitionContext)_localctx).statement = statement();
					((DefinitionContext)_localctx).statements.add(((DefinitionContext)_localctx).statement);
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(74);
				match(T__5);

						 	((DefinitionContext)_localctx).ast =  new FunctionDefinition(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).paramList, _localctx.t, ((DefinitionContext)_localctx).definitions, ((DefinitionContext)_localctx).statements); 
						
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructFieldContext extends ParserRuleContext {
		public StructField ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_structField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			((StructFieldContext)_localctx).IDENT = match(IDENT);
			setState(79);
			match(T__1);
			setState(80);
			((StructFieldContext)_localctx).type = type();
			setState(81);
			match(T__2);
			 ((StructFieldContext)_localctx).ast =  new StructField(((StructFieldContext)_localctx).IDENT, ((StructFieldContext)_localctx).type.ast); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public VarDefinition ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			((ParamContext)_localctx).IDENT = match(IDENT);
			setState(85);
			match(T__1);
			setState(86);
			((ParamContext)_localctx).type = type();
			 ((ParamContext)_localctx).ast =  new VarDefinition(((ParamContext)_localctx).IDENT, ((ParamContext)_localctx).type.ast); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext left;
		public ExpressionContext right;
		public Token IDENT;
		public ExpressionContext expression;
		public List<ExpressionContext> expressions = new ArrayList<ExpressionContext>();
		public StatementContext statement;
		public List<StatementContext> ifBody = new ArrayList<StatementContext>();
		public List<StatementContext> elseBody = new ArrayList<StatementContext>();
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				((StatementContext)_localctx).left = expression(0);
				setState(90);
				match(T__9);
				setState(91);
				((StatementContext)_localctx).right = expression(0);
				setState(92);
				match(T__2);
				 ((StatementContext)_localctx).ast =  new Assignment(((StatementContext)_localctx).left.ast, ((StatementContext)_localctx).right.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				((StatementContext)_localctx).IDENT = match(IDENT);
				setState(96);
				match(T__6);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8250648952960L) != 0)) {
					{
					setState(97);
					((StatementContext)_localctx).expression = expression(0);
					((StatementContext)_localctx).expressions.add(((StatementContext)_localctx).expression);
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(98);
						match(T__7);
						setState(99);
						((StatementContext)_localctx).expression = expression(0);
						((StatementContext)_localctx).expressions.add(((StatementContext)_localctx).expression);
						}
						}
						setState(104);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(107);
				match(T__8);
				setState(108);
				match(T__2);
				 ((StatementContext)_localctx).ast =  new FunctionCallStatement(((StatementContext)_localctx).IDENT, ((StatementContext)_localctx).expressions); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				match(T__10);
				setState(111);
				match(T__6);
				setState(112);
				((StatementContext)_localctx).expression = expression(0);
				setState(113);
				match(T__8);
				setState(114);
				match(T__4);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8250649471104L) != 0)) {
					{
					{
					setState(115);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).ifBody.add(((StatementContext)_localctx).statement);
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121);
				match(T__5);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(122);
					match(T__11);
					setState(123);
					match(T__4);
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8250649471104L) != 0)) {
						{
						{
						setState(124);
						((StatementContext)_localctx).statement = statement();
						((StatementContext)_localctx).elseBody.add(((StatementContext)_localctx).statement);
						}
						}
						setState(129);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(130);
					match(T__5);
					}
				}

				 ((StatementContext)_localctx).ast =  new If(((StatementContext)_localctx).expression.ast, ((StatementContext)_localctx).ifBody, ((StatementContext)_localctx).elseBody); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				match(T__12);
				setState(136);
				match(T__6);
				setState(137);
				((StatementContext)_localctx).expression = expression(0);
				setState(138);
				match(T__8);
				setState(139);
				match(T__4);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8250649471104L) != 0)) {
					{
					{
					setState(140);
					((StatementContext)_localctx).statement = statement();
					((StatementContext)_localctx).statements.add(((StatementContext)_localctx).statement);
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
				match(T__5);
				 ((StatementContext)_localctx).ast =  new While(((StatementContext)_localctx).expression.ast, ((StatementContext)_localctx).statements); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				match(T__13);
				setState(150);
				((StatementContext)_localctx).expression = expression(0);
				setState(151);
				match(T__2);
				 ((StatementContext)_localctx).ast =  new Read(((StatementContext)_localctx).expression.ast); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(154);
				match(T__14);
				setState(155);
				((StatementContext)_localctx).expression = expression(0);
				((StatementContext)_localctx).expressions.add(((StatementContext)_localctx).expression);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(156);
					match(T__7);
					setState(157);
					((StatementContext)_localctx).expression = expression(0);
					((StatementContext)_localctx).expressions.add(((StatementContext)_localctx).expression);
					}
					}
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(163);
				match(T__2);
				 ((StatementContext)_localctx).ast =  new Print(((StatementContext)_localctx).expressions, ""); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(166);
				match(T__15);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8250648952960L) != 0)) {
					{
					setState(167);
					((StatementContext)_localctx).expression = expression(0);
					((StatementContext)_localctx).expressions.add(((StatementContext)_localctx).expression);
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(168);
						match(T__7);
						setState(169);
						((StatementContext)_localctx).expression = expression(0);
						((StatementContext)_localctx).expressions.add(((StatementContext)_localctx).expression);
						}
						}
						setState(174);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(177);
				match(T__2);
				 ((StatementContext)_localctx).ast =  new Print(((StatementContext)_localctx).expressions, "sp"); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(179);
				match(T__16);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8250648952960L) != 0)) {
					{
					setState(180);
					((StatementContext)_localctx).expression = expression(0);
					((StatementContext)_localctx).expressions.add(((StatementContext)_localctx).expression);
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(181);
						match(T__7);
						setState(182);
						((StatementContext)_localctx).expression = expression(0);
						((StatementContext)_localctx).expressions.add(((StatementContext)_localctx).expression);
						}
						}
						setState(187);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(190);
				match(T__2);
				 ((StatementContext)_localctx).ast =  new Print(((StatementContext)_localctx).expressions, "ln"); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(192);
				match(T__17);
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8250648952960L) != 0)) {
					{
					setState(193);
					((StatementContext)_localctx).expression = expression(0);
					}
				}

				setState(196);
				match(T__2);
				 ((StatementContext)_localctx).ast =  new Return(((StatementContext)_localctx).expression != null ? ((StatementContext)_localctx).expression.ast : null); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext left;
		public Token INT_LITERAL;
		public Token REAL_LITERAL;
		public Token CHAR_LITERAL;
		public Token IDENT;
		public ExpressionContext expression;
		public List<ExpressionContext> expressions = new ArrayList<ExpressionContext>();
		public TypeContext type;
		public Token op;
		public ExpressionContext right;
		public TerminalNode INT_LITERAL() { return getToken(GrammarParser.INT_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(GrammarParser.REAL_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(GrammarParser.CHAR_LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(201);
				((ExpressionContext)_localctx).INT_LITERAL = match(INT_LITERAL);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_LITERAL); 
				}
				break;
			case 2:
				{
				setState(203);
				((ExpressionContext)_localctx).REAL_LITERAL = match(REAL_LITERAL);
				 ((ExpressionContext)_localctx).ast =  new FloatLiteral(((ExpressionContext)_localctx).REAL_LITERAL); 
				}
				break;
			case 3:
				{
				setState(205);
				((ExpressionContext)_localctx).CHAR_LITERAL = match(CHAR_LITERAL);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_LITERAL); 
				}
				break;
			case 4:
				{
				setState(207);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).IDENT); 
				}
				break;
			case 5:
				{
				setState(209);
				match(T__6);
				setState(210);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(211);
				match(T__8);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).expression.ast; 
				}
				break;
			case 6:
				{
				setState(214);
				match(T__31);
				setState(215);
				((ExpressionContext)_localctx).expression = expression(5);
				 ((ExpressionContext)_localctx).ast =  new Negation(((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 7:
				{
				setState(218);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				setState(219);
				match(T__6);
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8250648952960L) != 0)) {
					{
					setState(220);
					((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
					((ExpressionContext)_localctx).expressions.add(((ExpressionContext)_localctx).expression);
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(221);
						match(T__7);
						setState(222);
						((ExpressionContext)_localctx).expression = ((ExpressionContext)_localctx).expression = expression(0);
						((ExpressionContext)_localctx).expressions.add(((ExpressionContext)_localctx).expression);
						}
						}
						setState(227);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(230);
				match(T__8);
				 ((ExpressionContext)_localctx).ast =  new FunctionCallExpression(((ExpressionContext)_localctx).IDENT, ((ExpressionContext)_localctx).expressions); 
				}
				break;
			case 8:
				{
				setState(232);
				match(T__23);
				setState(233);
				((ExpressionContext)_localctx).type = type();
				setState(234);
				match(T__24);
				setState(235);
				match(T__6);
				setState(236);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(237);
				match(T__8);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).type.ast, ((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(277);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(242);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(243);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(244);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(11);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(248);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(10);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(253);
						((ExpressionContext)_localctx).op = match(T__22);
						setState(254);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(9);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(258);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1056964608L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(259);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(8);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticComparison(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(263);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(264);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(7);
						 ((ExpressionContext)_localctx).ast =  new LogicalComparison(((ExpressionContext)_localctx).left.ast, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(268);
						match(T__32);
						setState(269);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(0);
						setState(270);
						match(T__33);
						 ((ExpressionContext)_localctx).ast =  new ArrayAccess(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(273);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(274);
						match(T__34);
						setState(275);
						((ExpressionContext)_localctx).IDENT = match(IDENT);
						 ((ExpressionContext)_localctx).ast =  new StructAccess(((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).IDENT); 
						}
						break;
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token INT_LITERAL;
		public TypeContext type;
		public Token IDENT;
		public TerminalNode INT_LITERAL() { return getToken(GrammarParser.INT_LITERAL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				match(T__35);
				 ((TypeContext)_localctx).ast =  new IntType(); 
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				match(T__36);
				 ((TypeContext)_localctx).ast =  new FloatType(); 
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				match(T__37);
				 ((TypeContext)_localctx).ast =  new CharType(); 
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 4);
				{
				setState(288);
				match(T__32);
				setState(289);
				((TypeContext)_localctx).INT_LITERAL = match(INT_LITERAL);
				setState(290);
				match(T__33);
				setState(291);
				((TypeContext)_localctx).type = type();
				 ((TypeContext)_localctx).ast =  new ArrayType(((TypeContext)_localctx).INT_LITERAL, ((TypeContext)_localctx).type.ast); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(294);
				((TypeContext)_localctx).IDENT = match(IDENT);
				 ((TypeContext)_localctx).ast =  new StructType(((TypeContext)_localctx).IDENT); 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u012b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0005\u0000\u0010"+
		"\b\u0000\n\u0000\f\u0000\u0013\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"#\b\u0001\n\u0001\f\u0001&\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001/\b\u0001"+
		"\n\u0001\f\u00012\t\u0001\u0003\u00014\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001<\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001@\b\u0001\n\u0001\f\u0001C\t\u0001"+
		"\u0001\u0001\u0005\u0001F\b\u0001\n\u0001\f\u0001I\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001M\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004e\b\u0004\n\u0004\f\u0004h\t\u0004\u0003\u0004"+
		"j\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004u\b\u0004"+
		"\n\u0004\f\u0004x\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004~\b\u0004\n\u0004\f\u0004\u0081\t\u0004\u0001\u0004\u0003"+
		"\u0004\u0084\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u008e\b\u0004\n"+
		"\u0004\f\u0004\u0091\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u009f\b\u0004\n\u0004\f\u0004"+
		"\u00a2\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004\u00ab\b\u0004\n\u0004\f\u0004\u00ae"+
		"\t\u0004\u0003\u0004\u00b0\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00b8\b\u0004\n\u0004"+
		"\f\u0004\u00bb\t\u0004\u0003\u0004\u00bd\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u00c3\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00c7\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u00e0\b\u0005\n\u0005\f\u0005\u00e3\t\u0005\u0003"+
		"\u0005\u00e5\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u00f1\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u0116\b\u0005\n\u0005\f\u0005\u0119\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u0129\b\u0006\u0001\u0006\u0000\u0001\n\u0007"+
		"\u0000\u0002\u0004\u0006\b\n\f\u0000\u0004\u0001\u0000\u0013\u0014\u0001"+
		"\u0000\u0015\u0016\u0001\u0000\u0018\u001d\u0001\u0000\u001e\u001f\u0154"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0002L\u0001\u0000\u0000\u0000\u0004"+
		"N\u0001\u0000\u0000\u0000\u0006T\u0001\u0000\u0000\u0000\b\u00c6\u0001"+
		"\u0000\u0000\u0000\n\u00f0\u0001\u0000\u0000\u0000\f\u0128\u0001\u0000"+
		"\u0000\u0000\u000e\u0010\u0003\u0002\u0001\u0000\u000f\u000e\u0001\u0000"+
		"\u0000\u0000\u0010\u0013\u0001\u0000\u0000\u0000\u0011\u000f\u0001\u0000"+
		"\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0014\u0001\u0000"+
		"\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0000"+
		"\u0000\u0001\u0015\u0016\u0006\u0000\uffff\uffff\u0000\u0016\u0001\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0005\u0001\u0000\u0000\u0018\u0019\u0005"+
		"\'\u0000\u0000\u0019\u001a\u0005\u0002\u0000\u0000\u001a\u001b\u0003\f"+
		"\u0006\u0000\u001b\u001c\u0005\u0003\u0000\u0000\u001c\u001d\u0006\u0001"+
		"\uffff\uffff\u0000\u001dM\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0004"+
		"\u0000\u0000\u001f \u0005\'\u0000\u0000 $\u0005\u0005\u0000\u0000!#\u0003"+
		"\u0004\u0002\u0000\"!\u0001\u0000\u0000\u0000#&\u0001\u0000\u0000\u0000"+
		"$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000"+
		"\u0000&$\u0001\u0000\u0000\u0000\'(\u0005\u0006\u0000\u0000(M\u0006\u0001"+
		"\uffff\uffff\u0000)*\u0005\'\u0000\u0000*3\u0005\u0007\u0000\u0000+0\u0003"+
		"\u0006\u0003\u0000,-\u0005\b\u0000\u0000-/\u0003\u0006\u0003\u0000.,\u0001"+
		"\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000"+
		"01\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u00003+\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u000056\u0005\t\u0000\u00006;\u0006\u0001\uffff\uffff\u000078\u0005"+
		"\u0002\u0000\u000089\u0003\f\u0006\u00009:\u0006\u0001\uffff\uffff\u0000"+
		":<\u0001\u0000\u0000\u0000;7\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=A\u0005\u0005\u0000\u0000>@\u0003\u0002"+
		"\u0001\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BG\u0001\u0000\u0000\u0000"+
		"CA\u0001\u0000\u0000\u0000DF\u0003\b\u0004\u0000ED\u0001\u0000\u0000\u0000"+
		"FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000"+
		"\u0000HJ\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0005\u0006"+
		"\u0000\u0000KM\u0006\u0001\uffff\uffff\u0000L\u0017\u0001\u0000\u0000"+
		"\u0000L\u001e\u0001\u0000\u0000\u0000L)\u0001\u0000\u0000\u0000M\u0003"+
		"\u0001\u0000\u0000\u0000NO\u0005\'\u0000\u0000OP\u0005\u0002\u0000\u0000"+
		"PQ\u0003\f\u0006\u0000QR\u0005\u0003\u0000\u0000RS\u0006\u0002\uffff\uffff"+
		"\u0000S\u0005\u0001\u0000\u0000\u0000TU\u0005\'\u0000\u0000UV\u0005\u0002"+
		"\u0000\u0000VW\u0003\f\u0006\u0000WX\u0006\u0003\uffff\uffff\u0000X\u0007"+
		"\u0001\u0000\u0000\u0000YZ\u0003\n\u0005\u0000Z[\u0005\n\u0000\u0000["+
		"\\\u0003\n\u0005\u0000\\]\u0005\u0003\u0000\u0000]^\u0006\u0004\uffff"+
		"\uffff\u0000^\u00c7\u0001\u0000\u0000\u0000_`\u0005\'\u0000\u0000`i\u0005"+
		"\u0007\u0000\u0000af\u0003\n\u0005\u0000bc\u0005\b\u0000\u0000ce\u0003"+
		"\n\u0005\u0000db\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000"+
		"hf\u0001\u0000\u0000\u0000ia\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000kl\u0005\t\u0000\u0000lm\u0005\u0003\u0000"+
		"\u0000m\u00c7\u0006\u0004\uffff\uffff\u0000no\u0005\u000b\u0000\u0000"+
		"op\u0005\u0007\u0000\u0000pq\u0003\n\u0005\u0000qr\u0005\t\u0000\u0000"+
		"rv\u0005\u0005\u0000\u0000su\u0003\b\u0004\u0000ts\u0001\u0000\u0000\u0000"+
		"ux\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wy\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000y\u0083\u0005"+
		"\u0006\u0000\u0000z{\u0005\f\u0000\u0000{\u007f\u0005\u0005\u0000\u0000"+
		"|~\u0003\b\u0004\u0000}|\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000"+
		"\u0080\u0082\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000"+
		"\u0082\u0084\u0005\u0006\u0000\u0000\u0083z\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0006\u0004\uffff\uffff\u0000\u0086\u00c7\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0005\r\u0000\u0000\u0088\u0089\u0005\u0007\u0000\u0000\u0089"+
		"\u008a\u0003\n\u0005\u0000\u008a\u008b\u0005\t\u0000\u0000\u008b\u008f"+
		"\u0005\u0005\u0000\u0000\u008c\u008e\u0003\b\u0004\u0000\u008d\u008c\u0001"+
		"\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0092\u0001"+
		"\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0093\u0005"+
		"\u0006\u0000\u0000\u0093\u0094\u0006\u0004\uffff\uffff\u0000\u0094\u00c7"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u000e\u0000\u0000\u0096\u0097"+
		"\u0003\n\u0005\u0000\u0097\u0098\u0005\u0003\u0000\u0000\u0098\u0099\u0006"+
		"\u0004\uffff\uffff\u0000\u0099\u00c7\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0005\u000f\u0000\u0000\u009b\u00a0\u0003\n\u0005\u0000\u009c\u009d\u0005"+
		"\b\u0000\u0000\u009d\u009f\u0003\n\u0005\u0000\u009e\u009c\u0001\u0000"+
		"\u0000\u0000\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0003"+
		"\u0000\u0000\u00a4\u00a5\u0006\u0004\uffff\uffff\u0000\u00a5\u00c7\u0001"+
		"\u0000\u0000\u0000\u00a6\u00af\u0005\u0010\u0000\u0000\u00a7\u00ac\u0003"+
		"\n\u0005\u0000\u00a8\u00a9\u0005\b\u0000\u0000\u00a9\u00ab\u0003\n\u0005"+
		"\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000"+
		"\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000"+
		"\u0000\u00af\u00a7\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u0003\u0000"+
		"\u0000\u00b2\u00c7\u0006\u0004\uffff\uffff\u0000\u00b3\u00bc\u0005\u0011"+
		"\u0000\u0000\u00b4\u00b9\u0003\n\u0005\u0000\u00b5\u00b6\u0005\b\u0000"+
		"\u0000\u00b6\u00b8\u0003\n\u0005\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00b4\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000"+
		"\u00be\u00bf\u0005\u0003\u0000\u0000\u00bf\u00c7\u0006\u0004\uffff\uffff"+
		"\u0000\u00c0\u00c2\u0005\u0012\u0000\u0000\u00c1\u00c3\u0003\n\u0005\u0000"+
		"\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0003\u0000\u0000"+
		"\u00c5\u00c7\u0006\u0004\uffff\uffff\u0000\u00c6Y\u0001\u0000\u0000\u0000"+
		"\u00c6_\u0001\u0000\u0000\u0000\u00c6n\u0001\u0000\u0000\u0000\u00c6\u0087"+
		"\u0001\u0000\u0000\u0000\u00c6\u0095\u0001\u0000\u0000\u0000\u00c6\u009a"+
		"\u0001\u0000\u0000\u0000\u00c6\u00a6\u0001\u0000\u0000\u0000\u00c6\u00b3"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c0\u0001\u0000\u0000\u0000\u00c7\t\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u0006\u0005\uffff\uffff\u0000\u00c9\u00ca"+
		"\u0005(\u0000\u0000\u00ca\u00f1\u0006\u0005\uffff\uffff\u0000\u00cb\u00cc"+
		"\u0005)\u0000\u0000\u00cc\u00f1\u0006\u0005\uffff\uffff\u0000\u00cd\u00ce"+
		"\u0005*\u0000\u0000\u00ce\u00f1\u0006\u0005\uffff\uffff\u0000\u00cf\u00d0"+
		"\u0005\'\u0000\u0000\u00d0\u00f1\u0006\u0005\uffff\uffff\u0000\u00d1\u00d2"+
		"\u0005\u0007\u0000\u0000\u00d2\u00d3\u0003\n\u0005\u0000\u00d3\u00d4\u0005"+
		"\t\u0000\u0000\u00d4\u00d5\u0006\u0005\uffff\uffff\u0000\u00d5\u00f1\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0005 \u0000\u0000\u00d7\u00d8\u0003\n"+
		"\u0005\u0005\u00d8\u00d9\u0006\u0005\uffff\uffff\u0000\u00d9\u00f1\u0001"+
		"\u0000\u0000\u0000\u00da\u00db\u0005\'\u0000\u0000\u00db\u00e4\u0005\u0007"+
		"\u0000\u0000\u00dc\u00e1\u0003\n\u0005\u0000\u00dd\u00de\u0005\b\u0000"+
		"\u0000\u00de\u00e0\u0003\n\u0005\u0000\u00df\u00dd\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00dc\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0005\t\u0000\u0000\u00e7\u00f1\u0006\u0005\uffff\uffff\u0000"+
		"\u00e8\u00e9\u0005\u0018\u0000\u0000\u00e9\u00ea\u0003\f\u0006\u0000\u00ea"+
		"\u00eb\u0005\u0019\u0000\u0000\u00eb\u00ec\u0005\u0007\u0000\u0000\u00ec"+
		"\u00ed\u0003\n\u0005\u0000\u00ed\u00ee\u0005\t\u0000\u0000\u00ee\u00ef"+
		"\u0006\u0005\uffff\uffff\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0"+
		"\u00c8\u0001\u0000\u0000\u0000\u00f0\u00cb\u0001\u0000\u0000\u0000\u00f0"+
		"\u00cd\u0001\u0000\u0000\u0000\u00f0\u00cf\u0001\u0000\u0000\u0000\u00f0"+
		"\u00d1\u0001\u0000\u0000\u0000\u00f0\u00d6\u0001\u0000\u0000\u0000\u00f0"+
		"\u00da\u0001\u0000\u0000\u0000\u00f0\u00e8\u0001\u0000\u0000\u0000\u00f1"+
		"\u0117\u0001\u0000\u0000\u0000\u00f2\u00f3\n\n\u0000\u0000\u00f3\u00f4"+
		"\u0007\u0000\u0000\u0000\u00f4\u00f5\u0003\n\u0005\u000b\u00f5\u00f6\u0006"+
		"\u0005\uffff\uffff\u0000\u00f6\u0116\u0001\u0000\u0000\u0000\u00f7\u00f8"+
		"\n\t\u0000\u0000\u00f8\u00f9\u0007\u0001\u0000\u0000\u00f9\u00fa\u0003"+
		"\n\u0005\n\u00fa\u00fb\u0006\u0005\uffff\uffff\u0000\u00fb\u0116\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\n\b\u0000\u0000\u00fd\u00fe\u0005\u0017"+
		"\u0000\u0000\u00fe\u00ff\u0003\n\u0005\t\u00ff\u0100\u0006\u0005\uffff"+
		"\uffff\u0000\u0100\u0116\u0001\u0000\u0000\u0000\u0101\u0102\n\u0007\u0000"+
		"\u0000\u0102\u0103\u0007\u0002\u0000\u0000\u0103\u0104\u0003\n\u0005\b"+
		"\u0104\u0105\u0006\u0005\uffff\uffff\u0000\u0105\u0116\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\n\u0006\u0000\u0000\u0107\u0108\u0007\u0003\u0000\u0000"+
		"\u0108\u0109\u0003\n\u0005\u0007\u0109\u010a\u0006\u0005\uffff\uffff\u0000"+
		"\u010a\u0116\u0001\u0000\u0000\u0000\u010b\u010c\n\u0003\u0000\u0000\u010c"+
		"\u010d\u0005!\u0000\u0000\u010d\u010e\u0003\n\u0005\u0000\u010e\u010f"+
		"\u0005\"\u0000\u0000\u010f\u0110\u0006\u0005\uffff\uffff\u0000\u0110\u0116"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\n\u0002\u0000\u0000\u0112\u0113\u0005"+
		"#\u0000\u0000\u0113\u0114\u0005\'\u0000\u0000\u0114\u0116\u0006\u0005"+
		"\uffff\uffff\u0000\u0115\u00f2\u0001\u0000\u0000\u0000\u0115\u00f7\u0001"+
		"\u0000\u0000\u0000\u0115\u00fc\u0001\u0000\u0000\u0000\u0115\u0101\u0001"+
		"\u0000\u0000\u0000\u0115\u0106\u0001\u0000\u0000\u0000\u0115\u010b\u0001"+
		"\u0000\u0000\u0000\u0115\u0111\u0001\u0000\u0000\u0000\u0116\u0119\u0001"+
		"\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001"+
		"\u0000\u0000\u0000\u0118\u000b\u0001\u0000\u0000\u0000\u0119\u0117\u0001"+
		"\u0000\u0000\u0000\u011a\u011b\u0005$\u0000\u0000\u011b\u0129\u0006\u0006"+
		"\uffff\uffff\u0000\u011c\u011d\u0005%\u0000\u0000\u011d\u0129\u0006\u0006"+
		"\uffff\uffff\u0000\u011e\u011f\u0005&\u0000\u0000\u011f\u0129\u0006\u0006"+
		"\uffff\uffff\u0000\u0120\u0121\u0005!\u0000\u0000\u0121\u0122\u0005(\u0000"+
		"\u0000\u0122\u0123\u0005\"\u0000\u0000\u0123\u0124\u0003\f\u0006\u0000"+
		"\u0124\u0125\u0006\u0006\uffff\uffff\u0000\u0125\u0129\u0001\u0000\u0000"+
		"\u0000\u0126\u0127\u0005\'\u0000\u0000\u0127\u0129\u0006\u0006\uffff\uffff"+
		"\u0000\u0128\u011a\u0001\u0000\u0000\u0000\u0128\u011c\u0001\u0000\u0000"+
		"\u0000\u0128\u011e\u0001\u0000\u0000\u0000\u0128\u0120\u0001\u0000\u0000"+
		"\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129\r\u0001\u0000\u0000\u0000"+
		"\u001b\u0011$03;AGLfiv\u007f\u0083\u008f\u00a0\u00ac\u00af\u00b9\u00bc"+
		"\u00c2\u00c6\u00e1\u00e4\u00f0\u0115\u0117\u0128";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}