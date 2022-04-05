package Main;

import SymbolTable.SymbolTable;

import java.util.Enumeration;

public class Printer {
    public SymbolTable SymbolTable;

    public Printer(SymbolTable symbolTable) {
        SymbolTable = symbolTable;
    }


    public void PrintValues() {
        Enumeration<String> e = SymbolTable.Symbols.keys();

        while (e.hasMoreElements()) {
            String key = e.nextElement();

            System.out.println("Identifier = " + key + " - Attribute = " + SymbolTable.Symbols.get(key).Attribute + " - Type = " + SymbolTable.Symbols.get(key).Type + "\n");
        }
    }
}
