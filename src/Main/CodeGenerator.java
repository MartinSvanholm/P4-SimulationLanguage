package Main;

import ASTNodes.ProgramNode;
import Visitors.CodeGenerationVisitor;

public class CodeGenerator {
    public ProgramNode AST;
    private CodeGenIO io;

    public CodeGenerator(ProgramNode AST) {
        this.AST = AST;
        io = new CodeGenIO();
    }

    public void GenerateCode() {
        CodeGenerationVisitor codeGenerationVisitor = new CodeGenerationVisitor();
        String str = codeGenerationVisitor.visitProgramNode(AST);

        io.WriteFile("GeneratedCode.cs", str);
    }
}
