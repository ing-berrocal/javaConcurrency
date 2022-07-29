/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.independent;

/**
 *
 * @author DELL
 */
public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;
    
    private final Object controlCinema1, controlCinema2;

    public Cinema() {
        this.controlCinema1 = new Object();
        this.controlCinema2 = new Object();
        this.vacanciesCinema1 = 20;
        this.vacanciesCinema2 = 20;
    }
    
    public boolean sellTickets1(int number){
        synchronized (this.controlCinema1) {
            System.out.println(Thread.currentThread().getName());
            if(number<vacanciesCinema1){
                vacanciesCinema1-=number;
                return true;
            }else{
                return false;
            }
        }
    }
    
    public boolean sellTickets2(int number){
        synchronized (this.controlCinema2) {
            System.out.println(Thread.currentThread().getName());
            if(number<vacanciesCinema2){
                vacanciesCinema2-=number;
                return true;
            }else{
                return false;
            }
        }
    }
    
    public boolean returnTickets1(int number){
        synchronized (this.controlCinema1) {
            vacanciesCinema1+=number;
            return true;
        }
    }
    
    public boolean returnTickets2(int number){
        synchronized (this.controlCinema2) {
            vacanciesCinema2+=number;
            return true;
        }
    }

    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }        
}
