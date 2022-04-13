package ASTNodes.ExprNodes;

import ASTNodes.Node;
import ASTNodes.ValueNodes.OpNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class InfixExpressionNode extends ExpressionNode {
    public Node Left;

    public OpNode Operator;

    public Node Right;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitInfixExpressionNode(this);
        } else return null;
    }
}
