package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;
import errorHandler.ErrorHandler;

public class SubOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSemanticFacade().updateLastTempIndex();
        var tempAdd = functionOperationData.getSemanticFacade().getTemp();
        Address temp = new Address(tempAdd, varType.Int);
        Address s2 = functionOperationData
                .getSs().pop();
        Address s1 = functionOperationData
                .getSs().pop();
        if (s1.varType != varType.Int || s2.varType != varType.Int) {
            ErrorHandler.printError("In sub two operands must be integer");
        }
        functionOperationData.getSemanticFacade().add3AddressCode(Operation.SUB, s1, s2, temp);
        functionOperationData.getSs().push(temp);
    }

    @Override
    public int GetFunction() {
        return 11;
    }
}
