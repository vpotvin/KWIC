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
    private Input inputF;
    
    @PostConstruct
    private void init(){
        ls = new LineStorage();
    }
    
    
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        inputF = new Input(input, ls);
        
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
    private void printLS(){
        for(int i = 0; i < ls.size(); i++){
            Line tempLine = ls.getLine(i);
            String builder = "";
            for(int j = 0; j < tempLine.size(); j++){
                builder += tempLine.getWord(j) + " ";
            }
            System.out.println(builder);
            
        }
    }
    
    
}
