package ASTNodes;

import ASTNodes.ValueNodes.OpNode;

import java.util.jar.Attributes;

public class AssignmentNode extends Node {
    public String Name = "Assignment";

    public IdentifierNode Identifier;

    public OpNode Equals = new OpNode();

    public Node ValueNode;
}
