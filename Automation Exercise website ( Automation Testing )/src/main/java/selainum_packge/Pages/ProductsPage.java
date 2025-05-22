package selainum_packge.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductsPage extends PageBase {
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a")
	public  WebElement AddToChartBtn_1 ;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a")
	public  WebElement AddToChartBtn_2 ;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
	public WebElement ProductsPageTitle;
	@FindBy(css = ".features_items .col-sm-4")
	public List<WebElement> productsList;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
	public WebElement viewProductBtn;
	@FindBy(id = "search_product")
	public WebElement SearchTxt;
	@FindBy(id = "submit_search")
	public WebElement SearchBtn;
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
	public WebElement ContinueShoppingbtn;
	@FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > h2")
	public WebElement ProductsTitle;
	@FindBy(linkText = "View Cart")
	public WebElement ViewCartBtn;
	@FindBy(xpath = "@FindBy(xpath = \"//a[contains(text(),'H&M')]\")")
	public WebElement HMBrand;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
	public WebElement SearchProductMessage;
	@FindBy(css = ".features_items .col-sm-4 .productinfo p")
	public List<WebElement> productNames;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div[3]/h2")
	public WebElement productBrands;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div[3]/div/ul/li[1]/a")
	public WebElement PoloBrand;
	@FindBy(css = ".features_items .productinfo .add-to-cart")
	public List<WebElement> addToCartButtons;
	
	
	
	public void addAllProductsToCart() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    for (WebElement button : addToCartButtons) {
	        js.executeScript("arguments[0].scrollIntoView(true);", button);
	        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

	        // Wait for and click "Continue Shopping" button
	        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector(".modal-footer .btn.btn-success.close-modal")));
	        continueBtn.click();
	    }
	}

	
	public void openProductDetailsPage() {
		viewProductBtn.click();
	}
	
	public void SearchForProduct(String ProductName) {
		SearchTxt.sendKeys(ProductName);
		SearchBtn.click();
	}
	public void AddTwoElementsToCart() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(AddToChartBtn_1).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(AddToChartBtn_1));
		AddToChartBtn_1.click();
		wait.until(ExpectedConditions.visibilityOf(ContinueShoppingbtn));
		ContinueShoppingbtn.click();
		actions.moveToElement(AddToChartBtn_2).perform();
		wait.until(ExpectedConditions.elementToBeClickable(AddToChartBtn_2));
		AddToChartBtn_2.click();
		wait.until(ExpectedConditions.visibilityOf(ViewCartBtn));
		ViewCartBtn.click();
	}
	
	public void assertProductListIsVisible() {
	    Assert.assertFalse(productsList.isEmpty(), "Product list is empty!");
	    for (WebElement product : productsList) {
	        Assert.assertTrue(product.isDisplayed(), "A product in the list is not visible.");
	    }
	}
	
	public void OpenFirstProductDetailPage() {
		viewProductBtn.click();
	}
	
	public void assertSearchResultsContain(String keyword) {
	    Assert.assertFalse(productNames.isEmpty(), "No products found in search results!");

	    for (WebElement product : productNames) {
	        Assert.assertTrue(product.isDisplayed(), "Product is not visible.");
	        String productText = product.getText().toLowerCase();
	        Assert.assertTrue(productText.contains(keyword.toLowerCase()), 
	            "Product does not match search keyword: " + productText);
	    }
	}

	public void openBrandPage(String Brand) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(Brand.equals("Polo"))
		{
			PoloBrand.click();	
		}
		else if (Brand.equals("HM"))
		{
			wait.until(ExpectedConditions.visibilityOf(HMBrand));
			HMBrand.click();
			System.out.println("liho");
		}
	}
	
}
