package selainum_packge.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductDetailPage extends PageBase{

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
	public WebElement ProductName;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")
	public WebElement ProductCategory;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")
	public WebElement ProductPrice;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]")
	public WebElement ProductAvailability;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]")
	public WebElement ProductCondition;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]")
	public WebElement ProductBrand;
	@FindBy(id = "quantity")
	public WebElement ProductQuantitiyTxt;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
	public WebElement ProductAddtoCartBtn;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a")
	public WebElement ProductReviewTitle;
	@FindBy(id = "name")
	public WebElement ProductReviewName;
	@FindBy(id = "email")
	public WebElement ProductReviewEmail;
	@FindBy(id = "review")
	public WebElement ProductReview;
	@FindBy(id = "button-review")
	public WebElement ProductReviewSubmit;
	@FindBy(xpath = "//*[@id=\"review-section\"]/div/div/span")
	public WebElement ProductReviewMessage;
	
	
	public void CheckProductParametersVisability() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	  	wait.until(ExpectedConditions.visibilityOf(ProductName));
		Assert.assertTrue(ProductName.isDisplayed(), "Element 'ProductName' is not visible");
		Assert.assertTrue(ProductCategory.isDisplayed(), "Element 'ProductCategory' is not visible");
		Assert.assertTrue(ProductPrice.isDisplayed(), "Element 'ProductPrice' is not visible");
		Assert.assertTrue(ProductAvailability.isDisplayed(), "Element 'ProductAvailability' is not visible");
		Assert.assertTrue(ProductCondition.isDisplayed(), "Element 'ProductCondition' is not visible");
		Assert.assertTrue(ProductBrand.isDisplayed(), "Element 'ProductBrand' is not visible");
	}
	
	public void ChangeProductQuantity(String Quantity ) {
		ProductQuantitiyTxt.clear();
		ProductQuantitiyTxt.sendKeys(Quantity);
	}
	public void ProductAddtoCart() {
		ProductAddtoCartBtn.click();
	}
	public void ProductAddYourreview(String name,String email,String review) {
		ProductReviewName.sendKeys(name);
		ProductReviewEmail.sendKeys(email);
		ProductReview.sendKeys(review);
		ProductReviewSubmit.click();
	}
}
