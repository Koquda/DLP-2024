// Generated with VGen 2.0.0

package ast.definition;

import ast.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------


/*
	structDefinition: definition -> name:string structFields:structField*
	definition -> 
*/
public class StructDefinition extends AbstractDefinition  {

    // ----------------------------------
    // Instance Variables

	// structDefinition: definition -> string structField*
	private String name;
	private List<StructField> structFields;

    // ----------------------------------
    // Constructors

	public StructDefinition(String name, List<StructField> structFields) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (structFields == null)
			structFields = new ArrayList<>();
		this.structFields = structFields;

		updatePositions(name, structFields);
	}

	public StructDefinition(Object name, Object structFields) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        this.structFields = castList(structFields, unwrapIfContext.andThen(StructField.class::cast));
		updatePositions(name, structFields);
	}


    // ----------------------------------
    // structDefinition: definition -> string structField*

	// Child 'string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }


	// Child 'structField*' 

	public void setStructFields(List<StructField> structFields) {
		if (structFields == null)
			structFields = new ArrayList<>();
		this.structFields = structFields;

	}

    public List<StructField> getStructFields() {
        return structFields;
    }

    public Stream<StructField> structFields() {
        return structFields.stream();
    }


    // ----------------------------------
    // Helper methods

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "StructDefinition{" + " name=" + this.getName() + " structFields=" + this.getStructFields() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------

}
