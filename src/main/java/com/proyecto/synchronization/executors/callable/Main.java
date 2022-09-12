/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.executors.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) {

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);

        ThreadPoolExecutor executors = (ThreadPoolExecutor) newFixedThreadPool;

        List<Future<Integer>> resultList = new ArrayList<>();

        Random random = new Random();

        random.ints(10L,1, 10).forEach((value) -> {
        //for (int i = 0; i < 10; i++) {                        

            FactorialCalculator factorialCalculator = new FactorialCalculator(value);
            
            Future<Integer> result = newFixedThreadPool.submit(factorialCalculator);

            resultList.add(result);
        });

        do {

            System.out.printf("Main: Number of Complete Tasks: %d\n", executors.getCompletedTaskCount());

            for (int i = 0; i < resultList.size(); i++) {

                Future<Integer> result = resultList.get(i);

                System.out.printf("Main: Tasks: %d: %s\n", i, result.isDone());
            }

            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Main: Results\n");

        } while (executors.getCompletedTaskCount() < resultList.size());

        for (int i = 0; i < resultList.size(); i++) {

            Future<Integer> result = resultList.get(i);

            Integer number = null;

            try {
                number = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.printf("Main: Tasks: %d: %d\n", i, number);
        }

        executors.shutdown();
    }
}
