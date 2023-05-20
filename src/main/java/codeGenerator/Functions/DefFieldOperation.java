package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;

public class DefFieldOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().pop();
        functionOperationData.getSymbolTable().addField(functionOperationData.getSymbolStack().pop(), functionOperationData.getSymbolStack().peek());
    }

    @Override
    public int GetFunction() {
        return 27;
    }
}
