package com.tranquyet.service.excel;

import com.tranquyet.util.constant.excel.TableExcelValueConstant;
import com.tranquyet.util.excel.table.ComponentExcel;
import com.tranquyet.util.excel.table.ListStudentTable;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;


/**
 * ExcelService will get the request from client to create Excel file consist of List StudentDTO Sheet and Graph Sheet
 *
 * @author tranquyet
 */
public class ExcelService {

    /**
     * createDataExcel: create Sheet for Excel file comprise the List StudentDTO Sheet and Graph StudentDTO Sheet
     * where
     * List StudentDTO Sheet would draw the table contain the value of student
     * Chart Sheet would draw a bar chart describe the same year of birth of student
     */
    public ByteArrayInputStream createDataExcel() {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet studentSheet = wb.createSheet(TableExcelValueConstant.LIST_STUDENT_SHEET_EXCEL); // create List StudentDTO Sheet
        ComponentExcel componentExcelInstance = ComponentExcel.getInstance(); // create instance to use style for cell and border of table in Excel file

        ListStudentTable.createPage(studentSheet, componentExcelInstance, wb);

        ByteArrayInputStream input = customersToExcel(wb);
        return input;

    }

    public static ByteArrayInputStream customersToExcel(Workbook workbook) {
        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
