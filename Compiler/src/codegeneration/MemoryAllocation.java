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
    // phase MemoryAllocation { int offset }
    @Override
    public Object visit(VarDefinition varDefinition, Object param) {

        super.visit(varDefinition, param);

        if(varDefinition.getScope()==0) {
            varDefinition.setOffset(globalOffset);
            globalOffset+=varDefinition.getType().getSize();
        }else if(varDefinition.getScope()==1) {
            localOffset -= varDefinition.getType().getSize(); //Ojo que es en negativo
            varDefinition.setOffset(localOffset);
        }
        return null;    }
    // class FunctionDefinition(String name, List<VarDefinition> varDefinitions, Type type, List<Definition> definitions, List<Statement> statements)
    // phase MemoryAllocation { int bytesLocals }
    @Override
    public Object visit(FunctionDefinition functionDefinition, Object param) {
        localOffset=0;
        super.visit(functionDefinition, param);

        int paramBytesSum = 0;
        for (int i = functionDefinition.getVarDefinitions().size() - 1; i >= 0; i--) {
            VarDefinition varDef = functionDefinition.getVarDefinitions().get(i);
            varDef.setOffset(4 + paramBytesSum);
            paramBytesSum += varDef.type.numberOfBytes();
        }
        return null;
    }

    // class StructField(String name, Type type)
    // phase MemoryAllocation { int offset }
    @Override
    public Object visit(StructField structField, Object param) {

        // structField.getType().accept(this, param);
        super.visit(structField, param);

        // TODO: Remember to initialize SYNTHESIZED attributes <-----
        // structField.setOffset(?);
        return null;
    }

    // class StructType(String name)
    // phase Identification { StructDefinition structDefinition }
    @Override
    public Object visit(StructType structType, Object param) {

        return null;
    }
}
