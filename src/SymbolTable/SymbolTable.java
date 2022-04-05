package SymbolTable;

import Main.CFGParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class SymbolTable {
    public Hashtable<String, SymbolInformation> Symbols = new Hashtable<String, SymbolInformation>();

    public ArrayList<SymbolTable> SymbolTables = new ArrayList<SymbolTable>();

    public void AddSymbol (ParserRuleContext ctx) throws IOException {

        for (ParseTree child : ctx.children) {
            if (child.getClass() == CFGParser.IdentifierContext.class) {
                if(Symbols.containsKey(child.getText())) {
                    throw new IOException("line " + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + " \"" + child.getText() + "\"" + " has already been declared");
                }
            }
        }

        if (ctx.getClass() == CFGParser.PrimVarDclContext.class) {
            AddVar((CFGParser.PrimVarDclContext) ctx);
        }

        if(ctx.getClass() == CFGParser.FunctionDclContext.class) {
            AddFunc((CFGParser.FunctionDclContext) ctx);
        }
    }

    private void AddVar (CFGParser.PrimVarDclContext ctx) {
        Symbols.put(ctx.identifier().getText(), new SymbolInformation(ctx.getClass().getSimpleName(),
                                                                      ctx.primType().getText()
                                                                     ));
    }

    private void AddFunc (CFGParser.FunctionDclContext ctx) {
        Symbols.put(ctx.identifier().getText(), new SymbolInformation(ctx.getClass().getSimpleName(), "void"));
    }

    private String TrimAttribute(String attribute) {
        return attribute.replace("Context", "");
    }
}