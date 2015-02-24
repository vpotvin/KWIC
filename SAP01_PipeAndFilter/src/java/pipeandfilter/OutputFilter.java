package pipeandfilter;

public class OutputFilter  extends Filter{
    
    private String output;
    
    
    // Calls superclass constuctor with null as the output pipe because
    // Output prints to the command line
    public OutputFilter(Pipe inPipe){
        super(inPipe, null);
        this.output = "";
    }
    
    
    // get values from the input pipe until the terminating string is found, 
    // and prints them to the command line 
    @Override
    public void run(){
        while(true){
            String value = this.inPipe.PullData();
            if(value.equals("#DONE")){
                break;
            } else{
                output += value + "\n";
            }
        }
        
    }
    
    public String getOutput(){
        return this.output;
    }
}
