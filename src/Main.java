import java.io.IOException;

import org.antlr.runtime.tree.TreeWizard;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) {
        try {
            String source = "YTBNSL.txt";
            CharStream cs = fromFileName(source);
            CFGLexer lexer = new CFGLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            CFGParser parser = new CFGParser(token);
            ParseTree tree = parser.program();

            CFGBaseVisitor<TreeWizard.Visitor> visitor = new CFGBaseVisitor<>();

            visitor.visit(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
