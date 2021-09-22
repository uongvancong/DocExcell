package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Data;

public class InsertPool {

    static ExecutorService executorService = Executors.newFixedThreadPool(3);
    static List<Future<?>> futureList = new ArrayList<Future<?>>();

    public static void insertToDB(BlockingQueue<Data> listData) {

        Task task1 = new Task(listData);
        Task task2 = new Task(listData);
        Task task3 = new Task(listData);
        Task task4 = new Task(listData);
        Task task5 = new Task(listData);

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

        for (Future f : futureList) {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException ex) {
                executorService.shutdownNow();
                ex.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println("Insert DB OK");
    }

   
}
