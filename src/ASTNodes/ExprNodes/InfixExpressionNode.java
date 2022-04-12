package ASTNodes.ExprNodes;

import ASTNodes.Node;
import ASTNodes.ValueNodes.OpNode;

public class InfixExpressionNode extends ExpressionNode {
    public ExpressionNode Left;

    public OpNode Operator;

    public ExpressionNode Right;
}
