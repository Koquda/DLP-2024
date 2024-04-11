package semantic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import ast.*;
import ast.definition.FunctionDefinition;
import ast.definition.StructDefinition;
import ast.definition.VarDefinition;
import ast.expression.FunctionCallExpression;
import ast.expression.Variable;
import ast.statement.FunctionCallStatement;
import ast.type.StructType;
import main.ErrorManager;
import visitor.DefaultVisitor;

// This class will be implemented in identification phase

public class Identification extends DefaultVisitor {

    private ErrorManager errorManager;
 	private ContextMap<VarDefinition> variables = new ContextMap<>();
    private HashMap<String, FunctionDefinition> functions = new HashMap<>();
    private HashMap<String, StructDefinition> structs = new HashMap<>();

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // # ----------------------------------------------------------
    /*
     * Write "visits" here...
     */

	// class VarDefinition(String name, Type type)
    @Override
    public Object visit(VarDefinition varDefinition, Object param) {
        var definition = variables.getFromTop(varDefinition.getName());
        if (definition != null)
            notifyError("Variable already defined: " + varDefinition.getName(), varDefinition);
        else {
            variables.put(varDefinition.getName(), varDefinition);
        }

        super.visit(varDefinition, param);

        return null;
    }

	// class StructDefinition(String name, List<StructField> structFields)
	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

        var definition = structs.get(structDefinition.getName());
        if (definition != null)
            notifyError("Struct already defined: " + structDefinition.getName(), structDefinition);
        else
            structs.put(structDefinition.getName(), structDefinition);

        Set<String> fieldNames = new HashSet<>();
        for (var field : structDefinition.getStructFields()) {
            if (fieldNames.contains(field.getName())) {
                notifyError("Field already defined: " + field.getName(), field);
            } else {
                fieldNames.add(field.getName());
            }
        }

		super.visit(structDefinition, param);

		return null;
	}

	// class FunctionDefinition(String name, List<FunctionParam> functionParams, Type type, List<Definition> definitions, List<Statement> statements)
	@Override
	public Object visit(FunctionDefinition functionDefinition, Object param) {

        variables.set();

        var definition = functions.get(functionDefinition.getName());
        if (definition != null)
            notifyError("Function already defined: " + functionDefinition.getName(), functionDefinition);
        else
            functions.put(functionDefinition.getName(), functionDefinition);

		super.visit(functionDefinition, param);
        variables.reset();

		return null;
	}

	// class FunctionCallStatement(String name, List<Expression> expressions)
	// phase Identification { FunctionDefinition functionDefinition }
	@Override
	public Object visit(FunctionCallStatement functionCallStatement, Object param) {

        var definition = functions.get(functionCallStatement.getName());
        if (definition == null)
            notifyError("Undefined function: " + functionCallStatement.getName(), functionCallStatement);
        else
            functionCallStatement.setDefinition(definition);

		super.visit(functionCallStatement, param);

		return null;
	}

	// class Variable(String name)
	// phase Identification { VarDefinition varDefinition }
	@Override
	public Object visit(Variable variable, Object param) {

		var definition = variables.getFromAny(variable.getName());
        if (definition == null)
            notifyError("Undefined variable: " + variable.getName(), variable);
        else
            variable.setVarDefinition(definition);
		return null;
	}

	// class FunctionCallExpression(String name, List<Expression> expressions)
	@Override
	public Object visit(FunctionCallExpression functionCallExpression, Object param) {

        var definition = functions.get(functionCallExpression.getName());
        if (definition == null)
            notifyError("Undefined function: " + functionCallExpression.getName(), functionCallExpression);
        else
            functionCallExpression.setDefinition(definition);

		super.visit(functionCallExpression, param);

		return null;
	}

	// class StructType(String name)
	// phase Identification { StructDefinition structDefinition }
	@Override
	public Object visit(StructType structType, Object param) {

        var definition = structs.get(structType.getName());
        if (definition == null)
            notifyError("Undefined struct: " + structType.getName(), structType);
        else
            structType.setStructDefinition(definition);

		return null;
	}


    // # --------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    private void notifyError(String msg) {
        errorManager.notify("Identification", msg);
    }

    private void notifyError(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }

    private void notifyError(String msg, AST node) {
        notifyError(msg, node.start());
    }

}
