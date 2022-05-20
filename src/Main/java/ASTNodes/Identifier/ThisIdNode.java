package ASTNodes.Identifier;

import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class ThisIdNode extends IdentifierNode {
    public SimpleIdNode Identifier;
    public String ClassName;
    public ObjIdNode ObjNode;

    @Override
    public ArrayList<Node> GetChildren() {
        return null;
    }

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitThisIdNode(this);
        } else return null;
    }

    @Override
    public String GetName(String obj) {
        if (obj.equals("obj"))
            return ObjNode.ObjectNode.Name;

        if (ObjNode != null)
            return ObjNode.Identifier.Name;
        return Identifier.Name;
    }
}
