package SymbolTable;

import ASTNodes.*;
import ASTNodes.Node;
import ASTNodes.DclNodes.*;
import Main.Error;
import Main.ErrorHandler;
import Models.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class GlobalSymbolTable extends SymbolTable {
    public ErrorHandler ErrorHandler;

    public SymbolTable Vehicle = new SymbolTable("Vehicle", 0, null, "Vehicle");
    public SymbolTable Node = new SymbolTable("Node", 0, null, "Node");
    public SymbolTable Road = new SymbolTable("Road", 0, null, "Road");
    public SymbolTable Simulation = new SymbolTable("Simulation", 0, null, "Simulation");
    public SymbolTable List = new SymbolTable("List", 0, null, "List");

    public List<SymbolTable> PredifindValues = new ArrayList<SymbolTable>(
            java.util.List.of(Vehicle, Node, Road, Simulation, List)
    );

    private SymbolTable Scope;
    private int tempLvl = 0;

    public GlobalSymbolTable(String name, int lvl, ErrorHandler errorHandler) {
        super(name, lvl);
        ErrorHandler = errorHandler;
    }

    public void BuildSymbolTable(ASTNodes.Node ast) {
        InittializeTables();
        ProcessNode(ast);

        PrintTable(Vehicle);
        PrintTable(Node);
        PrintTable(Road);
        PrintTable(Simulation);
        PrintTable(List);
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
            if(Scope.Symbols.containsKey(((ParamNode) node).Identifier.Name)) {
                ErrorHandler.HasErrors = true;
                ErrorHandler.Errors.add(new Error(node.Line, ((ParamNode) node).Identifier.Name + " has already been declared"));
                return;
            }
            Scope.Symbols.put(((ParamNode) node).Identifier.Name, new Symbol(
                    ((ParamNode) node).Identifier.Name,
                    ((ParamNode) node).Type.Name,
                    "Parameter"));
            return;
        }

        if(DclAllreadyExist(((DclNode) node))) {
            ErrorHandler.HasErrors = true;
            ErrorHandler.Errors.add(new Error(node.Line, ((DclNode) node).Identifier.Name + " has already been declared"));
            return;
        }

        if(node instanceof ObjDclNode) {
            String Attribute = "Standard";

            if(((ObjDclNode) node).ObjValue instanceof ConstructorCallNode) {
                Attribute = ((ConstructorCallNode) ((ObjDclNode) node).ObjValue).Type.Name;
            }
            Scope.Symbols.put(((ObjDclNode) node).Identifier.Name, new Symbol(
                    ((ObjDclNode) node).Identifier.Name,
                    ((ObjDclNode) node).Type.Name,
                    Attribute
            ));
            return;
        }

        if(node instanceof ListDclNode) {
            Scope.Symbols.put(((ListDclNode) node).Identifier.Name, new Symbol(
                    ((ListDclNode) node).Identifier.Name,
                    ((ListDclNode) node).Type.Name,
                    "List"
            ));
            return;
        }

        if(node instanceof ConstructorDclNode) {
            if(Scope.Symbols.containsKey("constructor")) {
                ErrorHandler.HasErrors = true;
                ErrorHandler.Errors.add(new Error(node.Line,  "constructor for " + ((DclNode) node).Type.Name + " has already been declared"));
            } else {
                Scope.Symbols.put("constructor", new Symbol(
                        "constructor",
                        ((ConstructorDclNode) node).Type.Name,
                        "Constructor"));
                for(ParamNode node1 : ((ConstructorDclNode) node).Parameters) {
                    Scope.Symbols.put(node1.Identifier.Name, new Symbol(
                            node1.Identifier.Name,
                            node1.Type.Name,
                            "Parameter"));
                }
            }
        }
    }

    private boolean DclAllreadyExist(DclNode node) {
        return Scope.Symbols.containsKey(node.Identifier.Name);
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

    private void InittializeTables() {
        Vehicle.Symbols.put("Length" , new Symbol("Length", "number"));
        Vehicle.Symbols.put("Acceleration", new Symbol("Acceleration", "number"));
        Vehicle.Symbols.put("Path", new Symbol("Path", "Node", "List"));
        SymbolTable Pathfinding = new SymbolTable("Pathfinding", 0, Vehicle, "Node");
        Vehicle.Children.add(Pathfinding);

        Node.Symbols.put("Connections" , new Symbol("Connections", "Node", "List"));

        Road.Symbols.put("Length" , new Symbol("Length", "Number"));
        Road.Symbols.put("startNode", new Symbol("startNode", "Node"));
        Road.Symbols.put("endNode", new Symbol("endNode", "endNode"));

        SymbolTable Add = new SymbolTable("Add", 0, List, "void");
        Add.Symbols.put("value", new Symbol("value", "Generic", "Parameter"));

        SymbolTable Remove = new SymbolTable("Remove", 0, List, "void");
        Remove.Symbols.put("value", new Symbol("index", "number", "Parameter"));

        SymbolTable GetIndex = new SymbolTable("GetIndex", 0, List, "number");
        GetIndex.Symbols.put("value", new Symbol("value", "Generic", "Parameter"));

        List.Children.add(Add);
        List.Children.add(Remove);
        List.Children.add(GetIndex);

        SymbolTable Print = new SymbolTable("Print", 0, null, "void");
        Print.Symbols.put("line", new Symbol("line", "string", "parameter"));
        this.Children.add(Print);

        SymbolTable Type = new SymbolTable("Type", 0, null, "string");
        this.Children.add(Type);

        Simulation.Symbols.put("currentTick", new Symbol("currentTick", "number"));
    }
}
