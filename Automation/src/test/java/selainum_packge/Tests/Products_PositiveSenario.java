package selainum_packge.Tests;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Data.LoadLoginData;
import Data.LoadRegisterData;
import selainum_packge.Pages.CartPage;
import selainum_packge.Pages.HomePage;
import selainum_packge.Pages.LoginPage;
import selainum_packge.Pages.ProductDetailPage;
import selainum_packge.Pages.ProductsPage;

public class Products_PositiveSenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	ProductsPage ProductObject= new ProductsPage(driver);
	ProductDetailPage ProductDetailObject = new ProductDetailPage(driver);
	CartPage CartObject = new CartPage(driver);
	LoginPage LoginObject = new LoginPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	String emailExist = LoadLoginData.userData.getProperty("email");
	String name = LoadRegisterData.userData.getProperty("name");
	String password = LoadRegisterData.userData.getProperty("password");
	@Test (priority = 1)
    public void Producttest_VerifyAllproduct() throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	homeObject.openProductsPage();
  	  	wait.until(ExpectedConditions.visibilityOf(ProductObject.ProductsPageTitle));
    	Assert.assertEquals("ALL PRODUCTS", ProductObject.ProductsPageTitle.getText());
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		    "let subject = document.getElementsByClassName('btn btn-default add-to-cart')[0];" +
		    "subject.scrollIntoView({ behavior: 'smooth' });"
		);
    	ProductObject.assertProductListIsVisible();
    	ProductObject.OpenFirstProductDetailPage();
    	wait.until(ExpectedConditions.visibilityOf(ProductDetailObject.ProductName));
    	ProductDetailObject.CheckProductParametersVisability();
    }
	@Test (priority = 2)
	public void Products_VerifySearchproduct() throws InterruptedException {
		homeObject.openHomePage();
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	homeObject.openProductsPage();
  	  	wait.until(ExpectedConditions.visibilityOf(ProductObject.ProductsPageTitle));
    	Assert.assertEquals("ALL PRODUCTS", ProductObject.ProductsPageTitle.getText());
    	ProductObject.SearchForProduct("jeans");
    	wait.until(ExpectedConditions.visibilityOf(ProductObject.SearchProductMessage));
    	Assert.assertEquals("SEARCHED PRODUCTS", ProductObject.SearchProductMessage.getText());
    	ProductObject.assertSearchResultsContain("jeans");
    }
	@Test (priority = 3)
	public void Products_ViewCategory() throws InterruptedException {
		homeObject.openHomePage();
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		    "let subject = document.getElementsByClassName('productinfo text-center')[2];" +
		    "subject.scrollIntoView({ behavior: 'smooth' });"
		); 
		Thread.sleep(1000);
    	Assert.assertEquals("CATEGORY", homeObject.CategoryTitle.getText());
    	homeObject.openCategoryPage("Tops");
    	Assert.assertEquals("WOMEN - TOPS PRODUCTS", homeObject.topsPageTitle.getText());
    	homeObject.openCategoryPage("T-shirt");
    	Assert.assertEquals("MEN - TSHIRTS PRODUCTS", homeObject.tshirtPageTitle.getText());
    }
	
	@Test (priority = 4)
	public void Products_ViewBrand() throws InterruptedException {
		homeObject.openHomePage();
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	homeObject.openProductsPage();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript(
    		"let subject = document.getElementsByClassName('productinfo text-center')[2];" +
        	"subject.scrollIntoView({ behavior: 'smooth' });"
        ); 
		Thread.sleep(1000);
    	ProductObject.openBrandPage("Polo");
    	Assert.assertEquals("Brand - Polo Products".toUpperCase(), homeObject.topsPageTitle.getText());
    	ProductObject.assertProductListIsVisible();
    }
	
	@Test (priority = 5)
	 public void SearchProductsAndVerifyCartAfterLogin() throws InterruptedException {
		 Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
		 homeObject.openProductsPage();
		 wait.until(ExpectedConditions.visibilityOf(ProductObject.ProductsPageTitle));
	     Assert.assertEquals("ALL PRODUCTS", ProductObject.ProductsPageTitle.getText());
	     ProductObject.SearchForProduct("jeans");
	     wait.until(ExpectedConditions.visibilityOf(ProductObject.SearchProductMessage));
	   	 Assert.assertEquals("SEARCHED PRODUCTS", ProductObject.SearchProductMessage.getText());
	   	 ProductObject.assertSearchResultsContain("jeans");
	   	 ProductObject.addAllProductsToCart();
	   	 homeObject.openCartPage();
	   	 Assert.assertEquals(3, CartObject.Cart_Products.size());
	   	 homeObject.openLoginPage();
	   	 LoginObject.userCanLogin(emailExist, password);
	   	 Assert.assertEquals("Logout", LoginObject.logoutBtn.getText());  
	   	 homeObject.openCartPage();
	   	 Assert.assertEquals(3, CartObject.Cart_Products.size());
	  	 
	 }
	 @Test (priority = 6)
	 public void AddReviewOnProduct() throws InterruptedException {
		 Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
		 homeObject.openProductsPage();
		 wait.until(ExpectedConditions.visibilityOf(ProductObject.ProductsPageTitle));
	     Assert.assertEquals("ALL PRODUCTS", ProductObject.ProductsPageTitle.getText());
	     ProductObject.OpenFirstProductDetailPage();
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript(
	    	"let subject = document.getElementsByClassName('active')[0];" +
	        "subject.scrollIntoView({ behavior: 'smooth' });"
	     ); 
	     Assert.assertEquals("Write Your Review".toUpperCase(), ProductDetailObject.ProductReviewTitle.getText());
	     ProductDetailObject.ProductAddYourreview(name,emailExist,"Good Price");
	     Assert.assertEquals("Thank you for your review.", ProductDetailObject.ProductReviewMessage.getText());
	     
	  	 
	 }
}
