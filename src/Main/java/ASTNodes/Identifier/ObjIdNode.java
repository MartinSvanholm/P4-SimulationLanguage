package ASTNodes.Identifier;

import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class ObjIdNode extends IdentifierNode {
    public SimpleIdNode Identifier;
    public SimpleIdNode ObjectNode;
    public ObjIdNode ObjIdNode;

    @Override
    public ArrayList<Node> GetChildren() {
        return null;
    }

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitObjIdNode(this);
        } else return null;
    }

    @Override
    public String GetName(String obj) {
        if(obj.equals("obj"))
            return ObjectNode.Name;

        if(ObjIdNode != null)
            return ObjIdNode.GetName(obj);
        return Identifier.Name;
    }
}
