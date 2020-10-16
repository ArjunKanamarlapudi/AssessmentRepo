package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;

public class HomePage extends BaseTest
{

	@FindBy(xpath = "//div[@class='header-links']/ul/li[2]/a")
	WebElement login;
	
	
	//Initializing the Page Objects:
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginLink()
	{
		//Click on Login button
		login.click();
	}
}
