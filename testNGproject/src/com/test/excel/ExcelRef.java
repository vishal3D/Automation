package com.test.excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRef {
	
	static XSSFWorkbook Workbook;
	static XSSFSheet sheet;

	public ExcelRef(String sheetPath, String sheetName)throws IOException  {

		Workbook = new XSSFWorkbook(sheetPath);
		sheet = Workbook.getSheet(sheetName);

	}
	
	public String getStringData(int rawNum, int colNum) throws IOException {

		String value = sheet.getRow(rawNum).getCell(colNum).getStringCellValue();
	return value;
	}
	public void getNumericData(int rawNum, int colNum) throws IOException {

		double value = sheet.getRow(rawNum).getCell(colNum).getNumericCellValue();
		System.out.println(value);
	}
	public int getRawCount() {

		int count= sheet.getPhysicalNumberOfRows();
		return count;
		
	}
	public int getColCount() {

		int count= sheet.getRow(0).getPhysicalNumberOfCells();
		return count;
		
	}

}
