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
	statement -> functionDefinition:functionDefinition
*/
public abstract class AbstractStatement extends AbstractAST implements Statement {

    // ----------------------------------
    // Instance Variables


    // PHASE TypeChecking
	private FunctionDefinition functionDefinition;



    // --------------------------------
    // PHASE TypeChecking

	// Attribute 'functionDefinition' 

	public void setFunctionDefinition(FunctionDefinition functionDefinition) {
		if (functionDefinition == null)
			throw new IllegalArgumentException("Parameter 'functionDefinition' can't be null. Pass a non-null value or use 'functionDefinition?' in the abstract grammar");
		this.functionDefinition = functionDefinition;

	}

    public FunctionDefinition getFunctionDefinition() {
        return functionDefinition;
    }



    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
