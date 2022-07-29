/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.utilities.countdownlatch;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Participant implements Runnable{

    private VideoConference conferece;
    private String name;

    public Participant(VideoConference conferece, String name) {
        this.conferece = conferece;
        this.name = name;
    }
            
    @Override
    public void run() {
        long duration = (long)(Math.random()*10);
        try{
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ex) {
            Logger.getLogger(Participant.class.getName()).log(Level.SEVERE, null, ex);
        }
        conferece.arrive(name);
    }
    
}
