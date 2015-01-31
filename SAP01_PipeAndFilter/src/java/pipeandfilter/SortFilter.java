package pipeandfilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SortFilter extends Filter {
    public SortFilter(Pipe inPipe, Pipe outPipe){
        super(inPipe, outPipe);
    }
    
    @Override
    public void run(){
        boolean running = true;
        String data;
        List values = new ArrayList<String>();
        
        
        while(running){
                data = this.inPipe.PullData();
                
                if(data.equals("#DONE")){
                    running = false;

                    Collections.sort(values);
                    
                    values.add("#DONE");
                    
                    Iterator iterator = values.iterator();
                    while(iterator.hasNext()){
                        String element = (String) iterator.next();
                        this.outPipe.PushData(element);
                    }

                    break;
                }

            values.add(data);
        }
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
