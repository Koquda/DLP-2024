// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.expression.*;
import codegeneration.mapl.*;


public class Address extends AbstractCodeFunction {

    public Address(MaplCodeSpecification specification) {
        super(specification);
    }


	// class IntLiteral(int value)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		out("<instruction>");

		return null;
	}

	// class FloatLiteral(float value)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(FloatLiteral floatLiteral, Object param) {

		out("<instruction>");

		return null;
	}

	// class CharLiteral(String value)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

		out("<instruction>");

		return null;
	}

	// class Variable(String name)
	// phase Identification { VarDefinition varDefinition }
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Variable variable, Object param) {

		// TODO revisar
		out("pusha BP" + variable.getVarDefinition().getAddress());

		return null;
	}

	// class Arithmetic(Expression left, String operator, Expression right)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Arithmetic arithmetic, Object param) {

		// value(arithmetic.getLeft());
		// address(arithmetic.getLeft());

		// value(arithmetic.getRight());
		// address(arithmetic.getRight());

		out("<instruction>");

		return null;
	}

	// class ArithmeticComparison(Expression left, String operator, Expression right)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(ArithmeticComparison arithmeticComparison, Object param) {

		// value(arithmeticComparison.getLeft());
		// address(arithmeticComparison.getLeft());

		// value(arithmeticComparison.getRight());
		// address(arithmeticComparison.getRight());

		out("<instruction>");

		return null;
	}

	// class LogicalComparison(Expression left, String operator, Expression right)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(LogicalComparison logicalComparison, Object param) {

		// value(logicalComparison.getLeft());
		// address(logicalComparison.getLeft());

		// value(logicalComparison.getRight());
		// address(logicalComparison.getRight());

		out("<instruction>");

		return null;
	}

	// class Negation(Expression expression)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Negation negation, Object param) {

		// value(negation.getExpression());
		// address(negation.getExpression());

		out("<instruction>");

		return null;
	}

	// class FunctionCallExpression(String name, List<Expression> expressions)
	// phase Identification { FunctionDefinition definition }
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(FunctionCallExpression functionCallExpression, Object param) {

		// value(functionCallExpression.expressions());
		// address(functionCallExpression.expressions());

		out("<instruction>");

		return null;
	}

	// class StructAccess(Expression expression, String field)
	// phase TypeChecking { boolean lvalue, Type type, StructField structField }
	@Override
	public Object visit(StructAccess structAccess, Object param) {

		// value(structAccess.getExpression());
		// address(structAccess.getExpression());

		address(structAccess.getExpression());
		out("pushi " + structAccess.getStructField().getAddress());
		out("addi");

		return null;
	}

	// class Cast(Type castType, Expression expression)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Cast cast, Object param) {

		// value(cast.getExpression());
		// address(cast.getExpression());

		out("<instruction>");

		return null;
	}

	// class ArrayAccess(Expression left, Expression right)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

		// value(arrayAccess.getLeft());
		// address(arrayAccess.getLeft());

		// value(arrayAccess.getRight());
		// address(arrayAccess.getRight());

		address(arrayAccess.getLeft());
		value(arrayAccess.getRight());
		out("pushi " + arrayAccess.getLeft().getType().numberOfBytes());
		out("muli");
		out("addi");

		return null;
	}

}
