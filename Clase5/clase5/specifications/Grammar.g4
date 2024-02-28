grammar Grammar;

import Lexer;
@header {
	import ast.*;
	import ast.expression.*;
	import ast.statement.*;
	import ast.definition.*;
	import ast.type.*;
}

program returns[Program ast]
	: definitions+=definition* EOF { $ast = new Program($definitions); }
	;

definition returns[Definition ast]
	: 'var ' IDENT ':' type ';' { $ast = new VarDefinition($IDENT, $type.ast); }
	| 'struct ' IDENT  '{' fields+=structField+ '}' { $ast = new StructDefinition($IDENT, $fields); }
	| IDENT '(' paramList+=params? ')' (':' type)? ' {' definitions+=definition* statements+=statement* '}' { $ast = new FuncDefinition($IDENT, $paramList, $type.ast, $definitions, $statements); }
;

structField returns[StructField ast]
	: IDENT ':' type ';' { $ast = new StructField($IDENT, $type.ast); }
	;

params returns[FuncParam ast]
	: IDENT ':' type (', ' IDENT ':' type)* { $ast = new FuncParam($IDENT, $type.ast); }
	;

statement returns[Statement ast]
	: left=expression ' = ' right=expression ';' { $ast = new Assignment($left.ast, $right.ast); }
	| 'if (' expression ') {' ifBody+=statement* '}' ( ' else {' elseBody+=statement* '}' )? { $ast = new If($expression.ast, $ifBody, $elseBody); }
	| 'while (' expression ') {' statements+=statement* '}' { $ast = new While($expression.ast, $statements); }
	| 'read ' expression ';' { $ast = new Read($expression.ast); }
	| 'print ' expression ';' { $ast = new Print($expression.ast); }
	| 'printsp ' expression ? ';' { $ast = new Print($expression.ast); }
	| 'println ' expression ? ';' { $ast = new Print($expression.ast); }
	| 'return' (' ' expression)? ';' { $ast = new Return($expression.ast); }
	;

// TODO: Comprobar el orden de prioridad
expression returns[Expression ast]
	: INT_LITERAL { $ast = new IntLiteral($INT_LITERAL); }
	| REAL_LITERAL { $ast = new FloatLiteral($REAL_LITERAL); }
	| CHAR_LITERAL { $ast = new CharLiteral($CHAR_LITERAL); }
	| IDENT { $ast = new Variable($IDENT); }
	| left=expression ' '?  op=('*' | '/' | '%') ' '?  right=expression { $ast = new Arithmetic($left.ast, $op.text, $right.ast); }
	| left=expression ' '? op=('+' | '-') ' '? right=expression { $ast = new Arithmetic($left.ast, $op.text, $right.ast); }
	| left=expression ' '? op=('<' | '>' | '<=' | '>=' | '==' | '!=') ' '? right=expression { $ast = new ArithmeticComparison($left.ast, $op.text, $right.ast); }
	| left=expression op=('&&' | '||') right=expression { $ast = new LogicalComparison($left.ast, $op.text, $right.ast); }
	| '!' expression { $ast = new Negation($expression.ast); }
	| '(' expression ')' { $ast = $expression.ast; }
	| IDENT '(' expressions+=expression (', ' expressions+=expression)* ')' { $ast = new FuncCall($IDENT, $expressions); }
	| expression '.' IDENT { $ast = new StructAccess($expression.ast, $IDENT); }
	| '<' type '>(' expression ')' { $ast = new Cast($type.ast, $expression.ast); }
	| left=expression '[' right=expression ']' { $ast = new ArrayAccess($left.ast, $right.ast); }
	;

type returns[Type ast]
	: 'int' { $ast = new IntType(); }
	| 'float' { $ast = new FloatType(); }
	| 'char' { $ast = new CharType(); }
	| '[' INT_LITERAL ']' ' '? type { $ast = new ArrayType($INT_LITERAL, $type.ast); }
	| IDENT { $ast = new StructType($IDENT); }
	;
