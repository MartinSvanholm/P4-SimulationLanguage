package ASTNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class ConstructorBodyNode extends Node {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitConstructorBodyNode(this);
        } else return null;
    }
}
