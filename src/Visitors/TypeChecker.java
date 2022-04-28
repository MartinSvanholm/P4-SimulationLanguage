package Visitors;

import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.*;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.OpNode;
import ASTNodes.ValueNodes.StringNode;
import ASTVisitors.BaseVisitor;
import Main.Error;
import Main.ErrorHandler;
import Parser.CFGParser;
import SymbolTable.*;

import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeChecker extends BaseVisitor<Object> {
    ErrorHandler ErrorHandler;
    GlobalSymbolTable GlobalSymbolTable;
    int Level = 0;

    private Symbol GetSymbol(String name, int lvl) {
        SymbolTable symbolTable = FindTable(GlobalSymbolTable, lvl);

        Enumeration<String> keys = null;
        if(symbolTable != null)
            keys = symbolTable.Symbols.keys();

        while(keys.hasMoreElements()) {
            Symbol symbol = null;
            symbol = symbolTable.Symbols.get(keys.nextElement());

            if(symbol.Identifier.equals(name))
                return symbol;
        }
        return null;
    }
    
    private SymbolTable FindTable(SymbolTable symbolTable, int lvl) {
        for(SymbolTable symbolTable1 : symbolTable.Children) {
            if(symbolTable1.Children == null)
                continue;

            if(symbolTable1.Level == lvl)
                return symbolTable1;

            FindTable(symbolTable1, lvl);
        }

        return null;
    }

    private void AddError(Node node, String message) {
        ErrorHandler.HasErrors = true;
        ErrorHandler.Errors.add(new Error(node.Line, message));
    }

    public TypeChecker(ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
        ErrorHandler = errorHandler;
        GlobalSymbolTable = globalSymbolTable;
    }

    public void CheckTypes(Node ast) {
        visitProgramNode((ProgramNode) ast);
    }

    @Override
    public Object visitProgramNode(ProgramNode programNode) {
        visitChildren(programNode);
        return null;
    }

    @Override
    public Object visitSectionNode(SectionNode sectionNode) {
        Level++;
        visitChildren(sectionNode);
        Level--;
        return null;
    }

    @Override
    public Object visitEndCondition(EndConditionNode endConditionNode) {
        visitChildren(endConditionNode);
        return null;
    }

    @Override
    public Object visitInitCondition(InitConditionNode initConditionNode) {
        visitChildren(initConditionNode);
        return null;
    }

    @Override
    public Object visitFunctionNode(FunctionDclNode functionDclNode) {
        visitChildren(functionDclNode);
        return null;
    }

    @Override
    public Object visitListNode(ListDclNode listDclNode) {
        visitChildren(listDclNode);
        return null;
    }

    @Override
    public Object visitClassNode(ClassNode classNode) {
        visitChildren(classNode);
        return null;
    }

    @Override
    public Object visitConstructorNode(ConstructorDclNode constructorDclNode) {
        visitChildren(constructorDclNode);
        return null;
    }

    @Override
    public Object visitObjDcl(ObjDclNode objDclNode) {
        if(objDclNode.ObjValue != null) {
            switch (objDclNode.Type.Name) {
                case "number " -> {
                    if(!(objDclNode.ObjValue instanceof IdentifierNode)) {
                        if (!Pattern.matches("[0-9]*(\\.)?[0-9]*", objDclNode.ObjValue.Name)) {
                            AddError(objDclNode, objDclNode.Identifier.Name + " must be of type number");
                        }
                    } else {
                        Symbol var = GetSymbol(objDclNode.ObjValue.Name, Level);
                        if (var == null) {
                            AddError(objDclNode, objDclNode.Identifier.Name + " has never been declared");
                        } else if (!var.Type.equals(objDclNode.Type.Name)){
                            AddError(objDclNode, objDclNode.Identifier.Name + " must be of type number");
                        }
                    }

                }
                case "string " -> {
                }
            }
        }

        return null;
    }

    @Override
    public Object visitIfElseNode(IfElseNode ifElseNode) {
        visitChildren(ifElseNode);
        //if(ifElseNode.condition)
        return null;
    }

    @Override
    public Object visitElseIfNode(ElseIfNode elseIfNode) {
        visitChildren(elseIfNode);
        return null;
    }

    @Override
    public Object visitSwitchNode(SwitchNode switchNode) {
        visitChildren(switchNode);
        return null;
    }

    @Override
    public Object visitSwitchBodyNode(SwitchBody switchBody) {
        visitChildren(switchBody);
        return null;
    }

    @Override
    public Object visitCaseNode(CaseNode caseNode) {
        visitChildren(caseNode);
        return null;
    }

    @Override
    public Object visitForLoopNode(ForLoopNode forLoopNode) {

        Symbol listIdentifierSymbol = GetSymbol(forLoopNode.listIdentifier.Name, Level);

        if(listIdentifierSymbol == null) {
            AddError(forLoopNode, String.format("%s %s",
                    forLoopNode.listIdentifier.Name, "has never been declared - List expected"));
        }

        return null;
    }

    @Override
    public Object visitWhileLoopNode(WhileLoopNode whileLoopNode) {
        visitChildren(whileLoopNode);
            return null;
    }

    @Override
    public Object visitAssignmentNode(AssignmentNode assignmentNode) {
        visitChildren(assignmentNode);
        return null;
    }

    @Override
    public Object visitArrayExprNode(ArrayExprNode arrayExprNode) {
        visitChildren(arrayExprNode);
        return null;
    }

    @Override
    public Object visitCompareNode(CompareNode compareNode) {
        visitChildren(compareNode);
        return null;
    }

    @Override
    public Object visitFunctionCallNode(FunctionCallNode functionCallNode) {
        visitChildren(functionCallNode);
        return null;
    }

    @Override
    public Object visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        visitChildren(constructorCallNode);
        return null;
    }

    @Override
    public Object visitInfixExpressionNode(InfixExpressionNode infixExpressionNode) {
        visitChildren(infixExpressionNode);
        return null;
    }

    @Override
    public Object visitLogicalNode(LogicalNode logicalNode) {
        visitChildren(logicalNode);
        return null;
    }

    @Override
    public Object visitMathExpressionNode(MathExpressionNode mathExpressionNode) {
        visitChildren(mathExpressionNode);
        return null;
    }

    @Override
    public Object visitReturnNode(ReturnNode returnNode) {
        visitChildren(returnNode);
        return null;
    }

    @Override
    public Object visitParamNode(ParamNode paramNode) {
        visitChildren(paramNode);
         return null;
    }

    @Override
    public Object visitBodyNode(BodyNode bodyNode) {
        visitChildren(bodyNode);
        return null;
    }

    @Override
    public Object visitConstructorBodyNode(ConstructorBodyNode constructorBodyNode) {
        visitChildren(constructorBodyNode);
        return null;
    }

    @Override
    public Object visitIdentifierNode(IdentifierNode identifierNode) {

        return null;
    }

    @Override
    public Object visitTypeNode(TypeNode typeNode) {
        visitChildren(typeNode);
        return null;
    }

    @Override
    public Object visitNumberNode(NumberNode numberNode) {

        return null;
    }

    @Override
    public Object visitStringNode(StringNode stringNode) {
        visitChildren(stringNode);
        return null;
    }

    @Override
    public Object visitBoolNode(BoolNode boolNode) {
        visitChildren(boolNode);
        return null;
    }

    @Override
    public Object visitOpNode(OpNode opNode) {
        visitChildren(opNode);
        return null;
    }
}
