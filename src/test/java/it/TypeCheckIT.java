package it;

import ASTNodes.ValueNodes.BoolNode;
import ASTNodes.ValueNodes.NumberNode;
import Main.ErrorHandler;
import SymbolTable.GlobalSymbolTable;
import SymbolTable.SymbolTable;
import Visitors.TypeChecker;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface IntegrationTest{}

@Category(IntegrationTest.class)
public class TypeCheckIT {

    GlobalSymbolTable globalSymbolTable;
    TypeChecker tc;
    BoolNode boolNode;
    NumberNode numberNode;

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
    @DisplayName("Object IT")
    public void objectCheck(){

        
        assertEquals("Test1Success", "Test1Success");
    }




}
