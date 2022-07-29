/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization;

/**
 *
 * @author DELL
 */
public class Company implements Runnable{

    private Account account;

    public Company(Account account) {
        this.account = account;
    }
    
    
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            account.addAmont(1000);
        }
    }
    
}
