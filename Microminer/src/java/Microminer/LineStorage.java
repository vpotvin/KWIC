package Microminer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "ls")
@ApplicationScoped
public class LineStorage implements Serializable{
    private ArrayList<Line> lines;
    private int linesNum;
    
    @PostConstruct
    public void init(){
        lines = new ArrayList<>();
        linesNum = 0;
    }
    
    
    public void setWord(int line, int wordNum, String word, long dbid){
        if(line >= lines.size()){
            Line newLine = new Line();
            newLine.setDBID(dbid);
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
    
    public ArrayList<Line> getLines(){
        return this.lines;
    }
    
    public void add(Line l) {
       lines.add(l);
       linesNum++;
    }
    
    public int lineSize(int i){
        return lines.get(i).size();
    }
}

