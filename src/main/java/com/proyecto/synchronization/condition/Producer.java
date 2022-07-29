/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.condition;

/**
 *
 * @author DELL
 */
public class Producer implements Runnable{

    private FileMock mock;
    private Buffer buffer;
    
    public Producer (FileMock mock, Buffer buffer){
        this.mock=mock;
        this.buffer=buffer;
    }
    
    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()){
            String line=mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
    
}
