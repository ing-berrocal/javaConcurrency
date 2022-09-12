/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.executors.create;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        for(int i=1;i<=100;i++){
            Task task = new Task("Task "+i);
            server.executeTask(task);
        }
        server.endServer();        
    }
}
