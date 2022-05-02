package Testing;


import ASTNodes.DclNodes.ListDclNode;
import ASTNodes.DclNodes.ObjDclNode;
import ASTNodes.IdentifierNode;
import ASTNodes.Node;
import ASTNodes.ParamNode;
import ASTNodes.TypeNode;
import ASTVisitors.IBaseVisitor;
import Main.ErrorHandler;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.SymbolTable;
import Visitors.TypeChecker;
import org.junit.jupiter.api.*;
import SymbolTable.Symbol;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeCheckTest {
    GlobalSymbolTable globalSymbolTable;
    TypeChecker tc;

    IdentifierNode numberIdentifierNode;
    IdentifierNode stringIdentifierNode;

    TypeNode type;

    ParamNode paramMock1;
    ParamNode paramMock2;

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

    }

    @Test
    @DisplayName("Proper symbol should be returned")
    void testGetSymbol() {

    }

    @Test
    @DisplayName("List type check")
    void testListCheck() {
        ArrayList<ParamNode> testParams = new ArrayList<>();
        paramMock1.Identifier.Name = "number";
        paramMock2.Identifier.Name = "number";
        paramMock1.Type.Name = "number";
        paramMock2.Type.Name = "number";
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
}
