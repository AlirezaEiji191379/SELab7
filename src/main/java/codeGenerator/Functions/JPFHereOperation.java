package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;

public class JPFHereOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getMemory().add3AddressCode(functionOperationData.getSs().pop().num, Operation.JP, new Address(functionOperationData.getMemory().getCurrentCodeBlockAddress(), varType.Address), null, null);
    }

    @Override
    public int GetFunction() {
        return 17;
    }
}
