package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;


public class SwitchNode extends ControlNode {
    public String Name = "switch";

    public ExpressionNode switchValue;

    public BodyNode Body;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitSwitchNode(this);
        } else return null;
    }
}
