package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;

public class JPFSaveOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        Address save = new Address(functionOperationData.getMemory().saveMemory(), varType.Address);
        functionOperationData.getMemory().add3AddressCode(functionOperationData.getSs().pop().num,
                Operation.JPF,
                functionOperationData.getSs().pop(),
                new Address(functionOperationData.getMemory().getCurrentCodeBlockAddress(),
                        varType.Address),
                null);
        functionOperationData.getSs().push(save);
    }

    @Override
    public int GetFunction() {
        return 16;
    }
}
