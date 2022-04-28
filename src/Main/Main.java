package Main;

import ASTNodes.ProgramNode;
import SymbolTable.*;
import Visitors.TypeChecker;

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
        ErrorHandler errorHandler = new ErrorHandler();
        AstBuilder astBuilder = new AstBuilder(args[0], errorHandler);
        astBuilder.BuildAST();

        if(!errorHandler.HasErrors) {
            ASTPrinter astPrinter = new ASTPrinter((ProgramNode) astBuilder.AST);
            astPrinter.PrintAST();
        }

        GlobalSymbolTable globalSymbolTable = new GlobalSymbolTable("Global Symbol Table", 0, errorHandler);
        globalSymbolTable.BuildSymbolTable(astBuilder.AST);

        TypeChecker typeChecker = new TypeChecker(errorHandler, globalSymbolTable);
        typeChecker.CheckTypes(astBuilder.AST);

        errorHandler.PrintErrors();
    }
}