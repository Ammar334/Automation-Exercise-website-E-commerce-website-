package selainum_packge.Tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;

import Data.LoadLoginData;
import selainum_packge.Pages.HomePage;
import selainum_packge.Pages.LoginPage;

public class LoginTests_PositiveAndNegativeScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	
	String email = LoadLoginData.userData.getProperty("email");
	String password = LoadLoginData.userData.getProperty("password");
	boolean success = Boolean.parseBoolean( LoadLoginData.userData.getProperty("success"));
	
  @Test(priority = 1)
  public void testLogin_CorrectEmailAndPassword() throws InterruptedException {
	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
	homeObject.openLoginPage();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(loginObject.loginMessage));
	Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
	loginObject.userCanLogin(email, password);
	
	if(success==true) {
		Assert.assertEquals("Logout", loginObject.logoutBtn.getText());  
		loginObject.userCanLogout();
	}
	else {
		Assert.assertEquals("Your email or password is incorrect!", loginObject.failedMessage.getText());
	}
	
	
  }
}
