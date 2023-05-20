package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Enums.Operation;
import codeGenerator.FunctionOperationData;

public class PrintOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getMemory().add3AddressCode(Operation.PRINT, functionOperationData.getSs().pop(), null, null);
    }

    @Override
    public int GetFunction() {
        return 18;
    }
}
