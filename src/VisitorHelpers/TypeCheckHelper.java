package VisitorHelpers;

import ASTNodes.Identifier.SimpleIdNode;
import SymbolTable.Symbol;
import SymbolTable.SymbolTable;
import SymbolTable.GlobalSymbolTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TypeCheckHelper extends BaseHelper{

    public TypeCheckHelper(Main.ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
        super(errorHandler, globalSymbolTable);
    }

    public boolean IsBaseType(String type) {
        return switch (type) {
            case "number", "Road", "bool", "string", "Vehicle", "Node" -> true;
            default -> false;
        };
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

    public Symbol CheckInheritance(SimpleIdNode simpleIdNode, String scopeName) {
        SymbolTable classTable = FindTableByName(GlobalSymbolTable, scopeName, 0);
        return GetSymbolByScopeName(simpleIdNode.Name, classTable.Type);
    }
}
