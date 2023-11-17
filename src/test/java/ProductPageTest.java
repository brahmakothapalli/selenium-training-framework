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
    public void testValidateProductsPage()
    {

        ProductsPageObjects productPageObject=loginPageObjects.loginApplication(driver,"standard_user","secret_sauce");
       // ProductsPageObjects productPageObject = new ProductsPageObjects();
        String productPageVariable = productPageObject.productTitle(driver);
        Assert.assertEquals(productPageVariable,"Products","Product title not matched");
        WebElement cartIcon = productPageObject.cartTitle(driver);
        Assert.assertTrue(cartIcon.isDisplayed(),"cart icon not displayed");
    }
    @Test
    public void testAddingProductTOCart()
    {

        //ProductsPageObjects productPageObject=loginPageObjects.loginApplication(driver,"standard_user","secret_sauce");
        // ProductsPageObjects productPageObject = new ProductsPageObjects();
        ProductsPageObjects checkOutOverView =  new ProductsPageObjects().checkOut(driver,"Deepthi","Gandham","8050");
        String checkOutOverViewElement =
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
