package codegeneration;

import ast.*;
import ast.definition.Definition;
import ast.definition.FunctionDefinition;
import ast.definition.StructDefinition;
import ast.definition.VarDefinition;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;
import visitor.DefaultVisitor;

// This class will be implemented in memory allocation phase

public class MemoryAllocation extends DefaultVisitor {

    private int globalOffset=0;
    private int localOffset=0;

    public void process(AST ast) {
        ast.accept(this, null);
    }

    // Visit Methods --------------------------------------------------------------

    // class VarDefinition(String name, Type type)
    // phase MemoryAllocation { int address }
    @Override
    public Object visit(VarDefinition varDefinition, Object param) {

        super.visit(varDefinition, param);

        if(param instanceof FunctionDefinition) {
            localOffset -= varDefinition.getType().numberOfBytes();
            varDefinition.setAddress(localOffset);
        } else {
            varDefinition.setAddress(globalOffset);
            globalOffset += varDefinition.getType().numberOfBytes();
        }
        return null;    }
    // class FunctionDefinition(String name, List<VarDefinition> varDefinitions, Type type, List<Definition> definitions, List<Statement> statements)
    // phase MemoryAllocation { int bytesLocals }
    @Override
    public Object visit(FunctionDefinition functionDefinition, Object param) {

        localOffset=0;
        functionDefinition.getVarDefinitions().forEach(varDefinition -> varDefinition.accept(this, functionDefinition));
        functionDefinition.getType().accept(this, param);

        localOffset=0;
        functionDefinition.getDefinitions().forEach(definition -> definition.accept(this, functionDefinition));
        functionDefinition.getStatements().forEach(statement -> statement.accept(this, param));

        int paramBytesSum = 0;
        for (int i = functionDefinition.getVarDefinitions().size() - 1; i >= 0; i--) {
            VarDefinition varDef = functionDefinition.getVarDefinitions().get(i);
            varDef.setAddress(4 + paramBytesSum);
            paramBytesSum += varDef.getType().numberOfBytes();
        }
        return null;
    }

    // class StructDefinition(String name, List<StructField> structFields)
    @Override
    public Object visit(StructDefinition structDefinition, Object param) {
        super.visit(structDefinition, param);

        int structOffset = 0; // in this case we don't have to control BP and ret addr
        for (var structField : structDefinition.getStructFields()) {
            structField.setAddress(structOffset);
            structOffset += structField.getType().numberOfBytes();
        }

        return null;
    }
}
