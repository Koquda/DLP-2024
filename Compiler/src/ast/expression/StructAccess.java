// Generated with VGen 2.0.0

package ast.expression;

import ast.type.*;
import ast.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	structAccess: expression -> expression:expression field:string
	expression -> 
	
	PHASE TypeChecking
	expression -> lvalue:boolean
	expression -> type:type
	structAccess -> structField:structField
*/
public class StructAccess extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// structAccess: expression -> expression field:string
	private Expression expression;
	private String field;

    // PHASE TypeChecking
	private StructField structField;

    // ----------------------------------
    // Constructors

	public StructAccess(Expression expression, String field) {
		super();

		if (expression == null)
			throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = expression;

		if (field == null)
			throw new IllegalArgumentException("Parameter 'field' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.field = field;

		updatePositions(expression, field);
	}

	public StructAccess(Object expression, Object field) {
		super();

        if (expression == null)
            throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = (Expression) expression;

        if (field == null)
            throw new IllegalArgumentException("Parameter 'field' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.field = (field instanceof Token) ? ((Token) field).getText() : (String) field;

		updatePositions(expression, field);
	}


    // ----------------------------------
    // structAccess: expression -> expression field:string

	// Child 'expression' 

	public void setExpression(Expression expression) {
		if (expression == null)
			throw new IllegalArgumentException("Parameter 'expression' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.expression = expression;

	}

    public Expression getExpression() {
        return expression;
    }


	// Child 'field:string' 

	public void setField(String field) {
		if (field == null)
			throw new IllegalArgumentException("Parameter 'field' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.field = field;

	}

    public String getField() {
        return field;
    }



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'structField' 

	public void setStructField(StructField structField) {
		if (structField == null)
			throw new IllegalArgumentException("Parameter 'structField' can't be null. Pass a non-null value or use 'structField?' in the abstract grammar");
		this.structField = structField;

	}

    public StructField getStructField() {
        return structField;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "StructAccess{" + " expression=" + this.getExpression() + " field=" + this.getField() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
