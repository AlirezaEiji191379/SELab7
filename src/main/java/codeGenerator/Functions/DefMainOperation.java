package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;

public class DefMainOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        //ss.pop();
        functionOperationData.getSemanticFacade().add3AddressCode(functionOperationData.getSs().pop().num, Operation.JP, new Address(functionOperationData.getSemanticFacade().getCurrentCodeBlockAddress(), varType.Address), null, null);
        String methodName = "main";
        String className = functionOperationData.getSymbolStack().pop();

        functionOperationData.getSemanticFacade().addMethod(className, methodName, functionOperationData.getSemanticFacade().getCurrentCodeBlockAddress());

        functionOperationData.getSymbolStack().push(className);
        functionOperationData.getSymbolStack().push(methodName);
    }

    @Override
    public int GetFunction() {
        return 33;
    }
}
