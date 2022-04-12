package ASTNodes.ExprNodes;

import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public abstract class ExpressionNode extends Node {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor){ return null;}
    }
