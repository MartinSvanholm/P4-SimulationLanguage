package ASTNodes.ExprNodes;

import ASTNodes.Node;
import ASTNodes.ValueNodes.OpNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

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

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.add(Left);
        Children.add(Operator);
        Children.add(Right);

        return Children;
    }
}
