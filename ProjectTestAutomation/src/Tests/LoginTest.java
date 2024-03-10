package Tests;

import org.junit.Assert;
import org.junit.Test;

import TestData.Errors;
import TestData.PageTitles;

public class LoginTest extends BaseTest {
	
	@Test
	public void loginWithValidData() {
		loginPage.authenticate(0);
		Assert.assertTrue(homePage.checkHeaderElements());
		Assert.assertEquals(PageTitles.TITLE_LOGO, homePage.getAppLogoText());
	}
	
	@Test
	public void loginWithInvalidData() {
		loginPage.authenticate(1);
		Assert.assertEquals(Errors.INVALID_DATA, loginPage.getErrorMessage());
	}
	
	@Test
	public void loginWithLockedOutUser() {
		loginPage.authenticate(2);
		Assert.assertEquals(Errors.LOCKED_OUT_USER, loginPage.getErrorMessage());
	}
}
