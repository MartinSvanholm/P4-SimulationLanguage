package ASTNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class InitConditionNode extends Node{
    public String Name = "initcondition";
    public Node type;
    public BodyNode Body;


    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitInitCondition(this);
        } else return null;
    }
}