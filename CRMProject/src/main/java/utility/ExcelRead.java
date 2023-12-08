package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelRead {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;	


public static Object[][] getDataFromExcel(String filePath, String sheetName) throws InvalidFormatException, IOException
			 {//here getting excel data to an 2D(3x2) array using getDataFromExcel(path,value)
		// init
		Object[][] data;
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		
		Workbook wb = WorkbookFactory.create(inputStream);
		Sheet s = wb.getSheet(sheetName);

		// sheet range
		int rowCount = s.getLastRowNum();//count row
		int colCount = s.getRow(0).getLastCellNum();//count column

		// set data

		data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j <= colCount - 1; j++) {
				if (!getCellValue(s, 0, j).equals("")) {
					data[i - 1][j] = getCellValue(s, i, j);
				}
			}
		}
	
		return data;
	}

// Get cell value at given row and column
	
	private static String getCellValue(Sheet sheet, int row, int col) {
		String value = "";
		if (sheet.getRow(row).getCell(col) == null) {
			value = "";
		} else if (sheet.getRow(row).getCell(col).getCellType() == Cell.CELL_TYPE_STRING) {
			value = sheet.getRow(row).getCell(col).getStringCellValue();
		} else {
			sheet.getRow(row).getCell(col).setCellType(Cell.CELL_TYPE_STRING);
			value = sheet.getRow(row).getCell(col).getStringCellValue();
		}
		return value;
	}

	public static String getNumeric(int i, int j, String sheet) {
		String file_path = Constants.testData;
		try {
		f = new FileInputStream(file_path);
		} catch (FileNotFoundException e) {

		e.printStackTrace();
		}
		try {
		wb = new XSSFWorkbook(f);
		} catch (IOException e) {

		e.printStackTrace();
		}
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int value = (int) c.getNumericCellValue();
		return String.valueOf(value);
		}
	public static String getString(int i, int j, String sheet) {
		String file_path = Constants.testData;
		try {
		f = new FileInputStream(file_path);
		} catch (FileNotFoundException e) {

		e.printStackTrace();
		}
		try {
		wb = new XSSFWorkbook(f);
		} catch (IOException e) {

		e.printStackTrace();
		}
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
		}


}
