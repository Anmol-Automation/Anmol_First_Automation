package com.demo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import com.demo.qa.BaseUtility.TestBase;
import com.demo.qa.Utility.TestUtil;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LoginPage;
import com.demo.qa.pages.StudentsPage;

public class CStudentPageTest extends TestBase
{
	LoginPage Login_Page;
	HomePage Home_Page;
	StudentsPage Students_Page;
	TestUtil testutil;

	public CStudentPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Initialisation();
		Login_Page = new LoginPage();
		System.out.println("Logined");
		Home_Page = Login_Page.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		System.out.println("HomePage");
		Students_Page = Home_Page.Click_On_Students_Tab();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{ System.out.println("0");
		Object [][] data = TestUtil.Read_TestData_From_ExcelSheet("StudentAccount");
		return data;
	}
	
	@Test(priority=1,dataProvider="getData")
	public void CreateAccount(String username,String firstname,String middlename,String lastname,String password,String confirmpassword,String email,String re_email)
	{
		Assert.assertTrue(Students_Page.Is_Create_Student_Account_Tab_Displayed());
		Students_Page.Create_Student_Account(username,firstname,middlename,lastname,password,confirmpassword,email,re_email);
		Assert.assertEquals(Students_Page.GetAccountUserName(),'"'+username+'"');
		Assert.assertFalse(Students_Page.Account_Already_Created_By_This_Username());
		Assert.assertTrue(Students_Page.Is_Successfull_New_Account_Created());
		Assert.assertTrue(Students_Page.Is_Close_Icon_Displayed());
		Students_Page.Click_On_Close_Icon();
	}
	
	@AfterMethod()
	public void TearDown()
	{
		TestUtil.Quit_Driver();
	}
	
}
