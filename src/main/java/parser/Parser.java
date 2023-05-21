package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Stack;

import Log.Log;
import codeGenerator.Abstractions.ICodeGenerator;
import codeGenerator.CodeGenerator;
import errorHandler.ErrorHandler;
import parser.Abstractions.IParserFacade;
import parser.Abstractions.IParserTable;
import parser.Facade.ParserFacade;
import scanner.Abstractions.ILexicalAnalyzer;
import scanner.LexicalAnalyzer;
import scanner.token.Token;

public class Parser {
    private ArrayList<Rule> rules;
    private Stack<Integer> parsStack;

    private IParserFacade parserFacade;

    public Parser(java.util.Scanner sc) {
        parserFacade = new ParserFacade(sc);
        parsStack = new Stack<Integer>();
        parsStack.push(0);
        rules = new ArrayList<Rule>();
        try {
            for (String stringRule : Files.readAllLines(Paths.get("src/main/resources/Rules"))) {
                rules.add(new Rule(stringRule));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startParse() {
        Token lookAhead = parserFacade.GetNextToken();
        boolean finish = false;
        Action currentAction;
        while (!finish) {
            try {
                Log.print(/*"lookahead : "+*/ lookAhead.toString() + "\t" + parsStack.peek());
                currentAction = parserFacade.GetActionTable(parsStack.peek(), lookAhead);
                Log.print(currentAction.toString());

                switch (currentAction.action) {
                    case shift:
                        parsStack.push(currentAction.number);
                        lookAhead = parserFacade.GetNextToken();
                        break;
                    case reduce:
                        Rule rule = rules.get(currentAction.number);
                        for (int i = 0; i < rule.RHS.size(); i++) {
                            parsStack.pop();
                        }
                        Log.print(/*"state : " +*/ parsStack.peek() + "\t" + rule.LHS);
                        parsStack.push(parserFacade.GetGotoTable(parsStack.peek(), rule.LHS));
                        Log.print(/*"new State : " + */parsStack.peek() + "");
                        try {
                            parserFacade.SemanticFunction(rule.semanticAction, lookAhead);
                        } catch (Exception e) {
                            Log.print("Code Genetator Error");
                        }
                        break;
                    case accept:
                        finish = true;
                        break;
                }
                Log.print("");
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
        if (!ErrorHandler.hasError) parserFacade.PrintMemory();
    }
}
