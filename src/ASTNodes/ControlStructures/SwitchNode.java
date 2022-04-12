package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;


public class SwitchNode extends ControlNode {
    public String Name = "switch";

    public ExpressionNode switchValue;

    public BodyNode Body;
}
