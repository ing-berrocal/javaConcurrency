/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.executors.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author DELL
 */
public class FactorialCalculator implements Callable<Integer>{

    private final Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }
        
    @Override
    public Integer call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(20);
        Integer factResult = getFactResult(this.number);
        System.out.printf("Number: %d, Result: %d\n", this.number,factResult);
        return factResult;
    }
    
    private Integer getFactResult(int number){
        if(number < 2) return number;
        return number * getFactResult(--number);
    }
    
}
