package ASTNodes.ControlStructures;

import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;

import java.util.ArrayList;

public abstract class ControlNode extends Node {

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        return null;
    }

    @Override
    public abstract ArrayList<Node> GetChildren();

}
