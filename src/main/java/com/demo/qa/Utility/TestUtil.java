package com.demo.qa.Utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

import com.demo.qa.BaseUtility.*;

public class TestUtil extends TestBase
{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static Workbook book;
	public static Sheet sheet;
	
	public static String Test_Data_File_Path = "C:\\Users\\Anmol Aggarwal\\eclipse-workspace\\NaveenAutomationLabs\\AutomationUsingPOM\\src\\main\\java\\com\\demo\\qa\\TestData\\MyELT_Test_Data_Sheet.xlsx";

	public static void Maximize_Window()
	{
		driver.manage().window().maximize();
	}
		
	public static void Close_Window()
	{
		driver.close();
	}
	
	public static void Delete_All_Cookies()
	{
		driver.manage().deleteAllCookies();
	}
	
	public static void Quit_Driver()
	{
		driver.quit();
	}
	
	public static void Close_Driver()
	{
		driver.close();
	}
	
	public static boolean Is_Element_Displayed(WebElement e)
	{
		return e.isDisplayed();
	}
	
	
	public static Object[][] Read_TestData_From_ExcelSheet(String SheetName)
	{
		FileInputStream fin =null;
		try {
			 fin = new FileInputStream(Test_Data_File_Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fin);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(SheetName);
		
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}		
		return data;		
	}
	

}
