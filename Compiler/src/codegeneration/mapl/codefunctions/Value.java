// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.definition.FunctionDefinition;
import ast.expression.*;
import ast.statement.FunctionCallStatement;
import ast.type.CharType;
import ast.type.IntType;
import ast.type.Type;
import codegeneration.mapl.*;
import com.sun.jdi.DoubleType;

import java.util.HashMap;
import java.util.Map;


public class Value extends AbstractCodeFunction {

	private Map<String, String> instruction = new HashMap<String, String>();

    public Value(MaplCodeSpecification specification) {
        super(specification);

		instruction.put("+", "add");
		instruction.put("-", "sub");
		instruction.put("*", "mul");
		instruction.put("/", "div");
		instruction.put("&&", "and");
		instruction.put("||", "or");
		instruction.put(">", "gt");
		instruction.put(">=", "ge");
		instruction.put("<", "lt");
		instruction.put("<=", "le");
		instruction.put("==", "eq");
		instruction.put("!=", "ne");
    }


	// class IntLiteral(int value)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		out("push " + intLiteral.getValue());

		return null;
	}

	// class FloatLiteral(float value)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(FloatLiteral floatLiteral, Object param) {

		out("pushf " + floatLiteral.getValue());

		return null;
	}

	// class CharLiteral(String value)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

		out("pushb " + (int) charLiteral.getCharacter());

		return null;
	}

	// class Variable(String name)
	// phase Identification { VarDefinition varDefinition }
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Variable variable, Object param) {

		address(variable);
		out("load", variable.getType());

		return null;
	}

	// class Arithmetic(Expression left, String operator, Expression right)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Arithmetic arithmetic, Object param) {

		value(arithmetic.getLeft());
		value(arithmetic.getRight());
		out(instruction.get(arithmetic.getOperator()), arithmetic.getLeft().getType());

		return null;
	}

	// class ArithmeticComparison(Expression left, String operator, Expression right)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(ArithmeticComparison arithmeticComparison, Object param) {


		value(arithmeticComparison.getLeft());
		value(arithmeticComparison.getRight());
		if (arithmeticComparison.getLeft().getType() instanceof CharType)
			out(instruction.get(arithmeticComparison.getOperator()));
		else
			out(instruction.get(arithmeticComparison.getOperator()), arithmeticComparison.getLeft().getType());

		return null;
	}

	// class LogicalComparison(Expression left, String operator, Expression right)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(LogicalComparison logicalComparison, Object param) {

		value(logicalComparison.getLeft());
		value(logicalComparison.getRight());
		out(instruction.get(logicalComparison.getOperator()));

		return null;
	}

	// class Negation(Expression expression)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Negation negation, Object param) {

		value(negation.getExpression());
		out("not");

		return null;
	}

	// class FunctionCallExpression(String name, List<Expression> expressions)
	// phase Identification { FunctionDefinition definition }
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(FunctionCallExpression functionCallExpression, Object param) {

		// value(functionCallExpression.expressions());
		// address(functionCallExpression.expressions());

		int i = 0;
		for (Expression expr : functionCallExpression.getExpressions()) {
			value(expr);
			promoteTo(
					functionCallExpression.getExpressions().get(i).getType(),
					functionCallExpression.getDefinition().getVarDefinitions().get(i).getType()
			);
			i++;
		}
		out("call\t" + functionCallExpression.getName());

		return null;
	}

	// class StructAccess(Expression expression, String field)
	// phase TypeChecking { boolean lvalue, Type type, StructField structField }
	@Override
	public Object visit(StructAccess structAccess, Object param) {

		address(structAccess);
		promoteTo(structAccess.getExpression().getType(), structAccess.getType());
		out("load", structAccess.getType());

		return null;
	}

	// class Cast(Type castType, Expression expression)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Cast cast, Object param) {

		value(cast.getExpression());
		promoteTo(cast.getExpression().getType(), cast.getCastType());

		return null;
	}

	// class ArrayAccess(Expression left, Expression right)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

		address(arrayAccess);
		out("load", arrayAccess.getLeft().getType());

		return null;
	}


	// class FunctionCallStatement(String name, List<Expression> expressions)
	// phase Identification { FunctionDefinition definition }
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(FunctionCallStatement functionCallStatement, Object param) {

		// value(functionCallStatement.expressions());

		int i = 0;
		for (Expression expr : functionCallStatement.getExpressions()) {
			value(expr);
			promoteTo(
					functionCallStatement.getExpressions().get(i).getType(),
					functionCallStatement.getDefinition().getVarDefinitions().get(i).getType()
			);
			i++;
		}
		out("call\t" + functionCallStatement.getName());

		return null;
	}
}
