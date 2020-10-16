package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;

public class LoginPage extends BaseTest
{

	@FindBy(xpath="//div[@class='inputs']/input[@class='email']")
	WebElement email;
	
	@FindBy(xpath="//div[@class='inputs']/input[@class='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='buttons']/input[@class='button-1 login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//div[@class='page-title']/h1")
	WebElement headerTitle;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[2]/label")
	WebElement emailcheck;
	
	
	//Initializing the Page Objects:
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Validating header in Login page
	public String validateLoginPageTitle() 
	{	
		return headerTitle.getText();	
	}
	
	//Click on login by entering the valid credentials
	public void login(String mailId, String pwd)
	{
		email.sendKeys(mailId);
		password.sendKeys(pwd);
		loginBtn.click();
	}
}
