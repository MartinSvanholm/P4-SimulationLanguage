package ASTNodes.ExprNodes;

import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class ArrayExprNode extends ExpressionNode {
    public String Name = "Expr: arr";

    public Node Left;

    public Node Index;

    public Node Right;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitArrayExprNode(this);
        } else return null;
    }
}
