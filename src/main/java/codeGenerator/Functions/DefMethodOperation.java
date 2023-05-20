package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;

public class DefMethodOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().pop();
        String methodName = functionOperationData.getSymbolStack().pop();
        String className = functionOperationData.getSymbolStack().pop();

        functionOperationData.getSymbolTable().addMethod(className, methodName, functionOperationData.getMemory().getCurrentCodeBlockAddress());

        functionOperationData.getSymbolStack().push(className);
        functionOperationData.getSymbolStack().push(methodName);
    }

    @Override
    public int GetFunction() {
        return 24;
    }
}
