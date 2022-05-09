package Testing;


import ASTNodes.*;
import ASTNodes.ControlStructures.*;
import ASTNodes.DclNodes.ConstructorDclNode;
import ASTNodes.DclNodes.ListDclNode;
import ASTNodes.DclNodes.ObjDclNode;
import ASTNodes.ExprNodes.ExpressionNode;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.StringNode;
import Main.ErrorHandler;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.SymbolTable;
import Visitors.TypeChecker;
import org.junit.jupiter.api.*;
import SymbolTable.Symbol;


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

        globalSymbolTable.Children.add(environment);

        tc = new TypeChecker(new ErrorHandler(), globalSymbolTable);

        boolNode = new BoolNode();
        numberNode = new NumberNode();
    }

    @Test
    @DisplayName("List type check")
    void testListCheck() {
        ListDclNode listDclMock = new ListDclNode();
        ParamNode param = new ParamNode();
        param.Identifier = new NumberNode();
        param.Identifier.Name = "number";
        listDclMock.Parameters.add(param);
        listDclMock.Parameters.add(param);
        listDclMock.Parameters.add(param);

        listDclMock.Type = new TypeNode();
        listDclMock.Type.Name = "string";

        assertEquals("Test1Success", tc.visitListNode(listDclMock));
    }

    @Test
    @DisplayName("List type check 2")
    void testListCheck2() {
        ListDclNode listDclMock = new ListDclNode();
        ParamNode param = new ParamNode();
        param.Identifier = new NumberNode();
        param.Identifier.Name = "number";
        listDclMock.Parameters.add(param);
        listDclMock.Parameters.add(param);
        listDclMock.Parameters.add(param);

        listDclMock.Type = new TypeNode();
        listDclMock.Type.Name = "number";

        assertEquals("Test2Success", tc.visitListNode(listDclMock));
    }

    @Test
    @DisplayName("Constructor type check")
    void testConstructorCheck() {
        ConstructorDclNode constructorMock = new ConstructorDclNode();

        tc.Level = 1;
        SymbolTable table = new SymbolTable("tablename", 1);
        table.Name = "tablename";
        globalSymbolTable.Children.add(table);

        constructorMock.Type = new TypeNode();
        constructorMock.Type.Name = "tablename";

        assertEquals("Test1Success", tc.visitConstructorNode(constructorMock));
    }

    @Test
    @DisplayName("Constructor type check 2")
    void testConstructorCheck2() {
        ConstructorDclNode constructorMock = new ConstructorDclNode();
        tc.Level = 2;
        constructorMock.Type = new TypeNode();
        assertEquals("Test2Success", tc.visitConstructorNode(constructorMock));
    }

    @Test
    @DisplayName("Object dcl type check")
    void testObjectDclCheck() {
        ObjDclNode objDclMock = new ObjDclNode();
        objDclMock.ObjValue = new NumberNode();
        objDclMock.Type = new TypeNode();
        objDclMock.Identifier = new IdentifierNode(); // Prevents crash
        objDclMock.Type.Name = "string";

        assertEquals("Test1Success", tc.visitObjDcl(objDclMock));
    }

    @Test
    @DisplayName("Object dcl type check 2")
    void testObjectDclCheck2() {
        ObjDclNode objDclMock = new ObjDclNode();
        objDclMock.ObjValue = new NumberNode();
        objDclMock.Type = new TypeNode();
        objDclMock.Identifier = new IdentifierNode(); // Prevents crash if test fails
        objDclMock.Type.Name = "number";

        assertEquals("Test2Success", tc.visitObjDcl(objDclMock));
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

        elseIfMock.ElseIf = new ElseIfNode();
        elseIfMock.ElseIf.condition = boolNode;

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
        // Insert variable into symbol table
        Symbol sym = new Symbol("n", "string");
        globalSymbolTable.Children.get(0).Symbols.put("n", sym);
        tc.Level = 1;

        // Create mock object of assignmentNode
        AssignmentNode assignmentMock = new AssignmentNode();
        assignmentMock.Identifier = new IdentifierNode();
        assignmentMock.Identifier.Name = "n";
        assignmentMock.ValueNode = new NumberNode();

        assertEquals("Test1Success", tc.visitAssignmentNode(assignmentMock));
    }

    @Test
    @DisplayName("Assignment test 2")
    void testAssignment2() {
        // Insert variable into symbol table
        Symbol sym = new Symbol("n", "number");
        globalSymbolTable.Children.get(0).Symbols.put("n", sym);
        tc.Level = 1;

        // Create mock object of assignmentNode
        AssignmentNode assignmentMock = new AssignmentNode();
        assignmentMock.Identifier = new IdentifierNode();
        assignmentMock.Identifier.Name = "n";
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

