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
import Main.ErrorHandler;
import SymbolTable.*;

import java.util.ArrayList;
import java.util.Iterator;

public class TypeChecker extends BaseVisitor<String> {
    private final GlobalSymbolTable GlobalSymbolTable;
    String scopeName = "Global";
    String prevScopeName;
    String typeError = "error";
    private final TypeCheckHelper helper;

    public TypeChecker(ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
        GlobalSymbolTable = globalSymbolTable;
        helper = new TypeCheckHelper(errorHandler, GlobalSymbolTable);
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
        prevScopeName = scopeName;
        scopeName = sectionNode.Name;

        visitChildren(sectionNode);

        scopeName = prevScopeName;
        return null;
    }

    @Override
    public String visitEndCondition(EndConditionNode endConditionNode) {
        for(Node node : endConditionNode.Body.Children) {
            if(node instanceof ReturnNode) {
                if(visit(node).strip().equals("bool")) {
                    return null;
                } else {
                    helper.AddError(node, "return must be of type bool");
                }
            }
        }
        return null;
    }

    @Override
    public String visitInitCondition(InitConditionNode initConditionNode) {
        SymbolTable table = helper.FindTableByName(GlobalSymbolTable, initConditionNode.type.Name.strip(), 0);

        if(table != null)
            return null;
        else
            helper.AddError(initConditionNode, initConditionNode.type.Name.strip() + " has not been declared");
        return null;
    }

    @Override
    public String visitFunctionNode(FunctionDclNode functionDclNode) {
        prevScopeName = scopeName;
        scopeName = functionDclNode.Identifier.Name;

        for(Node node : functionDclNode.Body.Children) {
            if(node instanceof ReturnNode) {
                if(!visit(node).strip().equals(functionDclNode.Type.Name.strip())) {
                    helper.AddError(node, "return must be of type " + functionDclNode.Type.Name.strip());
                }
            }
        }
        visit(functionDclNode.Body);

        scopeName = prevScopeName;
        return null;
    }

    @Override
    public String visitListNode(ListDclNode listDclNode) {
        if(helper.IsBaseType(listDclNode.Type.Name)) {
            for(ParamNode node : listDclNode.Parameters) {
                String paramtype = visit(node);
                if(paramtype.equals(typeError)) {
                    helper.AddError(node, node.Identifier.Name + " has never been declared");
                } else if(!listDclNode.Type.Name.equals(paramtype))
                    helper.AddError(node, node.Identifier.Name + " must be of type " + listDclNode.Type.Name);
            }
        } else {
            helper.AddError(listDclNode, "cannot declare List of type " + listDclNode.Type.Name);
        }

        return null;
    }

    @Override
    public String visitClassNode(ClassNode classNode) {
        prevScopeName = scopeName;
        scopeName = classNode.Identifier.Name;

        visitChildren(classNode);

        scopeName = prevScopeName;
        return null;
    }

    @Override
    public String visitConstructorNode(ConstructorDclNode constructorDclNode) {
        SymbolTable table = helper.FindTableByName(GlobalSymbolTable, scopeName, 0);

        if (table != null) {
            if(!table.Name.equals(constructorDclNode.Type.Name))
                helper.AddError(constructorDclNode, "constructor must be of type " + table.Name);
        } else {
            helper.AddError(constructorDclNode, constructorDclNode.Type.Name + " has not been declared");
        }
        return null;
    }

    @Override
    public String visitObjDcl(ObjDclNode objDclNode) {
        if(helper.IsBaseType(objDclNode.Type.Name)) {
            if(objDclNode.ObjValue != null && !objDclNode.Type.Name.equals(visit(objDclNode.ObjValue))) {
                helper.AddError(objDclNode, objDclNode.Identifier.Name + " must be of type " + objDclNode.Type.Name);
            }
        }
        else {
            helper.AddError(objDclNode, "cannot declare variable of type " + objDclNode.Type.Name);
        }
        return null;
    }

    @Override
    public String visitIfElseNode(IfElseNode ifElseNode) {
        if(visit(ifElseNode.condition).strip().equals("bool")) {
            if(ifElseNode.ElseIf != null)
                visit(ifElseNode.ElseIf);
        } else {
            helper.AddError(ifElseNode, "condition must be of type bool");
        }
        return null;
    }

    @Override
    public String visitElseIfNode(ElseIfNode elseIfNode) {
        if(visit(elseIfNode.condition).strip().equals("bool")) {
            if(elseIfNode.ElseIf != null)
                visit(elseIfNode.ElseIf);
        } else {
            helper.AddError(elseIfNode, "condition must be of type bool");
        }
        return null;
    }

    @Override
    public String visitSwitchNode(SwitchNode switchNode) {
        for(Node switchCase : switchNode.Body.GetChildren()) {
            if(!visit(switchNode.switchValue).strip().equals(visit(switchCase))) {
                helper.AddError(switchCase, "case must be of type " + visit(switchNode.switchValue).strip());
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
            helper.AddError(whileLoopNode, "while loop condition must be of type bool");
        }
        visitChildren(whileLoopNode);
        return null;
    }

    @Override
    public String visitAssignmentNode(AssignmentNode assignmentNode) {
        if(visit(assignmentNode.Identifier).equals(typeError)) {
            helper.AddError(assignmentNode,assignmentNode.Identifier.Name + " has never been declared");
        } else if(!visit(assignmentNode.Identifier).strip().equals(visit(assignmentNode.ValueNode))) {
            helper.AddError(assignmentNode, assignmentNode.Identifier.Name + " must be of type " + visit(assignmentNode.Identifier));
        }
        return null;
    }

    @Override
    public String visitArrayExprNode(ArrayExprNode arrayExprNode) {
        if(!visit(arrayExprNode.Left).strip().equals(visit(arrayExprNode.Index).strip())) {
            helper.AddError(arrayExprNode, "index must be of type " + visit(arrayExprNode.Left).strip());
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

        SymbolTable table = helper.FindTableByName(GlobalSymbolTable, functionCallNode.Identifier.Name, 0);
        if(table == null) {
            table = helper.FindTableByName(GlobalSymbolTable, functionCallNode.Identifier.Name.split("\\.")[1], 0);
            funcName = functionCallNode.Identifier.Name.split("\\.")[1];
        }

        if(table != null) {
            ArrayList<Symbol> formParams = helper.MapToList(table.Symbols);
            Symbol var = helper.GetSymbolByScopeName(functionCallNode.Identifier.Name.split("\\.")[0], scopeName);

            String paramError = CheckParameters(formParams.iterator(), functionCallNode.Parameters, var);
            if(paramError != null)
                helper.AddError(functionCallNode, paramError);

        } else {
            helper.AddError(functionCallNode, functionCallNode.Identifier.Name + " has never been declared");
            return "error";
        }
        return visit(functionCallNode.Identifier);
    }

    @Override
    public String visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        if(!IsAbstractType(constructorCallNode.Type.Name)) {
            SymbolTable table = helper.FindTableByName(GlobalSymbolTable, constructorCallNode.Type.Name, 0);

            if(table != null) {
                ArrayList<Symbol> formalParams = helper.MapToList(table.Symbols);
                Symbol var  = helper.GetSymbolByScopeName(constructorCallNode.Type.Name, scopeName);

                String paramError = CheckParameters(formalParams.iterator(), constructorCallNode.Parameters, var);
                if(paramError != null)
                    helper.AddError(constructorCallNode, paramError);

                return table.Type;
            } else {
                helper.AddError(constructorCallNode, constructorCallNode.Type.Name + " has never been declared");
            }
        } else {
            helper.AddError(constructorCallNode, "cannot create instance of abstract class " + constructorCallNode.Type.Name);
        }

        return typeError;
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
        Symbol var = helper.GetSymbolByScopeName(identifierNode.Name, scopeName);
        SymbolTable table = helper.FindTableByName(GlobalSymbolTable, identifierNode.Name, 0);
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

    private String CheckParameters(Iterator<Symbol> formalParameters, ArrayList<ParamNode> parameters, Symbol var) {
        for(ParamNode param : parameters) {
            if(!formalParameters.hasNext()) {
                return "too many arguments";
            }
            while (formalParameters.hasNext()) {
                Symbol formalParam = formalParameters.next();

                if(formalParam.Identifier.equals("constructor"))
                    continue;

                if(formalParam.Type.equals("Generic") && !var.Type.equals(visit(param))) {
                    return param.Identifier.Name + " must be of type " + var.Type;
                } else if (!formalParam.Type.equals("Generic") && !formalParam.Type.equals(visit(param))) {
                    return param.Identifier.Name + " must be of type " + formalParam.Type;
                }
                break;
            }
        }

        while (formalParameters.hasNext() && !formalParameters.next().Identifier.equals("constructor")) {
            return "too few arguments";
        }

        return null;
    }

    public String GetInheritance(String type) {
        SymbolTable table = helper.FindTableByName(GlobalSymbolTable, type, 0);
        if(table != null)
            return table.Type;
        else
            return null;
    }
}
