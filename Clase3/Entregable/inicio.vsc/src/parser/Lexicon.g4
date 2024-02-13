lexer grammar Lexicon;

LITENT : [0-9]+;
LITREAL: [0-9]+ '.' [0-9]+;

COMMENT : '/*' .*? '*/' -> skip;

REAL: 'real';
INT: 'int';

IDENT: [a-zA-Z][a-zA-Z0-9_]*;

WS : [ \t\r\n]+ -> skip;

