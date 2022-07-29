/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.printqueue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author DELL
 */
public class PrintQueue {
    
    private final Lock queueLock = new ReentrantLock();
    
    public void printJob(Object document){
        //queueLock.lock();
        if(queueLock.tryLock())        {
            try{
                Long duration = (long)(Math.random()*10000);
                System.out.println(Thread.currentThread().getName()+" : PrintQueue: printing a job during "+(duration/1000)+ " seconds");
                Thread.sleep(duration);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                queueLock.unlock();
            }
        }else{
            System.out.println(Thread.currentThread().getName()+" : No lock");
        }
    }
}
