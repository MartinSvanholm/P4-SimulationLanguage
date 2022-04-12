package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class WhileLoopNode extends ControlNode {
    public String Name = "while";

    public ExpressionNode condition;

    public BodyNode Body;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitWhileLoopNode(this);
        } else return null;
    }
}
