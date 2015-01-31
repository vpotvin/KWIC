package pipeandfilter;


public class InputFilter extends Filter {
        
    private String input;
    
    public InputFilter(Pipe outPipe, String input){
        super(null, outPipe);
        this.input = input;
        processInput();
    }
    
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
