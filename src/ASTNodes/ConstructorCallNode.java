package ASTNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class ConstructorCallNode extends Node {
    public String Name = "create";

    public Node Type;

    public ArrayList<ParamNode> Parameters = new ArrayList<>();

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitConstructorCallNode(this);
        } else return null;
    }
}
