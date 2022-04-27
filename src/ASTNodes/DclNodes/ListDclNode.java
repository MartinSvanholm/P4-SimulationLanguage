package ASTNodes.DclNodes;

import ASTNodes.Node;
import ASTNodes.ParamNode;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class ListDclNode extends DclNode {
    public String Name = "List";
    public ArrayList<ParamNode> Parameters = new ArrayList<>();

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitListNode(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.addAll(Parameters);

        return Children;
    }
}
