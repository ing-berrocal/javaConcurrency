/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.executors.all;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author DELL
 */
public class Task implements Callable<Result>{

    private String name;

    public Task(String name) {
        this.name = name;
    }
    
    
    @Override
    public Result call() throws Exception {
        System.out.printf("%s: Starting\n",this.name);
        try{
            long duration = (long)(Math.random()*10);
            System.out.printf("%s: Waiting %d seconds for results.\n", this.name,duration);
            TimeUnit.SECONDS.sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        int value = 0;
        for(int i=0; i<5; i++){
            value += (int)(Math.random()*10);
        }
        
        Result result = new Result();
        result.setName(name);
        result.setValue(value);
        
        System.out.println(this.name+" :Ends");
        return result;
    }
    
}
