/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.executors.first;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        String username = "test";
        String password = "test";
        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("DB");
        
        TaskValidator ldapTaskValidator = new TaskValidator(ldapValidator, username, password);
        TaskValidator dbTaskValidator = new TaskValidator(dbValidator, username, password);
        
        List<TaskValidator> taskList = new ArrayList<>();
        taskList.add(ldapTaskValidator);
        taskList.add(dbTaskValidator);
        
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        
        try {
            String invokeAny = newCachedThreadPool.invokeAny(taskList);
            System.out.printf("Main: Result: %s\n", invokeAny);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        newCachedThreadPool.shutdown();
        System.out.printf("End of execution\n");
    }
}
