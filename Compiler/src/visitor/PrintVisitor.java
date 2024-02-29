package visitor;

import ast.AST;
import ast.FunctionParam;
import ast.Program;
import ast.StructField;
import ast.definition.FunctionDefinition;
import ast.definition.StructDefinition;
import ast.definition.VarDefinition;
import ast.expression.Arithmetic;
import ast.expression.ArithmeticComparison;
import ast.expression.ArrayAccess;
import ast.expression.Cast;
import ast.expression.CharLiteral;
import ast.expression.FloatLiteral;
import ast.expression.FunctionCallExpression;
import ast.expression.IntLiteral;
import ast.expression.LogicalComparison;
import ast.expression.Negation;
import ast.expression.StructAccess;
import ast.expression.Variable;
import ast.statement.Assignment;
import ast.statement.FunctionCallStatement;
import ast.statement.If;
import ast.statement.Print;
import ast.statement.Read;
import ast.statement.Return;
import ast.statement.While;
import ast.type.ArrayType;
import ast.type.CharType;
import ast.type.ErrorType;
import ast.type.FloatType;
import ast.type.IntType;
import ast.type.StructType;
import ast.type.VarType;
import ast.type.VoidType;

public class PrintVisitor extends DefaultVisitor {

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // Visit Methods --------------------------------------------------------------

	// class Program(List<Definition> definitions)
	@Override
	public Object visit(Program program, Object param) {
       
        System.out.println("Program:");
        super.visit(program, param);

		return null;
	}

	// class VarDefinition(String name, Type type)
	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

        System.out.println("VarDef: " + varDefinition.getName() + ", type: " + varDefinition.getType());
		super.visit(varDefinition, param);

		return null;
	}

	// class StructDefinition(String name, List<StructField> structFields)
	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

        System.out.println("StructDef: " + structDefinition.getName());
		super.visit(structDefinition, param);

		return null;
	}

	// class FunctionDefinition(String name, List<FunctionParam> functionParams, Type type, List<Definition> definitions, List<Statement> statements)
	@Override
	public Object visit(FunctionDefinition functionDefinition, Object param) {

        System.out.println("FunctionDef: " + functionDefinition.getName() + ", returnType: " + functionDefinition.getType());
		super.visit(functionDefinition, param);

		return null;
	}

	// class StructField(String name, Type type)
	@Override
	public Object visit(StructField structField, Object param) {

        System.out.println("StructField: " + structField.getName() + ", type: " + structField.getType());
		super.visit(structField, param);

		return null;
	}

	// class FunctionParam(String name, Type type)
	@Override
	public Object visit(FunctionParam functionParam, Object param) {

        System.out.println("FunctionParam: " + functionParam.getName() + ", type: " + functionParam.getType());
		super.visit(functionParam, param);

		return null;
	}

	// class Assignment(Expression left, Expression right)
	@Override
	public Object visit(Assignment assignment, Object param) {

		System.out.println("Assignment: Left: " + assignment.getLeft() + ", Right: " + assignment.getRight());
		super.visit(assignment, param);

		return null;
	}

	// class FunctionCallStatement(String name, List<Expression> expressions)
	@Override
	public Object visit(FunctionCallStatement functionCallStatement, Object param) {

		System.out.println("FunctionCallStatement: " + functionCallStatement.getName());
		super.visit(functionCallStatement, param);

		return null;
	}

	// class If(Expression expression, List<Statement> ifBody, List<Statement> elseBody)
	@Override
	public Object visit(If ifValue, Object param) {

		System.out.println("If: Condition: " + ifValue.getCondition());
		super.visit(ifValue, param);

		return null;
	}

	// class While(Expression expression, List<Statement> statements)
	@Override
	public Object visit(While whileValue, Object param) {

		System.out.println("While: Condition: " + whileValue.getCondition());
		super.visit(whileValue, param);

		return null;
	}

	// class Read(Expression expression)
	@Override
	public Object visit(Read read, Object param) {

		System.out.println("Read: " + read.getExpression());
		super.visit(read, param);

		return null;
	}

	// class Print(Optional<Expression> expression, String lexema)
	@Override
	public Object visit(Print print, Object param) {

		System.out.println("Print: " + print.getExpression() + ", lexema: " + print.getLexema());
		super.visit(print, param);

		return null;
	}

	// class Return(Optional<Expression> expression)
	@Override
	public Object visit(Return returnValue, Object param) {

		System.out.println("Return: " + returnValue.getExpression());
		super.visit(returnValue, param);

		return null;
	}

	// class IntLiteral(int intValue)
	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

		System.out.println("IntLiteral: " + intLiteral.getValue());
		return null;
	}

	// class FloatLiteral(float floatValue)
	@Override
	public Object visit(FloatLiteral floatLiteral, Object param) {

		System.out.println("FloatLiteral: " + floatLiteral.getValue());
		return null;
	}

	// class CharLiteral(char charValue)
	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

		System.out.println("CharLiteral: " + charLiteral.getCharacter());
		return null;
	}

	// class Variable(String name)
	@Override
	public Object visit(Variable variable, Object param) {

		System.out.println("Variable: " + variable.getName());
		return null;
	}

	// class Arithmetic(Expression left, String operator1, Expression right)
	@Override
	public Object visit(Arithmetic arithmetic, Object param) {

		System.out.println("Arithmetic: " + arithmetic.getOperator());
		super.visit(arithmetic, param);

		return null;
	}

	// class ArithmeticComparison(Expression left, String operator, Expression right)
	@Override
	public Object visit(ArithmeticComparison arithmeticComparison, Object param) {

		System.out.println("ArithmeticComparison: " + arithmeticComparison.getOperator());
		super.visit(arithmeticComparison, param);

		return null;
	}

	// class LogicalComparison(Expression left, String operator, Expression right)
	@Override
	public Object visit(LogicalComparison logicalComparison, Object param) {

		System.out.println("LogicalComparison: " + logicalComparison.getOperator());
		super.visit(logicalComparison, param);

		return null;
	}

	// class Negation(Expression expression)
	@Override
	public Object visit(Negation negation, Object param) {

		System.out.println("Negation: " + negation.getExpression());
		super.visit(negation, param);

		return null;
	}

	// class FunctionCallExpression(String name, List<Expression> expressions)
	@Override
	public Object visit(FunctionCallExpression functionCallExpression, Object param) {

		System.out.println("FunctionCallExpression: " + functionCallExpression.getName());
		super.visit(functionCallExpression, param);

		return null;
	}

	// class StructAccess(Expression expression, String name)
	@Override
	public Object visit(StructAccess structAccess, Object param) {

		System.out.println("StructAccess: " + structAccess.getExpression() + ", field: " + structAccess.getField());
		super.visit(structAccess, param);

		return null;
	}

	// class Cast(Type type, Expression expression)
	@Override
	public Object visit(Cast cast, Object param) {

		System.out.println("Cast: " + cast.getType());
		super.visit(cast, param);

		return null;
	}

	// class ArrayAccess(Expression left, Expression right)
	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

		System.out.println("ArrayAccess: " + arrayAccess.getLeft() + ", index: " + arrayAccess.getRight());
		super.visit(arrayAccess, param);

		return null;
	}

	// class IntType()
	@Override
	public Object visit(IntType intType, Object param) {

		System.out.println("IntType");
		return null;
	}

	// class FloatType()
	@Override
	public Object visit(FloatType floatType, Object param) {

		System.out.println("FloatType");
		return null;
	}

	// class CharType()
	@Override
	public Object visit(CharType charType, Object param) {

		return null;
	}

	// class VarType(String name)
	@Override
	public Object visit(VarType varType, Object param) {

		System.out.println("VarType: " + varType.getName());
		return null;
	}

	// class ArrayType(int intValue, Type type)
	@Override
	public Object visit(ArrayType arrayType, Object param) {

		System.out.println("ArrayType: " + arrayType.getSize() + ", type: " + arrayType.getType());
		super.visit(arrayType, param);

		return null;
	}

	// class StructType(String name)
	@Override
	public Object visit(StructType structType, Object param) {

		System.out.println("StructType: " + structType.getName());
		return null;
	}

	// class VoidType()
	@Override
	public Object visit(VoidType voidType, Object param) {

		System.out.println("VoidType");
		return null;
	}

	// class ErrorType()
	@Override
	public Object visit(ErrorType errorType, Object param) {

		System.out.println("ErrorType");
		return null;
	}
}
