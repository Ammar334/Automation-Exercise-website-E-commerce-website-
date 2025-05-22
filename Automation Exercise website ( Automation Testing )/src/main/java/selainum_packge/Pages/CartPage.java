package selainum_packge.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]")
	WebElement shoopingCartWord;
	
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[1]")
	WebElement AddedSuccessMessage;
	@FindBy(css = "#cart_items > div > div:nth-child(2) > h2")
	WebElement AddressDetailsMassage;
	
	@FindBy(css = "#cart_items > div > div:nth-child(4) > h2")
	WebElement ReviewYourOrderMassage;
	
	@FindBy(css = "#form > div > div > div > h2 > b")
	public WebElement PlacedOrdersuccessMassage;
	
	@FindBy(css = "#cart_items > div > div.step-one > h2")
	WebElement PaymentMassage;

	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a")
	public  WebElement AddToChartBtn ;
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
	WebElement ContinueShoppingBtn ;
	@FindBy(linkText = "View Cart")
	public WebElement ViewCartBtn;
	@FindBy(xpath = "//table[@id='employeeTable']//tr")
	List<WebElement> tableRows;
	@FindBy(linkText = "Proceed To Checkout")
	public WebElement ProceedToCheckoutBtn ;
	@FindBy(linkText = "Continue On Cart")
	WebElement ContinueOnCartBtn ;
	@FindBy(linkText = "Register / Login")
	WebElement RegisterLoginBtn ;
	@FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
	public WebElement PlaceOrderBtn ;
	@FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
	public WebElement TextAreaTxt;
	@FindBy(name="name_on_card")
	public WebElement nameOnCardTxt;
	@FindBy(name="card_number")
	public WebElement cardnumberTxt;
	@FindBy(name="cvc")
	public WebElement cvcTxt;
	@FindBy(name="expiry_month")
	public WebElement expirymonthTxt;
	@FindBy(name="expiry_year")
	public WebElement expiryyearTxt;
	@FindBy(xpath = "//*[@id=\"submit\"]")
	public WebElement PayandConfirmOrderBtn ;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/a")
	WebElement DownloadInvoiceBtn ;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
	WebElement ContinuetoHomepageBtn ;
	@FindBy(xpath = "//*[@id=\"product-2\"]/td[6]/a")
	WebElement DeleteProductFromCartBtn;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
	WebElement ContinueAfterRegCartBtn;
	@FindBy(xpath = "//*[@id=\"product-1\"]/td[3]/p")
	public WebElement FirstProduct_Price;
	@FindBy(xpath = "//*[@id=\"product-2\"]/td[3]/p")
	public WebElement SecondProduct_Price;
	@FindBy(xpath = "//*[@id=\"product-1\"]/td[5]/p")
	public WebElement FirstProduct_totalPrice;
	@FindBy(xpath = "//*[@id=\"product-2\"]/td[5]/p")
	public WebElement SecondProduct_totalPrice;
	@FindBy(xpath = "//*[@id=\"product-1\"]/td[4]/button")
	public WebElement FirstProduct_Quantity;
	@FindBy(xpath = "//*[@id=\"product-2\"]/td[4]/button")
	public WebElement SecondProduct_Quantity;
	@FindBy(xpath = "//*[@id=\"cart_info_table\"]/tbody/tr")
	public List<WebElement> Cart_Products;
	@FindBy(className = "cart_quantity_delete")
	public List<WebElement> deleteButtons;
	@FindBy(xpath = "//*[@id=\"address_delivery\"]/li[4]")
	public WebElement deliveryaddress;
	@FindBy(xpath = "//*[@id=\"address_invoice\"]/li[4]")
	public WebElement bilingaddress;
	
	
	public void ClearCart() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    while (true) {
		        if (deleteButtons.isEmpty()) {
		            break;
		        }
		        WebElement deleteBtn = deleteButtons.get(0);
		        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
		        wait.until(ExpectedConditions.stalenessOf(deleteBtn));
		    }
	}
	public void clickContinueAfterRegCart() {
		ContinueAfterRegCartBtn.click();
	}
	public void clickContinueShopping() {
		ContinueShoppingBtn.click();
	}
	
	public void clickContinueOnCartBtn() {
	    ContinueOnCartBtn.click();
	}
	
	public void clickRegisterLoginBtn() {
	    RegisterLoginBtn.click();
	}
	
	public void clickDownloadInvoiceBtn() {
	    DownloadInvoiceBtn.click();
	}
	public void choseproduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		AddToChartBtn.click();
		wait.until(ExpectedConditions.visibilityOf(ViewCartBtn));
		ViewCartBtn.click();
		wait.until(ExpectedConditions.visibilityOf(ProceedToCheckoutBtn));
		ProceedToCheckoutBtn.click();
		wait.until(ExpectedConditions.visibilityOf(RegisterLoginBtn));
		RegisterLoginBtn.click();
	}
	public void EnterOrderMessage(String message) {
	    TextAreaTxt.sendKeys(message);
	}
	
	public void EnterNameOnCard(String name) {
	    nameOnCardTxt.sendKeys(name);
	}
	
	public void EnterCardNumber(String cardNumber) {
	    cardnumberTxt.sendKeys(cardNumber);
	}
	
	public void EnterCVC(String cvc) {
	    cvcTxt.sendKeys(cvc);
	}
	
	public void EnterExpiryMonth(String month) {
	    expirymonthTxt.sendKeys(month);
	}
	
	public void EnterExpiryYear(String year) {
	    expiryyearTxt.sendKeys(year);
	}
	public void clickViewCartBtn() {
	    ViewCartBtn.click();
	}
	
	public void clickProceedToCheckoutBtn() {
	    ProceedToCheckoutBtn.click();
	}
	
	public void clickPlaceOrderBtn() {
	    PlaceOrderBtn.click();
	}
	
	public void clickTextAreaBtn() {
	    TextAreaTxt.click();
	}
	
	public void clickNameOnCardTxt() {
	    nameOnCardTxt.click();
	}
	
	public void clickCardNumberTxt() {
	    cardnumberTxt.click();
	}
	
	public void clickCvcTxt() {
	    cvcTxt.click();
	}
	
	public void clickExpiryMonthTxt() {
	    expirymonthTxt.click();
	}
	
	public void clickExpiryYearTxt() {
	    expiryyearTxt.click();
	}
	
	public void clickPayAndConfirmOrderBtn() {
	    PayandConfirmOrderBtn.click();
	}
	public void clickContinuetoHomepageAfterOrderFinishBtn() {
		ContinuetoHomepageBtn.click();
	}
	public void chosetoDeleteProduct() {
		AddToChartBtn.click();
	    ViewCartBtn.click();
	    DeleteProductFromCartBtn.click();
	}
	public void FULLAddProductAndBuy(String Comment,String name, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
		AddToChartBtn.click();
	    ViewCartBtn.click();
	    ProceedToCheckoutBtn.click();
	    TextAreaTxt.sendKeys(Comment);
	    PlaceOrderBtn.click();
	    nameOnCardTxt.sendKeys(name);
	    cardnumberTxt.sendKeys(cardNumber);
	    cvcTxt.sendKeys(cvc);
	    expirymonthTxt.sendKeys(expiryMonth);
	    expiryyearTxt.sendKeys(expiryYear);
	    PayandConfirmOrderBtn.click();
	}
	public void FULLAddProductAndBuyafterReg(String Comment,String name, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
		ProceedToCheckoutBtn.click();	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript(
			"let subject = document.getElementsByName('message')[0];" +
			"subject.scrollIntoView({ behavior: 'smooth' });"
		);
	    TextAreaTxt.sendKeys(Comment);
	    PlaceOrderBtn.click();
	    nameOnCardTxt.sendKeys(name);
	    cardnumberTxt.sendKeys(cardNumber);
	    cvcTxt.sendKeys(cvc);
	    expirymonthTxt.sendKeys(expiryMonth);
	    expiryyearTxt.sendKeys(expiryYear);
	    PayandConfirmOrderBtn.click();
	}
	
	


}
