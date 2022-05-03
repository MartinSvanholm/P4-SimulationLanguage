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

import java.util.ArrayList;
import java.util.Enumeration;

public class TypeChecker extends BaseVisitor<String> {
    ErrorHandler ErrorHandler;
    GlobalSymbolTable GlobalSymbolTable;
    int Level = 0;
    String typeError = "error";

    public TypeChecker(ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
        ErrorHandler = errorHandler;
        GlobalSymbolTable = globalSymbolTable;
    }

    private Symbol GetSymbol(String name, int lvl) {
        Symbol symbol;
        SymbolTable symbolTable = FindTable(GlobalSymbolTable, lvl);

        Enumeration<String> keys = null;
        if(symbolTable != null)
            keys = symbolTable.Symbols.keys();

        if(keys != null) {
            while(keys.hasMoreElements()) {
                symbol = symbolTable.Symbols.get(keys.nextElement());

                if(symbol.Identifier.equals(name))
                    return symbol;
            }
        }

        symbol = SearchClasses(name);
        if(symbol != null)
            return symbol;

        return null;
    }

    private Symbol GetSymbolByScopeName(String name, String scopeName) {
        SymbolTable symbolTable = FindTableByName(GlobalSymbolTable, scopeName, 0);

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

    private Symbol SearchClasses(String name) {
        Symbol symbol;

        symbol = GetSymbolByScopeName(name, "Vehicle");
        if(symbol != null)
            return symbol;

        symbol = GetSymbolByScopeName(name, "Node");
        if(symbol != null)
            return symbol;

        symbol = GetSymbolByScopeName(name, "Road");
        if(symbol != null)
            return symbol;

        symbol = GetSymbolByScopeName(name, "Simulation");
        return symbol;
    }

    private SymbolTable FindTable(SymbolTable symbolTable, int lvl) {
        for(SymbolTable table : symbolTable.Children) {
            if(table.Level == lvl)
                return table;

            if(!table.Children.isEmpty())
                return FindTable(table, lvl);
        }

        return null;
    }

    private SymbolTable FindTableByName(SymbolTable symbolTable, String name, int i) {
        for(SymbolTable table : symbolTable.Children) {
            if(table.Name.strip().equals(name.strip()))
                return table;

            if(!table.Children.isEmpty()) {
                SymbolTable var = FindTableByName(table, name, i + 1);
                if(var != null)
                    return var;
            }
        }

        if(i == 0) {
            for(SymbolTable table : GlobalSymbolTable.PredifindValues) {
                if(!table.Children.isEmpty()) {
                    SymbolTable var = FindTableByName(table, name, i + 1);
                    if(var != null)
                        return var;
                }
                if(table.Name.equals(name))
                    return table;
            }
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
        SymbolTable table = FindTableByName(GlobalSymbolTable, initConditionNode.type.Name.strip(), 0);

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
        for(ParamNode node : listDclNode.Parameters) {
            if(node.Identifier.Name.equals(listDclNode.Identifier.Name)) {
                AddError(listDclNode, listDclNode.Identifier.Name + " cannot be a parameter of itself");
            }

            String paramType = visit(node);
            if(!paramType.equals(typeError)) {
                SymbolTable table = FindTableByName(GlobalSymbolTable, paramType, 0);
                if(table != null && !table.Type.equals(listDclNode.Type.Name) && !paramType.equals(listDclNode.Type.Name)) {
                    AddError(listDclNode, "parameter must be of type " + listDclNode.Type.Name.strip());
                }

                if(!paramType.equals(listDclNode.Type.Name) && table == null) {
                    AddError(listDclNode, "parameter must be of type " + listDclNode.Type.Name.strip());
                }
            } else {
                AddError(listDclNode, node.Identifier.Name + " has never been declared");
            }
        }
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
        if(objDclNode.ObjValue instanceof ConstructorCallNode) {
            if(!visit(objDclNode.ObjValue).equals(objDclNode.Type.Name) && !((ConstructorCallNode) objDclNode.ObjValue).Type.Name.equals(objDclNode.Type.Name)) {
                AddError(objDclNode, objDclNode.Identifier.Name+" must be of type "+ visit(objDclNode.Type));
            }
        } else if(objDclNode.ObjValue != null && !objDclNode.Type.Name.strip().equals(visit(objDclNode.ObjValue).strip()))
            AddError(objDclNode, objDclNode.Identifier.Name+" must be of type "+ visit(objDclNode.Type));
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
        if(visit(elseIfNode.condition).strip().equals("bool")) {
            if(elseIfNode.ElseIf != null)
                visit(elseIfNode.ElseIf);
        } else {
            AddError(elseIfNode, "condition must be of type bool");
        }
        return null;
    }

    @Override
    public String visitSwitchNode(SwitchNode switchNode) {
        for(Node switchCase : switchNode.Body.GetChildren()) {
            if(!visit(switchNode.switchValue).strip().equals(visit(switchCase))) {
                AddError(switchCase, "case must be of type " + visit(switchNode.switchValue).strip());
            }
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
        }
        visitChildren(whileLoopNode);
        return null;
    }

    @Override
    public String visitAssignmentNode(AssignmentNode assignmentNode) {
        if(visit(assignmentNode.Identifier).equals(typeError)) {
            AddError(assignmentNode,assignmentNode.Identifier.Name + " has never been declared");
        } else if(!visit(assignmentNode.Identifier).strip().equals(visit(assignmentNode.ValueNode))) {
            AddError(assignmentNode, assignmentNode.Identifier.Name + " must be of type " + visit(assignmentNode.Identifier));
        }
        return null;
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
        if( visit(compareNode.Left).equals(visit(compareNode.Right)))
            return "bool";
        else
            return "error";
    }

    @Override
    public String visitFunctionCallNode(FunctionCallNode functionCallNode) {
        String funcName = functionCallNode.Identifier.Name;

        SymbolTable table = FindTableByName(GlobalSymbolTable, functionCallNode.Identifier.Name, 0);
        if(table == null) {
            table = FindTableByName(GlobalSymbolTable, functionCallNode.Identifier.Name.split("\\.")[1], 0);
            funcName = functionCallNode.Identifier.Name.split("\\.")[1];
        }

        if(table != null) {
            ArrayList<Symbol> formParams = table.Symbols;

            for(ParamNode param : functionCallNode.Parameters) {
                String line =  keys.nextElement();
                Symbol formalParam = GetSymbolByScopeName(line, funcName);

                if(formalParam != null) {

                    if(formalParam.Type.equals("Generic")) {
                        String paramType = visit(param);
                        Symbol field = GetSymbol(functionCallNode.Identifier.Name.split("\\.")[0], Level);
                        if(!paramType.equals(field.Type))
                            AddError(param, param.Identifier.Name + " must be of type " + field.Type);
                    }
                }
            }

        } else {
            AddError(functionCallNode, functionCallNode.Identifier.Name + " has never been declared");
            return "error";
        }
        return null;
    }

    @Override
    public String visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        if(IsAbstractType(constructorCallNode.Type.Name)) {
            AddError(constructorCallNode, "cannot declare value from abstract class");
            return "error";
        }
        SymbolTable table = FindTableByName(GlobalSymbolTable, constructorCallNode.Type.Name, 0);
        if(table == null) {
            AddError(constructorCallNode, constructorCallNode.Type.Name + " has never been declared");
            return "error";
        } else {
            Enumeration<String> keys = table.Symbols.keys();
            for(ParamNode param : constructorCallNode.Parameters) {
                String line = keys.nextElement();
                if(line.equals("constructor"))
                    continue;
                Symbol var = GetSymbolByScopeName(line, constructorCallNode.Type.Name);
                if(var == null)
                    AddError(constructorCallNode, "to many parameters");
                else if(!visit(param.Identifier).strip().equals(var.Type))
                    AddError(constructorCallNode, "parameter must be of type " + var.Type);
            }
            if(keys.hasMoreElements() && !keys.nextElement().equals("constructor"))
                AddError(constructorCallNode, "missing parameter");
            return table.Type;
        }
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
        SymbolTable table = FindTableByName(GlobalSymbolTable, identifierNode.Name, 0);
        if(var != null) {
            return var.Type.strip();
        } else if(table != null) {
            return table.Type.strip();
        }

        return typeError;
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

    private Boolean IsAbstractType(String type){
        return switch (type) {
            case "Node", "Vehicle", "Road" -> true;
            default -> false;
        };
    }

    private
}
