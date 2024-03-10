package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestData.Product;
import Tests.BaseTest;

public class HomePage {
	WebDriver driver;
	BaseTest baseTest = new BaseTest();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By hamburgerMenu = By.xpath("//button[@id=\"react-burger-menu-btn\"]");
	private By appLogo = By.xpath("//div[@class=\"app_logo\"]");
	private By shoppingCart = By.xpath("//a[@class=\"shopping_cart_link\"]");
	private By inventoryItems = By.xpath("//div[@class=\"inventory_item\"]");
	private By inventoryItemsName = By.xpath("//div[@class=\"inventory_item_name \"]");
	private By addToCartButtons = By.xpath("//div[contains(@class, 'inventory_item_name')]/ancestor::div[contains(@class, 'inventory_item')]//button");
	
	public boolean checkHeaderElements() {
		boolean hasHamburgerMenu = driver.findElements(hamburgerMenu).size() != 0;
		boolean hasAppLogo = driver.findElements(appLogo).size() != 0;
		boolean hasShoppingCart = driver.findElements(shoppingCart).size() != 0;
		return hasHamburgerMenu && hasAppLogo && hasShoppingCart ;
	}
	
	public String getAppLogoText() {
		return driver.findElement(appLogo).getText();
	}
	
	public void addProductToCart(int numberProduct) {
	    Product selectedProduct = baseTest.getProducts().get(numberProduct);
	    List<WebElement> listInventoryItems = driver.findElements(inventoryItems);
	    for (WebElement inventoryItem : listInventoryItems) {
	        WebElement inventoryItemName = inventoryItem.findElement(inventoryItemsName);
	        String currentProductName = inventoryItemName.getText();
	        if (currentProductName.equalsIgnoreCase(selectedProduct.getName())) {
	            WebElement addToCartButton = inventoryItem.findElement(addToCartButtons);
	            addToCartButton.click();
	            System.out.println("I added product " + inventoryItemName.getText() + " to the cart");
	            return;
	        }
	    }
	    System.out.println("Product not found: " + selectedProduct.getName());
	}
	
	public void clickToSeeProductDetails(int numberProduct) {
	    Product selectedProduct = baseTest.getProducts().get(numberProduct);
	    List<WebElement> listInventoryItems = driver.findElements(inventoryItems);
	    for (WebElement inventoryItem : listInventoryItems) {
	        WebElement inventoryItemName = inventoryItem.findElement(inventoryItemsName);
	        String currentProductName = inventoryItemName.getText();
	        if (currentProductName.equalsIgnoreCase(selectedProduct.getName())) {
	            WebElement inventoryTitleProduct = inventoryItem.findElement(inventoryItemsName);
	            inventoryTitleProduct.click();
	            return;
	        }
	    }
	    System.out.println("Product not found: " + selectedProduct.getName());
	}
	
	public void navigateToShoppingCart() {
		driver.findElement(shoppingCart).click();
	}
}
