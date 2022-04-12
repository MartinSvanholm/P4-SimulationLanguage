package ASTVisitors;

import ASTNodes.Node;

public abstract class AbstractBaseVisitor<T> implements IBaseVisitor<T> {

    @Override
    public T visit(Node node) {
        return node.accept(this);
    }
}
