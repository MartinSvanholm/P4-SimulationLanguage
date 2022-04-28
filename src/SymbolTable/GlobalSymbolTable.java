package SymbolTable;

import ASTNodes.*;
import ASTNodes.Node;
import ASTNodes.DclNodes.*;
import Main.Error;
import Main.ErrorHandler;
import Models.*;

import java.util.ArrayList;
import java.util.Enumeration;

public class GlobalSymbolTable extends SymbolTable {
    public ErrorHandler ErrorHandler;

    public Vehicle Vehicle;
    public Node Node;
    public Road Road;

    private SymbolTable Scope;
    private int tempLvl = 0;

    public GlobalSymbolTable(String name, int lvl, ErrorHandler errorHandler) {
        super(name, lvl);
        ErrorHandler = errorHandler;
    }

    public void BuildSymbolTable(ASTNodes.Node ast) {
        ProcessNode(ast);

        PrintTable(this);
    }

    private void ProcessNode(Node node) {
        if(node instanceof SectionNode || node instanceof FunctionDclNode || node instanceof ClassNode) {
            OpenScope(node);
        } else if(node instanceof ObjDclNode || node instanceof ListDclNode || node instanceof ConstructorDclNode) {
            InsertSymbol(node);
        }

        if(node != null) {
            if (node.GetChildren() != null) {
                for(Node tempNode : node.GetChildren()) {
                    ProcessNode(tempNode);
                }
            }
        }

        if(node instanceof SectionNode ||
                node instanceof FunctionDclNode ||
                node instanceof  ClassNode) {
            CloseScope();
        }
    }

    private void OpenScope(Node node) {
        tempLvl ++;
        if(node instanceof FunctionDclNode)
            Scope = new SymbolTable(((DclNode) node).Identifier.Name, tempLvl, Scope);
        else if (node instanceof ClassNode)
            Scope = new SymbolTable(((ClassNode) node).Identifier.Name, tempLvl, Scope);
        else
            Scope = new SymbolTable(node.Name, tempLvl, this);
    }

    private void CloseScope() {
        tempLvl --;

        Scope.Parent.Children.add(Scope);

        Scope = Scope.Parent;
    }

    private void InsertSymbol(Node node) {
        if(!(node instanceof ConstructorDclNode) && Scope.Symbols.containsKey(((DclNode) node).Identifier.Name)) {
            ErrorHandler.HasErrors = true;
            ErrorHandler.Errors.add(new Error(node.Line, ((DclNode) node).Identifier.Name + " has already been declared"));
        } else if(Scope.Symbols.containsKey("constructor")) {
            ErrorHandler.HasErrors = true;
            ErrorHandler.Errors.add(new Error(node.Line,  "constructor for " + ((DclNode) node).Type.Name + " has already been declared"));
        }

        if(!(node instanceof ConstructorDclNode)) {
            Scope.Symbols.put(((DclNode) node).Identifier.Name, new Symbol(
                    ((DclNode) node).Identifier.Name,
                    ((DclNode) node).Type.Name));
        } else {
            Scope.Symbols.put("constructor", new Symbol(
                    "constructor",
                    ((ConstructorDclNode) node).Type.Name));
        }
    }

    private void PrintTable(SymbolTable symbolTable) {
        System.out.println("");
        System.out.println(symbolTable.Name + " " + symbolTable.Level);

        Enumeration<String> keys = symbolTable.Symbols.keys();

        while (keys.hasMoreElements()) {
            Symbol symbol = symbolTable.Symbols.get(keys.nextElement());
            System.out.println("    " + symbol.Identifier + " " + symbol.Type);
        }

        if(symbolTable.Children != null) {
            for(SymbolTable symbolTable1 : symbolTable.Children) {
                PrintTable(symbolTable1);
            }
        }
    }
}
