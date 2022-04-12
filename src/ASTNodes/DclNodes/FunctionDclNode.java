package ASTNodes.DclNodes;

import ASTNodes.BodyNode;
import ASTNodes.ParamNode;

import java.util.ArrayList;

public class FunctionDclNode extends DclNode{
    public String Name = "function";

    public ArrayList<ParamNode> Parameters = new ArrayList<>();

    public BodyNode Body = new BodyNode();
}
