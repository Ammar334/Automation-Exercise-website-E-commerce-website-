package selainum_packge.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")
	public WebElement homeLink;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	public WebElement ProductBtn;
	@FindBy(linkText = "Contact us")
	public WebElement contactUsBtn;
	@FindBy(linkText = "Signup / Login")
	public WebElement signUpBtn;
	@FindBy(linkText = "Cart")
	public WebElement CartBtn;
	@FindBy(linkText = "Test Cases")
	public WebElement TestCasesBtn;
	@FindBy(linkText = "API Testing")
	public WebElement APIBtn;
	@FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
	public WebElement SubscriptionTitle;
	@FindBy(id = "susbscribe_email")
	public WebElement Subscriptiontxt;
	@FindBy(id = "subscribe")
	public WebElement Subscriptionbtn;
	@FindBy(xpath = "//*[@id=\"success-subscribe\"]/div")
	public WebElement SubscriptionSucessMessage;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/h2")
	public WebElement CategoryTitle;
	@FindBy(xpath = "//*[@id=\"accordian\"]/div[1]/div[1]/h4/a/span/i")
	public WebElement WomenCategory;
	@FindBy(xpath = "//*[@id=\"accordian\"]/div[2]/div[1]/h4/a/span/i")
	public WebElement MenCategory;
	@FindBy(xpath = "//*[@id=\"Men\"]/div/ul/li[1]/a")
	public WebElement TshirtCategory;
	@FindBy(xpath = "//*[@id=\"Women\"]/div/ul/li[2]/a")
	public WebElement TopsCategory;
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
	public WebElement topsPageTitle;
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
	public WebElement tshirtPageTitle;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[2]/h2")
	public WebElement RecomendedItemsTitle;
	@FindBy(xpath = "//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/a")
	public WebElement RecomendedItemFisrsAddtocart;
	
	
	
	public void openRegisterationPage() {
		signUpBtn.click();
	}
	
	public void openCategoryPage(String Categoey) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(Categoey.equals("Tops"))
		{
			
			WomenCategory.click();
			wait.until(ExpectedConditions.visibilityOf(TopsCategory));
			TopsCategory.click();
			
		}
		else if (Categoey.equals("T-shirt"))
		{
			MenCategory.click();
			wait.until(ExpectedConditions.visibilityOf(TshirtCategory));
			TshirtCategory.click();
		}
	}
	
	public void openLoginPage() {
		signUpBtn.click();
	}
	
	public void openProductsPage() {
		ProductBtn.click();
	}
	
	public void openTestCasespPage() {
		TestCasesBtn.click();
	}
	
	public void openTApiTestingPage() {
		APIBtn.click();
	}
	
	public void openCartPage() {
		CartBtn.click();
	}
	
	public void openContactUsPage() {
		contactUsBtn.click();
	}
	
	public void openHomePage() {
		homeLink.click();
	}
}
