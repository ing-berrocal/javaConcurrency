/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.utilities.exchange;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 *
 * @author DELL
 */
public class Consumer implements Runnable{
    
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }   
    
    @Override
    public void run() {
        int cycle = 1;
        
        for(int i=0; i<10; i++){
            System.out.printf("Consumer: Cycle %d\n", cycle);
            
            try{
                buffer = exchanger.exchange(buffer);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.printf("Consumer buffer: %d\n", buffer.size());
            for(int j=0; j<10; j++){
                String message = buffer.get(0);
                System.out.printf("Consumer: %s\n", message);
                buffer.remove(0);
            }                        
            System.out.println("Consumer: "+buffer.size());
            cycle++;
        }
    }
}
