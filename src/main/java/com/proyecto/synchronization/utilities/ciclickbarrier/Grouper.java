/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.utilities.ciclickbarrier;

/**
 *
 * @author DELL
 */
public class Grouper implements Runnable{

    private Results results;
    
    public Grouper(Results results){
        this.results=results;
    }
    
    @Override
    public void run() {
        int finalResult=0;
        System.out.printf("Grouper: Processing results...\n");
        int data[]=results.getData();
        for (int number:data){
            finalResult+=number;
        }
        System.out.printf("Grouper: Total result: %d.\n",finalResult);
    }
    
}
