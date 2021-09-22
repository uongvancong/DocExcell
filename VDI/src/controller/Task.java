/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.concurrent.BlockingQueue;
import model.Data;

/**
 *
 * @author Admin
 */
public class Task implements Runnable {

    BlockingQueue<Data> listData;

    public Task(BlockingQueue<Data> listData) {
        this.listData = listData;
    }

    @Override
    public void run() {
        InsertDatabase.insertToDatabase(listData);
    }
}
