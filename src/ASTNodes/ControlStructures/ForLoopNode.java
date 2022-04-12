package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.IdentifierNode;
import ASTNodes.ValueNodes.NumberNode;

public class ForLoopNode extends ControlNode {
    public String Name = "for";
    public IdentifierNode identifier;

    public NumberNode rangeInt;
    public IdentifierNode rangeIdentifier;

    public BodyNode Body;
}
