package Microminer;


import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

// Nameed Bean the takes input the input from the form starts connects all the 
// Filter to their respective pipes and starts the process. 

@Named
@RequestScoped
public class Kwic{
    private String input;
    private String output;
    private LineStorage ls;
    private Tree indexHolder;
    
    @Inject   
    private Input in;
     
    @PostConstruct
    private void init(){
        ls = new LineStorage();
        indexHolder = new Tree(ls);
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
    
    public void run() throws SQLException{

        in.processInput(this.input, ls);

        CircularShift.shiftLines(ls, indexHolder);

        this.output = Output.CreateOuput(indexHolder);

        System.out.println(this.output);
    }
    

    
    
}
