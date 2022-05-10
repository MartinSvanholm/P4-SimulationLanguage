package ASTVisitors;

import ASTNodes.Node;

public abstract class AbstractBaseVisitor<T> implements IBaseVisitor<T> {

    public T visit(Node node) {
        return node.accept(this);
    }

    public void visitChildren(Node node) {
        for(Node node1 : node.GetChildren()) if(node.GetChildren() != null) {
            visit(node1);
        }
    }
}
