/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization;

/**
 *
 * @author DELL
 */
public class Bank implements Runnable{

    private Account account;

    public Bank(Account account) {
        this.account = account;
    }
    
    
    @Override
    public void run() {
        for(int i=0; i<100;i++){
            account.substractAmount(1000);
        }
    }
    
}
