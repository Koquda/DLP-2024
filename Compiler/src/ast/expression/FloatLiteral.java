// Generated with VGen 2.0.0

package ast.expression;

import ast.type.*;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	floatLiteral: expression -> value:float
	expression -> 
	
	PHASE TypeChecking
	expression -> lvalue:boolean
	expression -> type:type
*/
public class FloatLiteral extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// floatLiteral: expression -> value:float
	private float value;

    // ----------------------------------
    // Constructors

	public FloatLiteral(float value) {
		super();

		this.value = value;

		updatePositions(value);
	}

	public FloatLiteral(Object value) {
		super();

        if (value == null)
            throw new IllegalArgumentException("Parameter 'value' can't be null. Pass a non-null value or use 'float?' in the abstract grammar");
        var value_temp = value;
        if (value_temp instanceof Token)
            value_temp = ((Token) value_temp).getText();
        if (value_temp instanceof String)
            value_temp = Float.valueOf((String) value_temp);
        this.value = (float) value_temp;

		updatePositions(value);
	}


    // ----------------------------------
    // floatLiteral: expression -> value:float

	// Child 'value:float' 

	public void setValue(float value) {
		this.value = value;

	}

    public float getValue() {
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
        return "FloatLiteral{" + " value=" + this.getValue() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
