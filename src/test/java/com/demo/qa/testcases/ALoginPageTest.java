package com.demo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;


import com.demo.qa.BaseUtility.TestBase;
import com.demo.qa.Utility.TestUtil;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LoginPage;

public class ALoginPageTest extends TestBase
{

	LoginPage Login_Page;
	HomePage Home_Page;
	TestUtil test_utility;

	public ALoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		Initialisation();
		Login_Page = new LoginPage();
	}
	
	@Test(priority=1)
	public void IsPageLogoDisplayed()
	{
		Assert.assertTrue(Login_Page.Is_Logo_Displayed(),"The Page Logo is Not Displayed");
		System.out.println("Page logo displayed");
	}
	
	@Test(priority=2)
	public void Validate_Page_Title()
	{
		Assert.assertEquals(Login_Page.Get_LoginPage_Title(),"MyELT | Online English Language Learning","The Page Title does not match.");
	}
	
	@Test(priority=3)
	public void Login()
	{
		Home_Page = Login_Page.Login(prop.getProperty("Username"),prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void TearDown()
	{
		TestUtil.Quit_Driver();
	}
	
	
}
