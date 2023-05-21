package codeGenerator.Facade;

import codeGenerator.Abstractions.IMemory;
import codeGenerator.Abstractions.ISemanticFacade;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Memory;
import semantic.symbol.Abstractions.ISymbolTable;
import semantic.symbol.Symbol;
import semantic.symbol.SymbolTable;
import semantic.symbol.SymbolType;

public class SemanticFacade implements ISemanticFacade {

    private IMemory memory;
    private ISymbolTable symbolTable;

    public SemanticFacade(){
        memory = new Memory();
        symbolTable = new SymbolTable(memory);
    }


    @Override
    public int getTemp() {
        return memory.getTemp();
    }

    @Override
    public int getDateAddress() {
        return memory.getDateAddress();
    }

    @Override
    public int saveMemory() {
        return memory.saveMemory();
    }

    @Override
    public void add3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        memory.add3AddressCode(op,opr1,opr2,opr3);
    }

    @Override
    public void add3AddressCode(int i, Operation op, Address opr1, Address opr2, Address opr3) {
        memory.add3AddressCode(i,op,opr1,opr2,opr3);
    }

    @Override
    public int getCurrentCodeBlockAddress() {
        return memory.getCurrentCodeBlockAddress();
    }

    @Override
    public void pintCodeBlock() {
        memory.pintCodeBlock();
    }
    ////
    @Override
    public void setLastType(SymbolType type) {
        symbolTable.setLastType(type);
    }

    @Override
    public void addClass(String className) {
        symbolTable.addClass(className);
    }

    @Override
    public void addField(String fieldName, String className) {
        symbolTable.addField(fieldName,className);
    }

    @Override
    public void addMethod(String className, String methodName, int address) {
        symbolTable.addMethod(className,methodName,address);
    }

    @Override
    public void addMethodParameter(String className, String methodName, String parameterName) {
        symbolTable.addMethodParameter(className,methodName,parameterName);
    }

    @Override
    public void addMethodLocalVariable(String className, String methodName, String localVariableName) {
        symbolTable.addMethodLocalVariable(className,methodName,localVariableName);
    }

    @Override
    public void setSuperClass(String superClass, String className) {
        symbolTable.setSuperClass(superClass,className);
    }

    @Override
    public Address get(String keywordName) {
        return symbolTable.get(keywordName);
    }

    @Override
    public Symbol get(String fieldName, String className) {
        return symbolTable.get(fieldName,className);
    }

    @Override
    public Symbol get(String className, String methodName, String variable) {
        return symbolTable.get(className,methodName,variable);
    }

    @Override
    public Symbol getNextParam(String className, String methodName) {
        return symbolTable.getNextParam(className,methodName);
    }

    @Override
    public void startCall(String className, String methodName) {
        symbolTable.startCall(className,methodName);
    }

    @Override
    public int getMethodCallerAddress(String className, String methodName) {
        return symbolTable.getMethodCallerAddress(className,methodName);
    }

    @Override
    public int getMethodReturnAddress(String className, String methodName) {
        return symbolTable.getMethodReturnAddress(className,methodName);
    }

    @Override
    public SymbolType getMethodReturnType(String className, String methodName) {
        return symbolTable.getMethodReturnType(className,methodName);
    }

    @Override
    public int getMethodAddress(String className, String methodName) {
        return symbolTable.getMethodAddress(className,methodName);
    }
}
