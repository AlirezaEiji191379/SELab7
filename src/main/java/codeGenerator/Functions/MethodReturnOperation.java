package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.TypeAddress;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;
import errorHandler.ErrorHandler;
import semantic.symbol.SymbolType;

public class MethodReturnOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        //TODO : call ok

        String methodName = functionOperationData.getSymbolStack().pop();
        Address s = functionOperationData.getSs().pop();
        SymbolType t = functionOperationData.getSemanticFacade().getMethodReturnType(functionOperationData.getSymbolStack().peek(), methodName);
        varType temp = varType.Int;
        switch (t) {
            case Int:
                break;
            case Bool:
                temp = varType.Bool;
        }
        if (s.varType != temp) {
            ErrorHandler.printError("The type of method and return address was not match");
        }
        functionOperationData.getSemanticFacade()
                .add3AddressCode(Operation.ASSIGN, s, new Address(functionOperationData.getSemanticFacade().getMethodReturnAddress(functionOperationData.getSymbolStack().peek(),
                        methodName),
                        varType.Address,
                        TypeAddress.Indirect),
                        null);
        functionOperationData.getSemanticFacade().add3AddressCode(Operation.JP,
                new Address(functionOperationData.getSemanticFacade().getMethodCallerAddress(functionOperationData.getSymbolStack().peek(), methodName),
                        varType.Address),
                null,
                null);
    }

    @Override
    public int GetFunction() {
        return 29;
    }
}
