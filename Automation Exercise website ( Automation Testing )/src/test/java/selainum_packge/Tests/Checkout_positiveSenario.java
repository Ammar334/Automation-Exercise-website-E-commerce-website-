package selainum_packge.Tests;

import org.testng.annotations.Test;


import Data.LoadRegisterData;
import selainum_packge.Pages.CartPage;
import selainum_packge.Pages.HomePage;
import selainum_packge.Pages.LoginPage;
import selainum_packge.Pages.ProductsPage;
import selainum_packge.Pages.RegisterPage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Checkout_positiveSenario extends TestBase{
	
	HomePage homeObject = new HomePage(driver);
	CartPage CartObject = new CartPage(driver);
	LoginPage loginObject = new LoginPage(driver);
	ProductsPage ProductObject = new ProductsPage(driver);
	RegisterPage registerobject = new RegisterPage(driver);
	String name = LoadRegisterData.userData.getProperty("name");
	String emailExist = LoadRegisterData.userData.getProperty("emailExist");
	String password = LoadRegisterData.userData.getProperty("password");
	String email = LoadRegisterData.userData.getProperty("email");
	int day = Integer.parseInt(LoadRegisterData.userData.getProperty("day"));
	String month = LoadRegisterData.userData.getProperty("month");
	String year = LoadRegisterData.userData.getProperty("year");
	String firstName = LoadRegisterData.userData.getProperty("firstname");
	String lastName = LoadRegisterData.userData.getProperty("lastname");
	String company = LoadRegisterData.userData.getProperty("company");
	String address = LoadRegisterData.userData.getProperty("address");
	String country = LoadRegisterData.userData.getProperty("country");
	String state = LoadRegisterData.userData.getProperty("state");
	String city = LoadRegisterData.userData.getProperty("city");
	String zipcode = LoadRegisterData.userData.getProperty("zipcode");
	String mobileNumber = LoadRegisterData.userData.getProperty("mobileNumber");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
 @Test (priority = 1)
 public void Registerwhilecheckout_with_notExistantEmail() throws InterruptedException {
	 Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript(
		"let subject = document.getElementsByClassName('btn btn-default add-to-cart')[0];" +
		"subject.scrollIntoView({ behavior: 'smooth' });"
	 );
	 Thread.sleep(2000);
	 CartObject.choseproduct();
	 registerobject.userCanRegister(name, email);
	 wait.until(ExpectedConditions.visibilityOf(registerobject.enterAccountMessage));
 	 Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerobject.enterAccountMessage.getText());
	 registerobject.enterAccountInformation(password, day, month, year, firstName, lastName, company, address, country, state, city, zipcode, address);
	 wait.until(ExpectedConditions.visibilityOf(registerobject.successMessage));
 	 Assert.assertTrue(registerobject.successMessage.getText().equalsIgnoreCase("Account Created!"));/// الطريقة الثانية
 	
 	 registerobject.continueAccount();
 	 wait.until(ExpectedConditions.visibilityOf(registerobject.loggedInLink));
 	 Assert.assertEquals("Logged in as "+name, registerobject.loggedInLink.getText());
   	 homeObject.openCartPage();
   	 CartObject.FULLAddProductAndBuyafterReg(city, firstName, mobileNumber, address, month, year);
   	 wait.until(ExpectedConditions.visibilityOf(CartObject.PlacedOrdersuccessMassage));
   	 Assert.assertEquals("ORDER PLACED!",CartObject.PlacedOrdersuccessMassage.getText());
   	 CartObject.clickContinueAfterRegCart();
   	 registerobject.deleteAccount();

   	 String deleteText = "Account Deleted!";
   	 wait.until(ExpectedConditions.visibilityOf(registerobject.deleteMessage));
   	 Assert.assertEquals(deleteText.toUpperCase(), registerobject.deleteMessage.getText());
   	 registerobject.continueAccount();
 }
 @Test (priority = 2)
 public void Registerbeforecheckout_with_ExistantEmail() throws InterruptedException {
	 Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
	 homeObject.openLoginPage();
	 registerobject.userCanRegister(name, email);
	 wait.until(ExpectedConditions.visibilityOf(registerobject.enterAccountMessage));
 	 Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerobject.enterAccountMessage.getText());
	 registerobject.enterAccountInformation(password, day, month, year, firstName, lastName, company, address, country, state, city, zipcode, address);
	 wait.until(ExpectedConditions.visibilityOf(registerobject.successMessage));
 	 Assert.assertTrue(registerobject.successMessage.getText().equalsIgnoreCase("Account Created!"));/// الطريقة الثانية
 	 registerobject.continueAccount();
 	 wait.until(ExpectedConditions.visibilityOf(registerobject.loggedInLink));
 	 Assert.assertEquals("Logged in as "+name, registerobject.loggedInLink.getText());
	 homeObject.openProductsPage();
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript(
		"let subject = document.getElementsByClassName('btn btn-default add-to-cart')[0];" +
		"subject.scrollIntoView({ behavior: 'smooth' });"
	 );
	 Thread.sleep(2000);
	 CartObject.AddToChartBtn.click();
	 wait.until(ExpectedConditions.visibilityOf(CartObject.ViewCartBtn));
	 CartObject.ViewCartBtn.click();
	 CartObject.FULLAddProductAndBuyafterReg(city, firstName, mobileNumber, address, month, year);
	 wait.until(ExpectedConditions.visibilityOf(CartObject.PlacedOrdersuccessMassage));
   	 Assert.assertEquals("ORDER PLACED!",CartObject.PlacedOrdersuccessMassage.getText());
   	 CartObject.clickContinueAfterRegCart();
  	 registerobject.deleteAccount();

  	 String deleteText = "Account Deleted!";
  	 wait.until(ExpectedConditions.visibilityOf(registerobject.deleteMessage));
  	 Assert.assertEquals(deleteText.toUpperCase(), registerobject.deleteMessage.getText());
  	 registerobject.continueAccount();
  	 
 }
 
 @Test (priority = 3)
 public void loginbeforecheckout_with_ExistantEmail() throws InterruptedException {
	 Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
	 homeObject.openLoginPage();
	 wait.until(ExpectedConditions.visibilityOf(loginObject.loginMessage));
	 Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
	 loginObject.userCanLogin(emailExist, password);
 	 wait.until(ExpectedConditions.visibilityOf(loginObject.logoutBtn));
 	 Assert.assertEquals("Logout", loginObject.logoutBtn.getText()); 
	 homeObject.openProductsPage();
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript(
		"let subject = document.getElementsByClassName('btn btn-default add-to-cart')[0];" +
		"subject.scrollIntoView({ behavior: 'smooth' });"
	 );
	 Thread.sleep(2000);
	 CartObject.AddToChartBtn.click();
	 wait.until(ExpectedConditions.visibilityOf(CartObject.ViewCartBtn));
	 CartObject.ViewCartBtn.click();
	 CartObject.FULLAddProductAndBuyafterReg(city, firstName, mobileNumber, address, month, year);
	 wait.until(ExpectedConditions.visibilityOf(CartObject.PlacedOrdersuccessMassage));
   	 Assert.assertEquals("ORDER PLACED!",CartObject.PlacedOrdersuccessMassage.getText());
   	 CartObject.clickContinueAfterRegCart();
  	 registerobject.deleteAccount();

  	 String deleteText = "Account Deleted!";
  	 wait.until(ExpectedConditions.visibilityOf(registerobject.deleteMessage));
  	 Assert.assertEquals(deleteText.toUpperCase(), registerobject.deleteMessage.getText());
  	 registerobject.continueAccount();
  	 
 }
 public void Verifyaddressincheckout() throws InterruptedException {
	 Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
	 homeObject.openRegisterationPage();
	 registerobject.userCanRegister(name, email);
	 wait.until(ExpectedConditions.visibilityOf(registerobject.enterAccountMessage));
 	 Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerobject.enterAccountMessage.getText());
	 registerobject.enterAccountInformation(password, day, month, year, firstName, lastName, company, address, country, state, city, zipcode, address);
	 wait.until(ExpectedConditions.visibilityOf(registerobject.successMessage));
 	 Assert.assertTrue(registerobject.successMessage.getText().equalsIgnoreCase("Account Created!"));/// الطريقة الثانية
 	 registerobject.continueAccount();
 	 wait.until(ExpectedConditions.visibilityOf(registerobject.loggedInLink));
 	 Assert.assertEquals("Logged in as "+name, registerobject.loggedInLink.getText());
	 homeObject.openProductsPage();
	 CartObject.AddToChartBtn.click();
	 homeObject.openCartPage();
	 CartObject.ProceedToCheckoutBtn.click();	    
	 Assert.assertEquals(address, CartObject.deliveryaddress.getText());
	 Assert.assertEquals(address, CartObject.bilingaddress.getText());
	 JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript(
		"let subject = document.getElementsByName('message')[0];" +
        "subject.scrollIntoView({ behavior: 'smooth' });"
	 );
     CartObject.TextAreaTxt.sendKeys("zagazig");
     CartObject.PlaceOrderBtn.click();
     CartObject.nameOnCardTxt.sendKeys("Ammar");
     CartObject.cardnumberTxt.sendKeys("Ammar Yasser");
     CartObject.cvcTxt.sendKeys("322");
     CartObject.expirymonthTxt.sendKeys("12");
     CartObject.expiryyearTxt.sendKeys("2024");
     CartObject.PayandConfirmOrderBtn.click();
	 js.executeScript(
		"let subject = document.getElementsByClassName('btn btn-default add-to-cart')[0];" +
		"subject.scrollIntoView({ behavior: 'smooth' });"
	 );
	 Thread.sleep(2000);
	 
	
 	
   	 homeObject.openCartPage();
   	 CartObject.FULLAddProductAndBuyafterReg(city, firstName, mobileNumber, address, month, year);
   	 wait.until(ExpectedConditions.visibilityOf(CartObject.PlacedOrdersuccessMassage));
   	 Assert.assertEquals("ORDER PLACED!",CartObject.PlacedOrdersuccessMassage.getText());
   	 CartObject.clickContinueAfterRegCart();
   	 registerobject.deleteAccount();

   	 String deleteText = "Account Deleted!";
   	 wait.until(ExpectedConditions.visibilityOf(registerobject.deleteMessage));
   	 Assert.assertEquals(deleteText.toUpperCase(), registerobject.deleteMessage.getText());
   	 registerobject.continueAccount();
 }
 
}
