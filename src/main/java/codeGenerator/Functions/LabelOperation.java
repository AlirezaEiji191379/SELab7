package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;

public class LabelOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().push(
                new Address(functionOperationData.getSemanticFacade().getCurrentCodeBlockAddress(),
                        varType.Address));
    }

    @Override
    public int GetFunction() {
        return 13;
    }
}
