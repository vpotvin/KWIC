package Microminer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

@Named(value = "tree")
@ApplicationScoped
public class Tree implements Serializable{
    private Node root;

    
    @Resource(name="jdbc/sa")
    private DataSource ds;
    
    @Inject
    private LineStorage ls;
    
    
    public void insert(LineHolder data) {
        root = insert(root, data);
    }
       
    private Node insert(Node node, LineHolder data) {
        
        if (node==null) {
            node = new Node(data);
            node.dbids.add(data.DBID);
        } else {
            
            String dataString = "";
            dataString += ls.getWord(data.lineNumber, data.word);
            
            
            String nodeString = "";
            nodeString += ls.getWord(node.line.lineNumber, node.line.word);
            
            if(dataString.equals(nodeString)){
                node.dbids.add(data.getDBID());
                return node;
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
               

        output.append(ls.getWord(node.line.lineNumber, node.line.word) + "Size: " + node.dbids.size() + " " + "PRINTTREE!");

        
        output.append("\n");
        
        printTree(node.right, output);
}
    
    public ArrayList<SearchResult> getAll() throws SQLException{
        ArrayList<SearchResult> r = new ArrayList<>();
        
        getAll(r, this.root);
        
        return r;
    }
    
    private void getAll(ArrayList<SearchResult> r, Node node) throws SQLException{
        if(node == null) return;
        getAll(r, node.left);
        
        SearchResult sr = new SearchResult();
        sr.setKeyword(ls.getWord(node.line.lineNumber, node.line.word));
        
        if (ds == null) {
            throw new SQLException("CANNOT GET DATASOURCE");
        }
        
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("CANNOT GET DATABASE");
        }
        

            try {     
                boolean committed = false;

                try{
                    
                    String query = "SELECT * FROM LINE_STORAGE WHERE ID = ?";
                    
    
                    for(int i = 0; i<node.dbids.size(); i++){
                        
                        
                        PreparedStatement stmt = conn.prepareStatement(query);
                        
                        
                        stmt.setLong(1, node.dbids.get(i));
                        ResultSet rs = stmt.executeQuery();

                        
                        if(rs.next()){
                            
                            URLInfo urlinfo = new URLInfo();
                            
                            
                            String url = rs.getString("URL");
                            
                            urlinfo.setURL(url);
                            
                            String desc = rs.getString("DESCRIPTION");
                            
                            sr.add(urlinfo);
                            

                        }
                        

                        
                    }

                } finally {
                    if (!committed) {
                        conn.rollback();
                    }
                }
            }finally{    
                conn.close();
            }
            r.add(sr);
       
        
        getAll(r, node.right);
    }
    
    public ArrayList<SearchResult> search(String term) throws SQLException{
        ArrayList<SearchResult> r = new ArrayList<>();
        search(r, this.root, term);
        return r;
    }
    
    private void search (ArrayList<SearchResult> r, Node node, String term) throws SQLException{
        if(node == null) return;
        
        
        
        Collator collator = Collator.getInstance(Locale.ENGLISH);
                

        
        
        if(collator.compare(term, ls.getWord(node.line.lineNumber, node.line.word)) < 0){
            search(r, node.left, term);
        } else if (collator.compare(term, ls.getWord(node.line.lineNumber, node.line.word)) > 0){
            search(r, node.right, term);
        }else {
  
            
            SearchResult sr = new SearchResult();
            sr.setKeyword(ls.getWord(node.line.lineNumber, node.line.word));
            
            if (ds == null) {
                throw new SQLException("CANNOT GET DATASOURCE");
            }
        
            Connection conn = ds.getConnection();
            if (conn == null) {
                throw new SQLException("CANNOT GET DATABASE");
            }
            
            try{
                String query = "SELECT * FROM LINE_STORAGE WHERE ID = ?";
                for(int i = 0; i<node.dbids.size(); i++){                        
                    PreparedStatement stmt = conn.prepareStatement(query);
                                               
                    stmt.setLong(1, node.dbids.get(i));
                    ResultSet rs = stmt.executeQuery();
                    
                    if(rs.next()){
                        
                        URLInfo urlinfo = new URLInfo();
                        

                        
                        String url = rs.getString("URL");
                        
                        
                        urlinfo.setURL(url);
                        
                        String desc = rs.getString("DESCRIPTION");
                        
                        urlinfo.setDescription(desc);
                        
                        sr.add(urlinfo);
                        

                    }                        
                }
                r.add(sr);
                return;
            }finally{    
                conn.close();
            }
        }
   
     
    }
    
    public static class Node {
        private LineHolder line;
        private ArrayList<Long> dbids = new ArrayList<>();
        private Node left;
        private Node right;
        
        
        Node(LineHolder newLine) {
            left = null;
            right = null;
            line = newLine;
        } 
    }
}
