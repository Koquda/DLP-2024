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
	while: statement -> condition:expression statements:statement*
	statement -> 
	
	PHASE TypeChecking
	statement -> functionDefinition:functionDefinition
*/
public class While extends AbstractStatement  {

    // ----------------------------------
    // Instance Variables

	// while: statement -> condition:expression statement*
	private Expression condition;
	private List<Statement> statements;

    // ----------------------------------
    // Constructors

	public While(Expression condition, List<Statement> statements) {
		super();

		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = condition;

		if (statements == null)
			statements = new ArrayList<>();
		this.statements = statements;

		updatePositions(condition, statements);
	}

	public While(Object condition, Object statements) {
		super();

        if (condition == null)
            throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = (Expression) condition;

        this.statements = castList(statements, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(condition, statements);
	}


    // ----------------------------------
    // while: statement -> condition:expression statement*

	// Child 'condition:expression' 

	public void setCondition(Expression condition) {
		if (condition == null)
			throw new IllegalArgumentException("Parameter 'condition' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.condition = condition;

	}

    public Expression getCondition() {
        return condition;
    }


	// Child 'statement*' 

	public void setStatements(List<Statement> statements) {
		if (statements == null)
			statements = new ArrayList<>();
		this.statements = statements;

	}

    public List<Statement> getStatements() {
        return statements;
    }

    public Stream<Statement> statements() {
        return statements.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "While{" + " condition=" + this.getCondition() + " statements=" + this.getStatements() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
