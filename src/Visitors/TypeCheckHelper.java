package Visitors;

import ASTNodes.Node;
import Main.Error;
import Main.ErrorHandler;
import SymbolTable.Symbol;
import SymbolTable.SymbolTable;
import SymbolTable.GlobalSymbolTable;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class TypeCheckHelper {
    private final ErrorHandler ErrorHandler;
    private final GlobalSymbolTable GlobalSymbolTable;

    public TypeCheckHelper(ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
        ErrorHandler = errorHandler;
        GlobalSymbolTable = globalSymbolTable;
    }
    public <T> ArrayList<T> MapToList(Hashtable<String, T> table) {
        ArrayList<T> result = new ArrayList<>();
        Enumeration<String> keys = table.keys();
        while (keys.hasMoreElements()) {
            result.add(table.get(keys.nextElement()));
        }
        return result;
    }

    public boolean IsBaseType(String type) {
        return switch (type) {
            case "number", "Road", "bool", "string", "Vehicle", "Node" -> true;
            default -> false;
        };
    }

    Symbol GetSymbolByScopeName(String name, String scopeName) {
        SymbolTable symbolTable = FindTableByName(GlobalSymbolTable, scopeName, 0);

        Enumeration<String> keys = null;
        if(symbolTable != null)
            keys = symbolTable.Symbols.keys();

        if(keys != null) {
            while(keys.hasMoreElements()) {
                Symbol symbol = null;
                symbol = symbolTable.Symbols.get(keys.nextElement());

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

    public void AddError(Node node, String message) {
        ErrorHandler.HasErrors = true;
        ErrorHandler.Errors.add(new Error(node.Line, message));
    }
}
