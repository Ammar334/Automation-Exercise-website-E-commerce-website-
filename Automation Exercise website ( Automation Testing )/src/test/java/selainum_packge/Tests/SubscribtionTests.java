package selainum_packge.Tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Data.LoadLoginData;
import selainum_packge.Pages.HomePage;

public class SubscribtionTests extends TestBase{
	HomePage homeObject = new HomePage(driver);
	String email = LoadLoginData.userData.getProperty("email");
	@Test (priority = 3)
    public void SubscribtionTest_HomePage() throws InterruptedException {
		Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
	   	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		    "let subject = document.getElementById('susbscribe_email');" +
		    "subject.scrollIntoView({ behavior: 'smooth' });"
		);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	  	wait.until(ExpectedConditions.visibilityOf(homeObject.SubscriptionTitle));
		Assert.assertEquals("SUBSCRIPTION",homeObject.SubscriptionTitle.getText());
		homeObject.Subscriptiontxt.sendKeys(email);
		homeObject.Subscriptionbtn.click();
 	  	wait.until(ExpectedConditions.visibilityOf(homeObject.SubscriptionSucessMessage));
  	  	Assert.assertEquals("You have been successfully subscribed!",homeObject.SubscriptionSucessMessage.getText());
  	  }
	@Test (priority = 4)
    public void SubscribtionTest_CartPage() throws InterruptedException {
		Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
		homeObject.openCartPage();
	   	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		    "let subject = document.getElementById('susbscribe_email');" +
		    "subject.scrollIntoView({ behavior: 'smooth' });"
		);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	  	wait.until(ExpectedConditions.visibilityOf(homeObject.SubscriptionTitle));
		Assert.assertEquals("SUBSCRIPTION",homeObject.SubscriptionTitle.getText());
		homeObject.Subscriptiontxt.sendKeys(email);
		homeObject.Subscriptionbtn.click();
 	  	wait.until(ExpectedConditions.visibilityOf(homeObject.SubscriptionSucessMessage));
  	  	Assert.assertEquals("You have been successfully subscribed!",homeObject.SubscriptionSucessMessage.getText());
  	  }
}
