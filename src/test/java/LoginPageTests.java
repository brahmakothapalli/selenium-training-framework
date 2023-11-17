import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;

public class LoginPageTests {

    LoginPageObjects loginPageObjects;


    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPageObjects = new LoginPageObjects();    }

    /**
     * Verifying the login page UI
     */
    @Test
    public void testLoginPageUI(){
        String title = loginPageObjects.getSwagTitle(driver);
        Assert.assertEquals(title, "Swag Labs", "Title is not as expected");
        Assert.assertTrue(loginPageObjects.getUserNameElement(driver).isDisplayed());
        Assert.assertTrue(loginPageObjects.getPasswordElement(driver).isDisplayed());
        Assert.assertTrue(loginPageObjects.getLoginElement(driver).isDisplayed());
    }

    @Test
    public void testLoginScenarios(){
        loginPageObjects.loginApplication(driver,"standard_user","secret_sauce");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
