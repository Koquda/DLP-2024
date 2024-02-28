// Generated with VGen 2.0.0

/**
* El objetivo de esta clase DefaultVisitor es ser la implementación base de la que
* deriven todos los demás visitor.
*
* Sus métodos visit recorren los hijos del nodo que se está visitando. Por tanto,
* todo visitor que derive de este ya tendrá implementado todo el código de
* recorrido del AST.
*
* Para crear nuevos visitor, en vez de modificar esta clase, se recomienda copiar
* 'SkeletonForNewVisitors.java' o, mejor aún, definir una nueva PHASE en la gramática
* y usar el visitor generado para la misma.
*/

package visitor;

import ast.*;
import ast.definition.*;
import ast.statement.*;
import ast.expression.*;
import ast.type.*;




public class DefaultVisitor implements Visitor {
	@Override
	public Object visit(Program program, Object param) {

		program.getDefinitions().forEach(definition -> definition.accept(this, param));
		return null;
	}

	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

		varDefinition.getType().accept(this, param);
		return null;
	}

	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

		structDefinition.getStructFields().forEach(structField -> structField.accept(this, param));
		return null;
	}

	@Override
	public Object visit(FuncDefinition funcDefinition, Object param) {

		funcDefinition.getFuncParams().forEach(funcParam -> funcParam.accept(this, param));
		funcDefinition.getType().accept(this, param);
		funcDefinition.getDefinitions().forEach(definition -> definition.accept(this, param));
		funcDefinition.getStatements().forEach(statement -> statement.accept(this, param));
		return null;
	}

	@Override
	public Object visit(StructField structField, Object param) {

		structField.getType().accept(this, param);
		return null;
	}

	@Override
	public Object visit(FuncParam funcParam, Object param) {

		funcParam.getType().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Assignment assignment, Object param) {

		assignment.getLeft().accept(this, param);
		assignment.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(FuncCallStatement funcCallStatement, Object param) {

		funcCallStatement.getExpressions().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(If ifValue, Object param) {

		ifValue.getExpression().accept(this, param);
		ifValue.getIfBody().forEach(statement -> statement.accept(this, param));
		ifValue.getElseBody().forEach(statement -> statement.accept(this, param));
		return null;
	}

	@Override
	public Object visit(While whileValue, Object param) {

		whileValue.getExpression().accept(this, param);
		whileValue.getStatements().forEach(statement -> statement.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Read read, Object param) {

		read.getExpression().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Print print, Object param) {

		print.getExpression().ifPresent(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(Return returnValue, Object param) {

		returnValue.getExpression().ifPresent(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		return null;
	}

	@Override
	public Object visit(FloatLiteral floatLiteral, Object param) {

		return null;
	}

	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

		return null;
	}

	@Override
	public Object visit(Variable variable, Object param) {

		return null;
	}

	@Override
	public Object visit(Arithmetic arithmetic, Object param) {

		arithmetic.getLeft().accept(this, param);
		arithmetic.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ArithmeticComparison arithmeticComparison, Object param) {

		arithmeticComparison.getLeft().accept(this, param);
		arithmeticComparison.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(LogicalComparison logicalComparison, Object param) {

		logicalComparison.getLeft().accept(this, param);
		logicalComparison.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Negation negation, Object param) {

		negation.getExpression().accept(this, param);
		return null;
	}

	@Override
	public Object visit(FuncCallExpression funcCallExpression, Object param) {

		funcCallExpression.getExpressions().forEach(expression -> expression.accept(this, param));
		return null;
	}

	@Override
	public Object visit(StructAccess structAccess, Object param) {

		structAccess.getExpression().accept(this, param);
		return null;
	}

	@Override
	public Object visit(Cast cast, Object param) {

		cast.getType().accept(this, param);
		cast.getExpression().accept(this, param);
		return null;
	}

	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

		arrayAccess.getLeft().accept(this, param);
		arrayAccess.getRight().accept(this, param);
		return null;
	}

	@Override
	public Object visit(IntType intType, Object param) {

		return null;
	}

	@Override
	public Object visit(FloatType floatType, Object param) {

		return null;
	}

	@Override
	public Object visit(CharType charType, Object param) {

		return null;
	}

	@Override
	public Object visit(VarType varType, Object param) {

		return null;
	}

	@Override
	public Object visit(ArrayType arrayType, Object param) {

		arrayType.getType().accept(this, param);
		return null;
	}

	@Override
	public Object visit(StructType structType, Object param) {

		return null;
	}

	@Override
	public Object visit(VoidType voidType, Object param) {

		return null;
	}

	@Override
	public Object visit(ErrorType errorType, Object param) {

		return null;
	}


}
