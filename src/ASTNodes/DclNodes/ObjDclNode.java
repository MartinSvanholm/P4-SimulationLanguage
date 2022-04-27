package ASTNodes.DclNodes;

import ASTNodes.*;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public class ObjDclNode extends DclNode{
    public Node ObjValue;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitObjDcl(this);
        } else return null;
    }

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.add(Type);
        Children.add(Identifier);
        Children.add(ObjValue);

        return Children;
    }
}
