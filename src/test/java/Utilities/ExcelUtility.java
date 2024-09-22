package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	String path;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	/*public ExcelUtility(String path) {
		this.path=path;
	}*/
	
	public  int getRowCount(String file, String sheetName) throws IOException {
		
		try {
			fis=new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Invalid xml file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}
	public  int getColumnCount(String file, String sheetName,int rowNo) throws IOException {
		
		try {
			fis=new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Invalid xml file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNo);
		int columCount=row.getLastCellNum();
		workbook.close();
		fis.close();
		return columCount;
	}
	public int getData() {
		return 0;
		
	}
	public static void main(String[] args) throws IOException {
		ExcelUtility obj=new ExcelUtility();
		int count=obj.getRowCount("./testdata/Book.xlsx", "Sheet1");
		int countColumn=obj.getColumnCount("./testdata/Book.xlsx", "Sheet1",3);
		System.out.println(count);
		System.out.println(countColumn);
	}	
		
		
	

}
