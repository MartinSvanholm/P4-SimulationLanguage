package ASTNodes;

import ASTVisitors.IBaseVisitor;

public class InitConditionNode extends Node{
    public BodyNode Body;
    public String type;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        return null;
    }
}
