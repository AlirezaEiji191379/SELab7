package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;

public class WhileOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSemanticFacade().add3AddressCode(functionOperationData.getSs().pop().num,
                Operation.JPF,
                functionOperationData.getSs().pop(),
                new Address(functionOperationData.getSemanticFacade().getCurrentCodeBlockAddress() + 1,
                        varType.Address),
                null);
        functionOperationData.getSemanticFacade().add3AddressCode(Operation.JP, functionOperationData.getSs().pop(), null, null);
    }

    @Override
    public int GetFunction() {
        return 15;
    }
}
