package selainum_packge.Tests;

import org.testng.annotations.Test;


import Data.LoadRegisterData;
import selainum_packge.Pages.CartPage;
import selainum_packge.Pages.HomePage;
import selainum_packge.Pages.RegisterPage;


import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Checkout_NegativeSenario extends TestBase{
	
	HomePage homeObject = new HomePage(driver);
	CartPage CartObject = new CartPage(driver);
	RegisterPage registerobject = new RegisterPage(driver);
	String name = LoadRegisterData.userData.getProperty("name");
	String Exist_email = LoadRegisterData.userData.getProperty("emailExist");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 @Test (priority = 1)
 public void Registerwhilecheckout_Negative() throws InterruptedException {
	 Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript(
		"let subject = document.getElementsByClassName('btn btn-default add-to-cart')[0];" +
		"subject.scrollIntoView({ behavior: 'smooth' });"
	 );
	 Thread.sleep(2000);
	 CartObject.choseproduct();
	 registerobject.userCanRegister(name,Exist_email);
 	 Assert.assertEquals("Email Address already exist!", registerobject.failedMessage.getText());
 }
 
 
}
