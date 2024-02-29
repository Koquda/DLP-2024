// Generated with VGen 2.0.0

package ast;

import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	AST -> 
*/
public interface AST {



    // ------------------------------
    // AST Methods

    public Object accept(Visitor visitor, Object param);

    Position start();
    Position end();

    public void updatePositions(Object... children);
    public void updatePositions(Position newStart, Position newEnd);



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
