package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;

public class DefClassOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().pop();
        functionOperationData.getSymbolTable().addClass(functionOperationData.getSymbolStack().peek());
    }

    @Override
    public int GetFunction() {
        return 23;
    }
}
