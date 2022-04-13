package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;
import ASTNodes.Node;
import ASTNodes.SwitchBody;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;


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
}
