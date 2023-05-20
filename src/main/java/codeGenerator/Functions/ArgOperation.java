package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.Operation;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;
import errorHandler.ErrorHandler;
import semantic.symbol.Symbol;

public class ArgOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        String methodName = functionOperationData.getCallStack().pop();
        try {
            Symbol s = functionOperationData.getSymbolTable()
                    .getNextParam(functionOperationData.getCallStack().peek(), methodName);
            varType t = varType.Int;
            switch (s.type) {
                case Bool:
                    t = varType.Bool;
                    break;
                case Int:
                    t = varType.Int;
                    break;
            }
            Address param = functionOperationData.getSs().pop();
            if (param.varType != t) {
                ErrorHandler.printError("The argument type isn't match");
            }
            functionOperationData.getMemory().add3AddressCode(Operation.ASSIGN, param, new Address(s.address, t), null);
        } catch (IndexOutOfBoundsException e) {
            ErrorHandler.printError("Too many arguments pass for method");
        }
        functionOperationData.getCallStack().push(methodName);
    }

    @Override
    public int GetFunction() {
        return 8;
    }
}
