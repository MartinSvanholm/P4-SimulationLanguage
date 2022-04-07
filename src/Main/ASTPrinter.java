package Main;

import ASTNodes.Node;

public class ASTPrinter {
    int indent = 0;

    public void PrintAST(Node node) {
        System.out.print(indent + " ");

        for(int i = 0; i < indent; i++) {
            System.out.print("   ");
        }

        System.out.println(node.Value);
        indent++;
        for(Node child : node.Nodes) {
            PrintAST(child);
        }

        indent--;
    }
}