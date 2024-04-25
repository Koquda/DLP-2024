// Generated with VGen 2.0.0

package codegeneration.mapl.codefunctions;

import ast.*;
import ast.definition.*;
import ast.type.*;
import codegeneration.mapl.*;


public class Metadata extends AbstractCodeFunction {

	public Metadata(MaplCodeSpecification specification) {
		super(specification);
	}


	// class Program(List<Definition> definitions)
	@Override
	public Object visit(Program program, Object param) {

		out("#SOURCE \"" + getSpecification().getSourceFile() + "\"");
		metadata(program.definitions());

		return null;
	}

	// class VarDefinition(String name, Type type)
	// phase MemoryAllocation { int address }
	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

		out("#GLOBAL " + varDefinition.getName() + ":" + getTypeName(varDefinition.getType()));
		metadata(varDefinition.getType());

		return null;
	}

	// class FunctionDefinition(String name, List<VarDefinition> varDefinitions, Type type, List<Definition> definitions, List<Statement> statements)
	// phase MemoryAllocation { int bytesLocals }
	@Override
	public Object visit(FunctionDefinition functionDefinition, Object param) {

		out(functionDefinition.getName() + ":");
		out("# FUNC " + functionDefinition.getName());
		if (functionDefinition.getType() instanceof VoidType)
			out("# RET VOID");
		else
			out("# RET " + getTypeName(functionDefinition.getType()));
		functionDefinition.varDefinitions().forEach(def -> out("# PARAM " + def.getName() + ":" + getTypeName(def.getType())));


		return null;
	}

	// class StructDefinition(String name, List<StructField> structFields)
	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

		out("# TYPE " + structDefinition.getName() + "{");
		structDefinition.structFields().forEach(field -> out("\t" + field.getName() + ":" + getTypeName(field.getType())));
		out("}");

		return null;
	}

	//# ------------------------------------------------------------------
	//# Auxiliary methods

	private String getTypeName(Type type) {
		if (type instanceof IntType)
			return "int";
		if (type instanceof FloatType)
			return "real";
		if (type instanceof CharType)
			return "byte";
		if (type instanceof ArrayType)
			return "array";
		if (type instanceof StructType t)
			return t.getName();

		// Sealed classes + pattern matching would avoid this situation. Those features were not
		// finished when this code was implemented
		throw new IllegalArgumentException("Unknown Type: " + type);
	}

}
