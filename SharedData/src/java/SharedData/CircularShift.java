package SharedData;

import java.util.ArrayList;
import java.util.List;



public class CircularShift {
    private static final String noiseWords[] = {"a", "an", "the", "and", "or", 
        "of", "to", "be", "is", "in", "out", "by", "as", "at", "off"};
    
    
    public static void shiftLines(LineStorage ls){
        int shifts = ls.size();
        for(int i=0; i < shifts;i++){
            Line l = new Line(ls.getLine(i));
            for(int j = 0; j < ls.getLine(i).size(); j++) {
                String word = l.getWord(0);
                boolean shiftCreatesNoise = false;
                for(String s: noiseWords) 
                    if(l.getWord(1).toLowerCase().equals(s)) 
                        shiftCreatesNoise = true;
                l.remove(0);
                l.add(word);
                Line l2 = new Line(l);
                if(!shiftCreatesNoise) ls.add(l);
            }
        }
    }
}
