package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;
import ASTNodes.IdentifierNode;
import ASTNodes.Node;
import ASTNodes.SwitchBody;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;


public class SwitchNode extends ControlNode {
    public String Name = "switch";

    public Node switchValue;
    //public IdentifierNode Identifier;

    public SwitchBody Body;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitSwitchNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.add(switchValue);
        Children.add(Body);

        return Children;
    }
}
