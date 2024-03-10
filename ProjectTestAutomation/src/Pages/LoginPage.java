package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestData.User;
import Tests.BaseTest;

public class LoginPage {
	WebDriver driver;
	BaseTest baseTest = new BaseTest();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By usernameInput = By.xpath("//input[@id=\"user-name\"]");
	private By passwordInput = By.xpath("//input[@id=\"password\"]");
	private By loginButton = By.xpath("//input[@id=\"login-button\"]");
	private By errorMessage = By.xpath("//h3[@data-test=\"error\"]");
	
	public void enterUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	public void authenticate(int numberUser) {
		User selectedUser = baseTest.getUsers().get(numberUser);
		enterUsername(selectedUser.getUsername());
		enterPassword(selectedUser.getPassword());
		clickLogin();
	}
	
	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}
}
