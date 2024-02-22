// Generated with VGen 2.0.0

/**
* Este interfaz es el resultado de la aplicación del patrón Visitor a los nodos del AST.
*/

package visitor;

import ast.*;
import ast.definition.*;
import ast.statement.*;
import ast.expression.*;




public interface Visitor {
	public Object visit(Program program, Object param);

	public Object visit(VarDefinition varDefinition, Object param);

	public Object visit(StructDefinition structDefinition, Object param);

	public Object visit(FuncDefinition funcDefinition, Object param);

	public Object visit(Assignment assignment, Object param);

	public Object visit(If ifValue, Object param);

	public Object visit(While whileValue, Object param);

	public Object visit(Read read, Object param);

	public Object visit(Print print, Object param);

	public Object visit(Return returnValue, Object param);

	public Object visit(FuncCall funcCall, Object param);

	public Object visit(IntLiteral intLiteral, Object param);

	public Object visit(FloatLiteral floatLiteral, Object param);

	public Object visit(CharLiteral charLiteral, Object param);

	public Object visit(Variable variable, Object param);

	public Object visit(Arithmetic arithmetic, Object param);


}
