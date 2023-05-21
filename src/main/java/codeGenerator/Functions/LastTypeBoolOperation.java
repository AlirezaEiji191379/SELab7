package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;
import semantic.symbol.SymbolType;

public class LastTypeBoolOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSemanticFacade().setLastType(SymbolType.Bool);
    }

    @Override
    public int GetFunction() {
        return 31;
    }
}
