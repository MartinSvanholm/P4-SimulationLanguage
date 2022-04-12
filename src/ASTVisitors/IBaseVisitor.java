package ASTVisitors;

import ASTNodes.Node;

public interface IBaseVisitor<T> {
    T visit(Node node);
}
