package ASTNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class BodyNode extends Node {
    public String Name = "Body";

    public ArrayList<Node> Lines = new ArrayList<>();

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitBodyNode(this);
        } else return null;
    }
}
