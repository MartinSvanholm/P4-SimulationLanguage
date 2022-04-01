package Main;

import SymbolTable.*;
import Visitors.*;

import java.io.IOException;
import java.util.Enumeration;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
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
            String source = "debug.txt";
            CharStream cs = fromFileName(source);
            CFGLexer lexer = new CFGLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            CFGParser parser = new CFGParser(token);
            ParseTree tree = parser.program();

            SymbolTable symbolTable = new SymbolTable();

            SymbolTableVisitor visitor = new SymbolTableVisitor(symbolTable);

            visitor.visit(tree);

            Printer Printer = new Printer(symbolTable);

            Printer.PrintValues();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
