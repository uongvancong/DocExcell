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
public class Main {

    public static void main(String[] args) {
        BlockingQueue<Data> list = ReadPool.loadDataFromFiles();
        InsertPool.insertToDB(list);

        BlockingQueue<Data> list2 = ReadWriteExcellFile.readDataCSV("logAll.csv");
        InsertDatabase.insertToDatabase(list2);

    }
}
