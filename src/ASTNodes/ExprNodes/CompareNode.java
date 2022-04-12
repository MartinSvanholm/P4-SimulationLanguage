package ASTNodes.ExprNodes;

import ASTNodes.ExprNodes.ExpressionNode;
import ASTNodes.ExprNodes.InfixExpressionNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class CompareNode extends InfixExpressionNode {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitCompareNode(this);
        } else return null;
    }
}
