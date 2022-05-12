package Main;

import ASTNodes.ProgramNode;
import SymbolTable.GlobalSymbolTable;
import Visitors.CodeGenerationVisitor;

public class CodeGenerator {
    public ProgramNode AST;
    private CodeGenIO io;
    private ErrorHandler errorHandler;
    private GlobalSymbolTable globalSymbolTable;

    public CodeGenerator(ProgramNode AST, ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
        this.AST = AST;
        io = new CodeGenIO();
        this.errorHandler = errorHandler;
        this.globalSymbolTable = globalSymbolTable;
    }

    public void GenerateCode() {
        CodeGenerationVisitor codeGenerationVisitor = new CodeGenerationVisitor(errorHandler, globalSymbolTable);
        String str = codeGenerationVisitor.visitProgramNode(AST);

        io.WriteFile("GeneratedCode.cs", str);
    }
}
