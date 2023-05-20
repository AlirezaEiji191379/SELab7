package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;

public class ExtendOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().pop();
        functionOperationData.getSymbolTable().setSuperClass(functionOperationData.getSymbolStack().pop(), functionOperationData.getSymbolStack().peek());
    }

    @Override
    public int GetFunction() {
        return 26;
    }
}
