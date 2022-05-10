package VisitorHelpers;
import Visitors.FlowControl;

public class FlowControlHelper extends BaseHelper {
    FlowControl FlowControl;

    public FlowControlHelper(Main.ErrorHandler errorHandler, SymbolTable.GlobalSymbolTable globalSymbolTable, FlowControl flowControl) {
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
}
