/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeandfilter;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Pipe {
 
    // queue that can be used by multiple threads 
    private BlockingQueue<String> dataBuffer;
    
    public Pipe(){
        dataBuffer = new LinkedBlockingQueue<>();
    }
    
    public void PushData(String input){
        try{
            this.dataBuffer.put(input); 
        } catch(Exception e){
            System.out.println("Push Data Exception");
            e.printStackTrace();
        }
    }
    
    public String PullData(){
        try{
            return dataBuffer.take();
        }catch(Exception e){
                System.out.println("Pull Data Exception");
                e.printStackTrace();
        }
        return null;
    }
    
}
