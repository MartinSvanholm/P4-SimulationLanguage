package ASTNodes.DclNodes;

import ASTNodes.*;
import ASTVisitors.IBaseVisitor;

import java.util.ArrayList;

public abstract class DclNode extends Node {
    public String Name;
    public Node Type;
    public IdentifierNode Identifier;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        return null;
    }
}
