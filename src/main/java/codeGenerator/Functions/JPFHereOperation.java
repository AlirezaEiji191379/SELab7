package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;

public class JPFHereOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSemanticFacade().add3AddressCode(functionOperationData.getSs().pop().num, Operation.JP, new Address(functionOperationData.getSemanticFacade().getCurrentCodeBlockAddress(), varType.Address), null, null);
    }

    @Override
    public int GetFunction() {
        return 17;
    }
}
