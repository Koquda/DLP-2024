// Generated with VGen 2.0.0

package ast.type;

import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	errorType: type -> 
	type -> 
*/
public class ErrorType extends AbstractType  {



    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "ErrorType{" + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed
        public static Type getInstance() {
            return new ErrorType();
        }
    
    // %% --------------------------------------
}
