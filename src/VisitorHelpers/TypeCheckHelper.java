package VisitorHelpers;

import ASTNodes.ExprNodes.FunctionCallNode;
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
}
