// Generated with VGen 2.0.0

/**
* Visitor del que derivar cuando se quiera que todo visit no redefinido lance
* una excepción si es invocado.
*
*/

package visitor;

import ast.*;
import ast.definition.*;
import ast.statement.*;
import ast.expression.*;
import ast.type.*;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------


public class ExceptionThrowerVisitor implements Visitor {
	@Override
	public Object visit(Program program, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Program)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(VarDefinition varDefinition, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(VarDefinition)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(StructDefinition structDefinition, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(StructDefinition)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(FunctionDefinition functionDefinition, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(FunctionDefinition)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(StructField structField, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(StructField)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(FunctionParam functionParam, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(FunctionParam)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Assignment assignment, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Assignment)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(FunctionCallStatement functionCallStatement, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(FunctionCallStatement)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(If ifValue, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(If)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(While whileValue, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(While)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Read read, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Read)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Print print, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Print)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Return returnValue, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Return)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(IntLiteral)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(FloatLiteral floatLiteral, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(FloatLiteral)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(CharLiteral charLiteral, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(CharLiteral)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Variable variable, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Variable)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Arithmetic arithmetic, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Arithmetic)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ArithmeticComparison arithmeticComparison, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ArithmeticComparison)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(LogicalComparison logicalComparison, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(LogicalComparison)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Negation negation, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Negation)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(FunctionCallExpression functionCallExpression, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(FunctionCallExpression)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(StructAccess structAccess, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(StructAccess)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(Cast cast, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(Cast)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ArrayAccess arrayAccess, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ArrayAccess)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(IntType intType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(IntType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(FloatType floatType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(FloatType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(CharType charType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(CharType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(VarType varType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(VarType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ArrayType arrayType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ArrayType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(StructType structType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(StructType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(VoidType voidType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(VoidType)' has been invoked but it has not been implemented.");
	}

	@Override
	public Object visit(ErrorType errorType, Object param) {

        throw new UnsupportedOperationException("'ExceptionThrowerVisitor.visit(ErrorType)' has been invoked but it has not been implemented.");
	}

    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
