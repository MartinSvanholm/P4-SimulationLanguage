package ASTNodes.ExprNodes;

import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;

public abstract class ExpressionNode extends Node {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor){ return null; }
}
