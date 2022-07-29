/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.utilities.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class VideoConference implements Runnable {

    private final CountDownLatch controller;
    
    public VideoConference(int number){
        controller = new CountDownLatch(number);
    }
    
    public void arrive(String name){
        System.out.printf("%s has arrived.\n", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }
    
    @Override
    public void run() {
        System.out.printf("VideoConference: initializacion: %d participants.\n", controller.getCount());
        try{
            controller.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException ex) {
            Logger.getLogger(VideoConference.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
