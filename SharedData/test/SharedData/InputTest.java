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
public class InputTest {
    
    public InputTest() {
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

    @Test
    public void testProcessInput() {
        
        LineStorage ls = new LineStorage();
        Input i = new Input("I am input", ls);
        System.out.println("The value is: " + ls.getLine(0).toString());
        
        assertTrue(ls.getLine(0).toString().equals("I am input "));
        assertEquals(1, ls.size());
        
    }
    
}
