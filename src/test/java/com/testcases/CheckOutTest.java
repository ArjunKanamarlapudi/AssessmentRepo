package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.CheckOutPage;

public class CheckOutTest extends BaseTest
{
	
	CheckOutPage checkoutPage;
	
	@BeforeMethod
	public void setUp() {	
		checkoutPage= new CheckOutPage();
	}
	
	@Test(priority=1)
	public void selectBillingAddress() 
	{
		checkoutPage.billingAddress();
	}
	
	@Test(priority=2)
	public void selectShippingAddress() 
	{
		checkoutPage.shippingAddress();
	}
	
	@Test(priority=3)
	public void selectShippingMethod() 
	{
		checkoutPage.shippingMethod();
	}
	
	@Test(priority=4)
	public void selectPMethod() 
	{
		checkoutPage.paymentMethod();
	}
	
	@Test(priority=5)
	public void validatePaymentInfo() 
	{
		String message= checkoutPage.paymentInfo();
		Assert.assertEquals(message, "You will pay by COD");
	}
	
	@Test(priority=6)
	public void confirmOrder() 
	{
		checkoutPage.confirmTheOrder();
	}
	
	@Test(priority=7)
	public void validateOrder() 
	{
		String message=checkoutPage.validateOrder();
		Assert.assertEquals(message, "Your order has been successfully processed!");
	}
	
	@Test(priority=8)
	public void logout() 
	{
		checkoutPage.clickOnLogout();
	}
	
}
