package Microminer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.sql.DataSource;


public class Input{
    
    @Resource(name="jdbc/sa")
    private DataSource ds;

   
    // Splits input string based on new lines
    public void processInput(String input, LineStorage ls) throws SQLException{
        String[] lines = input.split("\\r?\\n");
        int lineNum = 0;
        
        String URLString = "(https|http)://([a-zA-Z0-9]+.)?([a-zA-Z0-9]+.)(com|edu|org|net)";
        Pattern URLPattern = Pattern.compile(URLString);
        
        
        for(String l: lines){
            long key;
            Matcher URLMatcher = URLPattern.matcher(l);
                        
            if(!URLMatcher.find()){
                continue;
            }

            // TEST FOR UPPER AND LOWER CASE STUFF;
            

            String sURL = URLMatcher.group();

            String[] desArray = l.split(",");
            
            if(desArray.length > 2){
               continue; 
            }
            
            String description = desArray[1].trim();
            
 


            
            if (ds == null) {
                throw new SQLException("CANNOT GET DATASOURCE");
            }
        
            Connection conn = ds.getConnection();
            if (conn == null) {
                throw new SQLException("CANNOT GET DATABASE");
            }
        

            try {     
                boolean committed = false;
                conn.setAutoCommit(false);
                try{
                    String query = "INSERT INTO LINE_STORAGE(URL, DESCRIPTION) "
                                                               + "VALUES(?, ?)";
                    
                    PreparedStatement stmt = conn.prepareStatement(query,
                                               Statement.RETURN_GENERATED_KEYS);
                    
                    stmt.setString(1, sURL);
                    stmt.setString(2, description);
                    
                    stmt.executeUpdate();
                    ResultSet gk = stmt.getGeneratedKeys();
                    
                    
                    if (gk.next()) {
                        key = gk.getLong(1);
                    }else{
                        throw new SQLException("CANNOT GET GENERATED KEY");
                    }
                    
            
                } finally {
                    if (!committed) {
                        conn.rollback();
                    }
                }
            }finally{    
                conn.close();
            }
            
            int wordNum = 0;
            for (String word : l.split("\\s+")) {
                ls.setWord(lineNum, wordNum, word, key);
                wordNum++;
            }
            lineNum++;
        }

    }
    

}
