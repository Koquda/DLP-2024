// Generated with VGen 2.0.0

package ast.definition;

import ast.*;
import ast.type.*;
import ast.statement.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.antlr.v4.runtime.Token;
import visitor.Visitor;

// %% User Declarations -------------

    // Declarations (e.g. imports) in this section will be preserved. Delete if not needed

// %% -------------------------------

/*
	funcDefinition: definition -> name:string funcParams:funcParam* type:type definitions:definition* statements:statement*
	definition -> 
*/
public class FuncDefinition extends AbstractDefinition  {

    // ----------------------------------
    // Instance Variables

	// funcDefinition: definition -> string funcParam* type definition* statement*
	private String name;
	private List<FuncParam> funcParams;
	private Type type;
	private List<Definition> definitions;
	private List<Statement> statements;

    // ----------------------------------
    // Constructors

	public FuncDefinition(String name, List<FuncParam> funcParams, Type type, List<Definition> definitions, List<Statement> statements) {
		super();

		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

		if (funcParams == null)
			funcParams = new ArrayList<>();
		this.funcParams = funcParams;

		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type = type;

		if (definitions == null)
			definitions = new ArrayList<>();
		this.definitions = definitions;

		if (statements == null)
			statements = new ArrayList<>();
		this.statements = statements;

		updatePositions(name, funcParams, type, definitions, statements);
	}

	public FuncDefinition(Object name, Object funcParams, Object type, Object definitions, Object statements) {
		super();

        if (name == null)
            throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

        this.funcParams = castList(funcParams, unwrapIfContext.andThen(FuncParam.class::cast));
        if (type == null)
            throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type = (Type) type;

        this.definitions = castList(definitions, unwrapIfContext.andThen(Definition.class::cast));
        this.statements = castList(statements, unwrapIfContext.andThen(Statement.class::cast));
		updatePositions(name, funcParams, type, definitions, statements);
	}


    // ----------------------------------
    // funcDefinition: definition -> string funcParam* type definition* statement*

	// Child 'string' 

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Parameter 'name' can't be null. Pass a non-null value or use 'string?' in the abstract grammar");
		this.name = name;

	}

    public String getName() {
        return name;
    }


	// Child 'funcParam*' 

	public void setFuncParams(List<FuncParam> funcParams) {
		if (funcParams == null)
			funcParams = new ArrayList<>();
		this.funcParams = funcParams;

	}

    public List<FuncParam> getFuncParams() {
        return funcParams;
    }

    public Stream<FuncParam> funcParams() {
        return funcParams.stream();
    }


	// Child 'type' 

	public void setType(Type type) {
		if (type == null)
			throw new IllegalArgumentException("Parameter 'type' can't be null. Pass a non-null value or use 'type?' in the abstract grammar");
		this.type = type;

	}

    public Type getType() {
        return type;
    }


	// Child 'definition*' 

	public void setDefinitions(List<Definition> definitions) {
		if (definitions == null)
			definitions = new ArrayList<>();
		this.definitions = definitions;

	}

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public Stream<Definition> definitions() {
        return definitions.stream();
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
        return "FuncDefinition{" + " name=" + this.getName() + " funcParams=" + this.getFuncParams() + " type=" + this.getType() + " definitions=" + this.getDefinitions() + " statements=" + this.getStatements() + "}";
    }


    // %% User Members -------------------------

        // Methods/attributes in this section will be preserved. Delete if not needed

    // %% --------------------------------------
}
