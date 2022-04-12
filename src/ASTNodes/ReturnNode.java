package ASTNodes;

import ASTNodes.ExprNodes.ExpressionNode;
import ASTVisitors.IBaseVisitor;

public class ReturnNode extends Node {

    public String Name = "return";

    public ExpressionNode expressionNode;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        return null;
    }
}
