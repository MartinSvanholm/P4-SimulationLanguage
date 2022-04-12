package ASTNodes.DclNodes;

import ASTNodes.ParamNode;
import java.util.ArrayList;

public class ListDclNode extends DclNode {
    public String Name = "List";
    public ArrayList<ParamNode> Parameters = new ArrayList<>();
}
