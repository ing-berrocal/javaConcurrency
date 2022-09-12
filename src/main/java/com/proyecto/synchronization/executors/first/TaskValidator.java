/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.executors.first;

import java.util.concurrent.Callable;

/**
 *
 * @author DELL
 */
public class TaskValidator implements Callable<String>{
    
    private final UserValidator validator;    
    private final String user;
    private final String password;

    public TaskValidator(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if(!validator.validate(user, password)){
            System.out.printf("%s: The user has not been found\n", validator.getName());
            throw new Exception("Error validating user");
        }
        System.out.printf("%s: The user has been found\n", validator.getName());
        return validator.getName();
    }
    
    
    
}
