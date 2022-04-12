package ASTVisitors;

import ASTNodes.Node;
import ASTNodes.ProgramNode;
import hu.webarticum.treeprinter.SimpleTreeNode;

public class ASTPrinterVisitor<SimpleTreeNode> extends AbstractBaseVisitor<SimpleTreeNode> implements IYATSIVisitor<SimpleTreeNode> {

    @Override
    public SimpleTreeNode visitProgram(ProgramNode node) {
        return null;
    }
}
