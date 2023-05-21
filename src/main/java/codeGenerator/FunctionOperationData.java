package codeGenerator;

import codeGenerator.Abstractions.ISemanticFacade;
import codeGenerator.Facade.SemanticFacade;
import scanner.token.Token;
import semantic.symbol.SymbolTable;

import java.util.Stack;

public class FunctionOperationData {
    private ISemanticFacade semanticFacade;
    private Memory memory;
    private Stack<Address> ss;
    private Stack<String> symbolStack;
    private Stack<String> callStack;
    private SymbolTable symbolTable;
    private Token token;

    public FunctionOperationData() {
        semanticFacade = new SemanticFacade();
        memory = new Memory();
        symbolTable = new SymbolTable(memory);
        callStack = new Stack<>();
        symbolStack = new Stack<>();
        ss = new Stack<>();
    }

    public void setToken(Token token){
        this.token = token;
    }

    public ISemanticFacade getSemanticFacade() {
        return semanticFacade;
    }

    /*    public Memory getMemory() {
        return memory;
    }*/

    public Stack<Address> getSs() {
        return ss;
    }

    public Stack<String> getSymbolStack() {
        return symbolStack;
    }

    public Stack<String> getCallStack() {
        return callStack;
    }

/*    public SymbolTable getSymbolTable() {
        return symbolTable;
    }*/

    public Token getToken() {
        return token;
    }
}
