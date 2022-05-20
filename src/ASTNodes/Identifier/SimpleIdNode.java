package ASTNodes.Identifier;

import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class SimpleIdNode extends IdentifierNode {
    @Override
    public ArrayList<Node> GetChildren() {
        return null;
    }

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitSimpleIdNode(this);
        } else return null;
    }

    @Override
    public String GetName(String obj) {
        return Name;
    }
}
