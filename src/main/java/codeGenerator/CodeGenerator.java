package codeGenerator;

import Log.Log;
import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.Abstractions.ICodeGenerator;
import codeGenerator.Factory.CodeGeneratorOperationProvider;
import scanner.token.Token;

public class CodeGenerator implements ICodeGenerator {
    private FunctionOperationData functionOperationData;
    public CodeGenerator() {
        functionOperationData = new FunctionOperationData();
    }
    @Override
    public void printMemory() {
        functionOperationData.getMemory().pintCodeBlock();
    }
    @Override
    public void semanticFunction(int func, Token next) {
        Log.print("codegenerator : " + func);
        if(func == 0)
            return;
        functionOperationData.setToken(next);
        var codeGenerationOperation = CodeGeneratorOperationProvider.GetInstance().GetCodeGenerationOperationTypeByFunction(func);
        codeGenerationOperation.OperateCodeGeneration(functionOperationData);
    }
}

