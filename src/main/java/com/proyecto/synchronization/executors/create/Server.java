/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.executors.create;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author DELL
 */
public class Server {
    
    private ThreadPoolExecutor executor;

    public Server() {
        //ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();        
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setCorePoolSize(10);
        executor.setMaximumPoolSize(30);
    }
    
    public void executeTask(Task task){
        System.out.println("Server: A new task has arrived\n");        
        executor.execute(task);        
        System.out.printf("Server: Pool Size: %d\n",executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n",executor.getCompletedTaskCount());
    }
    
    public void endServer(){
        executor.shutdown();
    }
    
}
