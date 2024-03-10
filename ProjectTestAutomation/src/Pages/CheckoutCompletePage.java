package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
	WebDriver driver;
	
	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By titlePage = By.xpath("//span[@class=\"title\"]");
	private By checkoutCompleteImage = By.xpath("//img[@class=\"pony_express\"]");
	private By checkoutCompleteTitle = By.xpath("//h2[@class=\"complete-header\"]");
	private By checkoutCompleteText = By.xpath("//div[@class=\"complete-text\"]");
	private By backToProductsButton = By.xpath("//button[@id=\"back-to-products\"]");
	
	public boolean checkIfOrderWasPlaced(String title, String checkoutTitle, String checkoutText) {
        String webTitlePage = driver.findElement(titlePage).getText();
        boolean isImageDisplayed = driver.findElement(checkoutCompleteImage).isDisplayed();
		String webCheckoutCompleteTitle = driver.findElement(checkoutCompleteTitle).getText();
        String webCheckoutCompleteText = driver.findElement(checkoutCompleteText).getText();
        return (webTitlePage.equals(title) && isImageDisplayed && webCheckoutCompleteTitle.equals(checkoutTitle) && webCheckoutCompleteText.equals(checkoutText));
	}
	
	public void clickOnBackToProductsButon() {
		driver.findElement(backToProductsButton).click();
	}
}
