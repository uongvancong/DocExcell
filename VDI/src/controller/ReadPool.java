/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import model.Data;

/**
 *
 * @author Admin
 */
public class ReadPool {

    public static ExecutorService executorService;
    public static List<Future<?>> futureList = new ArrayList<Future<?>>();
    public static BlockingQueue<Data> listData = new ArrayBlockingQueue<>(100000);

    public static BlockingQueue<Data> loadDataFromFiles() {
        executorService = Executors.newFixedThreadPool(3);
        String fileName1 = "data1.xlsx";
        String fileName2 = "data2.xlsx";
        String fileName3 = "data3.xlsx";
        String fileName4 = "data4.xlsx";
        String fileName5 = "data5.xlsx";

        Task task1 = new Task(fileName1);
        Task task2 = new Task(fileName2);
        Task task3 = new Task(fileName3);
        Task task4 = new Task(fileName4);
        Task task5 = new Task(fileName5);

        Future<?> future1 = executorService.submit(task1);
        Future<?> future2 = executorService.submit(task2);
        Future<?> future3 = executorService.submit(task3);
        Future<?> future4 = executorService.submit(task4);
        Future<?> future5 = executorService.submit(task5);

        futureList.add(future1);
        futureList.add(future2);
        futureList.add(future3);
        futureList.add(future4);
        futureList.add(future5);

        for (Future<?> f : futureList) {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println("load file OK");

        return listData;
    }

    static class Task implements Runnable {

        private String fileName;

        public Task(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            listData.addAll(ReadWriteExcellFile.docFile(fileName));
        }

    }
 

}
