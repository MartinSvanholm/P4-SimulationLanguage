package ASTNodes.ExprNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class ArrayExprNode extends ExpressionNode {
    public String Name = "Expr: arr";

    public ExpressionNode Left;

    public ExpressionNode Index;

    public ExpressionNode Right;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitArrayExprNode(this);
        } else return null;
    }
}
