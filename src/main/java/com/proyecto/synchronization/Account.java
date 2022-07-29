/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization;

/**
 *
 * @author DELL
 */
public class Account {
    
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }            
    
    public synchronized void addAmont(double amount){
        double tmp = balance;
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        tmp+=amount;
        balance=tmp;
    }
    
    public synchronized void substractAmount(double amount){
        double tmp = balance;
        try{
            Thread.sleep(10);            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        tmp-=amount;
        balance=tmp;
    }
}
