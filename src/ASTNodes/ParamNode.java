package ASTNodes;

import ASTNodes.Identifier.IdentifierNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class ParamNode extends Node {
    public String Name = "Parameter";
    public IdentifierNode Type;
    public Node Identifier;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitParamNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.add(Identifier);

        return Children;
    }
}
