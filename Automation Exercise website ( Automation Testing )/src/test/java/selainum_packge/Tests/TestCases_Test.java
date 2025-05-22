package selainum_packge.Tests;

import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import selainum_packge.Pages.HomePage;
import selainum_packge.Pages.TestCasesPage;

public class TestCases_Test extends TestBase {
	HomePage homeObject = new HomePage(driver);
	TestCasesPage TestCasesObject= new TestCasesPage(driver);
	
	@Test (priority = 1)
    public void testCases_VerifyPage() throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	homeObject.openTestCasespPage();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	  	wait.until(ExpectedConditions.visibilityOf(TestCasesObject.TestCasesMessage));
    	Assert.assertEquals("TEST CASES", TestCasesObject.TestCasesMessage.getText());    	
    }
}
