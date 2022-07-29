/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.utilities.semaphories;

/**
 *
 * @author DELL
 */
public class Job implements Runnable{
    
    private PrintQueue printQueue;
    
    public Job(PrintQueue printQueue){
        this.printQueue=printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n",Thread.currentThread().getName());
        
        printQueue.printJob(new Object());
        
        System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());
    }
    
}
