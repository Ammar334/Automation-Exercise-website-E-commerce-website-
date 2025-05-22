package selainum_packge.Tests;

import org.testng.annotations.Test;


import Data.LoadRegisterData;
import selainum_packge.Pages.HomePage;
import selainum_packge.Pages.RegisterPage;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterTests_PositiveScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	RegisterPage registerObject = new RegisterPage(driver);
	String name = LoadRegisterData.userData.getProperty("name");
	String email = LoadRegisterData.userData.getProperty("email");
	String password = LoadRegisterData.userData.getProperty("password");
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
	
	
    @Test (priority = 1)
    public void testRegister_NewEmail_MandarotyAndOptional() throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	
    	homeObject.openRegisterationPage();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	  	wait.until(ExpectedConditions.visibilityOf(registerObject.newUserMessage));
    	Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
    	

    	registerObject.userCanRegister(name,email);
    	wait.until(ExpectedConditions.visibilityOf(registerObject.enterAccountMessage));
    	Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerObject.enterAccountMessage.getText());///الطريقة الاولي

    	registerObject.enterAccountInformation(password,day,month,year,
								    		   firstName,lastName,company,address,
								    		   country,state,city,zipcode,mobileNumber);
    	wait.until(ExpectedConditions.visibilityOf(registerObject.successMessage));
    	Assert.assertTrue(registerObject.successMessage.getText().equalsIgnoreCase("Account Created!"));/// الطريقة الثانية
    	
    	registerObject.continueAccount();
    	
    	wait.until(ExpectedConditions.visibilityOf(registerObject.loggedInLink));
    	Assert.assertEquals("Logged in as "+name, registerObject.loggedInLink.getText());
    	
    	registerObject.deleteAccount();

    	String deleteText = "Account Deleted!";
    	wait.until(ExpectedConditions.visibilityOf(registerObject.deleteMessage));
    	Assert.assertEquals(deleteText.toUpperCase(), registerObject.deleteMessage.getText());/// الطريقة الثالثة
    	
    	registerObject.continueAccount();
    }
    
    @Test (priority = 2,dependsOnMethods = {"testRegister_NewEmail_MandarotyAndOptional"})
    public void testRegister_NewEmail_Mandaroty() throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	
    	homeObject.openRegisterationPage();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	  	wait.until(ExpectedConditions.visibilityOf(registerObject.newUserMessage));
    	Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
    	
    	registerObject.userCanRegister(name,email);
    	wait.until(ExpectedConditions.visibilityOf(registerObject.enterAccountMessage));
    	Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerObject.enterAccountMessage.getText());///الطريقة الاولي
    	
    	registerObject.enterAccountInformation(password,day,month,year,
								    		   firstName,lastName,company,address,
								    		   country,state,city,zipcode,mobileNumber);
    	
    	wait.until(ExpectedConditions.visibilityOf(registerObject.successMessage));
    	Assert.assertTrue(registerObject.successMessage.getText().equalsIgnoreCase("Account Created!"));/// الطريقة الثانية
    	
    	registerObject.continueAccount();
    	wait.until(ExpectedConditions.visibilityOf(registerObject.loggedInLink));
    	Assert.assertEquals("Logged in as "+name, registerObject.loggedInLink.getText());
    	
    	registerObject.deleteAccount();
    	
    	String deleteText = "Account Deleted!";
    	wait.until(ExpectedConditions.visibilityOf(registerObject.deleteMessage));
    	Assert.assertEquals(deleteText.toUpperCase(), registerObject.deleteMessage.getText());/// الطريقة الثالثة
    	
    	registerObject.continueAccount();
    }

}
