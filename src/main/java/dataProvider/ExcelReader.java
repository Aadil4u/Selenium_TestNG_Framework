package dataProvider;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelReader {

    static XSSFWorkbook wb;

    public static Object[][] getDataFromSheet(String sheetName) {
        Object[][] arr = null;
        try {
            wb = new XSSFWorkbook("./testdata/Login Data.xlsx");
            XSSFSheet sheet = wb.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int columns = sheet.getRow(0).getPhysicalNumberOfCells();
            arr = new Object[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    arr[i][j] = getData(sheetName, i, j);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load the file" + e.getMessage());
        }

        return arr;
    }


    public static Object[][] getDataFromSheet(String sheetName, String path) {
        Object[][] arr = null;
        try {
            wb = new XSSFWorkbook(path);
            XSSFSheet sheet = wb.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int columns = sheet.getRow(0).getPhysicalNumberOfCells();
            arr = new Object[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    arr[i][j] = getData(sheetName, i, j);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load the file" + e.getMessage());
        }

        return arr;
    }

    public static Object[][] getDataFromSheetWithHeaders(String sheetName, String path) {
        Object[][] arr = null;
        try {
            wb = new XSSFWorkbook(path);
            XSSFSheet sheet = wb.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int columns = sheet.getRow(0).getPhysicalNumberOfCells();
            arr = new Object[rows - 1][columns];
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    arr[i - 1][j] = getData(sheetName, i, j);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load the file" + e.getMessage());
        }

        return arr;
    }

    public static String getData(String sheetName, int row, int column) {
        XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(column);
        String data = "";
        CellType cellType = cell.getCellType();
        if (cellType == CellType.STRING) {
            data = cell.getStringCellValue();
        } else if (cellType == CellType.NUMERIC) {
            data = String.valueOf(cell.getNumericCellValue());
        } else if (cellType == CellType.BLANK) {
            data = "";
        }

        return data;

    }
}
