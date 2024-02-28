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
    : definitions+=definition*            { $ast = new Program($definitions); }                  
	;

definition returns[Definition ast]
    : name=IDENT type                     { $ast = new VarDefinition($name, $type.ast); }        
    | name=IDENT structFields+=structField* { $ast = new StructDefinition($name, $structFields); } 
    | name=IDENT funcParams+=funcParam* type definitions+=definition* statements+=statement* { $ast = new FuncDefinition($name, $funcParams, $type.ast, $definitions, $statements); }
	;

type returns[Type ast]
    :                                     { $ast = new IntType(); }                              
    |                                     { $ast = new FloatType(); }                            
    |                                     { $ast = new CharType(); }                             
    | name=IDENT                          { $ast = new VarType($name); }                         
    | INT_LITERAL type                    { $ast = new ArrayType($INT_LITERAL, $type.ast); }     
    | name=IDENT                          { $ast = new StructType($name); }                      
    |                                     { $ast = new VoidType(); }                             
    |                                     { $ast = new ErrorType(); }                            
	;

structField returns[StructField ast]
    : name=IDENT type                     { $ast = new StructField($name, $type.ast); }          
	;

funcParam returns[FuncParam ast]
    : name=IDENT type                     { $ast = new FuncParam($name, $type.ast); }            
	;

statement returns[Statement ast]
    : left=expression right=expression    { $ast = new Assignment($left.ast, $right.ast); }      
    | name=IDENT expressions+=expression* { $ast = new FuncCallStatement($name, $expressions); } 
    | expression ifBody+=statement* elseBody+=statement* { $ast = new If($expression.ast, $ifBody, $elseBody); }
    | expression statements+=statement*   { $ast = new While($expression.ast, $statements); }    
    | expression                          { $ast = new Read($expression.ast); }                  
    | expression? lexema=IDENT            { $ast = new Print(($expression.ctx == null) ? null : $expression.ast, $lexema); }
    | expression?                         { $ast = new Return(($expression.ctx == null) ? null : $expression.ast); }
	;

expression returns[Expression ast]
    : INT_LITERAL                         { $ast = new IntLiteral($INT_LITERAL); }               
    | FLOAT_LITERAL                       { $ast = new FloatLiteral($FLOAT_LITERAL); }           
    | CHAR_LITERAL                        { $ast = new CharLiteral($CHAR_LITERAL); }             
    | name=IDENT                          { $ast = new Variable($name); }                        
    | left=expression operator1=IDENT right=expression { $ast = new Arithmetic($left.ast, $operator1, $right.ast); }
    | left=expression operator=IDENT right=expression { $ast = new ArithmeticComparison($left.ast, $operator, $right.ast); }
    | left=expression operator=IDENT right=expression { $ast = new LogicalComparison($left.ast, $operator, $right.ast); }
    | expression                          { $ast = new Negation($expression.ast); }              
    | name=IDENT expressions+=expression* { $ast = new FuncCallExpression($name, $expressions); }
    | expression name=IDENT               { $ast = new StructAccess($expression.ast, $name); }   
    | type expression                     { $ast = new Cast($type.ast, $expression.ast); }       
    | left=expression right=expression    { $ast = new ArrayAccess($left.ast, $right.ast); }     
	;


// ---------------------------------------------------------------
// Tokens

IDENT: [a-zA-Z_][a-zA-Z0-9_]*;
FLOAT_LITERAL: [0-9]+ '.' [0-9]+;
INT_LITERAL: [0-9]+;
CHAR_LITERAL: '\'' ~[\t\r\n] '\'' | '\'\\n\'';
