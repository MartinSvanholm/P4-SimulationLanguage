package ASTNodes.ValueNodes;

import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class OpNode extends Node {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitOpNode(this);
        } else return null;
    }
}
