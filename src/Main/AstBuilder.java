package Main;

import ASTNodes.Node;
import ASTNodes.ProgramNode;
import Parser.CFGLexer;
import Parser.CFGParser;
import Visitors.BuildAstVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static Main.Main.ANSI_RED;
import static Main.Main.ANSI_RESET;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class AstBuilder {

    public String FilePath;
    public CharStream cs;
    public CFGLexer Lexer;
    public CommonTokenStream Tokens;
    public CFGParser Parser;
    public CFGParser.ProgramContext CST;

    public BuildAstVisitor visitor = new BuildAstVisitor();
    public Node AST = new ProgramNode();

    public ErrorHandler ErrorHandler;

    public AstBuilder(String filePath, ErrorHandler errorHandler) {
        FilePath = filePath;
        ErrorHandler = errorHandler;
    }

    public void BuildAST() {
        BuildCST();

        if(Parser.getNumberOfSyntaxErrors() > 0) {
            ErrorHandler.HasErrors = true;
            return;
        }

        AST = visitor.visitProgram(CST);
    }

    public void BuildCST() {
        try {
            cs = fromFileName(FilePath);

            Lexer = new CFGLexer(cs);
            Tokens = new CommonTokenStream(Lexer);
            Parser = new CFGParser(Tokens);

            CST = Parser.program();
        } catch (
                NoSuchFileException exception) {
            System.out.println(ANSI_RED + "File does not exist" + ANSI_RESET);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
