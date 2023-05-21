package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;

public class SaveOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().push(new Address(functionOperationData.getSemanticFacade().saveMemory(), varType.Address));
    }

    @Override
    public int GetFunction() {
        return 14;
    }
}
