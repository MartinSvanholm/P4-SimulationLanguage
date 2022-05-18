import ASTNodes.ProgramNode;
import ASTVisitors.ASTPrinterVisitor;
import hu.webarticum.treeprinter.SimpleTreeNode;
import hu.webarticum.treeprinter.UnicodeMode;
import hu.webarticum.treeprinter.printer.traditional.TraditionalTreePrinter;

public class ASTPrinter {
    public ProgramNode AST;

    public ASTPrinter(ProgramNode programNode) {
        AST = programNode;
    }

    public void PrintAST() {
        ASTPrinterVisitor astPrinterVisitor = new ASTPrinterVisitor();

        SimpleTreeNode root = astPrinterVisitor.visitProgramNode(AST);

        UnicodeMode.setUnicodeAsDefault(false);

        TraditionalTreePrinter treePrinter = new TraditionalTreePrinter();
        treePrinter.print(root);
    }
}