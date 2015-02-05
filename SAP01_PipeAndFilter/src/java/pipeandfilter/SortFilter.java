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
        String data;
        // container for recieved strings 
        List values = new ArrayList<String>();
        
        
        while(true){
                data = this.inPipe.PullData();
                
                // when terminating string is found sort the array and 
                // push the values to the output pipe
                if(data.equals("#DONE")){

                    Collections.sort(values);
                    
                    // add the terminating string to the end of the array
                    // so that the next filter will know when to end it's 
                    // execution. 
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
    }
}
