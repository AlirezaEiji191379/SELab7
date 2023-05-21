package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;

public class StartCallOperation implements ICodeGeneratorOperation {
    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().pop();
        functionOperationData.getSs().pop();
        String methodName = functionOperationData.getSymbolStack().pop();
        String className = functionOperationData.getSymbolStack().pop();
        functionOperationData.getSemanticFacade().startCall(className, methodName);
        functionOperationData.getCallStack().push(className);
        functionOperationData.getCallStack().push(methodName);
    }

    @Override
    public int GetFunction() {
        return 6;
    }
}
