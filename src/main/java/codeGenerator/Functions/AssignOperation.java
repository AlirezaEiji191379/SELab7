package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.FunctionOperationData;
import errorHandler.ErrorHandler;

public class AssignOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        Address s1 = functionOperationData.getSs().pop();
        Address s2 = functionOperationData.getSs().pop();
        if (s1.varType != s2.varType) {
            ErrorHandler.printError("The type of operands in assign is different ");
        }
        functionOperationData.getSemanticFacade().add3AddressCode(Operation.ASSIGN, s1, s2, null);
    }

    @Override
    public int GetFunction() {
        return 9;
    }
}
