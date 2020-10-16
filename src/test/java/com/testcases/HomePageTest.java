package com.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;

public class HomePageTest extends BaseTest
{
	
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage= new HomePage();
	}
	
	
	//Click on Login button
	@Test
	public void clickLoginButton() throws InterruptedException
	{
		homePage.clickOnLoginLink();
		
	}
}
