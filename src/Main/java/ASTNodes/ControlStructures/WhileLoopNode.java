package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;
import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class WhileLoopNode extends ControlNode {
    public String Name = "while";

    public Node condition;

    public BodyNode Body;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitWhileLoopNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.add(condition);
        Children.add(Body);

        return Children;
    }
}
