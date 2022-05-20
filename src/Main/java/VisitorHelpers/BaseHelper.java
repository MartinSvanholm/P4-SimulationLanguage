package VisitorHelpers;

import ASTNodes.Node;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.*;

import java.util.ArrayList;

public class BaseHelper {
    public final Main.ErrorHandler ErrorHandler;
    public final GlobalSymbolTable GlobalSymbolTable;
    public String typeError = "error";

    public BaseHelper(ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
        ErrorHandler = errorHandler;
        GlobalSymbolTable = globalSymbolTable;
    }

    public void AddError(Node node, String message) {
        ErrorHandler.HasErrors = true;
        ErrorHandler.Errors.add(new Error(node.Line, message));
    }

    public Symbol GetSymbolByScopeName(String name, String scopeName) {
        SymbolTable symbolTable = FindTableByName(GlobalSymbolTable, scopeName, 0);

        if(symbolTable == null)
            return null;

        ArrayList<Symbol> symbols = new ArrayList<>(symbolTable.Symbols.values());

        if(!symbols.isEmpty()) {
            for(Symbol symbol : symbols) {
                if(symbol.Identifier.equals(name))
                    return symbol;
            }
        }
        return null;
    }

    public SymbolTable FindTableByName(SymbolTable symbolTable, String name, int i) {
        for(SymbolTable table : symbolTable.Children) {
            if(table.Name.strip().equals(name.strip()))
                return table;

            if(!table.Children.isEmpty()) {
                SymbolTable var = FindTableByName(table, name, i + 1);
                if(var != null)
                    return var;
            }
        }

        if(i == 0) {
            for(SymbolTable table : GlobalSymbolTable.PredifindValues) {
                if(!table.Children.isEmpty()) {
                    SymbolTable var = FindTableByName(table, name, i + 1);
                    if(var != null)
                        return var;
                }
                if(table.Name.equals(name))
                    return table;
            }
        }

        return null;
    }

    public void InsertInheritedTypeIntoSymbol(String varName, String scopeName, String value) {
        SymbolTable symbolTable = FindTableByName(GlobalSymbolTable, scopeName, 0);

        if(symbolTable == null)
            return;

        ArrayList<Symbol> symbols = new ArrayList<>(symbolTable.Symbols.values());

        for(Symbol symbol : symbols) {
            if(symbol.Identifier.equals(varName)) {
                symbol.InheritedType = value;
            }
        }
    }
}
