package ASTNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class ParamNode extends Node {
    public String Name = "Parameter";
    public TypeNode Type;
    public Node Identifier;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitParamNode(this);
        } else return null;
    }
}
