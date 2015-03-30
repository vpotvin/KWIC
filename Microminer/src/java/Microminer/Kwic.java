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

    
    @Inject   
    private Input in;
    
    @Inject   
    private CircularShift cs;
    


    
    
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

        in.processInput(this.input);

        cs.shiftLines();
//
//        this.output = Output.CreateOuput(indexHolder);

//        System.out.println(this.output);
    }
    

    
    
}

