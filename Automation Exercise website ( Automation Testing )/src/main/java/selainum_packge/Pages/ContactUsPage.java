package selainum_packge.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="name")
	WebElement nameTxt;
	
	@FindBy(name="email")
	WebElement emailTxt;
	
	@FindBy(name="subject")
	WebElement subjectTxt;
	
	@FindBy(id="message")
	WebElement messageTxt;
	
	@FindBy(name="upload_file")
	WebElement uploadFileBtn;
	
	@FindBy(name="submit")
	WebElement submitBtn;
	
	@FindBy(css="#contact-page > div.row > div.col-sm-8 > div > h2")
	public WebElement getInMessage;
	
	@FindBy(xpath="//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
	public WebElement successMessage;
	
	public void userCanContactUs(String name,String email,String subject,String message,String path) throws InterruptedException {
		nameTxt.sendKeys(name);
		emailTxt.sendKeys(email);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		    "let subject = document.getElementsByName('subject')[0];" +
		    "subject.scrollIntoView({ behavior: 'smooth' });"
		);
		subjectTxt.sendKeys(subject);
		messageTxt.sendKeys(message);
		String filePath = System.getProperty("user.dir")+"\\Images\\ContactUs.png";
		uploadFileBtn.sendKeys(filePath);
		submitBtn.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
