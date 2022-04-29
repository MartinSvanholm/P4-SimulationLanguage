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
import SymbolTable.*;

import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeChecker extends BaseVisitor<String> {
    ErrorHandler ErrorHandler;
    GlobalSymbolTable GlobalSymbolTable;
    int Level = 0;

    public TypeChecker(ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
        ErrorHandler = errorHandler;
        GlobalSymbolTable = globalSymbolTable;
    }

    private Symbol GetSymbol(String name, int lvl) {
        SymbolTable symbolTable = FindTable(GlobalSymbolTable, lvl);

        Enumeration<String> keys = null;
        if(symbolTable != null)
            keys = symbolTable.Symbols.keys();

        if(keys != null) {
            while(keys.hasMoreElements()) {
                Symbol symbol = null;
                symbol = symbolTable.Symbols.get(keys.nextElement());

                if(symbol.Identifier.equals(name))
                    return symbol;
            }
        }
        return null;
    }
    
    private SymbolTable FindTable(SymbolTable symbolTable, int lvl) {
        if(symbolTable.Children == null)
            return null;

        for(SymbolTable table : symbolTable.Children) {
            if(table.Level == lvl)
                return table;
            else
                return FindTable(table, lvl);
        }

        return null;
    }

    private void AddError(Node node, String message) {
        ErrorHandler.HasErrors = true;
        ErrorHandler.Errors.add(new Error(node.Line, message));
    }

    public void CheckTypes(Node ast) {
        visitProgramNode((ProgramNode) ast);
    }

    @Override
    public String visitProgramNode(ProgramNode programNode) {
        visitChildren(programNode);
        return null;
    }

    @Override
    public String visitSectionNode(SectionNode sectionNode) {
        Level++;
        visitChildren(sectionNode);
        Level--;
        return null;
    }

    @Override
    public String visitEndCondition(EndConditionNode endConditionNode) {
        visitChildren(endConditionNode);
        return null;
    }

    @Override
    public String visitInitCondition(InitConditionNode initConditionNode) {
        visitChildren(initConditionNode);
        return null;
    }

    @Override
    public String visitFunctionNode(FunctionDclNode functionDclNode) {
        Level++;
        for(Node node : functionDclNode.Body.Children) {
            if(node instanceof ReturnNode) {
                if(visit(node).equals(functionDclNode.Type));
            }
        }
        Level--;
        return null;
    }

    @Override
    public String visitListNode(ListDclNode listDclNode) {
        visitChildren(listDclNode);
        return null;
    }

    @Override
    public String visitClassNode(ClassNode classNode) {
        Level++;
        visitChildren(classNode);
        Level--;
        return null;
    }

    @Override
    public String visitConstructorNode(ConstructorDclNode constructorDclNode) {
        SymbolTable table = FindTable(GlobalSymbolTable, Level);

        if (table != null) {
            if(!table.Name.equals(constructorDclNode.Type.Name))
                AddError(constructorDclNode, "constructor must be of type " + table.Name);
        } else {
            AddError(constructorDclNode, constructorDclNode.Type.Name + " has not been declared");
        }
        return null;
    }

    @Override
    public String visitObjDcl(ObjDclNode objDclNode) {
        if(objDclNode.ObjValue != null && !objDclNode.Type.Name.strip().equals(visit(objDclNode.ObjValue).strip()))
            AddError(objDclNode, objDclNode.Identifier.Name+" must be of type "+ objDclNode.Type.Name.strip());
        return null;
    }

    @Override
    public String visitIfElseNode(IfElseNode ifElseNode) {
        if(visit(ifElseNode.condition).strip().equals("bool")) {
            if(ifElseNode.ElseIf != null)
                visit(ifElseNode.ElseIf);
        } else {
            AddError(ifElseNode, "condition must be of type bool");
        }
        return null;
    }

    @Override
    public String visitElseIfNode(ElseIfNode elseIfNode) {
        if(elseIfNode.condition instanceof FunctionCallNode ||
                elseIfNode.condition instanceof CompareNode ||
                elseIfNode.condition instanceof  LogicalNode) {
        } else if (elseIfNode.condition instanceof IdentifierNode) {
            String ClassName = elseIfNode.condition.Name;
            Symbol var = GetSymbol(ClassName, Level);

            if(var == null) {
                ErrorHandler.HasErrors = true;
                AddError(elseIfNode, elseIfNode.condition.Name + " has never been declared");
            } else if(!(var.Type.equals("bool "))) {
                AddError(elseIfNode, elseIfNode.Name + " must be of type bool");
            } else {
            }
        } else {
            AddError(elseIfNode, elseIfNode.Name + " must be of type bool");
        }

        if(elseIfNode.ElseIf != null)
            visit(elseIfNode.ElseIf);
        return null;
    }

    @Override
    public String visitSwitchNode(SwitchNode switchNode) {
        visitChildren(switchNode);
        return null;
    }

    @Override
    public String visitSwitchBodyNode(SwitchBody switchBody) {
        visitChildren(switchBody);
        return null;
    }

    @Override
    public String visitCaseNode(CaseNode caseNode) {
        visitChildren(caseNode);
        return null;
    }

    @Override
    public String visitForLoopNode(ForLoopNode forLoopNode) {
        visitChildren(forLoopNode);
        return null;
    }

    @Override
    public String visitWhileLoopNode(WhileLoopNode whileLoopNode) {
        visitChildren(whileLoopNode);
            return null;
    }

    @Override
    public String visitAssignmentNode(AssignmentNode assignmentNode) {
        visitChildren(assignmentNode);
        return null;
    }

    @Override
    public String visitArrayExprNode(ArrayExprNode arrayExprNode) {
        return visit(arrayExprNode.Left).strip();
    }

    @Override
    public String visitCompareNode(CompareNode compareNode) {
        if(visit(compareNode.Left).strip().equals("number") && visit(compareNode.Right).strip().equals("number"))
            return "bool";
        else return "error";
    }

    @Override
    public String visitFunctionCallNode(FunctionCallNode functionCallNode) {
        return visit(functionCallNode.Identifier).strip();
    }

    @Override
    public String visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        visitChildren(constructorCallNode);
        return null;
    }

    @Override
    public String visitInfixExpressionNode(InfixExpressionNode infixExpressionNode) {
        String Left = visit(infixExpressionNode.Left);
        String Right = visit(infixExpressionNode.Right);
        if(Left.strip().equals(Right.strip()))
            return Left;
        else
            return "error";
    }

    @Override
    public String visitLogicalNode(LogicalNode logicalNode) {
        if(visit(logicalNode.Left).strip().equals("bool") && visit(logicalNode.Right).strip().equals("bool"))
            return "bool";
        else
            return "error";
    }

    @Override
    public String visitMathExpressionNode(MathExpressionNode mathExpressionNode) {
        if(visit(mathExpressionNode.Left).strip().equals("number") && visit(mathExpressionNode.Right).strip().equals("number"))
            return "number";

        return "error";
    }

    @Override
    public String visitReturnNode(ReturnNode returnNode) {
        visitChildren(returnNode);
        return null;
    }

    @Override
    public String visitParamNode(ParamNode paramNode) {
        visitChildren(paramNode);
         return null;
    }

    @Override
    public String visitBodyNode(BodyNode bodyNode) {
        visitChildren(bodyNode);
        return null;
    }

    @Override
    public String visitConstructorBodyNode(ConstructorBodyNode constructorBodyNode) {
        visitChildren(constructorBodyNode);
        return null;
    }

    @Override
    public String visitIdentifierNode(IdentifierNode identifierNode) {
        Symbol var = GetSymbol(identifierNode.Name, Level);
        if(var == null) {
            AddError(identifierNode, identifierNode.Name + " has never been declared");
            return "error";
        }
        else
            return var.Type.strip();
    }

    @Override
    public String visitTypeNode(TypeNode typeNode) {
        return typeNode.Name;
    }

    @Override
    public String visitNumberNode(NumberNode numberNode) {
        return "number";
    }

    @Override
    public String visitStringNode(StringNode stringNode) {
        return "string";
    }

    @Override
    public String visitBoolNode(BoolNode boolNode) {
        return "bool";
    }

    @Override
    public String visitOpNode(OpNode opNode) {
        return null;
    }
}
