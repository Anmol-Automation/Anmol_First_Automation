package com.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demo.qa.BaseUtility.TestBase;
import com.demo.qa.Utility.TestUtil;

public class StudentsPage extends TestBase
{
	TestUtil testutil;

	//Page Factory
	
	@FindBy(xpath="//a[contains(text(),'Create Student Account')]")
	WebElement Create_Student_Account;
	
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
	
	@FindBy(xpath="//select[@id='userType']")
	WebElement UserType;
	
	@FindBy(xpath="//input[contains(@id,'userName')]")
	WebElement Username;
	
	@FindBy(xpath="//input[contains(@id,'firstName')]")
	WebElement FirstName;
	
	@FindBy(xpath="//input[contains(@id,'middle')]")
	WebElement MiddleName;
	
	@FindBy(xpath="//input[contains(@id,'lastName')]")
	WebElement LastName;
	
	@FindBy(xpath="//span[contains(text(),'Minimum')]//..//input[contains(@id,'password')]")
	WebElement Password;
	
	@FindBy(xpath="//span[contains(text(),'mismatch')]//..//input[contains(@id,'password')]")
	WebElement Confirm_Password;
	
	@FindBy(id="email")
	WebElement UserEmail;
	
	@FindBy(id="email2")
	WebElement ReTypeUserEmail;
	
	@FindBy(xpath="//a[contains(text(),'Add user')]")
	WebElement Add_User_Button;
	
	@FindBy(xpath="//div[contains(@class,'errorMessage')]//strong")
	WebElement Account_Username;
	
	@FindBy(xpath="//div[contains(@class,'errorMessage')]")
	WebElement Account_Creation_Alert;
	
	@FindBy(xpath="//i[@title='Close']")
	WebElement Close_Icon;
	
	public StudentsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//Actions
	public boolean Is_Create_Student_Account_Tab_Displayed()
	{
		return TestUtil.Is_Element_Displayed(Create_Student_Account);
	}
	
	public void Create_Student_Account(String username,String firstname,String middlename,String lastname,String password,String confirmpassword,String email,String re_email)
	{
		
		
		Create_Student_Account.click();
		Select s = new Select(UserType);
		s.selectByVisibleText(prop.getProperty("AccountType"));
		
		Username.sendKeys(username);
		FirstName.sendKeys(firstname);
		MiddleName.sendKeys(middlename);
		LastName.sendKeys(lastname);
		Password.sendKeys(password);
		Confirm_Password.sendKeys(confirmpassword);
		UserEmail.sendKeys(email);
		ReTypeUserEmail.sendKeys(re_email);
		
//		Username.sendKeys(prop.getProperty("AccountUserName"));
//		FirstName.sendKeys(prop.getProperty("AccountFirstName"));
//		MiddleName.sendKeys(prop.getProperty("AccountMiddleName"));
//		LastName.sendKeys(prop.getProperty("AccountLastName"));	
//		Password.sendKeys(prop.getProperty("AccountPassword"));
//		Confirm_Password.sendKeys(prop.getProperty("AccountPassword"));
//		UserEmail.sendKeys(prop.getProperty("AccountEmail"));
//		ReTypeUserEmail.sendKeys(prop.getProperty("AccountEmail"));
		Add_User_Button.click();
	}
	
	public boolean Is_Successfull_New_Account_Created()
	{
		 Boolean flag = false;
		 String Text = Account_Creation_Alert.getText();
		 if(Text.contains(" has been created successfully."))
		 flag=true;
		 return flag;
	}
	
	public boolean Account_Already_Created_By_This_Username()
	{
		 Boolean flag = false;
		 String Text = Account_Creation_Alert.getText();
		 if(Text.contains(" is already in use."))
		 flag=true;
		 return flag;
	}
	
	public String GetAccountUserName()
	{
		return Account_Username.getText();
	}
	
	public boolean Is_Close_Icon_Displayed()
	{
		return TestUtil.Is_Element_Displayed(Close_Icon);
	}
	
	public void Click_On_Close_Icon()
	{
		Close_Icon.click();
	}
	
	
}
