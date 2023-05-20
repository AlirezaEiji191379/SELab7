package codeGenerator.Abstractions;

import scanner.token.Token;

public interface ICodeGenerator {
    void printMemory();
    void semanticFunction(int func, Token next);
}
