package ASTNodes.Identifier;

import ASTNodes.ExprNodes.ExpressionNode;
import ASTNodes.Node;
import ASTVisitors.IBaseVisitor;
import ASTVisitors.IYATSIVisitor;

import java.util.ArrayList;

public abstract class IdentifierNode extends ExpressionNode {
    public abstract String GetName(String obj);
}
