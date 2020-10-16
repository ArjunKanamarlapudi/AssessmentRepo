package com.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.base.BaseTest;

public class CheckOutPage extends BaseTest
{

	@FindBy(xpath = "//select[@id='billing-address-select']")
	WebElement billingAddressID;
	
	@FindBy(xpath = "//div[@id='billing-buttons-container']/input")
	WebElement continu;
	
	@FindBy(xpath = "//select[@id='shipping-address-select']")
	WebElement shippingAddress;
	
	@FindBy(xpath = "//div[@id='shipping-buttons-container']/input")
	WebElement continu2;
	
	@FindBy(xpath = "//input[@id='shippingoption_1']")
	WebElement nextDayAir;
	
	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']/input")
	WebElement continu3;
	
	@FindBy(xpath = "//div[@id='checkout-payment-method-load']/div/div/ul/li[1]/div")
	WebElement selectCOD;
	
	@FindBy(xpath = "//div[@id='payment-method-buttons-container']/input[@class='button-1 payment-method-next-step-button']")
	WebElement continu4;
	
	
	@FindBy(xpath = "//div[@class='section payment-info']/div/table/tbody/tr/td/p")
	WebElement validatemsg;
	
	@FindBy(xpath = "//div[@id='payment-info-buttons-container']/input")
	WebElement continu5;
	
	@FindBy(xpath = "//div[@id='confirm-order-buttons-container']/input")
	WebElement confirmOrder;
	
	@FindBy(xpath = "//div[@class='title']/strong")
	WebElement order_successfull_message;
	
	@FindBy(xpath = "//div[@class='section order-completed']/ul/li[1]")
	WebElement order_number;
	
	@FindBy(xpath = "//div[@class='buttons']/input")
	WebElement continu6;
	
	@FindBy(xpath = "//div[@class='header-links']/ul/li[2]/a")
	WebElement logout;
	
	//Initializing the Page Objects:
	public CheckOutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Selecting the billing address
	public void billingAddress()
	{
		
		Select newAddress = new Select(billingAddressID);
		newAddress.selectByIndex(1); 
		continu.click();	
	}
	
	////Selecting the Shipping address
	public void shippingAddress()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Select newAddress = new Select(shippingAddress);
		newAddress.selectByIndex(1); 
		continu2.click();
	}
	
	//selecting Shipping Method
	public void shippingMethod()
	{
		nextDayAir.click();
		continu3.click();
	}
	
	//Selecting Payment Method
	public void paymentMethod()
	{	
		selectCOD.click();		
		continu4.click();
		
	}
	
	//Validating Payment Information
	public String paymentInfo()
	{
		continu5.click();
		return validatemsg.getText();
	}
	
	//Confirm the Order
	public void confirmTheOrder()
	{
		confirmOrder.click();
		
	}
	
	//Validating the Order details
	public String validateOrder()
	{
		System.out.println("Your"+order_number.getText());
		String message=order_successfull_message.getText();
		continu6.click();
		return message;
	}
	
	//Logout from the application
	public void clickOnLogout()
	{
		logout.click();
	}
}

