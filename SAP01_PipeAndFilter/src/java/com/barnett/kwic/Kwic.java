package com.barnett.kwic;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Kwic{
    private String input;
    private String output;
    
    public String startFilter(){
        
        pipeandfilter.Pipe p1 = new pipeandfilter.Pipe();
        pipeandfilter.Pipe p2 = new pipeandfilter.Pipe();
        pipeandfilter.Pipe p3 = new pipeandfilter.Pipe();
        
        pipeandfilter.Filter f1 = new pipeandfilter.InputFilter(p1, this.input);
        pipeandfilter.Filter f2 = new pipeandfilter.CircularShiftFilter(p1, p2);
        pipeandfilter.Filter f3 = new pipeandfilter.SortFilter(p2, p3);
        pipeandfilter.Filter f4 = new pipeandfilter.OutputFilter(p3);
        
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread(f3);
        Thread t4 = new Thread(f4);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        while(t4.isAlive());
        
        pipeandfilter.OutputFilter f5;
        if (f4 instanceof pipeandfilter.OutputFilter) {
            f5 = (pipeandfilter.OutputFilter) f4;
        }else{
            f5 = null;
        }
        
        
        String test = f5.getOutput();
        
     
        
        System.out.println(test);
        
        this.output = test;
        
        return "index";
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
