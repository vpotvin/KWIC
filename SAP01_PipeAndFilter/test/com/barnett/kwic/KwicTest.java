/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barnett.kwic;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lynnbarnett
 */
public class KwicTest {
    
    public KwicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of startFilter method, of class Kwic.
     */
    @Test
    public void testStartFilter() throws InterruptedException {
        System.out.println("MAIN TEST");

        pipeandfilter.Pipe p1 = new pipeandfilter.Pipe();
        pipeandfilter.Pipe p2 = new pipeandfilter.Pipe();
        pipeandfilter.Pipe p3 = new pipeandfilter.Pipe();
        
        
        String testInput = "A test\nB test";
        
        
        pipeandfilter.Filter f1 = new pipeandfilter.InputFilter(p1, testInput);

        pipeandfilter.Filter f2 = new pipeandfilter.CircularShiftFilter(p1, p2);
        
        pipeandfilter.Filter f3 = new pipeandfilter.SortFilter(p2, p3);
        
        pipeandfilter.Filter f4 = new pipeandfilter.OutputFilter(p3);
        
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread(f3); 
        Thread t4 = new Thread(f4);
        
        t2.start();// Start Cicular Shift Filter
        t3.start();// Start Sort Filter
        t4.start(); // Start output Filter
        
        t4.join();
        
        pipeandfilter.OutputFilter f5;
        if (f4 instanceof pipeandfilter.OutputFilter) {
            f5 = (pipeandfilter.OutputFilter) f4;
        }else{
            f5 = null;
        }
        
        System.out.println(f5.getOutput());
        assertTrue(f5.getOutput().equals("A test\nB test\ntest A\ntest B\n"));
    }

    /**
     * Test of getInput method, of class Kwic.
     */
    @Test
    public void testGetInput() {
//        System.out.println("getInput");
//        Kwic instance = new Kwic();
//        String expResult = "";
//        String result = instance.getInput();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setInput method, of class Kwic.
     */
    @Test
    public void testSetInput() {
//        System.out.println("setInput");
//        String input = "";
//        Kwic instance = new Kwic();
//        instance.setInput(input);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getOutput method, of class Kwic.
     */
    @Test
    public void testGetOutput() {
//        System.out.println("getOutput");
//        Kwic instance = new Kwic();
//        String expResult = "";
//        String result = instance.getOutput();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setOutput method, of class Kwic.
     */
    @Test
    public void testSetOutput() {
//        System.out.println("setOutput");
//        String output = "";
//        Kwic instance = new Kwic();
//        instance.setOutput(output);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
