// Generated with VGen 2.0.0

grammar Grammar;

@header {
	    import ast.expression.*;
	    import ast.statement.*;
	    import ast.definition.*;
	    import ast.type.*;
	    import ast.*;
}

program returns[Program ast]
    :                                     { $ast = new Program(/* new List<definicion>(...) */); }
	;


//$ -----------------------------------------------------------------------------
// WARNING. The following nodes are NOT accesibles from the first node of the
// grammar (program)

varDefinition returns[VarDefinition ast]
    : name=IDENT type                     { $ast = new VarDefinition($name, $type.ast); }        
	;

structDefinition returns[StructDefinition ast]
    : name=IDENT                          { $ast = new StructDefinition($name, /* new fields(...) */); }
	;

funcDefinition returns[FuncDefinition ast]
    : name=IDENT                          { $ast = new FuncDefinition($name); }                  
	;

assignment returns[Assignment ast]
    : variable expression                 { $ast = new Assignment($variable.ast, $expression.ast); }
	;

if returns[If ast]
    : expression ifBody+=statement* elseBody+=statement* { $ast = new If($expression.ast, $ifBody, $elseBody); }
	;

while returns[While ast]
    : expression body+=statement*         { $ast = new While($expression.ast, $body); }          
	;

read returns[Read ast]
    : expression                          { $ast = new Read($expression.ast); }                  
	;

print returns[Print ast]
    : expression                          { $ast = new Print($expression.ast); }                 
	;

return returns[Return ast]
    : expression                          { $ast = new Return($expression.ast); }                
	;

funcCall returns[FuncCall ast]
    : params+=expression*                 { $ast = new FuncCall($params); }                      
	;

intLiteral returns[IntLiteral ast]
    : INT_LITERAL                         { $ast = new IntLiteral($INT_LITERAL); }               
	;

floatLiteral returns[FloatLiteral ast]
    : FLOAT_LITERAL                       { $ast = new FloatLiteral($FLOAT_LITERAL); }           
	;

charLiteral returns[CharLiteral ast]
    : CHAR_LITERAL                        { $ast = new CharLiteral($CHAR_LITERAL); }             
	;

variable returns[Variable ast]
    : name=IDENT                          { $ast = new Variable($name); }                        
	;

arithmetic returns[Arithmetic ast]
    : left=expression operator=IDENT right=expression { $ast = new Arithmetic($left.ast, $operator, $right.ast); }
	;


// ---------------------------------------------------------------
// Tokens

IDENT: [a-zA-Z_][a-zA-Z0-9_]*;
FLOAT_LITERAL: [0-9]+ '.' [0-9]+;
INT_LITERAL: [0-9]+;
CHAR_LITERAL: '\'' ~[\t\r\n] '\'' | '\'\\n\'';
