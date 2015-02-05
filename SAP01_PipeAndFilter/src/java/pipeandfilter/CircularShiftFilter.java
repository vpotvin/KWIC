package pipeandfilter;


public class CircularShiftFilter extends Filter{
    
   public CircularShiftFilter(Pipe inPipe, Pipe outPipe){
        super(inPipe, outPipe);
    }
    
   
   // Meant to run in a seperate thread
    @Override
    public void run(){
        
        while(true){
            String input = inPipe.PullData();
            if(input.equals("#DONE")){
                this.outPipe.PushData(input);
                break;
            }
            String output = "";
            String lastWord = "";
            String firstWords;
            // Test if line only has one word; 
            if(!(input.indexOf(" ") == -1)){
                
                // remove white space so circular shift doen't match an empty 
                // first word to last word
                input = input.trim();
                
                // Get the first word of the line so you can test with the 
                // shift has made all posible line
                String begin = input.substring(0,input.indexOf(" "));
                
                // Shift and create new string until all strings have been 
                // created
                while(!lastWord.equals(begin)){
                                       
                    firstWords = input.substring(0, input.lastIndexOf(" "));
                    lastWord = input.substring(input.lastIndexOf(" ") + 1);
                    output = lastWord + " " + firstWords;
                    input = output;
                    // Push new string into output pipe
                    this.outPipe.PushData(input);
                }
            } else{
                // push single word string into pipe
                this.outPipe.PushData(input);
            }        
        }
        
        

    }
    
}
