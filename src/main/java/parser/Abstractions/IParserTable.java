package parser.Abstractions;

import parser.Action;
import parser.NonTerminal;
import scanner.token.Token;

public interface IParserTable {
    int getGotoTable(int currentState, NonTerminal variable);
    Action getActionTable(int currentState, Token terminal);
}
