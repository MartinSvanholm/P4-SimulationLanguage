package ASTNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class IdentifierNode extends Node {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitIdentifierNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();

        return null;
    }
}
