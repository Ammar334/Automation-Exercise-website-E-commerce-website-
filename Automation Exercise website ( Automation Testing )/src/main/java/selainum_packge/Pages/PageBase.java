package selainum_packge.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	protected WebDriver driver; 
	
	PageBase(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
