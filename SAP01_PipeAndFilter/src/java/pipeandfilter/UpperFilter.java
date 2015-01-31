package pipeandfilter;

public class UpperFilter extends Filter{
    
     public UpperFilter(Pipe inPipe){
        super(inPipe, null);
    }
    
    @Override
    public void run(){
        
        boolean running = true;
        
        try{
            while(running){
                String preText = inPipe.PullData();
                
                if(preText.equals("#DONE")){
                    running = false;
                }
                
                System.out.println("FROM UPPER FILTER: " + preText.toUpperCase());
                Thread.sleep(500);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
