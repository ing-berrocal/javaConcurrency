/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.utilities.exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();
        
        Exchanger<List<String>> exchanger = new Exchanger<>();
        
        Producer producer = new Producer(buffer1, exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);
        
        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);
        
        threadProducer.start();
        threadConsumer.start();
    }
}
