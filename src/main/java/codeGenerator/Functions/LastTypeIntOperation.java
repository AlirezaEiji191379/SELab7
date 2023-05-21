package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;
import semantic.symbol.SymbolType;

public class LastTypeIntOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSemanticFacade().setLastType(SymbolType.Int);
    }

    @Override
    public int GetFunction() {
        return 32;
    }
}
