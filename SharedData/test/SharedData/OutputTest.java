/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharedData;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victoria
 */
public class OutputTest {
    
    public OutputTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of CreateOuput method, of class Output.
     */
    @Test
    public void testCreateOuput() {
        System.out.println("CreateOuput");
        LineStorage ls = new LineStorage();
        Input.processInput("aa Aa AA aA", ls);
        Tree indexHolder = new Tree(ls);
        String expResult = "aa Aa AA aA";
        String result = Output.CreateOuput(indexHolder);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }
    
}
