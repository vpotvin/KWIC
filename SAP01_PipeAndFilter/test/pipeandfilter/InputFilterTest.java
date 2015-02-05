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
public class InputFilterTest {
    
    public InputFilterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of run method, of class InputFilter.
     */
    @Test
    public void testRun() {
        System.out.println("run InputFilterTest");
        Pipe outPipe = new Pipe();
        
        String testString = "This is Test One\nAnd Another\nThird Try\nForth";
        
        InputFilter instance = new InputFilter(outPipe,testString);
        instance.run();
        
        assertTrue(outPipe.PullData().equals("This is Test One"));
        assertTrue(outPipe.PullData().equals("And Another"));
        assertTrue(outPipe.PullData().equals("Third Try"));
        assertTrue(outPipe.PullData().equals("Forth"));
        
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
