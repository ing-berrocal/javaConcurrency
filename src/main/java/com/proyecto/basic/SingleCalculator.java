/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.basic;

/**
 *
 * @author DELL
 */
public class SingleCalculator{
    public static void main(String args[]){
        for(int i=1;i<=10;i++){
            Calculator calculator = new Calculator(i);
            Thread t = new Thread(calculator);
            t.start();
        }
    }
} 
class Calculator implements Runnable{

    private final Integer number;

    public Calculator(Integer number) {
        this.number = number;
    }
    
    
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.printf(
                    "%s: %d * %d = %d\n",
                    Thread.currentThread().getName(),
                    number,i,(i*number));            
        }
    }
    
}
