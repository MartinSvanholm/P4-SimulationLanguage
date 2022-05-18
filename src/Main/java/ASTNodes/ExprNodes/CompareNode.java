package ASTNodes.ExprNodes;

import ASTNodes.ExprNodes.ExpressionNode;
import ASTNodes.ExprNodes.InfixExpressionNode;
import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class CompareNode extends InfixExpressionNode {
    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitCompareNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren(){
        Children = new ArrayList<>();
        return null;
    }
}
