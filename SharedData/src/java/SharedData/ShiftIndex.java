package SharedData;


import java.util.ArrayList;
import java.util.LinkedList;




public class ShiftIndex {
    private LinkedList<LineHolder> indexHolder;
    
    public ShiftIndex(){
        indexHolder = new LinkedList<>();
    }
    
    public int getSize(){
        return indexHolder.size();
    }
    
    public LineHolder getLine(int i){
        return indexHolder.get(i);
    }
    
   public void addLine(Integer[] l, int n){
       
       LineHolder lh = new LineHolder(l, n);
              
       indexHolder.addFirst(lh);
       
//       if(indexHolder.size() > 3){
//           
//
//           
//           Integer[] i = indexHolder.get(0).line;
//           for(Integer k : i){
//               System.out.println(k);
//           }
//           
//           System.out.println("BREAK");
//           
//           i = indexHolder.get(1).line;
//           for(Integer k : i){
//               System.out.println(k);
//           }
//           
//           System.out.println("BREAK");
//           
//           i = indexHolder.get(2).line;
//           for(Integer k : i){
//               System.out.println(k);
//           }
//           
//           System.out.println("BREAK");
//
//       }
       
       
       
       
   }
   
   public String buildString(LineStorage ls){
              
       String returnString = "";
       for(int j = 0; j < indexHolder.size(); j++){
           LineHolder lh = indexHolder.get(j);
           
           for(Integer i: lh.line){
               returnString += ls.getWord(lh.lineNumber, i) + " ";
           }
           
           returnString += "\n";
       }
       
       System.out.println(returnString);
       return returnString;
   }
   


}
