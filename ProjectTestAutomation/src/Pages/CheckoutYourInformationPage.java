package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
	WebDriver driver;
	
	public CheckoutYourInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By firstNameInput = By.xpath("//input[@id=\"first-name\"]");
	private By lastNameInput = By.xpath("//input[@id=\"last-name\"]");
	private By postalCodeInput = By.xpath("//input[@id=\"postal-code\"]");
	private By continueButton = By.xpath("//input[@id=\"continue\"]");
	
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameInput).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(lastNameInput).sendKeys(lastName);
	}
	
	public void enterPostalCode(String postalCode) {
		driver.findElement(postalCodeInput).sendKeys(postalCode);
	}
	
	public void clickOnContinue() {
		driver.findElement(continueButton).click();
	}
	
	public void completeCheckoutInformation(String firstName, String lastName, String postalCode) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPostalCode(postalCode);
		clickOnContinue();
	}
}
