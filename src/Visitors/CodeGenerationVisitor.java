package Visitors;

import ASTNodes.*;
import ASTVisitors.BaseVisitor;
import hu.webarticum.treeprinter.SimpleTreeNode;

public class CodeGenerationVisitor extends BaseVisitor<String> {
    @Override
    public String visitProgramNode(ProgramNode programNode) {

        /*
        String output = readfile(header.txt);

        output = output + visit(programNode.Update);

         */



        return visit(programNode.Environment) + visit(programNode.Behavior) + visit(programNode.Update) + visit(programNode.Output);
    }

    @Override
    public String visitSectionNode(SectionNode sectionNode){
        String output = "";

        for(Node line : sectionNode.Lines) {
            output += sectionNode.Lines;
        }
        return "";
    }
}
