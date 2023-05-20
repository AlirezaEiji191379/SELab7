package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;

public class KPIDOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().push(functionOperationData.getSymbolTable().get(functionOperationData.getToken().value));
    }

    @Override
    public int GetFunction() {
        return 4;
    }
}
