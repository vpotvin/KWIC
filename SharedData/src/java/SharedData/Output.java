/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharedData;

/**
 *
 * @author Victoria
 */
public class Output {
    public static String out(LineStorage ls) {
        String output = new String();
        for(int i = 0; i < ls.size(); i++){
            output = output + ls.getLine(i) + "\n";
        }
        return output;
    }
}
