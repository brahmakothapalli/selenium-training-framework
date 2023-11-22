package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageobjects.LoginPageObjects;
import utils.ConfigurationReader;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    protected LoginPageObjects loginPageObjects;

    private static String appUrl;
    public static String userName;
    public static String password;

    @BeforeSuite
    public static void getConfiguration() throws IOException {
        Properties prop = ConfigurationReader.readConfigFile();
        appUrl = prop.getProperty("appUrl");
        userName = prop.getProperty("username");
        password = prop.getProperty("password");
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(appUrl);
        loginPageObjects = new LoginPageObjects();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("takescreen");
            // report add
        }
        driver.close();
    }
}
