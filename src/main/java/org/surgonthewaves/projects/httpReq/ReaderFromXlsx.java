package org.surgonthewaves.projects.httpReq;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class ReaderFromXlsx {
    public String readFromExcel(String file) throws IOException {
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheet("Автомобіль");
        XSSFRow row = myExcelSheet.getRow(0);


       /* if(row.getCell(0).getCellType() == XSSFCell.CELL_TYPE_STRING){
            String name = row.getCell(0).getStringCellValue();
            System.out.println("name : " + name);
        }

        if(row.getCell(1).getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
            Date birthdate = row.getCell(1).getDateCellValue();
            System.out.println("birthdate :" + birthdate);
        }*/

        myExcelBook.close();
        return String.valueOf(row.getLastCellNum());
    }
}
