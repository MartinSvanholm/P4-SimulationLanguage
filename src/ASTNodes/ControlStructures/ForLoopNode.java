package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.IdentifierNode;
import ASTNodes.Node;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.OpNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class ForLoopNode extends ControlNode {
    public String Name = "for";
    public IdentifierNode identifier;

    public NumberNode rangeInt;
    public IdentifierNode rangeIdentifier;

    public BodyNode Body;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitForLoopNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.add(identifier);
        Children.add(rangeInt);
        Children.add(rangeIdentifier);
        Children.add(Body);

        return Children;
    }
}
