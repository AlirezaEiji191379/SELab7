package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;

public class DefMethodOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().pop();
        String methodName = functionOperationData.getSymbolStack().pop();
        String className = functionOperationData.getSymbolStack().pop();

        functionOperationData.getSemanticFacade().addMethod(className, methodName, functionOperationData.getSemanticFacade().getCurrentCodeBlockAddress());

        functionOperationData.getSymbolStack().push(className);
        functionOperationData.getSymbolStack().push(methodName);
    }

    @Override
    public int GetFunction() {
        return 24;
    }
}
