package ASTNodes.ValueNodes;

import ASTNodes.ExprNodes.ExpressionNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class NumberNode extends ExpressionNode {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitNumberNode(this);
        } else return null;
    }
}
