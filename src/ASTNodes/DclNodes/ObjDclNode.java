package ASTNodes.DclNodes;

import ASTNodes.*;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class ObjDclNode extends DclNode{
    public String Name = "dcl";

    public Node ObjValue;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitObjDcl(this);
        } else return null;
    }
}
