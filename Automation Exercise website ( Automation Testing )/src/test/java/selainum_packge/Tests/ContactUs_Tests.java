package selainum_packge.Tests;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Data.LoadContactUsDate;
import selainum_packge.Pages.ContactUsPage;
import selainum_packge.Pages.HomePage;

public class ContactUs_Tests extends TestBase {
	HomePage homeObject = new HomePage(driver);
	ContactUsPage contactUsObject = new ContactUsPage(driver);
	String name = LoadContactUsDate.userData.getProperty("name");
	String email = LoadContactUsDate.userData.getProperty("email");
	String subject = LoadContactUsDate.userData.getProperty("subject");
	String message = LoadContactUsDate.userData.getProperty("message");
	String path = LoadContactUsDate.userData.getProperty("path");
  @Test
  public void testContactUs_validData() throws InterruptedException, AWTException {
	  Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
	  homeObject.openContactUsPage();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(contactUsObject.getInMessage));
	  Assert.assertEquals("GET IN TOUCH", contactUsObject.getInMessage.getText());
	  contactUsObject.userCanContactUs(name,email,subject,message,path);
	  wait.until(ExpectedConditions.visibilityOf(contactUsObject.successMessage));
	  Assert.assertEquals("Success! Your details have been submitted successfully.", contactUsObject.successMessage.getText());
  }
}
