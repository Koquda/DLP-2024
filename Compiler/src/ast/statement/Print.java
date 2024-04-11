// Generated with VGen 2.0.0

package ast.statement;

import ast.expression.*;
import ast.definition.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	print: statement -> expressions:expression* lexema:string
	statement -> 
	
	PHASE TypeChecking
	statement -> functionWhereDefined:functionDefinition
*/
public class Print extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// print: statement -> expression* lexema:string
	private List<Expression> expressions;
	private String lexema;

    // ----------------------------------
    // Constructors

	public Print(List<Expression> expressions, String lexema) {
		super();

		if (expressions == null)
			expressions = new ArrayList<>();
		this.expressions = expressions;

		if (lexema == null)
			throw new IllegalArgumentException("Parameter 'lexema' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.lexema = lexema;

		updatePositions(expressions, lexema);
	}

	public Print(Object expressions, Object lexema) {
		super();

        this.expressions = castList(expressions, unwrapIfContext.andThen(Expression.class::cast));
        if (lexema == null)
            throw new IllegalArgumentException("Parameter 'lexema' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.lexema = (lexema instanceof Token) ? ((Token) lexema).getText() : (String) lexema;

		updatePositions(expressions, lexema);
	}


    // ----------------------------------
    // print: statement -> expression* lexema:string

	// Child 'expression*' 

	public void setExpressions(List<Expression> expressions) {
		if (expressions == null)
			expressions = new ArrayList<>();
		this.expressions = expressions;

	}

    public List<Expression> getExpressions() {
        return expressions;
    }

    public Stream<Expression> expressions() {
        return expressions.stream();
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
        return "Print{" + " expressions=" + this.getExpressions() + " lexema=" + this.getLexema() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
