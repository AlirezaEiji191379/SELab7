package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;
import semantic.symbol.Symbol;

public class PIDOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        if (functionOperationData.getSymbolStack().size() > 1) {
            String methodName = functionOperationData.getSymbolStack().pop();
            String className = functionOperationData.getSymbolStack().pop();
            try {

                Symbol s = functionOperationData.getSymbolTable().get(className, methodName, functionOperationData.getToken().value);
                varType t = varType.Int;
                switch (s.type) {
                    case Bool:
                        t = varType.Bool;
                        break;
                    case Int:
                        t = varType.Int;
                        break;
                }
                functionOperationData.getSs().push(new Address(s.address, t));


            } catch (Exception e) {
                functionOperationData.getSs().push(new Address(0, varType.Non));
            }
            functionOperationData.getSymbolStack().push(className);
            functionOperationData.getSymbolStack().push(methodName);
        } else {
            functionOperationData.getSs().push(new Address(0, varType.Non));
        }
        functionOperationData.getSymbolStack().push(functionOperationData.getToken().value);
    }

    @Override
    public int GetFunction() {
        return 2;
    }
}
