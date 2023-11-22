import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import pageObjects.ProductsPageObjects;

public class ProductPageTest {

    LoginPageObjects loginPageObjects;
    WebDriver driver = null;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPageObjects = new LoginPageObjects();    }
    @Test
    public void testValidateProductsPage()    {
        ProductsPageObjects productPageObject=loginPageObjects.loginApplication(driver,"standard_user","secret_sauce");
        String productPageVariable = productPageObject.productTitle(driver);
        Assert.assertEquals(productPageVariable,"Products","Product title not matched");
        WebElement cartIcon = productPageObject.cartTitle(driver);
        Assert.assertTrue(cartIcon.isDisplayed(),"cart icon not displayed");
    }
    @Test
    public void testAddingProductToCart()   {
        ProductsPageObjects productPageObject=loginPageObjects.loginApplication(driver,"standard_user","secret_sauce");
        productPageObject.addItemToCart(driver);
        Assert.assertTrue(productPageObject.doesItemsAddedToCart(driver), "Items not added to cart");
        productPageObject.getCartItemsCount(driver);

    }
    @Test
    public void testAddingProductToCartCount()
    {
        ProductsPageObjects productPageObject=loginPageObjects.loginApplication(driver,"standard_user","secret_sauce");
        productPageObject.addItemToCart(driver);
        int productsCount = productPageObject.itemsAddedCount(driver);
        System.out.println(productsCount);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
