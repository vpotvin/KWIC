package SharedData;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

// Nameed Bean the takes input the input from the form starts connects all the 
// Filter to their respective pipes and starts the process. 

@Named
@RequestScoped
public class Kwic{
    private String input;
    private String output;
    private LineStorage ls;
    private ShiftIndex si;
    private Input inputF;
    private Tree sorted;
    
    @PostConstruct
    private void init(){
        ls = new LineStorage();
        si = new ShiftIndex();
        sorted = new Tree(si, ls);
    }
    
    
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        Input.processInput(input, ls);
        CircularShift.shiftLines(ls, si);
        Sort.sort(si, sorted);
        sorted.printTree();
        
        this.input = input;
        
        //this.output = si.buildString(ls);
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    

    
    
}
