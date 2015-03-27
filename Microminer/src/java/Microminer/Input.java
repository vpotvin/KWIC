package Microminer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;


public class Input{
    
    @Resource(name="jdbc/SA")
    DataSource ds;
//    public Input(String input, LineStorage ls){
//        this.input = input;
//        processInput(ls);
//    }
   
    // Splits input string based on new lines
    public void processInput(String input, LineStorage ls) throws SQLException{
        String[] lines = input.split("\\r?\\n");
        int lineNum = 0;
        for(String l: lines){ 
            String sURL = l.substring(l.indexOf("http://"));
            String sDesc = l.substring(0, l.indexOf("http://"));
            try(Connection conn = ds.getConnection()) {
                String sql = "insert into LINE_STORAGE values('" 
                        + sURL + "', '" + sDesc + "')";
                PreparedStatement insert = conn.prepareStatement(sql);
                insert.execute();
            }
            
            int wordNum = 0;
            for (String word : l.split("\\s+")) {
                ls.setWord(lineNum, wordNum, word);
                wordNum++;
            }
            lineNum++;
        }

    }
    

}
