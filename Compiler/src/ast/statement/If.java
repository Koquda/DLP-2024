// Generated with VGen 2.0.0

package ast.statement;

import ast.expression.*;
import ast.definition.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	if: statement -> condition:expression ifBody:statement* elseBody:statement*
	statement -> 
	
	PHASE TypeChecking
	statement -> functionWhereDefined:functionDefinition
*/
public class If extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// if: statement -> condition:expression ifBody:statement* elseBody:statement*
	private Expression condition;
	private List<Statement> ifBody;
	private List<Statement> elseBody;

    // ----------------------------------
    // Constructors

	public If(Expression condition, List<Statement> ifBody, List<Statement> elseBody) {
		super();

		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = condition;

		if (ifBody == null)
			ifBody = new ArrayList<>();
		this.ifBody = ifBody;

		if (elseBody == null)
			elseBody = new ArrayList<>();
		this.elseBody = elseBody;

		updatePositions(condition, ifBody, elseBody);
	}

	public If(Object condition, Object ifBody, Object elseBody) {
		super();

        if (condition == null)
            throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = (Expression) condition;

        this.ifBody = castList(ifBody, unwrapIfContext.andThen(Statement.class::cast));
        this.elseBody = castList(elseBody, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(condition, ifBody, elseBody);
	}


    // ----------------------------------
    // if: statement -> condition:expression ifBody:statement* elseBody:statement*

	// Child 'condition:expression' 

	public void setCondition(Expression condition) {
		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = condition;

	}

    public Expression getCondition() {
        return condition;
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
        return "If{" + " condition=" + this.getCondition() + " ifBody=" + this.getIfBody() + " elseBody=" + this.getElseBody() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
