grammar Grammar;

import Lexicon;

start : data code EOF;

data : 'DATA' varList;
code : 'CODE' statementList;

varList : varList varDef |
          varDef;
varDef : varType IDENT ';';
varType : INT | REAL;

statementList : statementList statement |
                statement;
statement : ifStatement | whileStatement | funcCall | assign | read | print;

expression: IDENT |
            LITENT |
            LITREAL |
            expression '+' expression |
            '(' expression ')' |
            '<' varType '>(' expression ')';

ifStatement : 'if (' condition ')' '{' statementList '}' elseStatement?;
elseStatement : 'else' '{' statementList '}';
whileStatement : 'while (' condition ')' '{' statementList '}';
condition : LITENT |
            expression '!=' expression ;

read : 'read ' IDENT ';';
print : 'print ' expression ';';
assign : IDENT '=' expression ';';

// Llamadas a funciones
funcCall: IDENT '(' paramList? ')' ';';
paramList : paramList ',' expression |
            expression;

