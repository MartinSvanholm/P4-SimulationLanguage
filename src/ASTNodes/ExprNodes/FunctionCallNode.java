package ASTNodes.ExprNodes;

import ASTNodes.Identifier.IdentifierNode;
import ASTNodes.Node;
import ASTNodes.ParamNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class FunctionCallNode extends InfixExpressionNode {
    public String Name = "functioncall";

    public IdentifierNode Identifier;

    public ArrayList<ParamNode> Parameters = new ArrayList<>();

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitFunctionCallNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        return null;
    }
}
