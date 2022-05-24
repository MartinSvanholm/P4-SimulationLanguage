package Testing;


import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.*;
import ASTNodes.ExprNodes.ExpressionNode;
import ASTNodes.ExprNodes.LogicalNode;
import ASTNodes.ExprNodes.MathExpressionNode;
import ASTNodes.Identifier.IdentifierNode;
import ASTNodes.Identifier.SimpleIdNode;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.StringNode;
import Main.ErrorHandler;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.SymbolTable;
import VisitorHelpers.TypeCheckHelper;
import Visitors.TypeChecker;
import org.junit.jupiter.api.*;
import SymbolTable.Symbol;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeCheckTest {
    GlobalSymbolTable globalSymbolTable;
    TypeChecker tc;

    TypeNode type;

    ParamNode paramMock1;
    ParamNode paramMock2;

    ExpressionNode exprNode;
    BoolNode boolNode;
    NumberNode numberNode;

    IfElseNode ifElseMock;
    ElseIfNode elseIfMock;
    SwitchNode switchMock;

    @BeforeEach
    void setUp() {
        /* GLOBAL SYMBOL TABLE MOCK SETUP */
        globalSymbolTable = new GlobalSymbolTable(
                "Global Symbol Table",
                0,
                new ErrorHandler()
        );
        SymbolTable environment = new SymbolTable("Environment", 1);
        environment.Type = "Simulation";

        globalSymbolTable.Children.add(environment);
        Symbol sym = new Symbol("n", "number");
        globalSymbolTable.Children.get(0).Symbols.put("n", sym);

        tc = new TypeChecker(new ErrorHandler(), globalSymbolTable);
        tc.helper = new TypeCheckHelper(new ErrorHandler(), globalSymbolTable);

        boolNode = new BoolNode();
        numberNode = new NumberNode();
    }

    @Test
    @DisplayName("EndCondition type check")
    void testEndCondition() {
        EndConditionNode endCondMock = new EndConditionNode();
        ReturnNode returnNode = new ReturnNode();
        returnNode.expressionNode = new NumberNode();
        endCondMock.Body = new BodyNode();
        endCondMock.Body.Children.add(returnNode);

        tc.visitEndCondition(endCondMock);
        assertEquals("return must be of type bool", tc.helper.ErrorHandler.Errors.get(0).Message);
    }

    @Test
    @DisplayName("EndCondition type check 2")
    void testEndCondition2() {
        EndConditionNode endCondMock = new EndConditionNode();
        ReturnNode returnNode = new ReturnNode();
        returnNode.expressionNode = new BoolNode();
        endCondMock.Body = new BodyNode();
        endCondMock.Body.Children.add(returnNode);

        assertEquals(null, tc.visitEndCondition(endCondMock));
    }

    @Test
    @DisplayName("InitCondition type check 2")
    void testInitCondition() {
        InitConditionNode initCondMock = new InitConditionNode();
        initCondMock.type = new TypeNode();
        initCondMock.type.Name = "nonexistenttable";

        tc.visitInitCondition(initCondMock);
        assertEquals("nonexistenttable has not been declared", tc.helper.ErrorHandler.Errors.get(0).Message);
    }

    @Test
    @DisplayName("Function test 1")
    void testFunction() {
        FunctionDclNode funcDclMock = new FunctionDclNode();
        funcDclMock.Identifier = new SimpleIdNode();

        funcDclMock.Body = new BodyNode();
        ReturnNode returnNode = new ReturnNode();
        returnNode.Name = "number";
        returnNode.expressionNode = new NumberNode();
        funcDclMock.Body.Children.add(returnNode);
        funcDclMock.Type = new TypeNode();
        funcDclMock.Type.Name = "string";

        tc.visitFunctionNode(funcDclMock);
        assertEquals("return must be of type string", tc.helper.ErrorHandler.Errors.get(0).Message);
    }

    @Test
    @DisplayName("List type check")
    void testListCheck() {
        ListDclNode listDclMock = new ListDclNode();
        listDclMock.Type = new TypeNode();
        listDclMock.Type.Name = "List<string>";

        tc.visitListNode(listDclMock);
        assertEquals("cannot declare List of type List<string>", tc.helper.ErrorHandler.Errors.get(0).Message);
    }

    @Test
    @DisplayName("Constructor type check")
    void testConstructorCheck() {
        ConstructorDclNode constructorMock = new ConstructorDclNode();

        SymbolTable table = new SymbolTable("Vehicle", 0);
        globalSymbolTable.Children.add(table);

        tc.scopeName = "Vehicle";

        constructorMock.Type = new TypeNode();
        constructorMock.Type.Name = "Road";
        constructorMock.Body = new BodyNode();


        tc.visitConstructorNode(constructorMock);
        assertEquals("constructor must be of type Vehicle", tc.helper.ErrorHandler.Errors.get(0).Message);
    }

    @Test
    @DisplayName("Constructor type check 2")
    void testConstructorCheck2() {
        ConstructorDclNode constructorMock = new ConstructorDclNode();

        SymbolTable table = new SymbolTable("Vehicle", 0);
        globalSymbolTable.Children.add(table);

        tc.scopeName = "tablename";

        constructorMock.Type = new TypeNode();
        constructorMock.Type.Name = "Vehicle";
        constructorMock.Body = new BodyNode();


        tc.visitConstructorNode(constructorMock);
        assertEquals("Vehicle has not been declared", tc.helper.ErrorHandler.Errors.get(0).Message);
    }

    @Test
    @DisplayName("Object dcl type check")
    void testObjectDclCheck() {
        ObjDclNode objDclMock = new ObjDclNode();
        objDclMock.Identifier = new IdentifierNode() {
            @Override
            public String GetName(String obj) {
                return null;
            }

            @Override
            public ArrayList<Node> GetChildren() {
                return null;
            }
        };
        objDclMock.Identifier.Name = "identifier";
        objDclMock.ObjValue = new NumberNode();
        objDclMock.Type = new TypeNode();
        objDclMock.Type.Name = "string";

        tc.visitObjDcl(objDclMock);
        assertEquals("identifier must be of type string", tc.helper.ErrorHandler.Errors.get(0).Message);
    }

    @Test
    @DisplayName("Object dcl type check 2")
    void testObjectDclCheck2() {
        ObjDclNode objDclMock = new ObjDclNode();
        objDclMock.ObjValue = new NumberNode();
        objDclMock.Type = new TypeNode();
        objDclMock.Type.Name = "List";

        tc.visitObjDcl(objDclMock);
        assertEquals("cannot declare variable of type List", tc.helper.ErrorHandler.Errors.get(0).Message);
    }

    @Test
    @DisplayName("If/else type check 1")
    void testIfElseCheck() {
        ifElseMock = new IfElseNode();
        ifElseMock.condition = boolNode;
        ifElseMock.Body = new BodyNode();

        elseIfMock = new ElseIfNode();
        elseIfMock.condition = boolNode;
        elseIfMock.Body = new BodyNode();
        ifElseMock.ElseIf = elseIfMock;

        assertEquals(null, tc.visitIfElseNode(ifElseMock));
    }


    @Test
    @DisplayName("If/else type check 2")
    void testIfElseCheck2() {
        ifElseMock = new IfElseNode();
        ifElseMock.condition = boolNode;

    }


    @Test
    @DisplayName("ElseIf type check 1")
    void testElseIfCheck() {
        elseIfMock = new ElseIfNode();
        elseIfMock.condition = boolNode;
        elseIfMock.Body = new BodyNode();

        elseIfMock.ElseIf = new ElseIfNode();
        elseIfMock.ElseIf.condition = boolNode;
        elseIfMock.ElseIf.Body = new BodyNode();

        assertEquals(null, tc.visitElseIfNode(elseIfMock));
    }

    @Test
    @DisplayName("ElseIf type check 2")
    void testElseIfCheck2() {
        elseIfMock = new ElseIfNode();
        elseIfMock.condition = boolNode;

    }

    @Test
    @DisplayName("Switch type check")
    void testSwitchCheck() {
        switchMock = new SwitchNode();
        switchMock.Value = "number";
        switchMock.Body = new SwitchBody();
        switchMock.Body.Children.add(new NumberNode());
        switchMock.Body.Children.add(new StringNode());
        switchMock.Body.cases.add(new NumberNode());
        switchMock.Body.cases.add(new StringNode());
        switchMock.switchValue = new NumberNode();

        tc.visitSwitchNode(switchMock);
        assertEquals("case must be of type number", tc.helper.ErrorHandler.Errors.get(0).Message);
    }

    @Test
    @DisplayName("switch type check 3")
    void testSwitchCheck3() {
        switchMock = new SwitchNode();
        switchMock.Value = "number";
        switchMock.Body = new SwitchBody();
        switchMock.Body.Children.add(new NumberNode());
        switchMock.Body.Children.add(new NumberNode());
        CaseNode defaultCase = new CaseNode();
        defaultCase.Name = "default";
        switchMock.Body.Children.add((defaultCase));
        switchMock.Body.cases.add(new NumberNode());
        switchMock.Body.cases.add(new StringNode());
        switchMock.switchValue = new NumberNode();

        assertEquals(null, tc.visitSwitchNode(switchMock));
    }

    @Test
    @DisplayName("While loop type check 1")
    void testWhileLoop1() {
        WhileLoopNode whileMock = new WhileLoopNode();
        whileMock.condition = new NumberNode();
        whileMock.Body = new BodyNode();

        tc.visitWhileLoopNode(whileMock);
        assertEquals("while loop condition must be of type bool", tc.helper.ErrorHandler.Errors.get(0).Message);
    }

    @Test
    @DisplayName("Logical type check 1")
    void testLogical() {
        LogicalNode logicalMock = new LogicalNode();
        logicalMock.Left = new BoolNode();
        logicalMock.Right = new BoolNode();
        assertEquals("bool", tc.visitLogicalNode(logicalMock));
    }

    @Test
    @DisplayName("Simple Id type check")
    void testSimpleId() {
        SimpleIdNode simpleIdmock = new SimpleIdNode();
        simpleIdmock.Name = "n";
        tc.scopeName = "Environment";
        assertEquals("number", tc.visitSimpleIdNode(simpleIdmock));
    }

    @Test
    @DisplayName("Simple Id type check 2")
    void testSimpleId2() {
        SimpleIdNode simpleIdmock = new SimpleIdNode();
        simpleIdmock.Name = "function";
        tc.scopeName = "Environment";
        SymbolTable func = new SymbolTable("function", 2);
        func.Type = "function";

        globalSymbolTable.Children.get(0).Children.add(func);
        assertEquals("function", tc.visitSimpleIdNode(simpleIdmock));
    }

    @Test
    @DisplayName("Simple Id type check 3")
    void testSimpleId3() {

    }

    @Test
    @DisplayName("Logical type check 2")
    void testLogical2() {
        LogicalNode logicalMock = new LogicalNode();
        logicalMock.Left = new NumberNode();
        logicalMock.Right = new NumberNode();
        assertEquals("error", tc.visitLogicalNode(logicalMock));
    }

    @Test
    @DisplayName("Math expression type check 1")
    void testMathExpression() {
        MathExpressionNode mathExprMock = new MathExpressionNode();
        mathExprMock.Left = new NumberNode();
        mathExprMock.Right = new NumberNode();
        assertEquals("number", tc.visitMathExpressionNode(mathExprMock));
    }

    @Test
    @DisplayName("Math expression type check 2")
    void testMathExpression2() {
        MathExpressionNode mathExprMock = new MathExpressionNode();
        mathExprMock.Left = new StringNode();
        mathExprMock.Right = new StringNode();
        assertEquals("error", tc.visitMathExpressionNode(mathExprMock));
    }

    @Test
    @DisplayName("Assignment test 1")
    void testAssignment1() {
        AssignmentNode assignMock = new AssignmentNode();
        assignMock.Identifier = new SimpleIdNode();
        assignMock.Identifier.Name = "n";

        tc.scopeName = "Environment";

        assignMock.ValueNode = new StringNode();

        tc.visitAssignmentNode(assignMock);
        assertEquals("n must be of type number", tc.helper.ErrorHandler.Errors.get(0).Message);
    }
}

