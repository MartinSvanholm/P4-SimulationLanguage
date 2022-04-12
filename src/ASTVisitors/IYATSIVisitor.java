package ASTVisitors;

import ASTNodes.ProgramNode;

public interface IYATSIVisitor<T> extends IBaseVisitor<T> {
    T visitProgram(ProgramNode node);
}
