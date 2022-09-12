/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.synchronization.utilities.ciclickbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author DELL
 */
public class Searcher implements Runnable{

    private int firstRow;
    private int lastRow;
    private MatrixMock mock;
    private Results results;    
    private int number;    
    private final CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock mock,
            Results results, int number, CyclicBarrier barrier){
        this.firstRow=firstRow;
        this.lastRow=lastRow;
        this.mock=mock;
        this.results=results;
        this.number=number;
        this.barrier=barrier;
    }
    
    @Override
    public void run() {
        int counter;
        System.out.printf("%s: Processing lines from %d to %d.\n",Thread.currentThread().getName(),firstRow,lastRow);
        for (int i=firstRow; i<lastRow; i++){
            int row[]=mock.getRow(i);
            counter=0;
            for (int j=0; j<row.length; j++){
                if (row[j]==number){
                counter++;
                }
            }
        results.setData(i, counter);
        }        
        try {                                    
            Thread.sleep(new Random().nextInt(60000));
            System.out.printf("%s: Lines processed.\n",Thread.currentThread().getName());
            barrier.await();            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
