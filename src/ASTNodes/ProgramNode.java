package ASTNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

public class ProgramNode extends Node {
    public String Name = "Program";

    public SectionNode Environment;

    public SectionNode Behavior;

    public SectionNode Update;

    public SectionNode Output;

    @Override
    public <T> T accept(IBaseVisitor<? extends T> visitor) {
        if(visitor instanceof IYATSIVisitor) {
            return ((IYATSIVisitor<? extends T>) visitor).visitProgramNode(this);
        } else return null;
    }
}
