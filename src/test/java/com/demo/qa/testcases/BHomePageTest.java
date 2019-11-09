package com.demo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.demo.qa.BaseUtility.TestBase;
import com.demo.qa.Utility.TestUtil;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LoginPage;
import com.demo.qa.pages.StudentsPage;

public class BHomePageTest extends TestBase
{
	LoginPage Login_page;
	HomePage Home_Page;	
	StudentsPage Students_Page;

	public  BHomePageTest()
	{
	super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Initialisation();
		Login_page = new LoginPage();	
		Home_Page = Login_page.Login(prop.getProperty("Username"),prop.getProperty("Password"));
	}
	
	@Test(priority=1)
	public void Validate_Page_Title()
	{
		Assert.assertEquals(Home_Page.Get_Page_Title(), "MyELT | Online English Language Learning | Home","Home Page Title Not Matched");
	}
	
	@Test(priority=2)
	public void Is_Student_Tab_Displayed()
	{
		Assert.assertTrue(Home_Page.Students_Tab(),"StudentsTab is not Displayed");
	}
	
	@Test(priority=3)
	public void Open_Students_Tab()
	{
		Students_Page = Home_Page.Click_On_Students_Tab();
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
