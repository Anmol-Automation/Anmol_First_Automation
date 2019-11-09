package com.demo.qa.BaseUtility;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.demo.qa.Utility.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop = new Properties();
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("C:\\Users\\Anmol Aggarwal\\eclipse-workspace\\NaveenAutomationLabs\\AutomationUsingPOM\\src\\main\\java\\com\\demo\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Initialisation()
	{
		String BrowserName = prop.getProperty("Browser");
		
		if(BrowserName.equalsIgnoreCase("Chrome") || (BrowserName.equalsIgnoreCase("Google Chrome")) || (BrowserName.equalsIgnoreCase("GoogleChrome")) )
			{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Anmol Aggarwal\\eclipse-workspace\\NaveenAutomationLabs\\AutomationUsingPOM\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		
		else if(BrowserName.equalsIgnoreCase("FireFox") || (BrowserName.equalsIgnoreCase("Mozilla Firefox")) || (BrowserName.equalsIgnoreCase("FF")) )
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Anmol Aggarwal\\eclipse-workspace\\NaveenAutomationLabs\\AutomationUsingPOM\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}		
		
		TestUtil.Maximize_Window();
		TestUtil.Delete_All_Cookies();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);		
	}
	

}
