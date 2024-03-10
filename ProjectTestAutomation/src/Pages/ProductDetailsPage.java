package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestData.Product;
import Tests.BaseTest;

public class ProductDetailsPage {
	WebDriver driver;
	BaseTest baseTest = new BaseTest();
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By titleProduct = By.xpath("//div[@class=\"inventory_details_name large_size\"]");
	private By descriptionProduct = By.xpath("//div[@class=\"inventory_details_desc large_size\"]");
	private By priceProduct = By.xpath("//div[@class=\"inventory_details_price\"]");
	private By checkoutButton = By.xpath("//div[contains(@class, 'inventory_details_name')]/ancestor::div[contains(@class, 'inventory_details_desc_container')]//button");
	
	public boolean verifyTitle(int numberProduct) {
	    Product selectedProduct = baseTest.getProducts().get(numberProduct);
	    String actualTitle = driver.findElement(titleProduct).getText();
	    return selectedProduct.getName().equals(actualTitle);
	}

	public boolean verifyDescription(int numberProduct) {
	    Product selectedProduct = baseTest.getProducts().get(numberProduct);
	    String actualDescription = driver.findElement(descriptionProduct).getText();
	    return selectedProduct.getDescription().equals(actualDescription);
	}

	public boolean verifyPrice(int numberProduct) {
	    Product selectedProduct = baseTest.getProducts().get(numberProduct);
	    String actualPrice = driver.findElement(priceProduct).getText();
	    return selectedProduct.getPrice().equals(actualPrice);
	}
	
	public void clickOnAddToCartBuuton() {
		driver.findElement(checkoutButton).click();
	}
}
