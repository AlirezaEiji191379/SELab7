package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;

public class CheckIdOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSymbolStack().pop();
        if (functionOperationData.getSs().peek().varType == varType.Non) {
            //TODO : error
        }
    }

    @Override
    public int GetFunction() {
        return 1;
    }
}
