package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseTest;

public class DealsPage extends BaseTest
{

	@FindBy(xpath = "//div[@class='header-links']/ul/li[1]/a")
	WebElement accountID;
	
	@FindBy(xpath = "//div[@class='header-links']/ul/li[3]/a/span[2]")
	WebElement cart_qty;
	
	@FindBy(xpath = "//div[@class='block block-category-navigation']/div[2]/ul/li/a[@href ='/books']")
	WebElement books;
	
	@FindBy(xpath = "//div[@class='product-grid']/div[1]/div/div[1]/a/img")
	WebElement selectABook;	
	
	@FindBy(xpath = "//div[@class='product-price']/span")
	WebElement getPrice;
		
	@FindBy(xpath = "//div[@class='add-to-cart-panel']/input[@class='qty-input']")
	WebElement quantity;
	
	@FindBy(xpath = "//*[@id='add-to-cart-button-13']")
	WebElement addToCart;
	
	@FindBy(xpath = "//div[@id='bar-notification']/p")
	WebElement validatemsg;
	
	@FindBy(xpath = "//li[@id=\"topcartlink\"]/a/span[1]")
	WebElement shoppingCart;
	
	@FindBy(xpath = "//tr[@class='cart-item-row']/td/input[@name='removefromcart']")
	List<WebElement> remove_from_cart;
	
	@FindBy(xpath = "//div[@class='common-buttons']/input[1]")
	WebElement updateCart;
	
	@FindBy(xpath = "//div[@class='header-logo']/a/img")
	WebElement logo;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]/span/span")
	WebElement subTotalPrice;
	
	@FindBy(xpath = "//input[@id='termsofservice']")
	WebElement acceptTerms;	
	
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkOUt;
	
	
	//Initializing the Page Objects:
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Validating the User Account
	public String validateAccount() 
	{		
		return accountID.getText();	
	}
	
	//Clearing the cart
	public void clearCart() throws InterruptedException
	{
		String value=cart_qty.getText();
		System.out.println("cart qty is "+value);
		if(value.equals("(0)"))
		{
			System.out.println("Cart is empty to clear");
		}
		else
		{
			shoppingCart.click();
			for (WebElement element : remove_from_cart)
			{
				element.click();
			}
			updateCart.click();
		}
		
	}
	
	//Select A book from Books and enter the quantity
	public void selectABook()
	{	
		logo.click();
		books.click();
		selectABook.click();
		//Get the price details
		String priceValue=getPrice.getText();
		System.out.println("Price details:"+priceValue);
		quantity.click();
		quantity.clear();
		quantity.sendKeys("3");
			
	}
	
	//Clicking on Add to cart and validating the message
	public void addToCart()
	{
		addToCart.click();	
	}
	
	//Clicking on Check out and validating subtotal price
	public String checkOut()
	{	
		shoppingCart.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		String val = subTotalPrice.getText();
		System.out.println("Subtotal Price details after adding quantity:"+val);
		acceptTerms.click();
		checkOUt.click();	
		return val;
	}
}
