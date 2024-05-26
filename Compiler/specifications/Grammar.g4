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
	| 'struct' IDENT  '{' fields+=structField* '}' { $ast = new StructDefinition($IDENT, $fields); }
	| IDENT '(' (paramList+=param (',' paramList+=param)*)? ')' { $t = new VoidType();} (':' type { $t = $type.ast;})? '{' definitions+=definition* statements+=statement* '}' {
		 	$ast = new FunctionDefinition($IDENT, $paramList, $t, $definitions, $statements); 
		}
;

structField returns[StructField ast]
	: IDENT ':' type ';' { $ast = new StructField($IDENT, $type.ast); }
	;

param returns[VarDefinition ast]
	: IDENT ':' type { $ast = new VarDefinition($IDENT, $type.ast); }
	;

statement returns[Statement ast]
	: left=expression '=' right=expression ';' { $ast = new Assignment($left.ast, $right.ast); }
	| IDENT '(' (expressions+=expression (',' expressions+=expression)*)? ')' ';' { $ast = new FunctionCallStatement($IDENT, $expressions); }
	| 'if' '(' expression ')' '{' ifBody+=statement* '}' ( 'else' '{' elseBody+=statement* '}' )? { $ast = new If($expression.ast, $ifBody, $elseBody); }
	| 'while' '(' expression ')' '{' statements+=statement* '}' { $ast = new While($expression.ast, $statements); }
	| 'read' expression ';' { $ast = new Read($expression.ast); }
	| 'print' (expressions+=expression (',' expressions+=expression)*)? ';' { $ast = new Print($expressions, ""); }
	| 'printsp' (expressions+=expression (',' expressions+=expression)*)? ';' { $ast = new Print($expressions, "sp"); }
	| 'println' (expressions+=expression (',' expressions+=expression)*)? ';' { $ast = new Print($expressions, "ln"); }
	| 'return' expression? ';' { $ast = new Return($expression.ctx != null ? $expression.ast : null); }
	;

expression returns[Expression ast]
	: INT_LITERAL { $ast = new IntLiteral($INT_LITERAL); }
	| REAL_LITERAL { $ast = new FloatLiteral($REAL_LITERAL); }
	| CHAR_LITERAL { $ast = new CharLiteral($CHAR_LITERAL); }
	| IDENT { $ast = new Variable($IDENT); }
	| IDENT '(' (expressions+=expression (',' expressions+=expression)*)? ')' { $ast = new FunctionCallExpression($IDENT, $expressions); }
	| '(' expression ')' { $ast = $expression.ast; }
	| left=expression '[' right=expression ']' { $ast = new ArrayAccess($left.ast, $right.ast); }
	| left=expression '.' IDENT { $ast = new StructAccess($left.ast, $IDENT); }
	| '!' expression { $ast = new Negation($expression.ast); }
	| '<' type '>' '(' expression ')' { $ast = new Cast($type.ast, $expression.ast); }
	| left=expression op=('*' | '/') right=expression { $ast = new Arithmetic($left.ast, $op.text, $right.ast); }
	| left=expression op=('+' | '-') right=expression { $ast = new Arithmetic($left.ast, $op.text, $right.ast); }
	| left=expression op='%' right=expression { $ast = new Arithmetic($left.ast, $op.text, $right.ast); }
	| left=expression op=('<' | '>' | '<=' | '>=' | '==' | '!=') right=expression { $ast = new ArithmeticComparison($left.ast, $op.text, $right.ast); }
	| left=expression op=('&&' | '||') right=expression { $ast = new LogicalComparison($left.ast, $op.text, $right.ast); }
	;

type returns[Type ast]
	: 'int' { $ast = new IntType(); }
	| 'float' { $ast = new FloatType(); }
	| 'char' { $ast = new CharType(); }
	| '[' INT_LITERAL ']'  type { $ast = new ArrayType($INT_LITERAL, $type.ast); }
	| IDENT { $ast = new StructType($IDENT); }
	;
