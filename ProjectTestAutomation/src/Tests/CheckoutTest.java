package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import TestData.Messages;
import TestData.PageTitles;

public class CheckoutTest extends BaseTest {

	@Before
	public void before() {
		super.before();
		loginPage.authenticate(0);
	}
	
	@Test
	public void checkoutProduct() {
		homePage.clickToSeeProductDetails(0);
		Assert.assertTrue(productDetailsPage.verifyTitle(0));
		Assert.assertTrue(productDetailsPage.verifyDescription(0));
		Assert.assertTrue(productDetailsPage.verifyPrice(0));
		productDetailsPage.clickOnAddToCartBuuton();
		homePage.navigateToShoppingCart();
		Assert.assertTrue(cartPage.isItemInCart(0));
		cartPage.clickOnCheckoutButon();
		checkoutYourInformationPage.completeCheckoutInformation("Cătălan", "Cătălin", "447330");
		Assert.assertTrue(checkoutOverviewPage.checkOrderDetails(PageTitles.TITLE_OVERVIEW_PAGE, "1", 0));
		checkoutOverviewPage.clickOnFinishButon();
		Assert.assertTrue(checkoutCompletePage.checkIfOrderWasPlaced(PageTitles.TITLE_CHECKOUT_COMPLETE_PAGE, Messages.CHECKOUT_COMPLETE_TITLE, Messages.CHECKOUT_COMPLETE_TEXT));
		checkoutCompletePage.clickOnBackToProductsButon();
	}
}
