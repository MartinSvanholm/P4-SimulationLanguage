package ASTNodes.ControlStructures;

import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;


public class SwitchNode extends ControlNode {
    public String Name = "switch";

    public Node switchValue;

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
