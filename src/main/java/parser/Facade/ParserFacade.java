package parser.Facade;

import codeGenerator.Abstractions.ICodeGenerator;
import codeGenerator.CodeGenerator;
import parser.Abstractions.IParserFacade;
import parser.Abstractions.IParserTable;
import parser.Action;
import parser.NonTerminal;
import parser.ParseTable;
import scanner.Abstractions.ILexicalAnalyzer;
import scanner.LexicalAnalyzer;
import scanner.token.Token;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ParserFacade implements IParserFacade {
    private ICodeGenerator codeGenerator;
    private IParserTable parserTable;
    private ILexicalAnalyzer lexicalAnalyzer;

    public ParserFacade(java.util.Scanner sc) {
        try {
            parserTable = new ParseTable(Files.readAllLines(Paths.get("src/main/resources/parseTable")).get(0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        codeGenerator = new CodeGenerator();
        lexicalAnalyzer = new LexicalAnalyzer(sc);
    }

    @Override
    public Action GetActionTable(int currentState, Token terminal) {
        return parserTable.getActionTable(currentState,terminal);
    }

    @Override
    public int GetGotoTable(int currentState, NonTerminal variable) {
        return parserTable.getGotoTable(currentState,variable);
    }

    @Override
    public Token GetNextToken() {
        return lexicalAnalyzer.getNextToken();
    }

    @Override
    public void PrintMemory() {
        codeGenerator.printMemory();
    }

    @Override
    public void SemanticFunction(int func, Token next) {
        codeGenerator.semanticFunction(func,next);
    }
}
