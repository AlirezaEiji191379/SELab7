package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;

public class DefVarOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().pop();
        String var = functionOperationData.getSymbolStack().pop();
        String methodName = functionOperationData.getSymbolStack().pop();
        String className = functionOperationData.getSymbolStack().pop();
        functionOperationData.getSymbolTable().addMethodLocalVariable(className, methodName, var);
        functionOperationData.getSymbolStack().push(className);
        functionOperationData.getSymbolStack().push(methodName);
    }

    @Override
    public int GetFunction() {
        return 28;
    }
}
