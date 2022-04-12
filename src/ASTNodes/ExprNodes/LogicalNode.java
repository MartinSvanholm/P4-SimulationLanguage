package ASTNodes.ExprNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class LogicalNode extends InfixExpressionNode {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitLogicalNode(this);
        } else return null;
    }
}
