package ASTNodes.ExprNodes;

import ASTNodes.IdentifierNode;
import ASTNodes.Node;
import ASTNodes.ParamNode;

import java.util.ArrayList;

public class FunctionCallNode extends Node {
    public String Name = "functioncall";

    public IdentifierNode Identifier;

    public ArrayList<ParamNode> Parameters = new ArrayList<>();
}
