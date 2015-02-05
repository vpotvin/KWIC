/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeandfilter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lynnbarnett
 */
public class CircularShiftFilterTest {
    
    public CircularShiftFilterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of run method, of class CircularShiftFilter.
     */
    @Test
    public void testRun() {
        System.out.println("Circular Shfit Run");
        Pipe inPipe = new Pipe();
        Pipe outPipe = new Pipe();
        
        CircularShiftFilter instance = new CircularShiftFilter(inPipe, outPipe);
        
        inPipe.PushData("Test One");
        inPipe.PushData("Test Two");
        inPipe.PushData("test three");
        inPipe.PushData("#DONE");
        
        instance.run();
        assertTrue(outPipe.PullData().equals("One Test"));
        assertTrue(outPipe.PullData().equals("Test One"));
        
        assertTrue(outPipe.PullData().equals("Two Test"));
        assertTrue(outPipe.PullData().equals("Test Two"));
        
        assertTrue(outPipe.PullData().equals("three test"));
        assertTrue(outPipe.PullData().equals("test three"));
        
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
