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
public class CircularShiftTest {
    
    public CircularShiftTest() {
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
     * Test of shiftLines method, of class CircularShift.
     */
    @Test
    public void testShiftLines() {
        System.out.println("shiftLines");
        LineStorage ls = new LineStorage();
        Tree indexHolder = new Tree(ls);
        Input.processInput("I am a line.", ls);
        CircularShift.shiftLines(ls, indexHolder);
        assertEquals(3, ls.size());
    }
    
}
