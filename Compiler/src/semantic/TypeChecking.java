// Generated with VGen 2.0.0

/*

Este fichero es un esqueleto para facilitar la implementación de una gramática atribuida
('ATTRIBUTE GRAMMAR' de VGen). Para usarlo hay que realizar dos pasos:
1. Ubicar este código.
2. Completar cada método visit.

## Paso 1. Ubicación de este Código

Este esqueleto será SOBREESCRITO la próxima vez que se ejecuta VGen. Por ello, se debe
copiar su contenido antes de hacer cualquier cambio.

Hay dos opciones:

1) Si ya se tiene hecha una clase para el visitor, basta con copiar a dicha clase los
   métodos visit de este esqueleto (y los import) ignorando el resto.

2) Si no se tiene hecha aún la clase, este esqueleto vale como tal si se mueve a la
   carpeta deseada del proyecto y se le pone el package correspondiente a dicha
   ubicación.

Una vez hecho esto, ya se tendría un visitor que compilaría sin errores y que, al
ejecutarlo, recorrería todo el árbol (aunque sin hacer nada en cada nodo).


## Paso 2 Completar cada Método Visit

El visit generado para cada nodo se limita a recorrer sus hijos. El código de recorrido
se encuentra en la llamada a 'super.visit'. Los 'accept' comentados encima de cada
'super.visit' son sólo un recordatorio de lo que hace dicho método (son una copia de su
implementación, que se hereda de DefaultVisitor).

Por tanto, hay tres opciones a la hora de implementar cada visit:

1. Si en el visit de un nodo SÓLO SE NECESITA RECORRER sus hijos, se puede borrar
   completamente dicho visit de esta clase. Al no estar el método, se heredará de
   DefaultVisitor la misma implementación que se acaba de borrar. Es decir, en esta
   clase sólo será necesario dejar los visit que tengan alguna acción que realizar.

2. Si se necesita hacer alguna tarea adicional ANTES o DESPUÉS de recorrer todos los
   hijos, se debe añadir su código antes o después de la llamada a 'super.visit' (y se
   pueden borrar los 'accept' comentados).

3. Y, finalmente, si se necesita hacer alguna tarea INTERCALADA en el recorrido de los
   hijos (por ejemplo, comprobar su tipo), se debe borrar el 'super.visit' y descomentar
   los 'accept'. Así se tendría ya implementado el recorrido de los hijos, que es la
   estructura donde se intecalará el código de las acciones adicionales.

NOTA 1. En los visit en los que haya que inicializar atributos heredados de los hijos
antes de recorrerlos, se han añadido recordatorios en los puntos en los que es
aconsejable hacerlo.

NOTA 2. En los visit de los nodos que tengan atributos sintetizados, se han añadido
recordatorios de que se deben inicializar dichos atributos.

*/

package semantic;

import main.ErrorManager;
import visitor.DefaultVisitor;
import ast.*;
import ast.definition.*;
import ast.statement.*;
import ast.expression.*;
import ast.type.*;

import java.util.List;


public class TypeChecking extends DefaultVisitor {

    public TypeChecking (ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    private ErrorManager errorManager;

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // Visit Methods --------------------------------------------------------------

    // class FunctionDefinition(String name, List<VarDefinition> varDefinitions, Type type, List<Definition> definitions, List<Statement> statements)
    @Override
    public Object visit(FunctionDefinition functionDefinition, Object param) {

        // Predicates
        // Check if all the params are of type IntType, FloatType or CharType
        functionDefinition.varDefinitions().forEach(funcParam -> {
            funcParam.accept(this, param);
            predicate(isSimpleType(funcParam.getType()), "Parameter type must be a simple type", funcParam.start());
        });

        // If the return type is not void, check if it is of type IntType, FloatType or CharType
        if (!(functionDefinition.getType() instanceof VoidType)) {
            // TODO: mirar si tiene que estar o no
            //if (isSimpleType(functionDefinition.getType()))
                //predicate(hasReturn(functionDefinition.getStatements()), "Function must have a return statement", functionDefinition.start());
            //else
                predicate(isSimpleType(functionDefinition.getType()), "Return type must be a simple type", functionDefinition.start());
        }

        // Semantic functions
        functionDefinition.statements().forEach(stmt -> stmt.setFunctionWhereDefined(functionDefinition));

		functionDefinition.getType().accept(this, param);
		functionDefinition.getDefinitions().forEach(definition -> definition.accept(this, param));
		functionDefinition.getStatements().forEach(statement -> statement.accept(this, param));

        return null;
    }

    // class Assignment(Expression left, Expression right)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(Assignment assignment, Object param) {
        super.visit(assignment, param);

        if (assignment.getRight().getType() instanceof ErrorType)
            return null;

        var condition = assignment.getLeft().isLvalue();
        predicate(condition, "Left part of the assignment is not LValue", assignment.getLeft().start());

        predicate(isSimpleType(assignment.getLeft().getType()), "Left side of the assignment must be a simple type", assignment.getLeft().start());
        predicate(sameType(assignment.getLeft().getType(), assignment.getRight().getType()),
                "Both sides of the assignment must be of the same type, left is " + assignment.getLeft().getType() + " and right is " + assignment.getRight().getType(),
                assignment.getLeft().start());
        return null;
    }

    // class FunctionCallStatement(String name, List<Expression> expressions)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(FunctionCallStatement functionCallStatement, Object param) {
        super.visit(functionCallStatement, param);

        var condition = functionCallStatement.getExpressions().size() == functionCallStatement.getDefinition().getVarDefinitions().size();
        predicate(condition, "Number of params in the function do not match the definition", functionCallStatement.start());
        if (!condition)
            return null;

        for (int i = 0; i < functionCallStatement.getExpressions().size(); i++) {
            var expr = functionCallStatement.getExpressions().get(i);
            var paramType = functionCallStatement.getDefinition().getVarDefinitions().get(i).getType();
            predicate(sameType(expr.getType(), paramType), "Function call parameters do not match the definition", expr.start());
        }
        return null;
    }

    // class If(Expression condition, List<Statement> ifBody, List<Statement> elseBody)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(If ifValue, Object param) {
		ifValue.getCondition().accept(this, param);

        // Predicates
        predicate(ifValue.getCondition().getType() instanceof IntType, "Condition must be of type IntType", ifValue.getCondition().start());

        // Semantic functions
        ifValue.getIfBody().forEach(stmt -> stmt.setFunctionWhereDefined(ifValue.getFunctionWhereDefined()));
        ifValue.getElseBody().forEach(stmt -> stmt.setFunctionWhereDefined(ifValue.getFunctionWhereDefined()));

		ifValue.getIfBody().forEach(statement -> statement.accept(this, param));
		ifValue.getElseBody().forEach(statement -> statement.accept(this, param));

        return null;
    }

    // class While(Expression condition, List<Statement> statements)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(While whileValue, Object param) {
		whileValue.getCondition().accept(this, param);

        // Predicates
        predicate(whileValue.getCondition().getType() instanceof IntType, "Condition must be of type IntType", whileValue.getCondition().start());

        // Semantic functions
        if (whileValue.getFunctionWhereDefined() != null) {
            whileValue.getStatements().forEach(stmt -> stmt.setFunctionWhereDefined(whileValue.getFunctionWhereDefined()));
        }

		whileValue.getStatements().forEach(statement -> statement.accept(this, param));

        return null;
    }

    // class Read(Expression expression)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(Read read, Object param) {
        super.visit(read, param);

        predicate(read.getExpression().isLvalue(), "Expression is not LValue", read.getExpression().start());
        predicate(isSimpleType(read.getExpression().getType()), "Expression must be of a simple type", read.getExpression().start());

        return null;
    }

    // class Print(List<Expression> expressions, String lexema)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(Print print, Object param) {
        super.visit(print, param);

        print.expressions().forEach(expr -> {
            predicate(isSimpleType(expr.getType()), "Expression must be of a simple type", expr.start());
        });

        return null;
    }

    // class Return(Optional<Expression> expression)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(Return returnValue, Object param) {
        super.visit(returnValue, param);

        // Si la defFunc no tiene return y el return no tiene expr
        // Si la defFunc tiene return y el return tiene expr y son del mismo tipo

        var functionReturnType = returnValue.getFunctionWhereDefined().getType();
        if (functionReturnType instanceof VoidType) {
            predicate(returnValue.getExpression().isEmpty(),
                    "Return value should be VoidType", returnValue.start());
        } else {
            var condition = returnValue.getExpression().isPresent();
            predicate(condition,
                    "Return value is not present in a non void function", returnValue.start());
            if (!condition) {
                // TODO: hay que poner el ErrorType
                return null;
            }

            var exprType = returnValue.getExpression().get().getType();
            predicate(sameType(functionReturnType, exprType), "Function return type is not the same type of return value", returnValue.start());
            predicate(isSimpleType(exprType), "Return must be of a simple type", returnValue.start());

        }

        return null;
    }

    // class IntLiteral(int value)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(IntLiteral intLiteral, Object param) {

        intLiteral.setType(new IntType());
        intLiteral.setLvalue(false);
        return null;
    }

    // class FloatLiteral(float value)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(FloatLiteral floatLiteral, Object param) {

        floatLiteral.setType(new FloatType());
        floatLiteral.setLvalue(false);
        return null;
    }

    // class CharLiteral(String value)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(CharLiteral charLiteral, Object param) {

        charLiteral.setType(new CharType());
        charLiteral.setLvalue(false);
        return null;
    }

    // class Variable(String name)
    // phase Identification { VarDefinition varDefinition }
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Variable variable, Object param) {

        variable.setType(variable.getVarDefinition().getType());
        variable.setLvalue(true);
        return null;
    }

    // class Arithmetic(Expression left, String operator, Expression right)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        super.visit(arithmetic, param);

        var condition1 = sameType(arithmetic.getLeft().getType(), arithmetic.getRight().getType());
        predicate(condition1, "Both sides of the operation must be of the same type", arithmetic.getLeft().start());
        if (hasErrors(arithmetic, condition1)) {
            arithmetic.setLvalue(false);
            return null;
        }

        boolean condition2;
        if (arithmetic.getOperator().equals("%")) {
            condition2 = arithmetic.getLeft().getType() instanceof IntType;
            predicate(condition2, "Both operands have to be Int", arithmetic.getLeft().start());
        } else {
            condition2 = intOrFloat(arithmetic.getLeft().getType());
            predicate(condition2, "Both operands have to be Int or Float", arithmetic.getLeft().start());
        }

        
        if (hasErrors(arithmetic, condition1, condition2)) {
            arithmetic.setLvalue(false);
        } else {
            arithmetic.setType(arithmetic.getLeft().getType());
            arithmetic.setLvalue(false);
        }

        return null;
    }

    // class ArithmeticComparison(Expression left, String operator, Expression right)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(ArithmeticComparison arithmeticComparison, Object param) {
        super.visit(arithmeticComparison, param);

        var condition1 = sameType(arithmeticComparison.getLeft().getType(), arithmeticComparison.getRight().getType());
        predicate(condition1, "Both sides of the ArithmeticComparison must be the same type", arithmeticComparison.getLeft().start());
        if (hasErrors(arithmeticComparison, condition1)) {
            arithmeticComparison.setLvalue(false);
            return null;
        }

        condition1 = intOrFloat(arithmeticComparison.getLeft().getType()) && intOrFloat(arithmeticComparison.getRight().getType());
        predicate(condition1, "Both operands expected to be ints or floats", arithmeticComparison.getLeft().start());
        if (hasErrors(arithmeticComparison, condition1)) {
            arithmeticComparison.setLvalue(false);
        } else {
            arithmeticComparison.setType(new IntType());
            arithmeticComparison.setLvalue(false);
        }

        return null;
    }

    // class LogicalComparison(Expression left, String operator, Expression right)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(LogicalComparison logicalComparison, Object param) {
        super.visit(logicalComparison, param);

        var condition1 = logicalComparison.getLeft().getType() instanceof IntType;
        predicate(condition1, "First operand expected to be an integer, found a " + logicalComparison.getLeft().getType(), logicalComparison.getLeft().start());
        var condition2 = logicalComparison.getRight().getType() instanceof IntType;
        predicate(condition2, "Second operand expected to be an integer, found a " + logicalComparison.getRight().getType(), logicalComparison.getRight().start());

        if (hasErrors(logicalComparison, condition1, condition2)) {
            logicalComparison.setLvalue(false);
        } else {
            logicalComparison.setType(logicalComparison.getLeft().getType());
            logicalComparison.setLvalue(false);
        }

        return null;
    }

    // class Negation(Expression expression)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Negation negation, Object param) {
        super.visit(negation, param);

        var condition = negation.getExpression().getType() instanceof IntType;
        predicate(condition, "Expression must be of type IntType", negation.start());

        if (!hasErrors(negation, condition)) {
            negation.setType(negation.getExpression().getType());
            negation.setLvalue(false);
        }

        return null;
    }

    // class FunctionCallExpression(String name, List<Expression> expressions)
    // phase Identification { FunctionDefinition functionDefinition }
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(FunctionCallExpression functionCallExpression, Object param) {
        super.visit(functionCallExpression, param);

        var condition = functionCallExpression.getExpressions().size() == functionCallExpression.getDefinition().getVarDefinitions().size();
        predicate(condition, "Function call parameters do not match the definition", functionCallExpression.start());
        if (hasErrors(functionCallExpression, condition))
            return null;

        for (int i = 0; i < functionCallExpression.getExpressions().size(); i++) {
            var expr = functionCallExpression.getExpressions().get(i);
            var paramType = functionCallExpression.getDefinition().getVarDefinitions().get(i).getType();
            predicate(sameType(expr.getType(), paramType), "Param with index " + i + " has wrong type", expr.start());
        }

        functionCallExpression.setType(functionCallExpression.getDefinition().getType());
        functionCallExpression.setLvalue(false);
        return null;
    }

    // class StructAccess(Expression expression, String field)
    // phase TypeChecking { boolean lvalue, Type type, StructField structField }
    @Override
    public Object visit(StructAccess structAccess, Object param) {
        super.visit(structAccess, param);

        if (structAccess.getExpression().getType() instanceof ErrorType) {
            structAccess.setLvalue(true);
            structAccess.setType(structAccess.getExpression().getType());
            return null;
        }

        var condition = structAccess.getExpression().getType() instanceof StructType;
        predicate(condition, "Expression must be StructType", structAccess.getExpression().start());
        if (hasErrors(structAccess, condition)) {
            structAccess.setLvalue(true);
            return null;
        }

        StructField field = ((StructType) structAccess.getExpression().getType()).getField(structAccess.getField());
        condition = field != null;
        predicate(condition, "Field not found in struct", structAccess.start());

        if (!hasErrors(structAccess, condition)) {
            structAccess.setStructField(field);
            structAccess.setLvalue(true);
            structAccess.setType(structAccess.getStructField().getType());
        }

        return null;
    }

    // class Cast(Type castType, Expression expression)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Cast cast, Object param) {
        super.visit(cast, param);

        var condition1 = !sameType(cast.getExpression().getType(), cast.getCastType());
        predicate(condition1, "Cannot cast to the same type " + cast.getCastType(), cast.start());

        var condition2 = isSimpleType(cast.getCastType());
        predicate(condition2, "Cannot cast to type " + cast.getCastType(), cast.start());

        var condition3 = isSimpleType(cast.getExpression().getType());
        predicate(condition3, "Cannot cast from type " + cast.getExpression().getType(), cast.start());

        if (!hasErrors(cast, condition1, condition2, condition3)) {
            cast.setType(cast.getCastType());
            cast.setLvalue(false);
        }

        return null;
    }

    // class ArrayAccess(Expression left, Expression right)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(ArrayAccess arrayAccess, Object param) {
        super.visit(arrayAccess, param);

        if (arrayAccess.getLeft().getType() instanceof ErrorType) {
            arrayAccess.setLvalue(false);
            return null;
        }

        var condition = sameType(arrayAccess.getRight().getType(), new IntType());
        predicate(condition, "Array index must be of type IntType", arrayAccess.getRight().start());
        if (hasErrors(arrayAccess, condition)) {
            arrayAccess.setLvalue(false);
            return null;
        }

        condition = arrayAccess.getLeft().getType() instanceof ArrayType;
        predicate(condition, "Trying to access an array, found " + arrayAccess.getLeft().getType(), arrayAccess.getLeft().start());
        if (hasErrors(arrayAccess, condition)) {
            arrayAccess.setLvalue(false);
            return null;
        }

        condition = arrayAccess.getLeft().getType() instanceof ArrayType;
        predicate(condition, "Not accessing an array", arrayAccess.getLeft().start());
        if (hasErrors(arrayAccess, condition)) {
            arrayAccess.setLvalue(false);
            return null;
        }

        condition = arrayAccess.getRight().getType() instanceof IntType;
        predicate(condition, "Array index must be of type IntType", arrayAccess.getRight().start());

        if (hasErrors(arrayAccess, condition)) {
            arrayAccess.setLvalue(false);
        } else {
            var arrayType = (ArrayType) arrayAccess.getLeft().getType();
            arrayAccess.setType(arrayType.getType());
            arrayAccess.setLvalue(true);
        }

        return null;
    }

    private void predicate(boolean condition, String messageError, Position positionError) {
		if(!condition)
			errorManager.notify("Comprobación de tipos", messageError, positionError);
	}

    private boolean isSimpleType(Type type) {
        return type instanceof IntType || type instanceof FloatType || type instanceof CharType;
    }

    private boolean sameType(Type type1, Type type2) {
        if (type1 instanceof ArrayType t1 && type2 instanceof ArrayType t2) {
            return t1.getType().getClass().equals(t2.getType().getClass());
        }
        if (type1 instanceof StructType t1 && type2 instanceof StructType t2) {
            return t1.getStructDefinition().getName().equals(t2.getStructDefinition().getName());
        }
        return type1.getClass().equals(type2.getClass());
    }

    private boolean intOrFloat(Type type) {
        return type instanceof IntType || type instanceof FloatType;
    }

    // TODO: refactor
    private boolean hasReturn(List<Statement> statements) {
        for (Statement stmt : statements) {
            if (stmt instanceof Return)
                return true;
            if (stmt instanceof If) {
                If ifStmt = (If) stmt;
                if (hasReturn(ifStmt.getIfBody()) && hasReturn(ifStmt.getElseBody()))
                    return true;
            }
            if (stmt instanceof While) {
                While whileStmt = (While) stmt;
                if (hasReturn(whileStmt.getStatements()))
                    return true;
            }
        }

        return false;
    }

    private boolean hasErrors(Expression expr, boolean... conditions) {
        for (boolean condition : conditions) {
            if (!condition) {
                expr.setType(ErrorType.getInstance());
                return true;
            }
        }
        return false;
    }

}
