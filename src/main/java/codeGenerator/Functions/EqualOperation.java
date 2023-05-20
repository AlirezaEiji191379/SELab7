package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;
import errorHandler.ErrorHandler;

public class EqualOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        Address temp = new Address(functionOperationData.getMemory().getTemp(), varType.Bool);
        Address s2 = functionOperationData.getSs().pop();
        Address s1 = functionOperationData.getSs().pop();
        if (s1.varType != s2.varType) {
            ErrorHandler.printError("The type of operands in equal operator is different");
        }
        functionOperationData.getMemory().add3AddressCode(Operation.EQ, s1, s2, temp);
        functionOperationData.getSs().push(temp);
    }

    @Override
    public int GetFunction() {
        return 19;
    }
}
