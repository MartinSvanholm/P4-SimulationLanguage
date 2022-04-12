package ASTNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class EndConditionNode extends Node {
    public BodyNode Body;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) { return null;
    }
}
