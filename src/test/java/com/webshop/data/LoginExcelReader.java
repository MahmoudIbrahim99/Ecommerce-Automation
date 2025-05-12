package com.webshop.data;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginExcelReader {

    static FileInputStream fIS = null;

    //To reach to the file
    public FileInputStream getFIS() {
        String filePath = System.getProperty("user.dir" )+ "/src/test/java/com/webshop/data/login_data.xlsx";   //excel file
        File sourceFile = new File(filePath);
        try{
            fIS = new FileInputStream(sourceFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + sourceFile.getPath(), e);
        }
        return fIS;
    }

    //To access data in the file
    public Object[][] getExcelData() throws IOException {
        fIS = getFIS();
        XSSFWorkbook workBook = new XSSFWorkbook(fIS);
        XSSFSheet workSheet = workBook.getSheetAt(0);
        int rowNum = (workSheet.getLastRowNum()+1);
        int colNum = 2;
        String[][] data = new String[rowNum][colNum];
        DataFormatter formatter = new DataFormatter();
        for(int i = 0 ; i<rowNum ; i++){
            XSSFRow row = workSheet.getRow(i);
            for(int j = 0 ; j<colNum ; j++){
                data[i][j] = formatter.formatCellValue(row.getCell(j));
            }
        }
        workBook.close();
        return data;
    }
}
