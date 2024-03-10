package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartTest extends BaseTest {
	
	@Before
	public void before() {
		super.before();
		loginPage.authenticate(0);
	}
	
	@Test
	public void addAndRemoveProductFromCart() {
		homePage.addProductToCart(0);
		homePage.navigateToShoppingCart();
		Assert.assertTrue(cartPage.isItemInCart(0));
		cartPage.removeItemFromCart(0);
	}
}