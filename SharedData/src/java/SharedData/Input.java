package SharedData;


public class Input{
    

//    public Input(String input, LineStorage ls){
//        this.input = input;
//        processInput(ls);
//    }
   
    // Splits input string based on new lines
    public static void processInput(String input, LineStorage ls){
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
