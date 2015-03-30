package Microminer;

public class LineHolder {
    int lineNumber;
    int word;
    Long DBID;
       
    public LineHolder(int l, int lineNumber, long DBID){
        this.word = l;
        this.lineNumber = lineNumber;
        this.DBID = DBID;
    }
    
    public Long getDBID(){
        return this.DBID;
    }
}