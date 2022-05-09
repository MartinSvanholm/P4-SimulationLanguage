package VisitorHelpers;

import ASTNodes.Node;
import Main.Error;
import Main.ErrorHandler;
import SymbolTable.GlobalSymbolTable;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class BaseHelper {
    public final Main.ErrorHandler ErrorHandler;
    public final GlobalSymbolTable GlobalSymbolTable;
    public String typeError = "error";

    public BaseHelper(ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
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

    public void AddError(Node node, String message) {
        ErrorHandler.HasErrors = true;
        ErrorHandler.Errors.add(new Error(node.Line, message));
    }
}
