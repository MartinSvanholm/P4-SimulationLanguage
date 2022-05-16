package SymbolTable;

public class Symbol {
    public String Identifier;
    public String InheritedType = "Base";
    public String ActualType;
    public String Attribute = "Standard";

    /*public Symbol(String identifier, String inheritedType) {
        Identifier = identifier;
        InheritedType = inheritedType;
    }*/

    /*public Symbol(String identifier, String inheritedType, String attribute) {
        Identifier = identifier;
        InheritedType = inheritedType;
        Attribute = attribute;
    }*/

    public Symbol(String identifier, String actualType) {
        Identifier = identifier;
        ActualType = actualType;
    }

    public Symbol(String identifier, String actualType, String attribute) {
        Identifier = identifier;
        ActualType = actualType;
        Attribute = attribute;
    }

    public Symbol(String identifier, String actualType, String inheritedType, String attribute) {
        Identifier = identifier;
        ActualType = actualType;
        InheritedType = inheritedType;
        Attribute = attribute;
    }
}
