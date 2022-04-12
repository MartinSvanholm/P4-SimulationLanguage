package ASTNodes.ValueNodes;

import ASTNodes.ExprNodes.ExpressionNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class BoolNode extends ExpressionNode {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitBoolNode(this);
        } else return null;
    }
}
