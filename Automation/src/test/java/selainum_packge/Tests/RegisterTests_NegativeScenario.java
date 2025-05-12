package selainum_packge.Tests;

import org.testng.annotations.Test;

import Data.LoadRegisterData;
import selainum_packge.Pages.HomePage;
import selainum_packge.Pages.RegisterPage;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterTests_NegativeScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	RegisterPage registerObject= new RegisterPage(driver);
	
	String name = LoadRegisterData.userData.getProperty("name");
	String Exist_email = LoadRegisterData.userData.getProperty("emailExist");
	
    @Test (priority = 3)
    public void testRegister_ExistEmail() throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	
    	homeObject.openRegisterationPage();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	  	wait.until(ExpectedConditions.visibilityOf(registerObject.newUserMessage));
    	Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
    	
    	registerObject.userCanRegister(name,Exist_email);
    	
    	Assert.assertEquals("Email Address already exist!", registerObject.failedMessage.getText());
    	
    }
    
   
}
