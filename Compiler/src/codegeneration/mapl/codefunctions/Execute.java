// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.AST;
import ast.Position;
import ast.definition.FunctionDefinition;
import ast.definition.StructDefinition;
import ast.definition.VarDefinition;
import ast.statement.*;
import codegeneration.mapl.*;


public class Execute extends AbstractCodeFunction {

	private int elseLabelCount = 0;
	private int endIfLabelCount = 0;

    public Execute(MaplCodeSpecification specification) {
        super(specification);
    }

	// class Assignment(Expression left, Expression right)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(Assignment assignment, Object param) {

		line(assignment);
		address(assignment.getLeft());
		value(assignment.getRight());
		out("store" + suffixFor(assignment.getRight().getType()));

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

		line(ifValue);
		value(ifValue.getCondition());
		out("jz elseLabel" + elseLabelCount);
		execute(ifValue.ifBody());
		out("jmp endIfLabel" + endIfLabelCount);
		out("elseLabel" + elseLabelCount + ":");
		execute(ifValue.elseBody());
		out("endIfLabel" + endIfLabelCount + ":");

		elseLabelCount++;
		endIfLabelCount++;
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

		line(read);
		address(read.getExpression());
		out("in" + suffixFor(read.getExpression().getType()));
		out("store" + suffixFor(read.getExpression().getType()));

		return null;
	}

	// class Print(List<Expression> expressions, String lexema)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(Print print, Object param) {

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

	// class VarDefinition(String name, Type type)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

		metadata(varDefinition);
		return null;

	}

	// class StructDefinition(String name, List<StructField> structFields)
	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

		metadata(structDefinition);
		return null;

	}

	// class FunctionDefinition(String name, List<VarDefinition> varDefinitions, Type type, List<Definition> definitions, List<Statement> statements)
	// phase MemoryAllocation { int bytesLocals }
	@Override
	public Object visit(FunctionDefinition functionDefinition, Object param) {

		out(functionDefinition.getName() + ":");
//		metadata(functionDefinition);
		execute(functionDefinition.varDefinitions());
		execute(functionDefinition.definitions());
		execute(functionDefinition.statements());
		out("ret");

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
