package VisitorHelpers;
import ASTNodes.ControlStructures.ForLoopNode;
import ASTNodes.DclNodes.FunctionDclNode;
import ASTNodes.Node;
import ASTNodes.ParamNode;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.SymbolTable;
import Visitors.FlowControl;

public class FlowControlHelper extends BaseHelper {
    FlowControl FlowControl;

    public FlowControlHelper(Main.ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable, FlowControl flowControl) {
        super(errorHandler, globalSymbolTable);
        FlowControl = flowControl;
    }

    public void ResetOptions() {
        FlowControl.canCreateInitCondition = false;
        FlowControl.canCreateClass = false;
        FlowControl.canCreateEndCondition = false;
        FlowControl.canCreateFunction = false;
        FlowControl.canCreateVar = false;
        FlowControl.canCreateLogic = false;
    }

    public void CheckParameterInheritance(Node node, String scopeName) {
        if(node instanceof FunctionDclNode) {
            for(ParamNode param : ((FunctionDclNode) node).Parameters) {
                SymbolTable inheritedClass = FindTableByName(GlobalSymbolTable, param.Type.Name, 0);
                if(inheritedClass == null)
                    return;
                InsertInheritedTypeIntoSymbol(param.Identifier.Name, ((FunctionDclNode) node).Identifier.Name, inheritedClass.Type);
            }
        }

        if(node instanceof ForLoopNode) {
            if(!((ForLoopNode) node).TypeNode.Name.equals("number") && !((ForLoopNode) node).TypeNode.Name.equals("string")) {
                SymbolTable inheritedClass = FindTableByName(GlobalSymbolTable, ((ForLoopNode) node).TypeNode.Name, 0);
                InsertInheritedTypeIntoSymbol(((ForLoopNode) node).identifier.Name, scopeName, inheritedClass.Type);
            } else {
                InsertInheritedTypeIntoSymbol(((ForLoopNode) node).identifier.Name, scopeName, "base");
            }
        }
    }
}
