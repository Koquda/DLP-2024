grammar Grammar;

import Lexer;

program
	: definition* EOF
	;

definition
	: 'var ' IDENT ':' type ';'
	| 'struct ' IDENT '{' (IDENT ':' type ';')+ '}'
	| func_def
;

func_def
	: IDENT '(' params? ')' (':' type)? '{' definition* statement* '}'
	;

params
	: IDENT ':' type (', ' IDENT ':' type)*
	;

statement
	: expression '=' expression ';'
	| 'if' '(' expression ')' '{' statement* '}' ( 'else' '{' statement* '}' )?
	| 'while ' '(' expression ')' '{' statement* '}'
	| 'read ' expression ';'
	| 'print ' expression ';'
	| 'printsp ' expression ? ';'
	| 'println ' expression ? ';'
	| 'return ' expression ';'
	| 'return;'
	| IDENT '(' expression* (', ' expression)* ')' ';'
	;

// TODO: Comprobar el orden de prioridad
expression
	: INT_LITERAL
	| REAL_LITERAL
	| CHAR_LITERAL
	| IDENT
	| expression ('*' | '/' | '%') expression
	| expression ('+' | '-') expression
	| expression ('<' | '>' | '<=' | '>=' | '==' | '!=') expression
	| expression ('&&' | '||') expression
	| '!' expression
	| '(' expression ')'
	| IDENT '(' expression* (', ' expression)* ')'
	| expression '.' expression
	| '<' type '>(' expression ')'
	| expression '[' expression ']'
	;

type
	: 'int'
	| 'float'
	| 'char' 
	| '[' INT_LITERAL ']' type 
	| IDENT
	;
