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

import com.sun.jdi.DoubleType;
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
        functionDefinition.varDefinitions().forEach(funcParam -> isSimpleType(funcParam.getType()));
        if (!(functionDefinition.getType() instanceof VoidType))
            isSimpleType(functionDefinition.getType());

        // Semantic functions
        functionDefinition.statements().forEach(stmt -> stmt.setFunctionDefinition(functionDefinition));

        super.visit(functionDefinition, param);

        return null;
    }

    // class StructField(String name, Type type)
    @Override
    public Object visit(StructField structField, Object param) {

        isSimpleType(structField.getType());
        super.visit(structField, param);

        return null;
    }

    // class Assignment(Expression left, Expression right)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(Assignment assignment, Object param) {
        super.visit(assignment, param);

        sameType(assignment.getLeft().getType(), assignment.getRight().getType());

        return null;
    }

    // class FunctionCallStatement(String name, List<Expression> expressions)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(FunctionCallStatement functionCallStatement, Object param) {

        sameParams(functionCallStatement.getExpressions(), functionCallStatement.getFunctionDefinition().getVarDefinitions());
        super.visit(functionCallStatement, param);

        return null;
    }

    // class If(Expression condition, List<Statement> ifBody, List<Statement> elseBody)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(If ifValue, Object param) {

        // Predicates
        if (ifValue.getCondition().getType() instanceof IntType)
            notifyError("Condition must be of type IntType");

        // Semantic functions
        ifValue.getIfBody().forEach(stmt -> stmt.setFunctionDefinition(ifValue.getFunctionDefinition()));
        ifValue.getElseBody().forEach(stmt -> stmt.setFunctionDefinition(ifValue.getFunctionDefinition()));

        super.visit(ifValue, param);

        return null;
    }

    // class While(Expression condition, List<Statement> statements)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(While whileValue, Object param) {

        // Predicates
        if (whileValue.getCondition().getType() instanceof IntType)
            notifyError("Condition must be of type IntType");

        // Semantic functions
        whileValue.getStatements().forEach(stmt -> stmt.setFunctionDefinition(whileValue.getFunctionDefinition()));

        super.visit(whileValue, param);

        return null;
    }

    // class Read(Expression expression)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(Read read, Object param) {
        isSimpleType(read.getExpression().getType());

        super.visit(read, param);

        return null;
    }

    // class Print(List<Expression> expressions, String lexema)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(Print print, Object param) {
        super.visit(print, param);

        print.expressions().forEach(expr -> isSimpleType(expr.getType()));

        return null;
    }

    // class Return(Optional<Expression> expression)
    // phase TypeChecking { FunctionDefinition functionDefinition }
    @Override
    public Object visit(Return returnValue, Object param) {
        super.visit(returnValue, param);

        if (returnValue.getExpression().isPresent())
            sameType(returnValue.getExpression().get().getType(), returnValue.getFunctionDefinition().getType());

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

        sameType(arithmetic.getLeft().getType(), arithmetic.getRight().getType());

        arithmetic.setType(arithmetic.getLeft().getType());
        arithmetic.setLvalue(true);
        return null;
    }

    // class ArithmeticComparison(Expression left, String operator, Expression right)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(ArithmeticComparison arithmeticComparison, Object param) {
        if (arithmeticComparison.getOperator().equals("%")) {
            if (!(arithmeticComparison.getLeft().getType() instanceof IntType && arithmeticComparison.getRight().getType() instanceof IntType)) {
                notifyError("Both sides of the operation must be of type IntType");
            }
        } else {
            intOrDouble(arithmeticComparison.getLeft().getType());
            intOrDouble(arithmeticComparison.getRight().getType());
        }

        super.visit(arithmeticComparison, param);

        arithmeticComparison.setType(arithmeticComparison.getLeft().getType());
        arithmeticComparison.setLvalue(false);
        return null;
    }

    // class LogicalComparison(Expression left, String operator, Expression right)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(LogicalComparison logicalComparison, Object param) {

        if (!(logicalComparison.getLeft().getType() instanceof IntType && logicalComparison.getRight().getType() instanceof IntType))
            notifyError("Both sides of the operation must be of type IntType");

        super.visit(logicalComparison, param);

        logicalComparison.setType(logicalComparison.getLeft().getType());
        logicalComparison.setLvalue(false);
        return null;
    }

    // class Negation(Expression expression)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Negation negation, Object param) {

        if (!(negation.getType() instanceof IntType))
            notifyError("Both sides of the operation must be of type IntType");

        super.visit(negation, param);

        negation.setType(negation.getExpression().getType());
        negation.setLvalue(false);
        return null;
    }

    // class FunctionCallExpression(String name, List<Expression> expressions)
    // phase Identification { FunctionDefinition functionDefinition }
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(FunctionCallExpression functionCallExpression, Object param) {
        super.visit(functionCallExpression, param);

        sameParams(functionCallExpression.getExpressions(), functionCallExpression.getFunctionDefinition().getVarDefinitions());

        functionCallExpression.setType(functionCallExpression.getFunctionDefinition().getType());
        functionCallExpression.setLvalue(false);
        return null;
    }

    // class StructAccess(Expression expression, String field)
    // phase TypeChecking { boolean lvalue, Type type, StructField structField }
    @Override
    public Object visit(StructAccess structAccess, Object param) {

        super.visit(structAccess, param);

        // TODO: Remember to initialize SYNTHESIZED attributes <-----
        // structAccess.setLvalue(?);
        // structAccess.setType(?);
        // structAccess.setStructField(?);
        return null;
    }

    // class Cast(Type castType, Expression expression)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(Cast cast, Object param) {
        isSimpleType(cast.getCastType());

        super.visit(cast, param);

        cast.setType(cast.getExpression().getType());
        cast.setLvalue(false);
        return null;
    }

    // class ArrayAccess(Expression left, Expression right)
    // phase TypeChecking { boolean lvalue, Type type }
    @Override
    public Object visit(ArrayAccess arrayAccess, Object param) {
        if (!(arrayAccess.getRight().getType() instanceof IntType))
            notifyError("Index must be of type IntType");

        super.visit(arrayAccess, param);

        arrayAccess.setType(arrayAccess.getLeft().getType());
        arrayAccess.setLvalue(true);
        return null;
    }

    private void isSimpleType(Type type) {
        if (type instanceof IntType || type instanceof DoubleType || type instanceof CharType)
            return;

        notifyError("Type " + type.getClass() + " is not a simple type");
    }

    private void sameType(Type type1, Type type2) {
        if (!type1.getClass().equals(type2.getClass()))
            notifyError("Types are not the same");
    }

    private void sameParams(List<Expression> callParams, List<VarDefinition> defParams) {
        if (callParams.size() != defParams.size())
            notifyError("Number of parameters is not the same");

        for (int i = 0; i < callParams.size(); i++) {
            if (!callParams.get(i).getType().getClass().equals(defParams.get(i).getType().getClass()))
                notifyError("Parameter types are not the same");
        }
    }

    private void intOrDouble(Type type) {
        if (!(type instanceof IntType || type instanceof DoubleType))
            notifyError("Type must be IntType or DoubleType");
    }

    private void notifyError(String msg) {
        errorManager.notify("Identification", msg);
    }

}
