package Tests;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.CartPage;
import Pages.CheckoutCompletePage;
import Pages.CheckoutOverviewPage;
import Pages.CheckoutYourInformationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import TestData.Product;
import TestData.User;
import Utils.ReaderProduct;
import Utils.ReaderUser;

public class BaseTest {
	static WebDriver driver;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static CartPage cartPage;
	public static ProductDetailsPage productDetailsPage;
	public static CheckoutYourInformationPage checkoutYourInformationPage;
	public static CheckoutOverviewPage checkoutOverviewPage;
	public static CheckoutCompletePage checkoutCompletePage;
	private List<User> users = ReaderUser.readUsers("users");
	private List<Product> products = ReaderProduct.readProducts("products");

	@BeforeClass
	public static void setUp() {

	}
	
	@AfterClass
	public static void tearDown() {

	}
	
	@Before
	public void before() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		System.setProperty("webdriver.chrome.driver", "src/Resource/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
		driver.navigate().to("https://www.saucedemo.com/");
	}
	
	@After
	public void after() {
		driver.close();
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
