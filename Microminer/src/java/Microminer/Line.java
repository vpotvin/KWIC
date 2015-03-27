package Microminer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<String> l;
    private int wordCount;
    private long DBID;
   
    public Line(){
        l = new ArrayList<>();
        wordCount = 0;
    }
    
    public Line(Line l) {
        this.l = new ArrayList<>();
        
        for(int i = 0; i < l.size(); i++) {
            this.l.add(l.getWord(i));
        }
    }
    
    public void print(){
        for(int i= 0; i < l.size(); i++){
            System.out.printf("%s", l.get(i));
        }
        System.out.println();
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
    
    public void remove(int i) {
        l.remove(i);
        wordCount--;
    }
    
    public void add(String s){
        l.add(s);
        wordCount++;
    }
    
    public String toString(){
        String stringl = "";
        for(int i = 0; i < wordCount; i++){
            stringl = stringl + l.get(i) + " ";
        }
        return stringl;
    }
    
    public long getDBID(){
        return this.DBID;
    }
    
    public void setDBID(long i){
        this.DBID = i;
    }
    
}
