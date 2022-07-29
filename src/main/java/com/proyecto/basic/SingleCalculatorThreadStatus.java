/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.basic;

/**
 *
 * @author DELL
 */
public class SingleCalculatorThreadStatus{
    public static void main(String args[]){
        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];
        for(int i=0;i<10;i++){
            Calculator calculator = new Calculator(i+1);
            threads[i] = new Thread(calculator);
            if((i%2)==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else{
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }
        
        for (int i=0; i<10; i++){
            threads[i].start();
        }
        
        boolean finish=false;
        while (!finish) {
            for (int i=0; i<10; i++){
                if (threads[i].getState()!=status[i]) {
                    writeThreadInfo(threads[i],status[i]);
                    status[i]=threads[i].getState();
                }
            }
            finish=true;
            for (int i=0; i<10; i++){
                finish=finish &&(threads[i].getState()==Thread.State.TERMINATED);
            }
        }
    }
    
    private static void writeThreadInfo(Thread thread, Thread.State state) {
        System.out.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        System.out.printf("Main : Priority: %d\n",thread.getPriority());
        System.out.printf("Main : Old State: %s\n",state);
        System.out.printf("Main : New State: %s\n",thread.getState());
        System.out.printf("Main : ************************************\n");
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
