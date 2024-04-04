// Generated from c:/Users/aleja/Desktop/DLP-2024/Compiler/specifications/Grammar.g4 by ANTLR 4.13.1

	import ast.*;
	import ast.expression.*;
	import ast.statement.*;
	import ast.definition.*;
	import ast.type.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(GrammarParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(GrammarParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#structField}.
	 * @param ctx the parse tree
	 */
	void enterStructField(GrammarParser.StructFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#structField}.
	 * @param ctx the parse tree
	 */
	void exitStructField(GrammarParser.StructFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(GrammarParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(GrammarParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
}