package ASTNodes;

import ASTNodes.ValueNodes.OpNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class AssignmentNode extends Node {
    public String Name = "Assignment";

    public IdentifierNode Identifier;

    public OpNode Equals = new OpNode();

    public Node ValueNode;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitAssignmentNode(this);
        } else return null;
    }


    @Override
    public ArrayList<Node> GetChildren() {
        Children.add(ValueNode);
        return Children;
    }
}
