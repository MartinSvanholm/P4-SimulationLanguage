package ASTNodes.ControlStructures;

import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;

public class ControlNode extends Node {

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        return null;
    }
}