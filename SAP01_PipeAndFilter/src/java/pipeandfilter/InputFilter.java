package pipeandfilter;


public class InputFilter extends Filter {
        
    private String input;
    
    // calls super class constructor with null input pipe, becuase input will
    // come from a string. 
    public InputFilter(Pipe outPipe, String input){
        super(null, outPipe);
        this.input = input;
        processInput();
    }
   
    // Splits input string based on new lines
    private void processInput(){
        String[] lines = input.split("\\r?\\n");
        for(String l: lines){
            this.outPipe.PushData(l);
        }
        this.outPipe.PushData("#DONE");
    }
    
    @Override
    public void run(){}
}
