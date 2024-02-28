// Generated with VGen 2.0.0

package ast.statement;

import ast.expression.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	if: statement -> expression:expression ifBody:statement* elseBody:statement*
	statement -> 
*/
public class If extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// if: statement -> expression ifBody:statement* elseBody:statement*
	private Expression expression;
	private List<Statement> ifBody;
	private List<Statement> elseBody;

    // ----------------------------------
    // Constructors

	public If(Expression expression, List<Statement> ifBody, List<Statement> elseBody) {
		super();

		if (expression == null)
			throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = expression;

		if (ifBody == null)
			ifBody = new ArrayList<>();
		this.ifBody = ifBody;

		if (elseBody == null)
			elseBody = new ArrayList<>();
		this.elseBody = elseBody;

		updatePositions(expression, ifBody, elseBody);
	}

	public If(Object expression, Object ifBody, Object elseBody) {
		super();

        if (expression == null)
            throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = (Expression) expression;

        this.ifBody = castList(ifBody, unwrapIfContext.andThen(Statement.class::cast));
        this.elseBody = castList(elseBody, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(expression, ifBody, elseBody);
	}


    // ----------------------------------
    // if: statement -> expression ifBody:statement* elseBody:statement*

	// Child 'expression' 

	public void setExpression(Expression expression) {
		if (expression == null)
			throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = expression;

	}

    public Expression getExpression() {
        return expression;
    }


	// Child 'ifBody:statement*' 

	public void setIfBody(List<Statement> ifBody) {
		if (ifBody == null)
			ifBody = new ArrayList<>();
		this.ifBody = ifBody;

	}

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public Stream<Statement> ifBody() {
        return ifBody.stream();
    }


	// Child 'elseBody:statement*' 

	public void setElseBody(List<Statement> elseBody) {
		if (elseBody == null)
			elseBody = new ArrayList<>();
		this.elseBody = elseBody;

	}

    public List<Statement> getElseBody() {
        return elseBody;
    }

    public Stream<Statement> elseBody() {
        return elseBody.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "If{" + " expression=" + this.getExpression() + " ifBody=" + this.getIfBody() + " elseBody=" + this.getElseBody() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
