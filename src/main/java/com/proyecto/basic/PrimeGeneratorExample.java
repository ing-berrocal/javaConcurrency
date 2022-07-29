/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.basic;

/**
 *
 * @author DELL
 */
public class PrimeGeneratorExample{
    public static void main(String[] args) {
        Thread task=new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}

class PrimeGenerator extends Thread{

    @Override
    public void run() {
        long number = 1l;
        while(true){
            if(isPrime(number)){
                System.out.printf("Number %d is Prime\n",number);
            }
            if(isInterrupted()){
                System.out.printf("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <=2) {
            return true;
        }
        for (long i=2; i<number; i++){
            if ((number % i)==0) {
                return false;
            }
        }
        return true;
    }        
}
