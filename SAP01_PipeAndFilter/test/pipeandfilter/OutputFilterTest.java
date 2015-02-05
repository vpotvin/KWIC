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
public class OutputFilterTest {
    
    public OutputFilterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of run method, of class OutputFilter.
     */
    @Test
    public void testRun() {
        System.out.println("run Output Filter Test");
        Pipe inPipe = new Pipe();
        
        inPipe.PushData("TEST ONE");
        inPipe.PushData("TEST TWO");
        inPipe.PushData("#DONE");
        
        OutputFilter instance = new OutputFilter(inPipe);
        instance.run();
        
        assertTrue(instance.getOutput().equals("TEST ONE\nTEST TWO\n") );
    }

    /**
     * Test of getOutput method, of class OutputFilter.
     */

    @Test
    public void testGetOutput() {
//        System.out.println("getOutput");
//        OutputFilter instance = null;
//        String expResult = "";
//        String result = instance.getOutput();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
    }
    
}
