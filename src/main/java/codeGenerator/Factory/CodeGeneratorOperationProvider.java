package codeGenerator.Factory;

import codeGenerator.Abstractions.ICodeGeneratorOperation;
import codeGenerator.FunctionOperationData;
import org.reflections.Reflections;
import java.util.HashMap;

public class CodeGeneratorOperationProvider {
    private static CodeGeneratorOperationProvider Instance;
    private HashMap<Integer, ICodeGeneratorOperation> codeGeneratorOperationByFunctionInteger;

    private CodeGeneratorOperationProvider(){
        codeGeneratorOperationByFunctionInteger = InitializeDictionary();
    }
    private HashMap<Integer, ICodeGeneratorOperation> InitializeDictionary() {
        HashMap<Integer, ICodeGeneratorOperation> result = new HashMap<>();
        var packageName = "codeGenerator.Functions";
        var abstractClass = ICodeGeneratorOperation.class;
        var reflections = new Reflections(packageName);
        var subclasses = reflections.getSubTypesOf(abstractClass);
        for (var subclass : subclasses) {
            try {
                var instance = (ICodeGeneratorOperation) subclass.newInstance();
                result.put(instance.GetFunction(), instance);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static CodeGeneratorOperationProvider GetInstance(){
        if(Instance == null)
            Instance = new CodeGeneratorOperationProvider();
        return Instance;
    }

    public ICodeGeneratorOperation GetCodeGenerationOperationTypeByFunction(int function)
    {
        return codeGeneratorOperationByFunctionInteger.get(function);
    }
}