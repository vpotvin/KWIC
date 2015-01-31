package pipeandfilter;

public abstract class Filter implements Runnable {
    Pipe inPipe;
    Pipe outPipe;
    
    public Filter(Pipe inPipe, Pipe outPipe){
        this.inPipe     = inPipe;
        this.outPipe    = outPipe;
    }
    
    public abstract void run();
    
}
