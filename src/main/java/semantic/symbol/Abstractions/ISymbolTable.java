package semantic.symbol.Abstractions;

import codeGenerator.Address;
import semantic.symbol.Symbol;
import semantic.symbol.SymbolType;

public interface ISymbolTable {
    void setLastType(SymbolType type);

    void addClass(String className);

    void addField(String fieldName, String className);

    void addMethod(String className, String methodName, int address);

    void addMethodParameter(String className, String methodName, String parameterName);

    void addMethodLocalVariable(String className, String methodName, String localVariableName);

    void setSuperClass(String superClass, String className);

    Address get(String keywordName);

    Symbol get(String fieldName, String className);

    Symbol get(String className, String methodName, String variable);

    Symbol getNextParam(String className, String methodName);

    void startCall(String className, String methodName);

    int getMethodCallerAddress(String className, String methodName);

    int getMethodReturnAddress(String className, String methodName);

    SymbolType getMethodReturnType(String className, String methodName);

    int getMethodAddress(String className, String methodName);
}
