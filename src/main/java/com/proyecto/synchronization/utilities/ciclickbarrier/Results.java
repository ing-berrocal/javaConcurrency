/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.utilities.ciclickbarrier;

/**
 *
 * @author DELL
 */
public class Results {
    
    private int data[];
    
    public Results(int size){
        data=new int[size];
    }
    
    public void setData(int position, int value){
        data[position]=value;
    }
    
    public int[] getData(){
        return data;
    }
}
