/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.utilities.phaser;

import java.util.Scanner;
import java.util.concurrent.Phaser;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        
        
        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
        
        Phaser phaser=new Phaser(3);
        FileSearch system=new FileSearch("C:\\Windows", "log",phaser);
        FileSearch apps=new FileSearch("C:\\Program Files","log",phaser);
        FileSearch documents=new FileSearch("C:\\Documents And Settings","log",phaser);
        
        Thread systemThread=new Thread(system,"System");
        systemThread.start();
        
        Thread appsThread=new Thread(apps,"Apps");
        appsThread.start();
        
        Thread documentsThread=new Thread(documents, "Documents");
        documentsThread.start();
        
        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Terminated: "+ phaser.isTerminated());
        
        
    }
}
