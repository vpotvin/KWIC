package SharedData;


public class InputFilter{
        
    private String input;
    

    public InputFilter(String input, LineStorage ls){
        this.input = input;
        processInput(ls);
    }
   
    // Splits input string based on new lines
    private void processInput(LineStorage ls){
        String[] lines = input.split("\\r?\\n");
        int lineNum = 0;
        for(String l: lines){ 
            int wordNum = 0;
            for (String word : l.split("\\s+")) {
                ls.setWord(lineNum, wordNum, word);
                wordNum++;
            }
            lineNum++;
        }

    }
    

}
