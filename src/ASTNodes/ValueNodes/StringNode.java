package ASTNodes.ValueNodes;

import ASTNodes.ExprNodes.ExpressionNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class StringNode extends ExpressionNode {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitStringNode(this);
        } else return null;
    }
}
