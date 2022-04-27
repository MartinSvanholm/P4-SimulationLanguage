package ASTNodes;

import ASTNodes.ExprNodes.ExpressionNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class ReturnNode extends Node {

    public String Name = "return";

    public ExpressionNode expressionNode;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitReturnNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.add(expressionNode);

        return Children;
    }
}
