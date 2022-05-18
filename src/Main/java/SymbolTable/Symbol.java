package SymbolTable;

public class Symbol {
    public String Identifier;
    public String Type;
    public String Attribute = "Standard";

    public Symbol(String identifier, String type) {
        Identifier = identifier;
        Type = type;
    }

    public Symbol(String identifier, String type, String attribute) {
        Identifier = identifier;
        Type = type;
        Attribute = attribute;
    }
}
