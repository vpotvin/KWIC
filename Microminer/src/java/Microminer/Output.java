package Microminer;


public class Output {

    public static String CreateOuput(Tree indexHolder){
        
        StringBuilder output = indexHolder.printTree();

        
        return output.toString();
    }
    
}
