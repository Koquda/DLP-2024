// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.AST;
import ast.Position;
import ast.definition.FunctionDefinition;
import ast.definition.StructDefinition;
import ast.definition.VarDefinition;
import ast.expression.Expression;
import ast.statement.*;
import ast.type.VoidType;
import codegeneration.mapl.*;


public class Execute extends AbstractCodeFunction {

	private int elseLabelCount = 0;
	private int endIfLabelCount = 0;
	private int whileLabel = 0;
	private int whileEndLabel = 0;

    public Execute(MaplCodeSpecification specification) {
        super(specification);
    }

	// class Assignment(Expression left, Expression right)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(Assignment assignment, Object param) {

		line(assignment);
		address(assignment.getLeft(), param);
		value(assignment.getRight(), param);
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

		line(functionCallStatement);
		value(functionCallStatement.expressions());
		out("call " + functionCallStatement.getName());
		if (!(functionCallStatement.getDefinition().getType() instanceof VoidType)) {
			out("pop" + suffixFor(functionCallStatement.getDefinition().getType()));
		}

		return null;
	}

	// class If(Expression condition, List<Statement> ifBody, List<Statement> elseBody)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(If ifValue, Object param) {
		var elseLabel = elseLabelCount++;
		var endIfLabel = endIfLabelCount++;

		line(ifValue);
		value(ifValue.getCondition());
		out("jz elseLabel" + elseLabel);
		execute(ifValue.ifBody(), param);
		out("jmp endIfLabel" + endIfLabel);
		out("elseLabel" + elseLabel + ":");
		execute(ifValue.elseBody(), param);
		out("endIfLabel" + endIfLabel + ":");

		return null;
	}

	// class While(Expression condition, List<Statement> statements)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(While whileValue, Object param) {

		String wLabel = "whileLabel" + whileLabel;
		String wEndLabel = "whileEndLabel" + whileEndLabel;

		line(whileValue);
		out( wLabel + ":");
		out("\n' While Condition");
		value(whileValue.getCondition(), param);
		out("jz " + wEndLabel);
		out("\n' While Body");
		execute(whileValue.statements(), param);
		out("jmp " + wLabel);
		out("\n" + wEndLabel + ":");

		whileLabel++;
		whileEndLabel++;
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
		if (print.getExpressions() == null || print.getExpressions().size() <= 0) {
			printLexeme(print);
		} else {
			print.expressions().forEach(expression -> {
				value(expression);
				out("out", expression.getType());
				printLexeme(print);
			});
		}

		return null;
	}

	// class Return(Optional<Expression> expression)
	// phase TypeChecking { FunctionDefinition functionWhereDefined }
	@Override
	public Object visit(Return returnValue, Object param) {

		// value(returnValue.getExpression());
		// address(returnValue.getExpression());

		line(returnValue);
		if (returnValue.getExpression().isPresent()) {
			Expression expr = returnValue.getExpression().get();
			value(expr);
			if (param instanceof FunctionDefinition funcDef) {
				int paramSize = funcDef.varDefinitions()
						.map(funcParam -> funcParam.getType().numberOfBytes())
						.reduce(0, Integer::sum);

				int localVariablesSize = funcDef.definitions()
						.map(local -> ((VarDefinition) local).getType().numberOfBytes())
						.reduce(0, Integer::sum);

				out("ret " + funcDef.getType().numberOfBytes() + ", " + localVariablesSize + ", " + paramSize);
			}
		}

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

		// TODO
//		metadata(functionDefinition);

		line(functionDefinition);
		out(functionDefinition.getName() + ":");

		execute(functionDefinition.varDefinitions(), param);
		execute(functionDefinition.definitions(), param);

		int paramSize = functionDefinition.varDefinitions()
				.map(funcParam -> funcParam.getType().numberOfBytes())
				.reduce(0, Integer::sum);

		int localVariablesSize = functionDefinition.definitions()
				.map(local -> ((VarDefinition) local).getType().numberOfBytes())
				.reduce(0, Integer::sum);

		out("enter " + localVariablesSize);
		execute(functionDefinition.statements(), functionDefinition);
		if (functionDefinition.getType() instanceof VoidType)
			out("ret " + functionDefinition.getType().numberOfBytes() + ", " + localVariablesSize + ", " + paramSize);


		return null;
	}


	// Auxiliary methods for the generation of code
	private void printLexeme(Print print) {
		if (print.getLexema().equalsIgnoreCase("ln")) {
			out("pushb 10");
			out("outb");
		} else if (print.getLexema().equalsIgnoreCase("sp")) {
			out("pushb 32");
			out("outb");
		}
	}


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
