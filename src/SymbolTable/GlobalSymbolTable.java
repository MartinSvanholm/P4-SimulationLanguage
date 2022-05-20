package SymbolTable;

import ASTNodes.*;
import ASTNodes.ControlStructures.ForLoopNode;
import ASTNodes.Node;
import ASTNodes.DclNodes.*;
import Main.Error;
import Main.ErrorHandler;
import Models.*;
import VisitorHelpers.TypeCheckHelper;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class GlobalSymbolTable extends SymbolTable {
    public ErrorHandler ErrorHandler;
    public TypeCheckHelper helper;

    public SymbolTable Vehicle = new SymbolTable("Vehicle", 0, null, "Vehicle", "Class");
    public SymbolTable Node = new SymbolTable("Node", 0, null, "Node", "Class");
    public SymbolTable Road = new SymbolTable("Road", 0, null, "Road", "Class");
    public SymbolTable Simulation = new SymbolTable("Simulation", 0, null, "Simulation", "Class");
    public SymbolTable List = new SymbolTable("List", 0, null, "List", "Class");
    public SymbolTable AgentTypes = new SymbolTable("VehicleTypes", 0, null, "List", "Class");

    public List<SymbolTable> PredifindValues = new ArrayList<SymbolTable>(
            java.util.List.of(Vehicle, Node, Road, Simulation, List)
    );

    private SymbolTable Scope;
    private int tempLvl = 0;

    public GlobalSymbolTable(String name, int lvl, ErrorHandler errorHandler) {
        super(name, lvl);
        ErrorHandler = errorHandler;
        helper = new TypeCheckHelper(ErrorHandler, this);
    }

    public void BuildSymbolTable(ASTNodes.Node ast) {
        InittializeTables();
        ProcessNode(ast);
    }

    public void Print() {
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
        } else if(node instanceof ObjDclNode || node instanceof ListDclNode || node instanceof ConstructorDclNode || node instanceof ForLoopNode) {
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
            Scope = new SymbolTable(((DclNode) node).Identifier.Name, tempLvl, Scope, ((FunctionDclNode) node).Type.Name, "Function");
            for(Node param : ((FunctionDclNode) node).Parameters) {
                InsertSymbol(param);
            }
        }
        else if (node instanceof ClassNode)
            Scope = new SymbolTable(((ClassNode) node).Identifier.Name, tempLvl, Scope, ((ClassNode) node).Type.Name, "Class");
        else {
            Scope = new SymbolTable(node.Name, tempLvl, this, "Simulation", "Class");
        }
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
            return;
        }

        if(node instanceof ForLoopNode) {
            InsertForLoopDcl(((ForLoopNode) node));
            return;
        }

        if(DclAllreadyExist(((DclNode) node))) {
            ErrorHandler.HasErrors = true;
            ErrorHandler.Errors.add(new Error(node.Line, ((DclNode) node).Identifier.Name + " has already been declared"));
            return;
        }

        if(node instanceof ObjDclNode) {
            if(((ObjDclNode) node).ObjValue instanceof ConstructorCallNode) {
                String actualType = ((ConstructorCallNode) ((ObjDclNode) node).ObjValue).Type.Name;

                Scope.Symbols.put(((ObjDclNode) node).Identifier.Name, new Symbol(
                        ((ObjDclNode) node).Identifier.Name,
                        actualType,
                        ((ObjDclNode) node).Type.Name,
                        "Object"
                ));
                return;
            }

            Scope.Symbols.put(((ObjDclNode) node).Identifier.Name, new Symbol(
                    ((ObjDclNode) node).Identifier.Name,
                    ((ObjDclNode) node).Type.Name
            ));
        }

        if(node instanceof ListDclNode) {
            Scope.Symbols.put(((ListDclNode) node).Identifier.Name, new Symbol(
                    ((ListDclNode) node).Identifier.Name,
                    ((ListDclNode) node).Type.Name,
                    ((ListDclNode) node).Type.Name,
                    "List"
            ));
            return;
        }
    }

    private void InsertForLoopDcl(ForLoopNode node) {
        Scope.Symbols.put(node.identifier.Name, new Symbol(
                node.identifier.Name,
                node.TypeNode.Name,
                GetInheritance(node.TypeNode.Name),
                "ForParameter"
        ));
    }

    private boolean DclAllreadyExist(DclNode node) {
        return Scope.Symbols.containsKey(node.Identifier.Name);
    }

    private void PrintTable(SymbolTable symbolTable) {
        System.out.println("");
        System.out.println(symbolTable.Name + " : " + symbolTable.Type + " " + symbolTable.Attribute + " " + symbolTable.Level);

        for(Symbol symbol : symbolTable.Symbols.values()) {
            System.out.println("    " + symbol.Identifier + " " + symbol.ActualType + " " + symbol.InheritedType + " " + symbol.Attribute);
        }

        if(!symbolTable.Children.isEmpty()) {
            for(SymbolTable symbolTable1 : symbolTable.Children) {
                PrintTable(symbolTable1);
            }
        }
    }

    private void InittializeTables() {
        Vehicle.Symbols.put("length" , new Symbol("length", "number"));
        Vehicle.Symbols.put("acceleration", new Symbol("acceleration", "number"));
        Vehicle.Symbols.put("speed" , new Symbol("speed", "number"));
        Vehicle.Symbols.put("position" , new Symbol("position", "number"));
        Vehicle.Symbols.put("path", new Symbol("path", "Node", "List"));
        SymbolTable Pathfinding = new SymbolTable("PathFinding", 0, Vehicle, "Node", "Function");
        Vehicle.Children.add(Pathfinding);

        Node.Symbols.put("Connections" , new Symbol("Connections", "Node", "List"));

        Road.Symbols.put("speedLimit", new Symbol("speedLimit", "number"));
        Road.Symbols.put("length" , new Symbol("length", "number"));
        Road.Symbols.put("startNode", new Symbol("startNode", "Node"));
        Road.Symbols.put("endNode", new Symbol("endNode", "endNode"));

        SymbolTable Add = new SymbolTable("Add", 0, List, "void", "Function");
        Add.Symbols.put("value", new Symbol("value", "Generic", "Parameter"));

        SymbolTable Remove = new SymbolTable("Remove", 0, List, "void", "Function");
        Remove.Symbols.put("value", new Symbol("index", "number", "Parameter"));

        SymbolTable GetIndex = new SymbolTable("GetIndex", 0, List, "number", "Function");
        GetIndex.Symbols.put("value", new Symbol("value", "Generic", "Parameter"));

        List.Children.add(Add);
        List.Children.add(Remove);
        List.Children.add(GetIndex);

        SymbolTable Print = new SymbolTable("Print", 0, null, "void", "Function");
        Print.Symbols.put("line", new Symbol("line", "string", "Parameter"));
        Simulation.Children.add(Print);

        SymbolTable Random = new SymbolTable("Random", 0, null, "number", "Function");
        Random.Symbols.put("from", new Symbol("from", "number", "Parameter"));
        Random.Symbols.put("too", new Symbol("too", "number", "Parameter"));
        Simulation.Children.add(Random);

        SymbolTable Type = new SymbolTable("Type", 0, null, "string", "Function");
        Simulation.Children.add(Type);

        Symbol vehicles = new Symbol("vehicles", "Vehicle", "List", "Standard");
        Simulation.Symbols.put("vehicles", vehicles);

        Simulation.Symbols.put("CurrentTick", new Symbol("CurrentTick", "number"));


    }

    private String GetInheritance(String className) {
        SymbolTable table = helper.FindTableByName(this, className, 0);
        if(table != null)
            return table.Type;
        return null;
    }


}
