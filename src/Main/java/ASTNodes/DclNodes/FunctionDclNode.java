package ASTNodes.DclNodes;

import ASTNodes.BodyNode;
import ASTNodes.Node;
import ASTNodes.ParamNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class FunctionDclNode extends DclNode{
    public String Name = "function";

    public ArrayList<ParamNode> Parameters = new ArrayList<>();

    public BodyNode Body = new BodyNode();

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitFunctionNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.addAll(Parameters);
        Children.add(Body);

        return Children;
    }
}
