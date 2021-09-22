/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
 
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import model.Data;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 *
 * @author Admin
 */
public class ReadWriteExcellFile {

    public static final int COLUMN_NO = 0;
    public static final int COLUMN_NAME = 1;
    public static final int COLUMN_COMPANY = 2;
    public static final int COLUMN_PROJECT_NAME = 3;
    public static final int COLUMN_KNOX_ID = 4;
    public static final int COLUMN_IP_DEV = 5;
    public static final int COLUMN_IP_OPERATOR = 6;
    public static final int COLUMN_PLACE_OF_WORK = 7;
    public static final int COLUMN_PART_NAME = 8;
    public static final int COLUMN_REMARK1 = 9;
    public static final int COLUMN_CONNECT_GDCVDI = 10;
    public static final int COLUMN_CONNECTION_TIME = 11;
    public static final int COLUMN_CONNECTION_STATUS = 12;
    public static final int COLUMN_REMARK2 = 13;
    public static final int COLUMN_ISSUE = 14;

    public static BlockingQueue<Data> docFile(String fileName) {
        BlockingQueue<Data> listData = new ArrayBlockingQueue<>(100000);
        FileInputStream ips;
        try {
            ips = new FileInputStream(new File(fileName));

            Workbook wb = new XSSFWorkbook(ips);

            Sheet sheet = wb.getSheetAt(0);

            Iterator<Row> itr = sheet.iterator();

            while (itr.hasNext()) {

                Row row = itr.next();

                if (row.getRowNum() == 0) {
                    continue;
                }

                Iterator<Cell> cellIterator = row.cellIterator();

                Data dataTMP = new Data();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    int columnIndex = cell.getColumnIndex();

                    String cellValue = "";
                   
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                        
                            cellValue = cell.getStringCellValue();
                            break;
                        case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
                            cellValue = cell.getNumericCellValue() + "";

                            break;
                        default: {
                            break;
                        }
                    }

                    switch (columnIndex) {
                        case COLUMN_NO: {
                            String cellValueTMP = (int) Double.parseDouble(cellValue) + "";
                            dataTMP.setNo(cellValueTMP);
                            break;
                        }
                        case COLUMN_NAME: {
                            dataTMP.setName(cellValue);
                            break;
                        }
                        case COLUMN_COMPANY: {
                            dataTMP.setCompany(cellValue);
                            break;
                        }
                        case COLUMN_PROJECT_NAME: {
                            dataTMP.setProjectName(cellValue);
                            break;
                        }
                        case COLUMN_KNOX_ID: {
                            dataTMP.setKnoxID(cellValue);
                            break;
                        }
                        case COLUMN_IP_DEV: {
                            dataTMP.setIpDEV(cellValue);
                            break;
                        }
                        case COLUMN_IP_OPERATOR: {
                            dataTMP.setIpOPER(cellValue);
                            break;
                        }
                        case COLUMN_PLACE_OF_WORK: {
                            dataTMP.setPlaceOfWork(cellValue);
                            break;
                        }
                        case COLUMN_PART_NAME: {
                            dataTMP.setPartName(cellValue);
                            break;
                        }
                        case COLUMN_REMARK1: {
                            dataTMP.setRemark1(cellValue);
                            break;
                        }
                        case COLUMN_CONNECT_GDCVDI: {
                            dataTMP.setConnectGDCVDI(cellValue);
                            break;
                        }
                        case COLUMN_CONNECTION_TIME: {

                            dataTMP.setConnectionTime(cellValue);
                            break;
                        }
                        case COLUMN_CONNECTION_STATUS: {
                            dataTMP.setConnectionStatus(cellValue);
                            break;
                        }
                        case COLUMN_REMARK2: {
                            dataTMP.setRemark2(cellValue);
                            break;
                        }
                        case COLUMN_ISSUE: {
                            dataTMP.setIssue(cellValue);
                            break;
                        }

                        default: {
                            break;
                        }
                    }

                }
                listData.add(dataTMP);

            }
            wb.close();
            ips.close();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

        return listData;
    }

    public static BlockingQueue<Data> readDataCSV(String fileName) {
        BlockingQueue<Data> listData = new ArrayBlockingQueue<>(10000);
        CSVReader csvReader = null;
        try {
            FileReader filereader = new FileReader(fileName);
            csvReader = new CSVReader(filereader);
            String[] nextRecord;
            csvReader.readNext();
            while ((nextRecord = csvReader.readNext()) != null) {
                Data data = new Data();
                data.setNo(nextRecord[0]);
                data.setName(nextRecord[1]);
                data.setCompany(nextRecord[2]);
                data.setProjectName(nextRecord[3]);
                data.setKnoxID(nextRecord[4]);
                data.setIpDEV(nextRecord[5]);
                data.setIpOPER(nextRecord[6]);
                data.setPlaceOfWork(nextRecord[7]);
                data.setPartName(nextRecord[8]);
                data.setRemark1(nextRecord[9]);
                data.setConnectGDCVDI(nextRecord[10]);
                data.setConnectionTime(nextRecord[11]);
                data.setConnectionStatus(nextRecord[12]);
                data.setRemark2(nextRecord[13]);
                data.setIssue(nextRecord[14]);
                listData.add(data);
            }
            return listData;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvReader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

}

//    public static void main(String[] args) throws IOException {
//        String fileName = "data1.xlsx";
//        BlockingQueue<Data> q = docFile(fileName);
//        for (Data tmp : q) {
//            System.out.println(tmp.toString());
//        }
//        ArrayList<Data> arrData = new ArrayList<Data>();
//        while (!q.isEmpty()) {
//            Data data;
//            try {
//                data = q.take();
//                arrData.add(data);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ReadWriteExcellFile.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//        ReadWriteExcellFile writeExcellFile = new ReadWriteExcellFile();
//        writeExcellFile.writeExcell(arrData);
//
//    }
//    //    public static File f;
////    public static FileOutputStream fos;
////    public static XSSFWorkbook wb;
////    public static XSSFSheet sheet;
////    public static final String fileName = "data10.xlsx";
////    public static int rowIndex;
//
//  public ReadWriteExcellFile() throws IOException {
//////        System.out.println("da chay");
//////        f = new File(fileName);
//////        if (!f.exists()) {
//////            f.createNewFile();
//////            System.out.println("da tao file data10.xlsx");
//////        }
//////
//////        fos = new FileOutputStream(f);
//////
//////        wb = new XSSFWorkbook();
//////        sheet = wb.createSheet("VDI");
////////        rowIndex = -1;
////    }
//     public static void writeExcell(ArrayList<Data> listData) throws IOException {
//
//        Cell cell;
//        Row row;
//        int rowIndex = 0;
//        for (Data tmp : listData) {
//            rowIndex++;
//            System.out.println(rowIndex);
//            row = sheet.createRow(rowIndex);
//
//            cell = row.createCell(COLUMN_NO, CellType.STRING);
//            cell.setCellValue(tmp.getNo());
//
//            cell = row.createCell(COLUMN_NAME, CellType.STRING);
//            cell.setCellValue(tmp.getName());
//
//            cell = row.createCell(COLUMN_COMPANY, CellType.STRING);
//            cell.setCellValue(tmp.getCompany());
//
//            cell = row.createCell(COLUMN_PROJECT_NAME, CellType.STRING);
//            cell.setCellValue(tmp.getProjectName());
//
//            cell = row.createCell(COLUMN_KNOX_ID, CellType.STRING);
//            cell.setCellValue(tmp.getKnoxID());
//
//            cell = row.createCell(COLUMN_IP_DEV, CellType.STRING);
//            cell.setCellValue(tmp.getIpDEV());
//
//            cell = row.createCell(COLUMN_IP_OPERATOR, CellType.STRING);
//            cell.setCellValue(tmp.getIpOPER());
//
//            cell = row.createCell(COLUMN_PLACE_OF_WORK, CellType.STRING);
//            cell.setCellValue(tmp.getPlaceOfWork());
//
//            cell = row.createCell(COLUMN_PART_NAME, CellType.STRING);
//            cell.setCellValue(tmp.getPartName());
//
//            cell = row.createCell(COLUMN_REMARK1, CellType.STRING);
//            cell.setCellValue(tmp.getRemark1());
//
//            cell = row.createCell(COLUMN_CONNECT_GDCVDI, CellType.STRING);
//            cell.setCellValue(tmp.getConnectGDCVDI());
//
//            cell = row.createCell(COLUMN_CONNECTION_TIME, CellType.STRING);
//            cell.setCellValue(tmp.getConnectionTime());
//
//            cell = row.createCell(COLUMN_CONNECTION_STATUS, CellType.STRING);
//            cell.setCellValue(tmp.getConnectionStatus());
//
//            cell = row.createCell(COLUMN_REMARK2, CellType.STRING);
//            cell.setCellValue(tmp.getRemark2());
//
//            cell = row.createCell(COLUMN_ISSUE, CellType.STRING);
//            cell.setCellValue(tmp.getIssue());
//
//        }
//
//        wb.write(fos);
//        System.out.println("da ghi file xong");
//    }

