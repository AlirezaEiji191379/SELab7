package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;

public class PopClassOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData)
    {
        functionOperationData.getSymbolStack().pop();
    }

    @Override
    public int GetFunction() {
        return 25;
    }
}
