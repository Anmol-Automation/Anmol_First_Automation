package com.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.qa.BaseUtility.TestBase;
import com.demo.qa.Utility.TestUtil;

public class HomePage extends TestBase
{
	
	//Page Factory	
	@FindBy(xpath="//span[contains(text(),'Courses')]")
	WebElement Courses;
	
	@FindBy(xpath="//span[contains(text(),'Students')]")
	WebElement Students;
	
	@FindBy(xpath="//a[contains(text(),'Gradebook')]")
	WebElement GradeBook;
	
	@FindBy(xpath="//a[contains(text(),'Assignments')]")
	WebElement Assignments;
	
	@FindBy(xpath="//a[contains(text(),'All Activities')]")
	WebElement AllActivities;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Get_Page_Title()
	{
		return driver.getTitle();
	}

	public StudentsPage Click_On_Students_Tab()
	{
		Students.click();
		return new StudentsPage();
	}
	
	public boolean Students_Tab()
	{
		return TestUtil.Is_Element_Displayed(Students);
	}
	
}
