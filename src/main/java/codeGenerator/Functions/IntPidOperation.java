package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.TypeAddress;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;

public class IntPidOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().push(new Address(Integer.parseInt(functionOperationData.getToken().value),
                varType.Int,
                TypeAddress.Imidiate));
    }

    @Override
    public int GetFunction() {
        return 5;
    }
}
