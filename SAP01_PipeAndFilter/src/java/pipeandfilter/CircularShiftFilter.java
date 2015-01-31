package pipeandfilter;


public class CircularShiftFilter extends Filter{
    
   public CircularShiftFilter(Pipe inPipe, Pipe outPipe){
        super(inPipe, outPipe);
    }
    
    @Override
    public void run(){
        boolean running = true;
        
        while(running){
            String input = inPipe.PullData();
            if(input.equals("#DONE")){
                this.outPipe.PushData(input);
                running = false;
                break;
            }
            String output = "";
            String lastWord = "";
            String firstWords;
            if(!(input.indexOf(" ") == -1)){
                
                String begin = input.substring(0,input.indexOf(" "));
                
                while(!lastWord.equals(begin)){
                                       
                    firstWords = input.substring(0, input.lastIndexOf(" "));
                    lastWord = input.substring(input.lastIndexOf(" ") + 1);
                    output = lastWord + " " + firstWords;
                    input = output;
                    this.outPipe.PushData(input);
                }
            } else{
                this.outPipe.PushData(input);
            }
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
        
        

    }
    
}
