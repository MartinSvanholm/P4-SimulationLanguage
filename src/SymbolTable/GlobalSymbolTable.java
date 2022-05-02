package SymbolTable;

import ASTNodes.*;
import ASTNodes.Node;
import ASTNodes.DclNodes.*;
import Main.Error;
import Main.ErrorHandler;
import Models.*;

import java.util.ArrayList;
import java.util.Enumeration;

public class GlobalSymbolTable extends SymbolTable {
    public ErrorHandler ErrorHandler;

    public SymbolTable Vehicle = new SymbolTable("Vehicle", 0, null, "Vehicle");
    public SymbolTable Node = new SymbolTable("Node", 0, null, "Node");
    public SymbolTable Road = new SymbolTable("Road", 0, null, "Road");
    public SymbolTable Simulation = new SymbolTable("Simulation", 0, null, "Simulation");

    private SymbolTable Scope;
    private int tempLvl = 0;

    public GlobalSymbolTable(String name, int lvl, ErrorHandler errorHandler) {
        super(name, lvl);
        ErrorHandler = errorHandler;
    }

    public void BuildSymbolTable(ASTNodes.Node ast) {
        ProcessNode(ast);

        PrintTable(this);
    }

    private void ProcessNode(Node node) {
        if(node instanceof SectionNode || node instanceof FunctionDclNode || node instanceof ClassNode) {
            OpenScope(node);
        } else if(node instanceof ObjDclNode || node instanceof ListDclNode || node instanceof ConstructorDclNode) {
            InsertSymbol(node);
        }

        if(node != null) {
            if (node.GetChildren() != null) {
                for(Node tempNode : node.GetChildren()) {
                    ProcessNode(tempNode);
                }
            }
        }

        if(node instanceof SectionNode ||
                node instanceof FunctionDclNode ||
                node instanceof  ClassNode) {
            CloseScope(node);
        }
    }

    private void OpenScope(Node node) {
        if(node instanceof ClassNode) {
            for(SymbolTable symbolTable : Scope.Children) {
                if(symbolTable.Name.equals(((ClassNode) node).Identifier.Name)) {
                    ErrorHandler.HasErrors = true;
                    ErrorHandler.Errors.add(new Error(node.Line, ((ClassNode) node).Identifier.Name + " has already been declared"));
                    return;
                }
            }
        } else if (node instanceof FunctionDclNode) {
            for(SymbolTable symbolTable : Scope.Children) {
                if(symbolTable.Name.equals(((FunctionDclNode) node).Identifier.Name)) {
                    ErrorHandler.HasErrors = true;
                    ErrorHandler.Errors.add(new Error(node.Line, ((FunctionDclNode) node).Identifier.Name + " has already been declared"));
                    return;
                }
            }
        }

        tempLvl ++;
        if(node instanceof FunctionDclNode) {
            Scope = new SymbolTable(((DclNode) node).Identifier.Name, tempLvl, Scope, ((FunctionDclNode) node).Type.Name);
            for(Node param : ((FunctionDclNode) node).Parameters) {
                InsertSymbol(param);
            }
        }
        else if (node instanceof ClassNode)
            Scope = new SymbolTable(((ClassNode) node).Identifier.Name, tempLvl, Scope, ((ClassNode) node).Type.Name);
        else
            Scope = new SymbolTable(node.Name, tempLvl, this, "Simulation");
    }

    private void CloseScope(Node node) {
        if(node instanceof ClassNode) {
            for(SymbolTable symbolTable : Scope.Children) {
                if(symbolTable.Name.equals(((ClassNode) node).Identifier.Name)) {
                    return;
                }
            }
        } else if(node instanceof FunctionDclNode) {
            for(SymbolTable symbolTable : Scope.Children) {
                if(symbolTable.Name.equals(((FunctionDclNode) node).Identifier.Name))
                    return;
            }
        }
        tempLvl --;

        Scope.Parent.Children.add(Scope);

        Scope = Scope.Parent;
    }

    private void InsertSymbol(Node node) {
        if(node instanceof ParamNode) {
            Scope.Symbols.put(((ParamNode) node).Identifier.Name, new Symbol(
                    ((ParamNode) node).Identifier.Name,
                    ((ParamNode) node).Type.Name,
                    "Parameter"));
            return;
        } else if(!(node instanceof ConstructorDclNode) && Scope.Symbols.containsKey(((DclNode) node).Identifier.Name)) {
            ErrorHandler.HasErrors = true;
            ErrorHandler.Errors.add(new Error(node.Line, ((DclNode) node).Identifier.Name + " has already been declared"));
        } else if(Scope.Symbols.containsKey("constructor") && (node instanceof ConstructorDclNode)) {
            ErrorHandler.HasErrors = true;
            ErrorHandler.Errors.add(new Error(node.Line,  "constructor for " + ((DclNode) node).Type.Name + " has already been declared"));
        }

        if(!(node instanceof ConstructorDclNode)) {
            Scope.Symbols.put(((DclNode) node).Identifier.Name, new Symbol(
                    ((DclNode) node).Identifier.Name,
                    ((DclNode) node).Type.Name));
        } else {
            Scope.Symbols.put("constructor", new Symbol(
                    "constructor",
                    ((ConstructorDclNode) node).Type.Name));
            for(ParamNode node1 : ((ConstructorDclNode) node).Parameters) {
                Scope.Symbols.put(node1.Identifier.Name, new Symbol(
                        node1.Identifier.Name,
                        node1.Type.Name,
                        "Parameter"));
            }
        }
    }

    private void PrintTable(SymbolTable symbolTable) {
        System.out.println("");
        System.out.println(symbolTable.Name + " : " + symbolTable.Type + " " + symbolTable.Level);

        Enumeration<String> keys = symbolTable.Symbols.keys();

        while (keys.hasMoreElements()) {
            Symbol symbol = symbolTable.Symbols.get(keys.nextElement());
            System.out.println("    " + symbol.Identifier + " " + symbol.Type+" "+symbol.Attribute);
        }

        if(!symbolTable.Children.isEmpty()) {
            for(SymbolTable symbolTable1 : symbolTable.Children) {
                PrintTable(symbolTable1);
            }
        }
    }
}
