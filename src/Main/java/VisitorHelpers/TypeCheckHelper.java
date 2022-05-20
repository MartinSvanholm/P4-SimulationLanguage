package VisitorHelpers;

import ASTNodes.ExprNodes.FunctionCallNode;
import ASTNodes.Identifier.SimpleIdNode;
import ASTNodes.Node;
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

    public Symbol CheckInheritance(SimpleIdNode simpleIdNode, String scopeName) {
        SymbolTable classTable = FindTableByName(GlobalSymbolTable, scopeName, 0);
        return GetSymbolByScopeName(simpleIdNode.Name, classTable.Type);
    }

    public String GetInheritedType(String className) {
        return FindTableByName(GlobalSymbolTable, className, 0).Type;
    }

    public String CheckList(Symbol property, String identifier) {
        SymbolTable listTable = FindTableByName(GlobalSymbolTable, "List", 0);

        for(SymbolTable table : listTable.Children) {
            if(table.Name.equals(identifier))
                return table.Type;
        }
        return typeError + "." + identifier;
    }

    public String TypeCheckAgent(String funcName, Node node) {
        SymbolTable func = FindVehicleTable(GlobalSymbolTable, funcName, 0);
        if(func == null) {
            AddError(node, "Vehicle does not contain " + funcName);
            return typeError + "." + funcName;
        }
        return func.Type;
    }

    private SymbolTable FindVehicleTable(SymbolTable symbolTable, String funcName, int i) {
        for(SymbolTable table : symbolTable.Children) {

            if(table.Type.strip().equals("Vehicle")) {
                for(SymbolTable func : table.Children) {
                    if(func.Name.equals(funcName))
                        return func;
                }
            }

            if(!table.Children.isEmpty()) {
                SymbolTable var = FindVehicleTable(table, funcName, 0);
                if(var != null)
                    return var;
            }
        }

        if(i == 0) {
            for(SymbolTable table : GlobalSymbolTable.PredifindValues) {
                if(!table.Children.isEmpty()) {
                    SymbolTable var = FindTableByName(table, funcName, i + 1);
                    if(var != null)
                        return var;
                }
                if(table.Name.equals(funcName))
                    return table;
            }
        }

        return null;
    }
}
