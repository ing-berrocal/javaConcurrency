/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.buffer;

/**
 *
 * @author DELL
 */
public class Producer implements Runnable{

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }
    
    
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            storage.set();
        }
    }
    
}
