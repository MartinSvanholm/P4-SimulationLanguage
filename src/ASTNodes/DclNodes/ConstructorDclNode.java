package ASTNodes.DclNodes;

import ASTNodes.BodyNode;
import ASTNodes.Node;
import ASTNodes.ParamNode;

import java.util.ArrayList;

public class ConstructorDclNode extends DclNode {
    public String Name = "constructor";

    public ArrayList<ParamNode> Parameters = new ArrayList<>();

    public BodyNode Body;
}
