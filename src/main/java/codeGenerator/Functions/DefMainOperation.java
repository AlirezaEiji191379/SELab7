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
        functionOperationData.getMemory().add3AddressCode(functionOperationData.getSs().pop().num, Operation.JP, new Address(functionOperationData.getMemory().getCurrentCodeBlockAddress(), varType.Address), null, null);
        String methodName = "main";
        String className = functionOperationData.getSymbolStack().pop();

        functionOperationData.getSymbolTable().addMethod(className, methodName, functionOperationData.getMemory().getCurrentCodeBlockAddress());

        functionOperationData.getSymbolStack().push(className);
        functionOperationData.getSymbolStack().push(methodName);
    }

    @Override
    public int GetFunction() {
        return 33;
    }
}
