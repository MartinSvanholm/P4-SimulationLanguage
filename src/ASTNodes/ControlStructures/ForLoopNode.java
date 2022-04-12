package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.IdentifierNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class ForLoopNode extends ControlNode {
    public String Name = "for";
    public IdentifierNode identifier;

    public NumberNode rangeInt;
    public IdentifierNode rangeIdentifier;

    public BodyNode Body;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitForLoopNode(this);
        } else return null;
    }
}
