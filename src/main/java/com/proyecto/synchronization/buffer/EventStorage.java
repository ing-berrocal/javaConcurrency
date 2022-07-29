/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.buffer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class EventStorage {
    
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }
    
    public synchronized void set(){
        while(storage.size()==maxSize){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.printf("Set: %d\n",storage.size());
        notifyAll();
    }
    
    public synchronized void get(){
        while(storage.size()==0){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s\n",storage.size(),((LinkedList<?>)storage).poll());
        notifyAll();
    }
}
