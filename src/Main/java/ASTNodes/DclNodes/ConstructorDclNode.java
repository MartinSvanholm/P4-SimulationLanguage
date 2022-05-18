package ASTNodes.DclNodes;

import ASTNodes.BodyNode;
import ASTNodes.Node;
import ASTNodes.ParamNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class ConstructorDclNode extends DclNode {
    public String Name = "constructor";

    public ArrayList<ParamNode> Parameters = new ArrayList<>();

    public BodyNode Body;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitConstructorNode(this);
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
