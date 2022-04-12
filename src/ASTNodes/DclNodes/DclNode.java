package ASTNodes.DclNodes;

import ASTNodes.*;
import ASTVisitors.IBaseVisitor;

public abstract class DclNode extends Node {
    public Node Type;
    public IdentifierNode Identifier;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        return null;
    }
}
