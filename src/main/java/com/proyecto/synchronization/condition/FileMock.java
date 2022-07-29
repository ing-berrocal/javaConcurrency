/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.condition;

/**
 *
 * @author DELL
 */
public class FileMock {
    private String[] content;
    private int index;
    
    public FileMock(int size, int length){
        content = new String[size];
        for(int i=0;i<size;i++){
            StringBuilder buffer = new StringBuilder(length);
            for(int j=0;i<length;j++){
                int indice = (int)Math.random()*255;
                buffer.append((char)indice);
            }
            content[i]=buffer.toString();
        }
        index=0;
    }
    
    public boolean hasMoreLines(){
        return index<content.length;
    }
    
    public String getLine(){
        if(this.hasMoreLines()){
            System.out.println("Mock: "+(content.length-index));
            return content[index++];
        }
        return null;
    }
}
