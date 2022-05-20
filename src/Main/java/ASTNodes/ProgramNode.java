package ASTNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

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

    @Override
    public ArrayList<Node> GetChildren() {
        Children = new ArrayList<>();
        Children.add(Environment);
        Children.add(Behavior);
        Children.add(Update);
        Children.add(Output);

        return Children;
    }
}
