package com.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;

public class LogInPageTest extends BaseTest
{
	LoginPage loginPage = new LoginPage();
	
	@BeforeMethod
	public void setUp() {	
		loginPage= new LoginPage();
	}
	
	//validating Login Page
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String header = loginPage.validateLoginPageTitle();
		Assert.assertEquals(header, "Welcome, Please Sign In!");
	}
	
	//Login with credentials
	@Test(priority=2)
	public void loginTest()
	{
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
}

