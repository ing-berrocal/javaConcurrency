/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.printqueue;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for(int i=0; i<10;i++){
            thread[i] = new Thread(new Job(printQueue), "Thread "+i);
        }
        for(int i=0; i<10;i++){
            thread[i].start();
        }
    }
}
