// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.AST;
import ast.Position;
import ast.statement.*;
import codegeneration.mapl.*;


public class Execute extends AbstractCodeFunction {

    public Execute(MaplCodeSpecification specification) {
        super(specification);
    }


	// class Assignment(Expression left, Expression right)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(Assignment assignment, Object param) {

		// value(assignment.getLeft());
		// address(assignment.getLeft());

		// value(assignment.getRight());
		// address(assignment.getRight());

		line(assignment);
		address(assignment.getLeft());
		value(assignment.getRight());
		out("store" + assignment.getRight().getType());

		return null;
	}

	// class FunctionCallStatement(String name, List<Expression> expressions)
	// phase Identification { FunctionDefinition definition }
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(FunctionCallStatement functionCallStatement, Object param) {

		// value(functionCallStatement.expressions());
		// address(functionCallStatement.expressions());

		out("<instruction>");

		return null;
	}

	// class If(Expression condition, List<Statement> ifBody, List<Statement> elseBody)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(If ifValue, Object param) {

		// value(ifValue.getCondition());
		// address(ifValue.getCondition());

		// execute(ifValue.ifBody());

		// execute(ifValue.elseBody());

		out("<instruction>");

		return null;
	}

	// class While(Expression condition, List<Statement> statements)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(While whileValue, Object param) {

		// value(whileValue.getCondition());
		// address(whileValue.getCondition());

		// execute(whileValue.statements());

		out("<instruction>");

		return null;
	}

	// class Read(Expression expression)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(Read read, Object param) {

		// value(read.getExpression());
		// address(read.getExpression());

		out("<instruction>");

		return null;
	}

	// class Print(List<Expression> expressions, String lexema)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(Print print, Object param) {

		// value(print.expressions());
		// address(print.expressions());

		// TODO revisar
		line(print);
		print.expressions().forEach(expression -> {
			value(expression);
			out("out", expression.getType());
		});

		return null;
	}

	// class Return(Optional<Expression> expression)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(Return returnValue, Object param) {

		// value(returnValue.getExpression());
		// address(returnValue.getExpression());

		out("<instruction>");

		return null;
	}

	// Auxiliary methods for the generation of code

	private void line(AST node) {
		line(node.end());
	}
	private void line(Position pos) {
		if (pos != null)
			out("\n#line " + pos.getLine());
		else
			System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");
	}

}
