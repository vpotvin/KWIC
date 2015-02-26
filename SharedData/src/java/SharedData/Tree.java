package SharedData;


public class Tree {
    private Node root;
    private ShiftIndex si;
    private LineStorage ls;

    public Tree(ShiftIndex s, LineStorage ls) {
        root = null;
        this.si = s;
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
                dataString += data.line[l];
            }
            
            String nodeString = "";
            for(int l = 0; l < node.line.line.length; l++){
                nodeString += node.line.line[l];
            }

            if(dataString.compareTo(nodeString) <= 0){
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
            
        }   

        return(node);
    }
    
    
    
    public void printTree() {
        printTree(root);
        System.out.println();
    }

    private void printTree(Node node) {
        if (node == null) return;
        
        printTree(node.left);
        System.out.print(node.line + "  ");
        printTree(node.right);
} 
    

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
