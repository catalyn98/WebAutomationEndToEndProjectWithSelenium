package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestData.Product;
import Tests.BaseTest;

import java.time.Duration;

public class CartPage {
	WebDriver driver;
	BaseTest baseTest = new BaseTest();
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By cartItems = By.xpath("//div[@class=\"cart_item\"]");
	private By cartItemsName = By.xpath("//div[@class=\"inventory_item_name\"]");
	private By removeButtons = By.xpath("//div[contains(@class, 'inventory_item_name')]/ancestor::div[contains(@class, 'cart_item')]//button");
	private By checkoutButton = By.xpath("//button[@id=\"checkout\"]");
	
	public boolean isItemInCart(int numberProduct) {
		Product selectedProduct = baseTest.getProducts().get(numberProduct);
	    List<WebElement> listCartItems = driver.findElements(cartItems);
	    for (WebElement cartItem : listCartItems) {
	    	    WebElement cartItemName = cartItem.findElement(cartItemsName);
	            String productNameAdded = cartItemName.getText();
	            if (productNameAdded.equalsIgnoreCase(selectedProduct.getName())) {
	                return true;
	            }
	    }
	    return false;
	}

	public boolean removeItemFromCart(int numberProduct) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Product selectedProduct = baseTest.getProducts().get(numberProduct);
	    if (isItemInCart(numberProduct)) { 
	        List<WebElement> listCartItems = driver.findElements(cartItems);
	        for (WebElement cartItem : listCartItems) {
	            WebElement cartItemName = cartItem.findElement(cartItemsName);
	            String productNameAdded = cartItemName.getText();
	            if (productNameAdded.equalsIgnoreCase(selectedProduct.getName())) {
	                WebElement removeButton = cartItem.findElement(removeButtons);
	                removeButton.click();
	                System.out.println("I deleted the product " + productNameAdded + " from the cart");
	                try {
	                    return wait.until(ExpectedConditions.invisibilityOf(cartItem));
	                } catch (Exception e) {
	                	System.out.println("Product still exists in the cart");
	                    return false; 
	                }
	            }
	        }
	    }
	    return false;
	}
	
	public void clickOnCheckoutButon() {
		driver.findElement(checkoutButton).click();
	}
}
