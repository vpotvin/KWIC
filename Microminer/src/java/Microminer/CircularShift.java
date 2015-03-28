package Microminer;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;




public class CircularShift {
    private static final String noiseWords[] = {"a", "an", "the", "and", "or", 
        "of", "to", "be", "is", "in", "out", "by", "as", "at", "off"};
    
    
    public static void shiftLines(LineStorage ls, Tree indexHolder){
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
