package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;

public class IfElseNode extends ControlNode {
    public String Name = "if-else";
    public ExpressionNode condition;
    public BodyNode Body;
}
