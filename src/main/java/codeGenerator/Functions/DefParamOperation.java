package codeGenerator.Functions;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;

public class DefParamOperation implements ICodeGeneratorOperation {

    @Override
    public void OperateCodeGeneration(FunctionOperationData functionOperationData) {
        functionOperationData.getSs().pop();
        String param = functionOperationData.getSymbolStack().pop();
        String methodName = functionOperationData.getSymbolStack().pop();
        String className = functionOperationData.getSymbolStack().pop();

        functionOperationData.getSymbolTable().addMethodParameter(className, methodName, param);

        functionOperationData.getSymbolStack().push(className);
        functionOperationData.getSymbolStack().push(methodName);
    }

    @Override
    public int GetFunction() {
        return 30;
    }
}
