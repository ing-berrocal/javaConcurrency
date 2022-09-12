/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.basic;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author DELL
 */
public class LocalVariables {
    public static void main(String[] args) {
        Runnable task=new SafeTask();
        for (int i=0; i<10; i++){
            Thread thread=new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UnsafeTask implements Runnable{

    private Date startDate;       
    
    @Override
    public void run() {
        startDate=new Date();
        System.out.printf("Starting Thread: %s : %s\n",Thread.
                currentThread().getId(),startDate);
    try {
        TimeUnit.SECONDS.sleep( (int)Math.rint(Math.random()*10));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.printf("Thread Finished: %s : %s\n",Thread.
    currentThread().getId(),startDate);
    }    
}

class SafeTask implements Runnable{

    private static ThreadLocal<Date> startDate= new ThreadLocal<Date>() {
        protected Date initialValue(){
            return new Date();
        }
    };
    
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n",Thread.
                currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.
                currentThread().getId(),startDate.get());
    }
}