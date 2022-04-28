package ASTNodes.ExprNodes;

import ASTNodes.IdentifierNode;
import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public abstract class ExpressionNode extends Node {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor){ return null; }
}
