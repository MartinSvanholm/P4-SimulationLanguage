package SymbolTable;

import java.util.ArrayList;
import java.util.Hashtable;

public class SymbolTable {
    public String Name;
    public int Level;
    public String Type;
    public Hashtable<String, Symbol> Symbols = new Hashtable<>();
    public ArrayList<SymbolTable> Children = new ArrayList<>();
    public SymbolTable Parent = null;

    public SymbolTable(String name, int lvl) {
        Name = name;
        Level = lvl;
    }

    public SymbolTable(String name, int lvl, SymbolTable parent, String type) {
        Name = name;
        Level = lvl;
        Parent = parent;
        Type = type;
    }
}
