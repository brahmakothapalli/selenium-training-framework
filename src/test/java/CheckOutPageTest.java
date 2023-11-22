import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CheckoutPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ProductsPageObjects;
@Test
public class CheckOutPageTest {
    LoginPageObjects loginPageObjects;
    WebDriver driver = null;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPageObjects = new LoginPageObjects();
    }

    public void checkOutMethod() {
        String CheckoutPageObjects  = new CheckoutPageObjects().checkOut(driver, "Deepthi", "Gandham", "8050");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
