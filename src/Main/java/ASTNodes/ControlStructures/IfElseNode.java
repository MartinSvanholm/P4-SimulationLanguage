package ASTNodes.ControlStructures;

import ASTNodes.BodyNode;
import ASTNodes.ExprNodes.ExpressionNode;
import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class IfElseNode extends ControlNode {
    public String Name = "if-else";
    public ExpressionNode condition;
    public BodyNode Body;
    public ElseIfNode ElseIf;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitIfElseNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.add(condition);
        Children.add(Body);
        Children.add(ElseIf);

        return Children;
    }
}
