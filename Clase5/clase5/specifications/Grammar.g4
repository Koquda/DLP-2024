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

definition returns[Definition ast] locals [Type t]
	: 'var' IDENT ':' type ';' { $ast = new VarDefinition($IDENT, $type.ast); }
	| 'struct' IDENT  '{' fields+=structField+ '}' { $ast = new StructDefinition($IDENT, $fields); }
	| IDENT '(' (paramList+=param (',' paramList+=param)*)? ')' { $t = new VoidType();} (':' type { $t = $type.ast;})? '{' definitions+=definition* statements+=statement* '}' {
		 	$ast = new FuncDefinition($IDENT, $paramList, $t, $definitions, $statements); 
		}
;

structField returns[StructField ast]
	: IDENT ':' type ';' { $ast = new StructField($IDENT, $type.ast); }
	;

param returns[FuncParam ast]
	: IDENT ':' type { $ast = new FuncParam($IDENT, $type.ast); }
	;

statement returns[Statement ast]
	: left=expression '=' right=expression ';' { $ast = new Assignment($left.ast, $right.ast); }
	| IDENT '(' (expressions+=expression (',' expressions+=expression)*)? ')' ';' { $ast = new FuncCallStatement($IDENT, $expressions); }
	| 'if' '(' expression ')' '{' ifBody+=statement* '}' ( 'else' '{' elseBody+=statement* '}' )? { $ast = new If($expression.ast, $ifBody, $elseBody); }
	| 'while' '(' expression ')' '{' statements+=statement* '}' { $ast = new While($expression.ast, $statements); }
	| 'read' expression ';' { $ast = new Read($expression.ast); }
	| 'print' expression ';' { $ast = new Print($expression.ast, ""); }
	| 'printsp' expression? ';' { $ast = new Print($expression.ctx != null ? $expression.ast : null, "sp"); }
	| 'println' expression? ';' { $ast = new Print($expression.ctx != null ? $expression.ast : null, "ln"); }
	| 'return' expression? ';' { $ast = new Return($expression.ctx != null ? $expression.ast : null); }
	;

// TODO: Comprobar el orden de prioridad
expression returns[Expression ast]
	: INT_LITERAL { $ast = new IntLiteral($INT_LITERAL); }
	| REAL_LITERAL { $ast = new FloatLiteral($REAL_LITERAL); }
	| CHAR_LITERAL { $ast = new CharLiteral($CHAR_LITERAL); }
	| IDENT { $ast = new Variable($IDENT); }
	| '(' expression ')' { $ast = $expression.ast; }
	| left=expression op=('*' | '/') right=expression { $ast = new Arithmetic($left.ast, $op.text, $right.ast); }
	| left=expression op=('+' | '-') right=expression { $ast = new Arithmetic($left.ast, $op.text, $right.ast); }
	| left=expression op='%' right=expression { $ast = new Arithmetic($left.ast, $op.text, $right.ast); }
	| left=expression op=('<' | '>' | '<=' | '>=' | '==' | '!=') right=expression { $ast = new ArithmeticComparison($left.ast, $op.text, $right.ast); }
	| left=expression op=('&&' | '||') right=expression { $ast = new LogicalComparison($left.ast, $op.text, $right.ast); }
	| '!' expression { $ast = new Negation($expression.ast); }
	| IDENT '(' (expressions+=expression (',' expressions+=expression)*)? ')' { $ast = new FuncCallExpression($IDENT, $expressions); }
	| left=expression '[' right=expression ']' { $ast = new ArrayAccess($left.ast, $right.ast); }
	| left=expression '.' IDENT { $ast = new StructAccess($left.ast, $IDENT); }
	| '<' type '>' '(' expression ')' { $ast = new Cast($type.ast, $expression.ast); }
	;

type returns[Type ast]
	: 'int' { $ast = new IntType(); }
	| 'float' { $ast = new FloatType(); }
	| 'char' { $ast = new CharType(); }
	| '[' INT_LITERAL ']'  type { $ast = new ArrayType($INT_LITERAL, $type.ast); }
	| IDENT { $ast = new StructType($IDENT); }
	;
