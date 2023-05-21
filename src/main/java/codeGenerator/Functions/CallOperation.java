package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.TypeAddress;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;
import errorHandler.ErrorHandler;

public class CallOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        //TODO: method ok
        String methodName = functionOperationData.getCallStack().pop();
        String className = functionOperationData.getCallStack().pop();
        try {
            functionOperationData.getSemanticFacade().getNextParam(className, methodName);
            ErrorHandler.printError("The few argument pass for method");
        } catch (IndexOutOfBoundsException e) {
        }
        varType t = varType.Int;
        switch (functionOperationData.getSemanticFacade().getMethodReturnType(className, methodName)) {
            case Int:
                t = varType.Int;
                break;
            case Bool:
                t = varType.Bool;
                break;
        }
        Address temp = new Address(functionOperationData.getSemanticFacade().getTemp(), t);
        functionOperationData.getSs().push(temp);
        functionOperationData.getSemanticFacade().add3AddressCode(Operation.ASSIGN, new Address(temp.num, varType.Address, TypeAddress.Imidiate), new Address(functionOperationData.getSemanticFacade().getMethodReturnAddress(className, methodName), varType.Address), null);
        functionOperationData.getSemanticFacade().add3AddressCode(Operation.ASSIGN, new Address(functionOperationData.getSemanticFacade().getCurrentCodeBlockAddress() + 2, varType.Address, TypeAddress.Imidiate), new Address(functionOperationData.getSemanticFacade().getMethodCallerAddress(className, methodName), varType.Address), null);
        functionOperationData.getSemanticFacade().add3AddressCode(Operation.JP, new Address(functionOperationData.getSemanticFacade().getMethodAddress(className, methodName), varType.Address), null, null);
    }

    @Override
    public int GetFunction() {
        return 7;
    }
}
