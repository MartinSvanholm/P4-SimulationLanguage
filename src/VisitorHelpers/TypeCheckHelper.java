package VisitorHelpers;

import ASTNodes.IdentifierNode;
import SymbolTable.Symbol;
import SymbolTable.SymbolTable;
import SymbolTable.GlobalSymbolTable;
import java.util.Enumeration;

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

    public String CheckIdentifier(String scopeName, String varName) {
        return getType(varName, scopeName, FindTableByName(GlobalSymbolTable, varName, 0));
    }

    public String GetTypeOfDotNotation(String scopeName, IdentifierNode node, int i) {
        String[] identifiers = node.Name.split("\\.");
        if ("Simulation".equals(identifiers[0]))
            return CheckSimulation(identifiers[1]);

        if ("this".equals(identifiers[0]))
            return CheckThisKeyword(identifiers[1], scopeName);

        SymbolTable function = FindTableByName(GlobalSymbolTable, identifiers[1+i], 0);
        Symbol property = GetSymbolByScopeName(identifiers[i], scopeName);

        if (identifiers.length > 2+i) {
            return GetTypeOfDotNotation(property.Attribute, node, i+1);
        }

        if(function != null) {
            return function.Type;
        } else if(property != null) {
            Symbol test = GetSymbolByScopeName(identifiers[i+1], property.Attribute);
            if(test != null) {
                return test.Type;
            } else {
                return typeError;
            }
        } else {
            return typeError;
        }
    }

    private String CheckSimulation(String name) {
        Symbol var = GetSymbolByScopeName(name, "Simulation");
        SymbolTable table = FindTableByName(GlobalSymbolTable, name, 0);
        if(var != null) {
            return var.Type.strip();
        } else if(table != null) {
            return table.Type.strip();
        }
        return typeError;
    }

    private String CheckThisKeyword(String varName, String scopeName) {
        return getType(varName, scopeName, FindTableByName(GlobalSymbolTable, scopeName, 0));
    }

    private String getType(String varName, String scopeName, SymbolTable symbolTable) {
        Symbol var = GetSymbolByScopeName(varName, scopeName);

        if(var != null) {
            return var.Type.strip();
        } else if(symbolTable != null) {
            return symbolTable.Type.strip();
        }
        return typeError;
    }
}
