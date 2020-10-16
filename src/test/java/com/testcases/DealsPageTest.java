package com.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.DealsPage;


public class DealsPageTest extends BaseTest
{
	DealsPage dealspage;
	
	@BeforeMethod
	public void setUp() {	
		dealspage= new DealsPage();
	}
	
	//validating User Account
	@Test(priority=1)
	public void validateAccountId()
	{
		String fetchedId=dealspage.validateAccount();
		Assert.assertEquals(fetchedId, prop.getProperty("email"));
	}
	
	//Clearing cart
	@Test(priority=2)
	public void validateclearCart() throws InterruptedException
	{
		dealspage.clearCart();
	}
	
	@Test(priority=3)
	public void selectBooks() 
	{
		dealspage.selectABook();
	}
	
	@Test(priority=4)
	public void clickOnAddToCart()
	{
		dealspage.addToCart();
	}
	
	@Test(priority=5)
	public void clickOnCheckOut() throws InterruptedException
	{
		String val=dealspage.checkOut();
		Assert.assertEquals(val, "30.00");
	}
}
