package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;

public class ElseIfNode extends ControlNode {
    public String Name = "else-if";

    public ExpressionNode condition;

    public BodyNode Body;
}
