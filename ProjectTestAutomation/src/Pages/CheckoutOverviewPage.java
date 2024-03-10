package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Tests.BaseTest;

public class CheckoutOverviewPage {
	WebDriver driver;
	BaseTest baseTest = new BaseTest();
	
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By titlePage = By.xpath("//span[@class=\"title\"]");
	private By cartQuantity = By.xpath("//div[@class=\"cart_quantity\"]");
	private By inventoryItemName = By.xpath("//div[@class=\"inventory_item_name\"]");
	private By inventoryItemDescription = By.xpath("//div[@class=\"inventory_item_desc\"]");
	private By inventoryItemPrice = By.xpath("//div[@class=\"inventory_item_price\"]");
	private By finishButton = By.xpath("//button[@id=\"finish\"]");
	
	public boolean checkOrderDetails(String title, String numberOfProducts, int numberProduct) {
        String webTitlePage = driver.findElement(titlePage).getText();
        String webCartQuantity = driver.findElement(cartQuantity).getText();
		String webProductTitle = driver.findElement(inventoryItemName).getText();
        String webProductDescription = driver.findElement(inventoryItemDescription).getText();
        String webProductPrice = driver.findElement(inventoryItemPrice).getText();
        String jsonProductTitle = baseTest.getProducts().get(numberProduct).getName();
        String jsonProductDescription = baseTest.getProducts().get(numberProduct).getDescription();
        String jsonProductPrice = baseTest.getProducts().get(numberProduct).getPrice();
        return (webTitlePage.equals(title) && webCartQuantity.equals(numberOfProducts) && webProductTitle.equals(jsonProductTitle) && webProductDescription.equals(jsonProductDescription) && webProductPrice.equals(jsonProductPrice));
	}
	
	public void clickOnFinishButon() {
		driver.findElement(finishButton).click();
	}
}
