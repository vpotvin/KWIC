package Microminer;

import java.util.ArrayList;
import java.util.List;

public class LineStorage {
    private List<Line> lines;
    private int linesNum;
    
    public LineStorage(){
        lines = new ArrayList<>();
        linesNum = 0;
    }
    
    
    public void setWord(int line, int wordNum, String word){
        if(line >= lines.size()){
            Line newLine = new Line();
            newLine.setWord(wordNum, word);
            lines.add(newLine);
            linesNum++;
        } else {
            Line l = lines.get(line);
            l.setWord(wordNum, word);
            lines.set(line, l);
        }
        
    }
    
    public String getWord(int line, int word){
        return lines.get(line).getWord(word);
    }
    
    public int size(){
        return this.linesNum;
    }
    
    public Line getLine(int i){
        return lines.get(i);
    }
    
    public void add(Line l) {
       lines.add(l);
       linesNum++;
    }
    
    public int lineSize(int i){
        return lines.get(i).size();
    }
}
