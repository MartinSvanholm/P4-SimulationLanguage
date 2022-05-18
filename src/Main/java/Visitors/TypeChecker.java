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
import SymbolTable.GlobalSymbolTable;
import SymbolTable.Symbol;
import SymbolTable.SymbolTable;


import java.util.Enumeration;

public class TypeChecker extends BaseVisitor<String> {
    ErrorHandler ErrorHandler;
    GlobalSymbolTable GlobalSymbolTable;
    public int Level = 0;

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

    private Symbol GetSymbolByScopeName(String name, String scopeName) {
        SymbolTable symbolTable = FindTableByName(GlobalSymbolTable, scopeName);

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

    private SymbolTable FindTableByName(SymbolTable symbolTable, String name) {
        if(symbolTable.Children == null)
            return null;

        for(SymbolTable table : symbolTable.Children) {
            if(table.Name.equals(name))
                return table;
            else
                return FindTableByName(table, name);
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
        for(Node node : endConditionNode.Body.Children) {
            if(node instanceof ReturnNode) {
                if(visit(node).strip().equals("bool")) {
                    return null;
                } else {
                    AddError(node, "return must be of type bool");
                }
            }
        }
        return null;
    }

    @Override
    public String visitInitCondition(InitConditionNode initConditionNode) {
        SymbolTable table = FindTableByName(GlobalSymbolTable, initConditionNode.type.Name.strip());

        if(table != null)
            return null;
        else
            AddError(initConditionNode, initConditionNode.type.Name.strip() + " has not been declared");
        return null;
    }

    @Override
    public String visitFunctionNode(FunctionDclNode functionDclNode) {
        Level++;
        for(Node node : functionDclNode.Body.Children) {
            if(node instanceof ReturnNode) {
                if(!visit(node).strip().equals(functionDclNode.Type.Name.strip())) {
                    AddError(node, "return must be of type " + functionDclNode.Type.Name.strip());
                }
            }
        }
        Level--;
        return null;
    }

    @Override
    public String visitListNode(ListDclNode listDclNode) {
        for(Node node : listDclNode.Parameters) {
            String test2 = visit(node).strip();
            if(!visit(node).strip().equals(listDclNode.Type.Name.strip())) {
                AddError(listDclNode, "parameters must be of type " + listDclNode.Type.Name.strip());
                return "Test1Success";
            }
        }
        return "Test2Success";
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
            if(!table.Name.equals(constructorDclNode.Type.Name)) {
                AddError(constructorDclNode, "constructor must be of type " + table.Name);
                return "Test1Success";
            }
        } else {
            AddError(constructorDclNode, constructorDclNode.Type.Name + " has not been declared");
            return "Test2Success";
        }
        return "Test3Success";
    }

    @Override
    public String visitObjDcl(ObjDclNode objDclNode) {
        if(objDclNode.ObjValue != null && !objDclNode.Type.Name.strip().equals(visit(objDclNode.ObjValue).strip())) {
            AddError(objDclNode, objDclNode.Identifier.Name+" must be of type "+ objDclNode.Type.Name.strip());
            return "Test1Success";
        }
        return "Test2Success";
    }

    @Override
    public String visitIfElseNode(IfElseNode ifElseNode) {
        if(visit(ifElseNode.condition).strip().equals("bool")) {
            if(ifElseNode.ElseIf != null) {
                visit(ifElseNode.ElseIf);
                return "Test1Success";
            }
            return "Test2Success";
        } else {
            AddError(ifElseNode, "condition must be of type bool");
            return "Test3Success";
        }
    }

    @Override
    public String visitElseIfNode(ElseIfNode elseIfNode) {
        if(visit(elseIfNode.condition).strip().equals("bool")) {
            if(elseIfNode.ElseIf != null) {
                visit(elseIfNode.ElseIf);
                return "Test1Success";
            }
            return "Test2Success";
        } else {
            AddError(elseIfNode, "condition must be of type bool");
            return "Test3Success";
        }
    }

    @Override
    public String visitSwitchNode(SwitchNode switchNode) {
        for(Node switchCase : switchNode.Body.GetChildren()) {
            if(!visit(switchNode.switchValue).strip().equals(visit(switchCase))) {
                AddError(switchCase, "case must be of type " + visit(switchNode.switchValue).strip());
                return "Test1Success";
            }
            return "Test2Success";
        }
        return null;
    }



    @Override
    public String visitSwitchBodyNode(SwitchBody switchBody) {
        visitChildren(switchBody);
        return null;
    }

    @Override
    public String visitCaseNode(CaseNode caseNode) {
        return visit(caseNode.switchValue);
    }

    @Override
    public String visitForLoopNode(ForLoopNode forLoopNode) {
        visitChildren(forLoopNode);
        return null;
    }

    @Override
    public String visitWhileLoopNode(WhileLoopNode whileLoopNode) {
        if(!visit(whileLoopNode.condition).strip().equals("bool")){
            AddError(whileLoopNode, "while loop condition must be of type bool");
            return "Test1Success";
        }
        visitChildren(whileLoopNode);
        return "Test2Success";
    }

    @Override
    public String visitAssignmentNode(AssignmentNode assignmentNode) {
        String assignmentNodeIdentifier = visit(assignmentNode.Identifier);
        String assignmentNodeValue = visit(assignmentNode.ValueNode);

        if(!assignmentNodeIdentifier.equals(assignmentNodeValue)) {
            AddError(assignmentNode, assignmentNode.ValueNode.Name + " must be of type " + visit(assignmentNode.Identifier).strip());
            return "Test1Success";
        }
        return "Test2Success";
    }

    @Override
    public String visitArrayExprNode(ArrayExprNode arrayExprNode) {
        if(!visit(arrayExprNode.Left).strip().equals(visit(arrayExprNode.Index).strip())) {
            AddError(arrayExprNode, "index must be of type " + visit(arrayExprNode.Left).strip());
        }
        return null;
    }

    @Override
    public String visitCompareNode(CompareNode compareNode) {
        if(visit(compareNode.Left).strip().equals("number") && visit(compareNode.Right).strip().equals("number"))
            return "bool";
        else return "error";
    }

    @Override
    public String visitFunctionCallNode(FunctionCallNode functionCallNode) {
        SymbolTable table = FindTableByName(GlobalSymbolTable, functionCallNode.Identifier.Name);
        if(table != null) {
            for(ParamNode param : functionCallNode.Parameters) {
                Enumeration<String> keys = table.Symbols.keys();

                while (keys.hasMoreElements()) {
                    Symbol var = GetSymbolByScopeName(keys.nextElement(), functionCallNode.Identifier.Name.strip());
                    if(var != null && !var.Type.equals(visit(param.Identifier)))  {
                        AddError(param, "parameter must be of type " + var.Type.strip());
                    }
                }
            }
            return visit(functionCallNode.Identifier).strip();
        } else {
            return "error";
        }
    }

    @Override
    public String visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        return constructorCallNode.Type.Name;
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
        return visit(returnNode.expressionNode);
    }

    @Override
    public String visitParamNode(ParamNode paramNode) {
        return visit(paramNode.Identifier);
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
        SymbolTable table = FindTableByName(GlobalSymbolTable, identifierNode.Name);
        if(var != null) {
            return var.Type.strip();
        } else if(table != null) {
            return table.Type.strip();
        } else {
            AddError(identifierNode, identifierNode.Name + " has not been declared");
            return "TestErrorSuccess";
        }
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
