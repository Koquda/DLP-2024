// Generated with VGen 2.0.0

package ast.expression;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	intLiteral: expression -> value:int
	expression -> 
*/
public class IntLiteral extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// intLiteral: expression -> value:int
	private int value;

    // ----------------------------------
    // Constructors

	public IntLiteral(int value) {
		super();

		this.value = value;

		updatePositions(value);
	}

	public IntLiteral(Object value) {
		super();

        if (value == null)
            throw new IllegalArgumentException("Parameter 'value' can't be null. Pass a non-null value or use 'int?' in the abstract grammar");
        var value_temp = value;
        if (value_temp instanceof Token)
            value_temp = ((Token) value_temp).getText();
        if (value_temp instanceof String)
            value_temp = Integer.valueOf((String) value_temp);
        this.value = (int) value_temp;

		updatePositions(value);
	}


    // ----------------------------------
    // intLiteral: expression -> value:int

	// Child 'value:int' 

	public void setValue(int value) {
		this.value = value;

	}

    public int getValue() {
        return value;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "IntLiteral{" + " value=" + this.getValue() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
