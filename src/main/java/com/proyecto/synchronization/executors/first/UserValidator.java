/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.executors.first;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author DELL
 */
public class UserValidator {
    
    private final String name;

    public UserValidator(String name) {
        this.name = name;
    }
    
    public boolean validate(String name,String password){
        
        Random random = new Random();
        
        try{
            long duration = (long) (Math.random()*10);
            System.out.printf("Validator %s: Validating a user during %d secods\n", this.name,duration);
            TimeUnit.SECONDS.sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();           
            return Boolean.FALSE;
        }        
        return random.nextBoolean();
    }

    public String getName() {
        return name;
    }
    
    
}
