package SharedData;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;


public class Tree {
    private Node root;
    private LineStorage ls;

    public Tree(LineStorage ls) {
        root = null;
        this.ls = ls;
    }
    
    public void insert(LineHolder data) {
        root = insert(root, data);
    }
    

    
    private Node insert(Node node, LineHolder data) {
        
        if (node==null) {
            node = new Node(data);
        } else {
            
            String dataString = "";
            for(int l = 0; l < data.line.length; l++){
                dataString += ls.getWord(data.lineNumber, data.line[l]);
            }
            
            String nodeString = "";
            for(int l = 0; l < node.line.line.length; l++){
                nodeString += ls.getWord(node.line.lineNumber, node.line.line[l]);
            }
            Collator collator = Collator.getInstance(Locale.ENGLISH);
            if(collator.compare(dataString, nodeString) < 0){
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
            
        }   

        return(node);
    }
    
    
    
    public StringBuilder printTree() {
        
        StringBuilder output = new StringBuilder();
        printTree(root, output);
        return output;
    }

    private void printTree(Node node, StringBuilder output) {
        if (node == null) return;
        
        printTree(node.left, output);
               
        for(int i = 0; i < node.line.line.length; i++){
            output.append(ls.getWord(node.line.lineNumber, node.line.line[i]) + " ");
        }
        
        output.append("\n");
        
        printTree(node.right, output);
} 
//    @Override
//    public int compare(String dataString, String nodeString) {
//        
//        if (dataString.toLowerCase().equals(nodeString.toLowerCase())) {
//                if (dataString.toLowerCase().equals(dataString)) {
//                        return -1;
//                } else {
//                        return  1;
//                }
//        } else {
//                return dataString.toLowerCase().compareTo(nodeString.toLowerCase());
//
//        }
//    }

    public static class Node {
        private LineHolder line;
        private Node left;
        private Node right;
        
        
        Node(LineHolder newLine) {
            left = null;
            right = null;
            line = newLine;
        } 
    }
}
