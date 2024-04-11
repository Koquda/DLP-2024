// Generated with VGen 2.0.0

package ast.statement;

import ast.*;
import ast.definition.*;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	statement -> 
	
	PHASE TypeChecking
	statement -> functionWhereDefined:functionDefinition
*/
public abstract class AbstractStatement extends AbstractAST implements Statement {

    // ----------------------------------
    // Instance Variables


    // PHASE TypeChecking
	private FunctionDefinition functionWhereDefined;



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'functionWhereDefined:functionDefinition' 

	public void setFunctionWhereDefined(FunctionDefinition functionWhereDefined) {
		if (functionWhereDefined == null)
			throw new IllegalArgumentException("Parameter 'functionWhereDefined' can't be null. Pass a non-null value or use 'functionDefinition?' in the abstract grammar");
		this.functionWhereDefined = functionWhereDefined;

	}

    public FunctionDefinition getFunctionWhereDefined() {
        return functionWhereDefined;
    }



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
