package SharedData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



public class CircularShift {
    private static final String noiseWords[] = {"a", "an", "the", "and", "or", 
        "of", "to", "be", "is", "in", "out", "by", "as", "at", "off"};
    
    
    public static void shiftLines(LineStorage ls, ShiftIndex si){
        for(int i=0; i < ls.size();i++){
            Line l = ls.getLine(i);

            LinkedList<Integer> tempList = new LinkedList<>();
            
            for(int j = 0; j < l.size(); j++){
                tempList.add(j);
            }
            
            for(int j=0; j < l.size(); j++){
                Collections.rotate(tempList, -1);
                
                if(!Arrays.asList(noiseWords).contains(l.getWord(tempList.get(0)))){
                    
                    Integer[] t = new Integer[tempList.size()];
                    tempList.toArray(t);
                    
                    si.addLine(t, i);
                }
            }
            


            
        }

               

    }
}
