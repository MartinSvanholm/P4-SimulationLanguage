package Visitors;

import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.*;
import ASTNodes.Identifier.IdentifierNode;
import ASTNodes.Identifier.ObjIdNode;
import ASTNodes.Identifier.SimpleIdNode;
import ASTNodes.Identifier.ThisIdNode;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.OpNode;
import ASTNodes.ValueNodes.StringNode;
import ASTVisitors.BaseVisitor;
import VisitorHelpers.TypeCheckHelper;
import Main.ErrorHandler;
import SymbolTable.*;

import java.util.ArrayList;
import java.util.Iterator;

public class TypeChecker extends BaseVisitor<String> {
    private final GlobalSymbolTable GlobalSymbolTable;
    String scopeName = "Global";
    String prevScopeName;
    String typeError = "error";
    int CheckForPredifinedValues = 1;
    private final TypeCheckHelper helper;

    public TypeChecker(ErrorHandler errorHandler, GlobalSymbolTable globalSymbolTable) {
        GlobalSymbolTable = globalSymbolTable;
        helper = new TypeCheckHelper(errorHandler, GlobalSymbolTable);
    }

    public void CheckTypes(Node ast) {
        visit(ast);
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
            visit(initConditionNode.Body);
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
        visit(constructorDclNode.Body);
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
            visit(ifElseNode.Body);
            if(ifElseNode.ElseIf != null)
                visit(ifElseNode.ElseIf);
        } else {
            helper.AddError(ifElseNode, "condition must be of type bool");
        }
        return null;
    }

    @Override
    public String visitElseIfNode(ElseIfNode elseIfNode) {
        if(elseIfNode.condition != null) {
            if(visit(elseIfNode.condition).strip().equals("bool")) {
                visit(elseIfNode.Body);
                if(elseIfNode.ElseIf != null)
                    visit(elseIfNode.ElseIf);
            } else {
                helper.AddError(elseIfNode, "condition must be of type bool");
            }
        }
        return null;
    }

    @Override
    public String visitSwitchNode(SwitchNode switchNode) {
        if(visit(switchNode.switchValue).equals(typeError)) {
            helper.AddError(switchNode, "switch value has never been declared");
            return null;
        }

        for(Node switchCase : switchNode.Body.GetChildren()) {
            if(switchCase.Name.equals("default")) {
                visit(switchCase);
                continue;
            }

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
        visit(caseNode.CaseBody);
        return visit(caseNode.switchValue);
    }

    @Override
    public String visitForLoopNode(ForLoopNode forLoopNode) {
        visit(forLoopNode.Body);
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
        String error = visit(assignmentNode.Identifier);
        if(error.equals(typeError)) {
            helper.AddError(assignmentNode,assignmentNode.Identifier.GetName("") + " has never been declared");
        } else if(error.equals(typeError+"obj")) {
            helper.AddError(assignmentNode,assignmentNode.Identifier.GetName("obj") + " has never been declared");
        } else if(!visit(assignmentNode.Identifier).strip().equals(visit(assignmentNode.ValueNode))) {
            helper.AddError(assignmentNode, assignmentNode.Identifier.Name + " must be of type " + visit(assignmentNode.Identifier));
        }
        return null;
    }

    @Override
    public String visitArrayExprNode(ArrayExprNode arrayExprNode) {
        if(!visit(arrayExprNode.Index).equals("number")) {
            helper.AddError(arrayExprNode, "index must be of type number");
        }
        return visit(arrayExprNode.Left);
    }

    @Override
    public String visitCompareNode(CompareNode compareNode) {
        if(visit(compareNode.Left).equals(visit(compareNode.Right)))
            return "bool";
        else
            return "error";
    }

    @Override
    public String visitFunctionCallNode(FunctionCallNode functionCallNode) {
        String funcType = visit(functionCallNode.Identifier);
        if(!funcType.equals(typeError) && !funcType.equals(typeError+"obj")) {
            CheckFuncParameters(functionCallNode);
            return funcType;
        } else if(funcType.equals(typeError)) {
            helper.AddError(functionCallNode, functionCallNode.Identifier.GetName("") + " has never been declared");
            return funcType;
        } else {
            helper.AddError(functionCallNode, functionCallNode.Identifier.GetName("obj") + " has never been declared");
            return funcType;
        }
    }

    @Override
    public String visitConstructorCallNode(ConstructorCallNode constructorCallNode) {
        if(!IsAbstractType(constructorCallNode.Type.Name)) {
            SymbolTable table = helper.FindTableByName(GlobalSymbolTable, constructorCallNode.Type.Name, 0);

            if(table != null) {
                CheckConstructorParameters(constructorCallNode);

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
    public String visitObjIdNode(ObjIdNode objIdNode) {
        System.out.println(objIdNode.Line);
        SymbolTable classTable = null;
        Symbol property = null;

        if(objIdNode.ObjectNode.Name.equals("Simulation")) {
            classTable = helper.FindTableByName(GlobalSymbolTable, "Simulation", 0);
        } else {
            //Gets the property of the objNode, return an error if it does not exist.
            property = helper.GetSymbolByScopeName(objIdNode.ObjectNode.Name, scopeName);
            if(property == null)
                return typeError + "obj";

            //Gets the table of the property's class.
            classTable = helper.FindTableByName(GlobalSymbolTable, property.Attribute, 0);
        }

        //Checks if there is a property from the class that matches the identifier.
        ArrayList<Symbol> symbols = new ArrayList<>(classTable.Symbols.values());
        for(Symbol symbol: symbols) {
            if(symbol.Identifier.equals(objIdNode.Identifier.Name))
                return symbol.Type;
        }

        //checks if there is a function from the class that matches the identifier.
        for(SymbolTable symbolTable : classTable.Children) {
            if(symbolTable.Name.equals(objIdNode.Identifier.Name))
                return symbolTable.Type;
        }

        return typeError;
    }

    @Override
    public String visitThisIdNode(ThisIdNode thisIdNode) {
        CheckForPredifinedValues = 0;
        prevScopeName = scopeName;
        scopeName = thisIdNode.ClassName;

        String error;

        if(thisIdNode.ObjNode != null)
            error = visit(thisIdNode.ObjNode);
        else
            error = visit(thisIdNode.Identifier);

        scopeName = prevScopeName;
        CheckForPredifinedValues = 1;

        return error;
    }

    @Override
    public String visitSimpleIdNode(SimpleIdNode simpleIdNode) {
        Symbol var = helper.GetSymbolByScopeName(simpleIdNode.Name, scopeName);
        if(var != null)
            return var.Type;

        SymbolTable scope = helper.FindTableByName(GlobalSymbolTable, scopeName, CheckForPredifinedValues);
        if(scope != null) {
            SymbolTable table = helper.FindTableByName(scope, simpleIdNode.Name, CheckForPredifinedValues);
            if(table != null)
                return table.Type;
        }

        var = helper.CheckInheritance(simpleIdNode, scopeName);
        if(var != null)
            return var.Type;

        return typeError;
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

    private Boolean IsAbstractType(String type) {
        return switch (type) {
            case "Node", "Vehicle", "Road" -> true;
            default -> false;
        };
    }

    //This function checks if the parameters passed when calling the function is the same type as the formal parameters.
    private void CheckFuncParameters(FunctionCallNode node) {

        //Symbol table for the function
        SymbolTable funcTable = helper.FindTableByName(GlobalSymbolTable, node.Identifier.GetName(""), 0);

        //Iterator of the formal parameters of the function
        Iterator<Symbol> formalParams = funcTable.Symbols.values().iterator();

        for(ParamNode param : node.Parameters) {

            //Check if there are any formal parameters left, if not then there has been provided too many arguments
            if(!formalParams.hasNext())
                helper.AddError(node, "too many arguments");

            if(formalParams.hasNext()) {
                Symbol formalParam = formalParams.next();

                if(!formalParam.Type.equals("Generic") && !formalParam.Type.equals(visit(param)))
                    helper.AddError(node, param.Identifier.Name + " must be of type " + formalParam.Type);
            }
        }

        if(formalParams.hasNext() && formalParams.next().Attribute.equals("Parameter")) {
            helper.AddError(node, "too few arguments");
        }
    }

    //This function checks if the parameters passed when calling the ConstructorCall is the same type as the formal parameters.
    private void CheckConstructorParameters(ConstructorCallNode node) {
        //Symbol table for the ConstructorCall
        SymbolTable funcTable = helper.FindTableByName(GlobalSymbolTable, node.Type.Name, 0);

        //Iterator of the formal parameters of the ConstructorCall
        Iterator<Symbol> formalParams = funcTable.Symbols.values().iterator();

        for(ParamNode param : node.Parameters) {

            //Check if there are any formal parameters left, if not then there has been provided too many arguments
            if(!formalParams.hasNext())
                helper.AddError(node, "too many arguments");

            while (formalParams.hasNext()) {
                Symbol formalParam = formalParams.next();

                if(!formalParam.Attribute.equals("Parameter"))
                    continue;

                if(!formalParam.Type.equals(visit(param)))
                    helper.AddError(node, param.Identifier.Name + " must be of type " + formalParam.Type);

                break;
            }
        }

        if(formalParams.hasNext() && formalParams.next().Attribute.equals("Parameter")) {
            helper.AddError(node, "too few arguments");
        }
    }
}
