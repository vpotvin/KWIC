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
public class TreeTest {
    
    public TreeTest() {
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
     * Test of insert method, of class Tree.
     */


    /**
     * Test of printTree method, of class Tree.
     */
    @Test
    public void testPrintTree() {
        System.out.println("printTree");
        LineStorage ls = new LineStorage();
        Input.processInput("a \nb \nc \nd", ls);
        Tree instance = new Tree(ls);
        String expResult = "a \nb \nc \nd";
        String result = instance.printTree().toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of compare method, of class Tree.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        String arg0 = "a";
        String arg1 = "A";
        LineStorage ls = new LineStorage();
        Tree instance = new Tree(ls);
        int result = instance.compare(arg0, arg1);
        assertTrue(result <= 0);
    }
    
}
