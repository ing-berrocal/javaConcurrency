/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.executors.all;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        
        List<Task> taskList = new ArrayList<>();
        
        for(int i=0;i<3;i++){
            Task task = new Task(i+"");
            taskList.add(task);
        }
        
        List<Future<Result>> resulList = null;
        
        try{
            resulList = newFixedThreadPool.invokeAll(taskList);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        newFixedThreadPool.shutdown();
        
        System.out.println("Main: Printing the results");
        for(int i=0; i<resulList.size(); i++){
            Future<Result> future = resulList.get(i);
            try{
                Result result = future.get();
                System.out.println(result.getName()+": "+result.getValue());
            }catch( InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }
    }
}
