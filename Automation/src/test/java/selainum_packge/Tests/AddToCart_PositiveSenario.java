package selainum_packge.Tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import selainum_packge.Pages.CartPage;
import selainum_packge.Pages.HomePage;
import selainum_packge.Pages.ProductDetailPage;
import selainum_packge.Pages.ProductsPage;

public class AddToCart_PositiveSenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	CartPage CartObject = new CartPage(driver);
	ProductsPage ProductObject= new ProductsPage(driver);
	ProductDetailPage ProductdetailObject= new ProductDetailPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@Test (priority = 1)
    public void Verify_AddProductsToCart() throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	homeObject.openProductsPage();
  	  	wait.until(ExpectedConditions.visibilityOf(ProductObject.ProductsPageTitle));
    	Assert.assertEquals("ALL PRODUCTS", ProductObject.ProductsPageTitle.getText());
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		    "let subject = document.getElementsByClassName('productinfo text-center')[2];" +
		    "subject.scrollIntoView({ behavior: 'smooth' });"
		); 
		Thread.sleep(1000);
		ProductObject.AddTwoElementsToCart();
		Assert.assertEquals(2, CartObject.Cart_Products.size());
		Assert.assertEquals("Rs. 500", CartObject.FirstProduct_Price.getText());
		Assert.assertEquals("Rs. 400", CartObject.SecondProduct_Price.getText());
		Assert.assertEquals("1", CartObject.FirstProduct_Quantity.getText());
		Assert.assertEquals("1", CartObject.SecondProduct_Quantity.getText());
		String FirstProduct_P = CartObject.FirstProduct_Price.getText().substring(4);
		String secondProduct_P = CartObject.SecondProduct_Price.getText().substring(4);
		int totalPrice_FP = Integer.parseInt(FirstProduct_P) * Integer.parseInt(CartObject.FirstProduct_Quantity.getText());
		int totalPrice_SP = Integer.parseInt(secondProduct_P) * Integer.parseInt(CartObject.SecondProduct_Quantity.getText());
		String FirstProduct_tP = String.valueOf(totalPrice_FP);
		String SecondProduct_tP = String.valueOf(totalPrice_SP);
		Assert.assertEquals(FirstProduct_tP, CartObject.FirstProduct_totalPrice.getText().substring(4));
		Assert.assertEquals(SecondProduct_tP, CartObject.SecondProduct_totalPrice.getText().substring(4));
		
    }
	@Test (priority = 2)
    public void Verify_RemoveProductsFromCart() throws InterruptedException {
		homeObject.openHomePage();
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	homeObject.openCartPage(); 
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.CartBtn.getCssValue("color"));
		CartObject.ClearCart();
		Assert.assertEquals(0, CartObject.Cart_Products.size());
		
    }
	@Test (priority = 3)
    public void Verify_productQuantity() throws InterruptedException {
		homeObject.openHomePage();
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		    "let subject = document.getElementsByClassName('productinfo text-center')[2];" +
		    "subject.scrollIntoView({ behavior: 'smooth' });"
		); 
		Thread.sleep(1000);
		ProductObject.OpenFirstProductDetailPage();
		ProductdetailObject.CheckProductParametersVisability();
		ProductdetailObject.ChangeProductQuantity("4");
		ProductdetailObject.ProductAddtoCart();
		wait.until(ExpectedConditions.visibilityOf(ProductObject.ContinueShoppingbtn));
		ProductObject.ViewCartBtn.click();
		Assert.assertEquals(1, CartObject.Cart_Products.size());
		Assert.assertEquals("4", CartObject.FirstProduct_Quantity.getText());
		
    }
	@Test (priority = 4)
    public void AddToCartFromRecomendedItem() throws InterruptedException {
		homeObject.openHomePage();
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		    "let subject = document.getElementsByClassName('title text-center')[1];" +
		    "subject.scrollIntoView({ behavior: 'smooth' });"
		); 
		Thread.sleep(1000);
	    Assert.assertEquals("RECOMMENDED ITEMS".toUpperCase(), homeObject.RecomendedItemsTitle.getText());
	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(100));
	    wait1.until(ExpectedConditions.visibilityOf(homeObject.RecomendedItemFisrsAddtocart));
		homeObject.RecomendedItemFisrsAddtocart.click();
		wait1.until(ExpectedConditions.visibilityOf(ProductObject.ViewCartBtn));
		ProductObject.ViewCartBtn.click();
    }
}
