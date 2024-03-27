package Priyankaacademy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Priyankaacademy.pageobjects.CartPage;
import Priyankaacademy.pageobjects.CheckoutPage;
import Priyankaacademy.pageobjects.ConfirmationPage;
import Priyankaacademy.pageobjects.ProductCatalogue;
import TestComponents.Baseclass;
import TestComponents.FailedTestCases;

import org.testng.annotations.Test;

public class ErrorValidations extends Baseclass{
	
	@Test(groups= {"error"},retryAnalyzer=FailedTestCases.class) 
	public void ErrorCode() {
	 String productName = "ZARA COAT 3";
     //LandingPage landingPage = launchApplication();
		//LandingPage landingPage = new  LandingPage(driver);
		//landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iaming@000");
		 Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
		


}
	
	
	


}
