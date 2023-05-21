package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;
import errorHandler.ErrorHandler;

public class NotOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSemanticFacade().updateLastTempIndex();
        var tempAdd = functionOperationData.getSemanticFacade().getTemp();
        Address temp = new Address(tempAdd, varType.Bool);
        Address s2 = functionOperationData.getSs().pop();
        Address s1 = functionOperationData.getSs().pop();
        if (s1.varType != varType.Bool) {
            ErrorHandler.printError("In not operator the operand must be boolean");
        }
        functionOperationData.getSemanticFacade().add3AddressCode(Operation.NOT, s1, s2, temp);
        functionOperationData.getSs().push(temp);
    }

    @Override
    public int GetFunction() {
        return 22;
    }
}
