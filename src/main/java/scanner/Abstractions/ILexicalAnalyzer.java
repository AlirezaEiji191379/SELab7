package scanner.Abstractions;

import scanner.token.Token;

public interface ILexicalAnalyzer {
    Token getNextToken();
}
