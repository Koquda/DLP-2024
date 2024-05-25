// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.definition.FunctionDefinition;
import ast.expression.*;
import codegeneration.mapl.*;


public class Address extends AbstractCodeFunction {

	public Address(MaplCodeSpecification specification) {
		super(specification);
	}


	// class Variable(String name)
	// phase Identification { VarDefinition varDefinition }
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(Variable variable, Object param) {

		if (variable.getVarDefinition().isGlobal()) {
			out("pusha " + variable.getVarDefinition().getAddress());
		} else {
			out("pusha BP");
			out("push " + variable.getVarDefinition().getAddress());
			out("addi");
		}

		return null;
	}

	// class StructAccess(Expression expression, String field)
	// phase TypeChecking { boolean lvalue, Type type, StructField structField }
	@Override
	public Object visit(StructAccess structAccess, Object param) {

		// value(structAccess.getExpression());

		address(structAccess.getExpression());
		out("pushi " + structAccess.getStructField().getAddress());
		out("addi");

		return null;
	}

	// class ArrayAccess(Expression left, Expression right)
	// phase TypeChecking { boolean lvalue, Type type }
	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

		// value(arrayAccess.getLeft());

		// value(arrayAccess.getRight());

		address(arrayAccess.getLeft());
		value(arrayAccess.getRight());
		out("pushi " + arrayAccess.getLeft().getType().numberOfBytes());
		out("muli");
		out("addi");

		return null;
	}

}
