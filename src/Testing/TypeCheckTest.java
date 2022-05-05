package Testing;


import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.ListDclNode;
import ASTNodes.DclNodes.ObjDclNode;
import ASTNodes.ExprNodes.ExpressionNode;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.StringNode;
import ASTVisitors.IBaseVisitor;
import Main.ErrorHandler;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.SymbolTable;
import Visitors.TypeChecker;
import org.junit.jupiter.api.*;
import SymbolTable.Symbol;

import java.util.ArrayList;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeCheckTest {
    GlobalSymbolTable globalSymbolTable;
    TypeChecker tc;

    IdentifierNode numberIdentifierNode;
    IdentifierNode stringIdentifierNode;

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

        Symbol numberLiteral1 = new Symbol("numberLiteral1", "number", "Standard");
        Symbol numberLiteral2 = new Symbol("numberLiteral1", "number", "Standard");
        Symbol stringLiteral1 = new Symbol("stringLiteral1", "string", "Standard");
        Symbol stringLiteral2 = new Symbol("stringLiteral1", "string", "Standard");

        environment.Symbols.put("1", numberLiteral1);
        environment.Symbols.put("2", numberLiteral2);
        environment.Symbols.put("3", stringLiteral1);
        environment.Symbols.put("4", stringLiteral2);
        globalSymbolTable.Children.add(environment);

        tc = new TypeChecker(new ErrorHandler(), globalSymbolTable);
        type = new TypeNode();
        paramMock1 = new ParamNode();
        paramMock2 = new ParamNode();
        paramMock1.Type = new TypeNode();
        paramMock2.Type = new TypeNode();
        paramMock1.Identifier = new IdentifierNode();
        paramMock2.Identifier = new IdentifierNode();

        numberIdentifierNode = new IdentifierNode();
        numberIdentifierNode.Name = "customNumber";

        stringIdentifierNode = new IdentifierNode();
        stringIdentifierNode.Name = "customString";

        exprNode = new ExpressionNode() {
            @Override
            public ArrayList<Node> GetChildren() {
                return null;
            }
        };

        boolNode = new BoolNode();
        numberNode = new NumberNode();
    }

    @Test
    @DisplayName("Proper symbol should be returned")
    void testGetSymbol() {

    }

    @Test
    @DisplayName("List type check")
    void testListCheck() {
        ArrayList<ParamNode> testParams = new ArrayList<>();
        paramMock1.Identifier.Name = "1";
        paramMock2.Identifier.Name = "2";
        paramMock1.Type.Name = "number";
        paramMock2.Type.Name = "number";
        NumberNode test = new NumberNode();
        test.Name = "1";
        paramMock1.Children.add(test);
        paramMock2.Children.add(test);
        testParams.add(paramMock1);
        testParams.add(paramMock2);
        ListDclNode listDclMock = new ListDclNode();
        listDclMock.Parameters = testParams;
        TypeNode type = new TypeNode();
        type.Name = "number";
        listDclMock.Type = type;

        assertEquals(null, tc.visitListNode(listDclMock));
    }

    @Test
    @DisplayName("List type check 2")
    void testListCheck2() {
        ArrayList<ParamNode> testParams = new ArrayList<>();
        testParams.add(paramMock1);
        testParams.add(paramMock2);
        paramMock1.Type.Name = "number";
        paramMock2.Type.Name = "number";
        ListDclNode listDclMock = new ListDclNode();
        listDclMock.Parameters = testParams;
        TypeNode type = new TypeNode();
        type.Name = "string";
        listDclMock.Type = type;

        assertEquals(null, tc.visitListNode(listDclMock));
    }

    @Test
    @DisplayName("Constructor type check")
    void testConstructorCheck() {

    }

    @Test
    @DisplayName("Object dcl type check")
    void testObjectDclCheck() {
        ObjDclNode objDclMock = new ObjDclNode();
       // objDclMock.ObjValue
    }

    @Test
    @DisplayName("If/else type check 1")
    void testIfElseCheck() {
        ifElseMock = new IfElseNode();
        ifElseMock.condition = boolNode;

        elseIfMock = new ElseIfNode();
        elseIfMock.condition = boolNode;
        ifElseMock.ElseIf = elseIfMock;

        assertEquals("Test1Success", tc.visitIfElseNode(ifElseMock));
    }


    @Test
    @DisplayName("If/else type check 2")
    void testIfElseCheck2() {
        ifElseMock = new IfElseNode();
        ifElseMock.condition = boolNode;

        assertEquals("Test2Success", tc.visitIfElseNode(ifElseMock));
    }

    @Test
    @DisplayName("If/else type check 3")
    void testIfElseCheck3() {
        ifElseMock = new IfElseNode();
        ifElseMock.condition = numberNode;

        assertEquals("Test3Success", tc.visitIfElseNode(ifElseMock));
    }

    @Test
    @DisplayName("ElseIf type check 1")
    void testElseIfCheck() {
        elseIfMock = new ElseIfNode();
        elseIfMock.condition = boolNode;

        elseIfMock = new ElseIfNode();
        elseIfMock.condition = boolNode;
        ifElseMock.ElseIf = elseIfMock;

        assertEquals("Test1Success", tc.visitElseIfNode(elseIfMock));
    }

    @Test
    @DisplayName("ElseIf type check 2")
    void testElseIfCheck2() {
        elseIfMock = new ElseIfNode();
        elseIfMock.condition = boolNode;

        assertEquals("Test2Success", tc.visitElseIfNode(elseIfMock));
    }

    @Test
    @DisplayName("ElseIf type check 3")
    void testElseIfCheck3() {
        elseIfMock = new ElseIfNode();
        elseIfMock.condition = numberNode;

        assertEquals("Test3Success", tc.visitElseIfNode(elseIfMock));
    }

    @Test
    @DisplayName("Switch type check 1")
    void testSwitchCheck() {
        switchMock = new SwitchNode();
        switchMock.Body = new SwitchBody();
        switchMock.Body.cases.add(new NumberNode());
        switchMock.Body.cases.add(new NumberNode());
        switchMock.switchValue = new StringNode();

        assertEquals("Test1Success", tc.visitSwitchNode(switchMock));
    }

    @Test
    @DisplayName("Switch type check 2")
    void testSwitchCheck2() {
        switchMock = new SwitchNode();
        switchMock.Body = new SwitchBody();
        switchMock.Body.cases.add(new NumberNode());
        switchMock.Body.cases.add(new NumberNode());
        switchMock.switchValue = new NumberNode();

        assertEquals("Test2Success", tc.visitSwitchNode(switchMock));
    }

    @Test
    @DisplayName("While loop type check 1")
    void testWhileLoop1() {
        WhileLoopNode whileMock = new WhileLoopNode();
        whileMock.condition = new NumberNode();

        assertEquals("Test1Success", tc.visitWhileLoopNode(whileMock));
    }

    @Test
    @DisplayName("While loop type check 2")
    void testWhileLoop2() {
        WhileLoopNode whileMock = new WhileLoopNode();
        whileMock.condition = new BoolNode();

        // To avoid exception on visitChildren(whileLoopNode) call
        whileMock.Body = new BodyNode();

        assertEquals("Test2Success", tc.visitWhileLoopNode(whileMock));
    }

    @Test
    @DisplayName("Assignment test 1")
    void testAssignment1() {
        AssignmentNode assignmentMock = new AssignmentNode();

        assignmentMock.Identifier = new IdentifierNode();
        assignmentMock.Identifier.Name = "n";
        globalSymbolTable.Symbols.put("5", new Symbol("n", "number", "t"));
        assignmentMock.ValueNode = new NumberNode();

        assertEquals("Test1Success", tc.visitAssignmentNode(assignmentMock));
    }

    @Test
    @DisplayName("Assignment test 2")
    void testAssignment2() {
        AssignmentNode assignmentMock = new AssignmentNode();

        assignmentMock.Identifier = new IdentifierNode();
        assignmentMock.Identifier.Name = "n";

        globalSymbolTable.Symbols.put("5", new Symbol("n", "number", "t"));
        assignmentMock.ValueNode = new NumberNode();

        assertEquals("Test2Success", tc.visitAssignmentNode(assignmentMock));
    }

    @Test
    @DisplayName("Identifier test 1")
    void testIdentifier() {
        IdentifierNode identifierMock = new IdentifierNode();

        Symbol sym = new Symbol("i", "number");
        globalSymbolTable.Children.get(0).Symbols.put("i", sym);
        tc.Level = 1;
        identifierMock.Name = "i";

        assertEquals("number", tc.visitIdentifierNode(identifierMock));
    }

    @Test
    @DisplayName("Identifier test 2")
    void testIdentifier2() {
        IdentifierNode identifierMock = new IdentifierNode();

        identifierMock.Name = "Environment";

        assertEquals("Simulation", tc.visitIdentifierNode(identifierMock));
    }

    @Test
    @DisplayName("Identifier test 3")
    void testIdentifier3() {
        IdentifierNode identifierMock = new IdentifierNode();

        assertEquals("TestErrorSuccess", tc.visitIdentifierNode(identifierMock));
    }


}

