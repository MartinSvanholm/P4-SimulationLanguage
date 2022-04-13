package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class ElseIfNode extends ControlNode {
    public String Name = "else-if";
    public ExpressionNode condition;
    public BodyNode Body;
    public ElseIfNode ElseIf;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitElseIfNode(this);
        } else return null;
    }
}
