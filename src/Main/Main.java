package Main;

import ASTNodes.Node;
import Parser.*;
import Visitors.*;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import hu.webarticum.treeprinter.SimpleTreeNode;
import hu.webarticum.treeprinter.UnicodeMode;
import hu.webarticum.treeprinter.printer.traditional.TraditionalTreePrinter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        try {
            CharStream cs = null;
            cs = fromFileName(args[0]);

            CFGLexer lexer = new CFGLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            CFGParser cfgParser = new CFGParser(token);

            BuildAstVisitor visitor = new BuildAstVisitor();

            Node ast = visitor.visitProgram(cfgParser.program());

            /*ASTPrinter printer = new ASTPrinter();

            UnicodeMode.setUnicodeAsDefault(false);

            TraditionalTreePrinter treePrinter = new TraditionalTreePrinter();
            treePrinter.print(ast.PrintNodes.get(0));*/

        } catch (NoSuchFileException exception) {
            System.out.println(ANSI_RED + "File does not exist" + ANSI_RESET);

        } catch (IOException e) {
            e.printStackTrace();
        }

                    /*
            SymbolTable symbolTable = new SymbolTable();

            SymbolTableVisitor visitor = new SymbolTableVisitor(symbolTable);

            visitor.visit(tree);

            Printer Printer = new Printer(symbolTable);

            Printer.PrintValues();*/
    }
}