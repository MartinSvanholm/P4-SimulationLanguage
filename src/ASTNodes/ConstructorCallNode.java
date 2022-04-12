package ASTNodes;

import java.util.ArrayList;

public class ConstructorCallNode extends Node {
    public String Name = "create";

    public Node Type;

    public ArrayList<ParamNode> Parameters = new ArrayList<>();
}
