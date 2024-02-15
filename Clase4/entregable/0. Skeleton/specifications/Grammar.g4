grammar Grammar;

import Lexer;

program
	: definicion* EOF
	;

definicion
	: 'var ' IDENT ':' tipo ';'
	| 'struct ' IDENT '{' (IDENT ':' tipo ';')+ '}'
	| func_def
;

func_def
	: IDENT '(' parametros? ')' (':' tipo)? '{' definicion* sentencia* '}'
	;

parametros
	: IDENT ':' tipo (', ' IDENT ':' tipo)*
	;

sentencia
	: expresion '=' expresion ';'
	| 'if' '(' expresion ')' '{' sentencia* '}' ( 'else' '{' sentencia* '}' )?
	| 'while ' '(' expresion ')' '{' sentencia* '}'
	| 'read ' expresion ';'
	| 'print ' expresion ';'
	| 'printsp ' expresion ? ';'
	| 'println ' expresion ? ';'
	| 'return ' expresion ';'
	| 'return;'
	| IDENT '(' expresion* (', ' expresion)* ')' ';'
	;

expresion
	: INT_LITERAL
	| REAL_LITERAL
	| CHAR_LITERAL
	| IDENT
	| expresion '+' expresion
	| expresion '-' expresion
	| expresion '*' expresion
	| expresion '/' expresion
	| expresion '%' expresion
	| expresion '<' expresion
	| expresion '>' expresion
	| expresion '<=' expresion
	| expresion '>=' expresion
	| expresion '==' expresion
	| expresion '!=' expresion
	| expresion '&&' expresion
	| expresion '||' expresion
	| '!' expresion
	| '(' expresion ')'
	| IDENT '(' expresion* (', ' expresion)* ')'
	| expresion '.' expresion
	| '<' tipo_simple '>(' expresion ')'
	| expresion '[' expresion ']'
	;


tipo_simple
	: 'int'
	| 'float'
	| 'char'
	;

tipo_complejo
	: ('[' INT_LITERAL ']')+ tipo 
	| IDENT
	;

tipo
	: tipo_simple 
	| tipo_complejo
	;
