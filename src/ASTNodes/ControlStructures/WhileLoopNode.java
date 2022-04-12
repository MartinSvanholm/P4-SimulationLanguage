package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;

public class WhileLoopNode extends ControlNode {
    public String Name = "while";

    public ExpressionNode condition;

    public BodyNode Body;
}
