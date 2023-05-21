package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Address;
import codeGenerator.Enums.varType;
import codeGenerator.FunctionOperationData;
import semantic.symbol.Symbol;

public class FPIDOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().pop();
        functionOperationData.getSs().pop();

        Symbol s = functionOperationData.getSemanticFacade().get(functionOperationData.getSymbolStack().pop(), functionOperationData.getSymbolStack().pop());
        varType t = varType.Int;
        switch (s.type) {
            case Bool:
                t = varType.Bool;
                break;
            case Int:
                t = varType.Int;
                break;
        }
        functionOperationData.getSs().push(new Address(s.address, t));
    }

    @Override
    public int GetFunction() {
        return 3;
    }
}
