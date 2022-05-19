package Main;

import ASTNodes.ProgramNode;
import SymbolTable.*;
import Visitors.FlowControl;
import Visitors.TypeChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        GlobalSymbolTable globalSymbolTable = new GlobalSymbolTable("Global Symbol Table", 0, errorHandler);
        TypeChecker typeChecker = new TypeChecker(errorHandler, globalSymbolTable);
        FlowControl flowControl = new FlowControl(globalSymbolTable, errorHandler);
        CMDHandler cmdHandler = new CMDHandler();

        astBuilder.BuildAST();

        if(!errorHandler.HasErrors) {
            globalSymbolTable.BuildSymbolTable(astBuilder.AST);
        }

        System.out.println("----------------------------");
        globalSymbolTable.Print();

        if(!errorHandler.HasErrors) {
            ASTPrinter astPrinter = new ASTPrinter((ProgramNode) astBuilder.AST);
            astPrinter.PrintAST();

            CodeGenerator codeGenerator = new CodeGenerator((ProgramNode) astBuilder.AST, errorHandler, globalSymbolTable);
            codeGenerator.GenerateCode();
            //cmdHandler.dotnetCompilse();
            //cmdHandler.RunEXE();
        }

        if(!errorHandler.HasErrors) {
            flowControl.CheckFlow(astBuilder.AST);
        }

        if(!errorHandler.HasErrors) {
            typeChecker.CheckTypes(astBuilder.AST);
        }

        errorHandler.PrintErrors();
    }
}

