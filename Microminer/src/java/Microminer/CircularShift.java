package Microminer;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;



@Named(value = "cs")
@ApplicationScoped
public class CircularShift {
    
    @Inject
    private LineStorage ls;
    
    @Inject
    private Tree indexHolder;
    
    private static final String noiseWords[] = {"a", "an", "the", "and", "or", 
        "of", "to", "be", "is", "in", "out", "by", "as", "at", "off"};
    
    
    public void shiftLines(){
        for(int i=0; i < ls.size();i++){
            Line l = ls.getLine(i);

            LinkedList<Integer> tempList = new LinkedList<>();
            
            for(int j = 0; j < l.size(); j++){
                tempList.add(j);
            }
            
            for(int j=0; j < l.size(); j++){
                Collections.rotate(tempList, -1);
                
                if(!Arrays.asList(noiseWords).contains(l.getWord(tempList.get(0)))){
                    
                    int k = tempList.get(0);
                    
                    LineHolder tempHolder = new LineHolder(k, i, l.getDBID());
                    
                    indexHolder.insert(tempHolder);
                }
            }          
        }               
    }
}
