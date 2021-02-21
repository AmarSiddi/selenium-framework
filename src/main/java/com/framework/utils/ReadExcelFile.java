package com.framework.utils;

import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReadExcelFile {
    static String FILE_PATH = "src/main/resources/testData.xlsx";

    public static void main(String[] args) {
        ArrayList<Object[]> arrayList = new ReadExcelFile().readDataFromExcel();

        for (Object[] objects : arrayList) System.out.println(Arrays.toString(objects));
    }

    @SneakyThrows
    public ArrayList<Object[]> readDataFromExcel() {
        Workbook workbook = new XSSFWorkbook(FILE_PATH);
        Sheet sheet = workbook.getSheet("testSheet");

        int startRow = sheet.getFirstRowNum();
        //System.out.println("start row: "+startRow);

        int lastRow = sheet.getLastRowNum();
        //System.out.println("last row: "+lastRow);

        int noOfColumns = sheet.getRow(0).getLastCellNum();
        //System.out.println("last column: "+noOfColumns);

        String data00 = sheet.getRow(1).getCell(3).getStringCellValue();
        //System.out.println("Data from first row and first cell: "+data00);

        ArrayList<Object[]> arrayList = new ArrayList<Object[]>();
        //O(n)
        for (int i = startRow+1; i <=lastRow ; i++) {

            String firstName = sheet.getRow(i).getCell(0).getStringCellValue()+" ";
            String lastName = sheet.getRow(i).getCell(1).getStringCellValue()+" ";
            String email = sheet.getRow(i).getCell(2).getStringCellValue()+" ";
            String gender = sheet.getRow(i).getCell(3).getStringCellValue()+" ";
            String mobileNumber = sheet.getRow(i).getCell(4).getStringCellValue()+" ";

            Object[] objects = {firstName, lastName, email, gender, mobileNumber};
            arrayList.add(objects);
        }

        return arrayList;

        //O(n^2)
        /*for (int i = startRow+1; i <=lastRow ; i++) {
            for (int j = 0; j <noOfColumns ; j++) {
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+" ");
            }
            System.out.println();
        }*/


        /*for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.print(cell.toString()+" ");
            }
            System.out.println();
        }*/

    }

    @SneakyThrows
    public void sampleSearchExcel() {
        String filePath = "src/main/resources/testData.xlsx";

        String toSearch = "coresystem";
        int searchColumn = 7; // column H
        List<Row> results = new ArrayList<Row>();

        DataFormatter dataFormatter = new DataFormatter();
        Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
        FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) { // iterate over all rows in the sheet
            Cell cellInSearchColumn = row.getCell(searchColumn); // get the cell in seach column (H)
            if (cellInSearchColumn != null) { // if that cell is present
                String cellValue = dataFormatter.formatCellValue(cellInSearchColumn, formulaEvaluator); // get string cell value
                if (toSearch.equalsIgnoreCase(cellValue)) { // if cell value equals the searched value
                    results.add(row); // add that row to the results
                }
            }
        }

        // print the results
        System.out.println("Found results:");
        for (Row row : results) {
            int rowNumber = row.getRowNum() + 1;
            System.out.print("Row " + rowNumber + ":\t");
            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell, formulaEvaluator);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }

        workbook.close();
    }
}
