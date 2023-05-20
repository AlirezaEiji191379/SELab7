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
            functionOperationData.getSymbolTable().getNextParam(className, methodName);
            ErrorHandler.printError("The few argument pass for method");
        } catch (IndexOutOfBoundsException e) {
        }
        varType t = varType.Int;
        switch (functionOperationData.getSymbolTable().getMethodReturnType(className, methodName)) {
            case Int:
                t = varType.Int;
                break;
            case Bool:
                t = varType.Bool;
                break;
        }
        Address temp = new Address(functionOperationData.getMemory().getTemp(), t);
        functionOperationData.getSs().push(temp);
        functionOperationData.getMemory().add3AddressCode(Operation.ASSIGN, new Address(temp.num, varType.Address, TypeAddress.Imidiate), new Address(functionOperationData.getSymbolTable().getMethodReturnAddress(className, methodName), varType.Address), null);
        functionOperationData.getMemory().add3AddressCode(Operation.ASSIGN, new Address(functionOperationData.getMemory().getCurrentCodeBlockAddress() + 2, varType.Address, TypeAddress.Imidiate), new Address(functionOperationData.getSymbolTable().getMethodCallerAddress(className, methodName), varType.Address), null);
        functionOperationData.getMemory().add3AddressCode(Operation.JP, new Address(functionOperationData.getSymbolTable().getMethodAddress(className, methodName), varType.Address), null, null);
    }

    @Override
    public int GetFunction() {
        return 7;
    }
}
