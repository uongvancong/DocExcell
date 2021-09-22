/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Data;

/**
 *
 * @author Admin
 */
public class InsertDatabase {

    public static int batchSize = 20;
    public static ReadWriteExcellFile writeExcellFile;

    public InsertDatabase() {

    }

    public static void insertToDatabase(BlockingQueue<Data> listData) {
        ArrayList<Data> arrData = new ArrayList<Data>();
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vdidb", "root", "72093711124");
            Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            System.out.println("Batch - Inserting ");
            int batchIndex = 1;
            while (!listData.isEmpty()) {

                Data data = listData.take();

                arrData.add(data);

                String queryInsertManagervdilog = "insert into managervdilog(mid, name, datetimeconnect, connectime) values('" + data.getKnoxID()
                        + "','" + data.getName() + "','" + data.getConnectGDCVDI() + "','" + data.getConnectionTime() + "');";

                String queryInsertStaff = "INSERT INTO Staff(name,knoxID) SELECT'" + data.getName() + "','" + data.getKnoxID()
                        + "' FROM dual WHERE NOT EXISTS ( SELECT * FROM Staff WHERE knoxID = '" + data.getKnoxID()
                        + "');";

                statement.addBatch(queryInsertManagervdilog);
                statement.addBatch(queryInsertStaff);

                if (batchIndex % batchSize == 0) {
                    try {
                        statement.executeBatch();
                    } catch (Exception e) {
                        synchronized (InsertDatabase.class) {

                            FileWriter csvWriter = null;
                            try {
                                csvWriter = new FileWriter("logAll.csv", true);
                                writeLogCSV(csvWriter, arrData);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            } finally {
                                try {
                                    csvWriter.flush();
                                    csvWriter.close();
                                } catch (IOException e1) {

                                    e1.printStackTrace();
                                }
                            }

                            writeLog("log.txt", e.getMessage() + " fail when insert All");
                             
                        }
                        e.printStackTrace();
                    }
                }
                batchIndex++;
            }

            statement.executeBatch();

            statement.close();
            connection.commit();
//            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(InsertDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private static void writeLog(String fileName, String s) {
        try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                    .format(new Timestamp(System.currentTimeMillis()));
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(s + " " + timeStamp + "\n");
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void writeLogCSV(FileWriter csvWriter, ArrayList<Data> listData) throws IOException {
        for (Data dataLog : listData) {
            csvWriter.append(dataLog.getNo() + ",");
            csvWriter.append(dataLog.getName() + ",");
            csvWriter.append(dataLog.getCompany() + ",");
            csvWriter.append(dataLog.getProjectName() + ",");
            csvWriter.append(dataLog.getKnoxID() + ",");
            csvWriter.append(dataLog.getIpDEV() + ",");
            csvWriter.append(dataLog.getIpOPER() + ",");
            csvWriter.append(dataLog.getPlaceOfWork() + ",");
            csvWriter.append(dataLog.getPartName() + ",");
            csvWriter.append(dataLog.getRemark1() + ",");
            csvWriter.append(dataLog.getConnectGDCVDI() + ",");
            csvWriter.append(dataLog.getConnectionTime() + ",");
            csvWriter.append(dataLog.getConnectionStatus() + ",");
            csvWriter.append(dataLog.getRemark2() + ",");
            csvWriter.append(dataLog.getIssue() + "");
            csvWriter.append("\n");
        }
    }

//    public static void main(String[] args) {
//        BlockingQueue<Data> list = loadDataFromFiles();
////        for (Data d : list) {
////            System.out.println(d.toString());
////        }
//        InsertDatabase tmp = new InsertDatabase();
//        tmp.insertToDatabase(list);
//
//    }
}
