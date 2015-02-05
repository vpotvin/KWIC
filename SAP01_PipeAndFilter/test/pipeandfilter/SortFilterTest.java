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
public class SortFilterTest {
    
    public SortFilterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of run method, of class SortFilter.
     */
    @Test
    public void testRun() {
        System.out.println("run Sort Filter");
        Pipe inPipe = new Pipe();
        Pipe outPipe = new Pipe();
        
        SortFilter instance = new SortFilter(inPipe, outPipe);
        
        inPipe.PushData("Z");
        inPipe.PushData("Y");
        inPipe.PushData("C");
        inPipe.PushData("B");
        inPipe.PushData("A");
        inPipe.PushData("#DONE");
        
        
        instance.run();
        assertTrue(outPipe.PullData().equals("A"));
        assertTrue(outPipe.PullData().equals("B"));
        assertTrue(outPipe.PullData().equals("C"));
        assertTrue(outPipe.PullData().equals("Y"));       
        assertTrue(outPipe.PullData().equals("Z"));
    }
    
}
