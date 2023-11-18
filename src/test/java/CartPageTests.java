import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CartPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ProductsPageObjects;

public class CartPageTests {


    LoginPageObjects loginPageObjects;
    WebDriver driver = null;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPageObjects = new LoginPageObjects();
    }
    @Test
    public void testRemoveItemInTheCartPage(){
        ProductsPageObjects productsPageObjects = loginPageObjects.loginApplication(driver, "standard_user","secret_sauce");
        productsPageObjects.addItemToCart(driver);
        Assert.assertTrue(productsPageObjects.doesItemsAddedToCart(driver));
        CartPageObjects cartPageObjects = productsPageObjects.viewCart(driver);
        cartPageObjects.removeItemFromCart(driver);
//        cartPageObjects.checkoutItems(driver);
    }
}
