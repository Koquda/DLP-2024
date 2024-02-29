// Generated with VGen 2.0.0

package ast.statement;

import ast.expression.*;
import java.util.Optional;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------


/*
	print: statement -> expression:expression? lexema:string
	statement -> 
*/
public class Print extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// print: statement -> expression? lexema:string
	private Optional<Expression> expression;
	private String lexema;

    // ----------------------------------
    // Constructors

	public Print(Optional<Expression> expression, String lexema) {
		super();

		if (expression == null)
			expression = Optional.empty();
		this.expression = expression;

		if (lexema == null)
			throw new IllegalArgumentException("Parameter 'lexema' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.lexema = lexema;

		updatePositions(expression, lexema);
	}

	public Print(Object expression, Object lexema) {
		super();

        this.expression = castOptional(expression, Expression.class);
        if (lexema == null)
            throw new IllegalArgumentException("Parameter 'lexema' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.lexema = (lexema instanceof Token) ? ((Token) lexema).getText() : (String) lexema;

		updatePositions(expression, lexema);
	}


    // ----------------------------------
    // print: statement -> expression? lexema:string

	// Child 'expression?' 

	public void setExpression(Optional<Expression> expression) {
		if (expression == null)
			expression = Optional.empty();
		this.expression = expression;

	}

    public Optional<Expression> getExpression() {
        return expression;
    }


	// Child 'lexema:string' 

	public void setLexema(String lexema) {
		if (lexema == null)
			throw new IllegalArgumentException("Parameter 'lexema' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.lexema = lexema;

	}

    public String getLexema() {
        return lexema;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Print{" + " expression=" + this.getExpression() + " lexema=" + this.getLexema() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------

}
