// Generated with VGen 2.0.0

package ast.expression;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	arithmetic: expression -> left:expression operator1:string right:expression
	expression -> 
*/
public class Arithmetic extends AbstractExpression  {

    // ----------------------------------
    // Instance Variables

	// arithmetic: expression -> left:expression operator1:string right:expression
	private Expression left;
	private String operator1;
	private Expression right;

    // ----------------------------------
    // Constructors

	public Arithmetic(Expression left, String operator1, Expression right) {
		super();

		if (left == null)
			throw new IllegalArgumentException("Parameter 'left' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.left = left;

		if (operator1 == null)
			throw new IllegalArgumentException("Parameter 'operator1' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.operator1 = operator1;

		if (right == null)
			throw new IllegalArgumentException("Parameter 'right' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.right = right;

		updatePositions(left, operator1, right);
	}

	public Arithmetic(Object left, Object operator1, Object right) {
		super();

        if (left == null)
            throw new IllegalArgumentException("Parameter 'left' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.left = (Expression) left;

        if (operator1 == null)
            throw new IllegalArgumentException("Parameter 'operator1' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.operator1 = (operator1 instanceof Token) ? ((Token) operator1).getText() : (String) operator1;

        if (right == null)
            throw new IllegalArgumentException("Parameter 'right' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.right = (Expression) right;

		updatePositions(left, operator1, right);
	}


    // ----------------------------------
    // arithmetic: expression -> left:expression operator1:string right:expression

	// Child 'left:expression' 

	public void setLeft(Expression left) {
		if (left == null)
			throw new IllegalArgumentException("Parameter 'left' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.left = left;

	}

    public Expression getLeft() {
        return left;
    }


	// Child 'operator1:string' 

	public void setOperator1(String operator1) {
		if (operator1 == null)
			throw new IllegalArgumentException("Parameter 'operator1' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.operator1 = operator1;

	}

    public String getOperator1() {
        return operator1;
    }


	// Child 'right:expression' 

	public void setRight(Expression right) {
		if (right == null)
			throw new IllegalArgumentException("Parameter 'right' can't be null. Pass a non-null value or use 'expression?' in the abstract grammar");
		this.right = right;

	}

    public Expression getRight() {
        return right;
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "Arithmetic{" + " left=" + this.getLeft() + " operator1=" + this.getOperator1() + " right=" + this.getRight() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
