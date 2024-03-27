package Priyankaacademy.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Priyankaacademy.pageobjects.CartPage;
import Priyankaacademy.pageobjects.CheckoutPage;
import Priyankaacademy.pageobjects.ConfirmationPage;
import Priyankaacademy.pageobjects.LandingPage;
import Priyankaacademy.pageobjects.OrderPage;
import Priyankaacademy.pageobjects.ProductCatalogue;
import TestComponents.Baseclass;

public class SubmitOrderTest extends Baseclass  {

	String productName = "ZARA COAT 3";
	
	
	@Test(dataProvider="getdata",groups= {"purchase"})
	public void submitOrder(HashMap<String, String> Input) throws IOException, InterruptedException {
	//public void submitOrder(String email, String password, String productName) throws IOException, InterruptedException {
	
		
	  
       //LandingPage landingPage = launchApplication();
		//LandingPage landingPage = new  LandingPage(driver);
		//landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication(Input.get("email"), Input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(Input.get("Product"));
		
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(Input.get("Product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
		
	}
	

	@DataProvider
	public  Object[][] getdata() {
		
		HashMap<String,String>newobj = new HashMap<String,String>();
		
		newobj.put("email", "anshika@gmail.com");
		newobj.put("password", "Iamking@000");
		newobj.put("Product", "ZARA COAT 3");
		
		
		HashMap<String,String>newobj1 = new HashMap<String,String>();
		
		
		newobj1.put("email", "anshika@gmail.com");
		newobj1.put("password", "Iamking@000");
		newobj1.put("Product", "ADIDAS ORIGINAL");
		
		
		return new Object[] [] {{newobj},{newobj1}};
		
		
  // return new Object[][] {{"anshika@gmail.com", "Iamking@000", "ZARA COAT 3"},{"shetty@gmail.com","IamKing@000", "ADIDAS ORIGINAL"} };
		
 
		
		
	}
	
	
	



	
		
	}
	



