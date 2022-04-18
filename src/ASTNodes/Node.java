package ASTNodes;

import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;
import hu.webarticum.treeprinter.SimpleTreeNode;

import java.util.ArrayList;

public abstract class Node {
    public String Value = "Not found";

    public String Name = "";

    public int Line;

    public String GetNodeString() {
        return Name;
    }

    public abstract <T> T accept(IBaseVisitor<? extends T> visitor);
}
