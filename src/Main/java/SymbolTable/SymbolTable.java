package SymbolTable;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class SymbolTable {
    public String Name;
    public int Level;
    public String Type;
    public LinkedHashMap<String, Symbol> Symbols = new LinkedHashMap<>();
    public ArrayList<SymbolTable> Children = new ArrayList<>();
    public SymbolTable Parent = null;
    public String Attribute;

    public SymbolTable(String name, int lvl) {
        Name = name;
        Level = lvl;
    }

    public SymbolTable(String name, int lvl, SymbolTable parent, String type, String attribute) {
        Name = name;
        Level = lvl;
        Parent = parent;
        Type = type;
        Attribute = attribute;
    }
}
