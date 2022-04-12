package ASTNodes.DclNodes;

import ASTNodes.BodyNode;
import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class ClassNode extends DclNode {
    public String Name = "Class";

    public BodyNode Body;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitClassNode(this);
        } else return null;
    }
}
