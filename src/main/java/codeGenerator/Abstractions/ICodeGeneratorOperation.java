package codeGenerator.Abstractions;
import codeGenerator.FunctionOperationData;
public interface ICodeGeneratorOperation {


    public void OperateCodeGeneration(FunctionOperationData functionOperationData);
    public int GetFunction();
}
