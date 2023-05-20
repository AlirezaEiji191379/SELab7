package parser.Abstractions;

import parser.Action;
import parser.NonTerminal;
import scanner.token.Token;

public interface IParserFacade {
    Action GetActionTable(int currentState, Token terminal);
    int GetGotoTable(int currentState, NonTerminal variable);
    Token GetNextToken();
    void PrintMemory();
    void SemanticFunction(int func, Token next);
}
