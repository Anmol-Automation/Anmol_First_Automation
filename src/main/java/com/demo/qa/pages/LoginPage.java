package com.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.qa.BaseUtility.TestBase;

public class LoginPage extends TestBase
{

	//Page Factory
	@FindBy(xpath="//span[@id='dynamicFieldLogin']//input")
	WebElement username;
	
	@FindBy(xpath="//span[@id='dynamicFieldPasswd']//input")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement SignIn_Button;

	@FindBy(xpath="//img[contains(@src,'MyELT')]")
	WebElement Logo;
	
	
	//Now initialize page factory
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions that can be performed on that page
	
	public String Get_LoginPage_Title()
	{
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public boolean Is_Logo_Displayed()
	{
		System.out.println(driver.getTitle());
		return Logo.isDisplayed();
	}
	
	public String Get_Page_Title()
	{
		return driver.getTitle();
	}
	
	public HomePage Login(String Username,String Password)
	{
		username.sendKeys(Username);
		password.sendKeys(Password);
	    SignIn_Button.click();
	    return new HomePage();
	}

}
