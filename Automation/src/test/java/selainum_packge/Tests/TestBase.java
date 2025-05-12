package selainum_packge.Tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Data.LoadDriverData;

public class TestBase {
	String browserName ;
	protected WebDriver driver;
	protected String baseURL;
	
	TestBase(){
		baseURL = LoadDriverData.userData.getProperty("baseURL");
		browserName = LoadDriverData.userData.getProperty("browserName");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();

		}
		else if(browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
	}
	
    @BeforeTest
    public void openBrowser() {
    	driver.manage().window().maximize();
    	driver.navigate().to(baseURL);
    }

    @AfterTest
    public void closeBrowser() {
    	driver.quit();
    }
}
