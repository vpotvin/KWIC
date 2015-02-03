package com.barnett.kwic;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

// Nameed Bean the takes input the input from the form starts connects all the 
// Filter to their respective pipes and starts the process. 

@Named
@RequestScoped
public class Kwic{
    // Attributes that hold the input and out, used by the JSF framework
    private String input;
    private String output;
    
    public String startFilter(){
        
        // Pipes the connect the filters
        pipeandfilter.Pipe p1 = new pipeandfilter.Pipe();
        pipeandfilter.Pipe p2 = new pipeandfilter.Pipe();
        pipeandfilter.Pipe p3 = new pipeandfilter.Pipe();
        
        // Takes input as string, parses out individual lines and sends the
        // lines into pipe p1
        pipeandfilter.Filter f1 = new pipeandfilter.InputFilter(p1, this.input);
        
        // Takes lines from pipe p1 and cicularly shifts them to take create new 
        //lines that are sent into pipe p2
        pipeandfilter.Filter f2 = new pipeandfilter.CircularShiftFilter(p1, p2);
        
        // Takes strings from pipe p2 and stores them until is recieves the
        // teminating string, then it sorts the lines and send them to the
        // pipe p3
        pipeandfilter.Filter f3 = new pipeandfilter.SortFilter(p2, p3);
        
        // take the output from pipe p3 and build an output strine while it 
        // has not recieved the terminating string. 
        pipeandfilter.Filter f4 = new pipeandfilter.OutputFilter(p3);
        
        //Thread t1 = new Thread(f1); // Start 
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread(f3); 
        Thread t4 = new Thread(f4);
        
        //t1.start();
        t2.start();// Start Cicular Shift Filter
        t3.start();// Start Sort Filter
        t4.start(); // Start output Filter
        
        // Spins while output is still builing up the string, once the
        // terminating string is found t4 while no long be alive, and 
        // the program will move on. 
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
