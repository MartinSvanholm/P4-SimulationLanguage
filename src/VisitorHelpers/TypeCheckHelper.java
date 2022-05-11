package VisitorHelpers;

import ASTNodes.Identifier.IdentifierNode;
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

    private SymbolTable GetFunc(String parentScopeName, String funcName) {
        SymbolTable parent = FindTableByName(GlobalSymbolTable, parentScopeName, 0);
        if(parent != null) {
            for(SymbolTable table : parent.Children) {
                if(table.Name.equals(funcName))
                    return table;
            }
        }
        return null;
    }

    public String GetTypeOfIdentifier(String scopeName, String varName) {
        Symbol var = GetSymbolByScopeName(varName, scopeName);
        if(var != null)
            return var.Type;

        var = GetInheritance(varName, scopeName);
        if(var != null)
            return var.Type;

        var = GetFromClass(varName, scopeName);
        if(var != null)
            return var.Type;

        SymbolTable func = GetFunc(scopeName, varName);
        if(func != null)
            return func.Type;

        func = GetGlobalFunc(varName);
        if(func != null)
            return func.Type;

        return typeError;
    }

    public String GetTypeofThis(String scopeName) {
        SymbolTable scope = FindTableByName(GlobalSymbolTable, scopeName, 0);

        if(scope.Attribute.equals("Function")) {
            scope = scope.Parent;
        }

        return scope.Type;
    }

    public String GetTypeOfDotNotation(String scopeName, IdentifierNode node, int i) {
        String[] identifiers = node.Name.split("\\.");
        if ("Simulation".equals(identifiers[0]))
            return CheckSimulation(identifiers[1]);

        if ("this".equals(identifiers[0]))
            return CheckThisKeyword(identifiers[1], scopeName, node);

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

    private String CheckThisKeyword(String varName, String scopeName, IdentifierNode node) {
        SymbolTable scope = FindTableByName(GlobalSymbolTable, scopeName, 0);

        if(scope.Attribute.equals("Function")) {
            scope = scope.Parent;
        }

        Symbol var = GetSymbolByScopeName(varName, scope.Name);

        if (var != null)
            return var.Type.strip();

        var = GetInheritance(varName, scope.Type);

        if (var != null)
            return var.Type.strip();

        for(SymbolTable childTable : scope.Children) {
            if(childTable.Name.equals(varName)) {
                return childTable.Type;
            }
        }

        AddError(node, scope.Name + " does not contain a variable " + varName);
        return typeError;
    }


    private Symbol GetInheritance(String varName, String scopeName) {
        SymbolTable varClass = FindTableByName(GlobalSymbolTable, scopeName, 0);
        SymbolTable inheritedClass = FindTableByName(GlobalSymbolTable, varClass.Type, 0);

        if(inheritedClass != null)
            return GetSymbolByScopeName(varName, inheritedClass.Name);
        return null;
    }

    private SymbolTable GetGlobalFunc(String funcName) {
        for(SymbolTable func : GlobalSymbolTable.Children) {
            if(func.Name.equals(funcName))
                return func;
        }
        return null;
    }

    private Symbol GetFromClass(String varName, String scopeName) {
        SymbolTable scope = FindTableByName(GlobalSymbolTable, scopeName, 0);

        if(scope.Attribute.equals("Function")) {
            scope = scope.Parent;
        }

        return GetSymbolByScopeName(varName, scope.Name);
    }
}
