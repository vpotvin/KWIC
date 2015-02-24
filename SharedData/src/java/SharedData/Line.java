package SharedData;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<String> l;
    private int wordCount;
   
    public Line(){
        l = new ArrayList<>();
        wordCount = 0;
    }
    
    public void setWord(int pos, String word){
        l.add(word);
        wordCount++;
    }
    
    public int size(){
        return this.wordCount;
    }
    
    public String getWord(int i){
        return l.get(i);
    }
}
