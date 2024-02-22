lexer grammar Lexer;

IDENT
	: [a-zA-Z_] [a-zA-Z_0-9]*
	;

INT_LITERAL
	: [0-9]+
	;

REAL_LITERAL
	: INT_LITERAL '.' INT_LITERAL
	;

CHAR_LITERAL
	: '\'' ~[\r\n] '\''
	| '\'\\n\''
	;

LINE_COMMENT
	: '//' .*? ('\n' | EOF) -> skip
	;

MULTILINE_COMMENT
	: '/*' .*? '*/' -> skip
	;

WHITESPACE
	: [ \t\r\n]+ -> skip
	;
