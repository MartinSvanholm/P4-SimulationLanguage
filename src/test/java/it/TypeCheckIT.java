package it;

import ASTNodes.ControlStructures.SwitchBody;
import ASTNodes.ControlStructures.SwitchNode;
import ASTNodes.ControlStructures.WhileLoopNode;
import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import ASTNodes.ValueNodes.StringNode;
import Main.ErrorHandler;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.SymbolTable;
import Visitors.TypeChecker;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface IntegrationTest{}

@RunWith(MockitoJUnitRunner.class)
public class TypeCheckIT {

    GlobalSymbolTable globalSymbolTable;
    TypeChecker tc;
    BoolNode boolNode;
    NumberNode numberNode;
    @Mock
    WhileLoopNode whileMock;

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
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("While IT")
    public void whileCheck(){

        Mockito.when(whileMock.).thenReturn();
        Double whileLoop = this.calculateArea.calculateArea(Type.RECTANGLE, 5.0d, 4.0d);


        SwitchNode switchMock = new SwitchNode();
        switchMock.Body = new SwitchBody();
        switchMock.Body.cases.add(new NumberNode());
        switchMock.Body.cases.add(new NumberNode());
        switchMock.switchValue = new StringNode();

        assertEquals("Test1Success", tc.visitSwitchNode(switchMock));

        //assertEquals("Test1Success", "Test1Success");
    }




}
