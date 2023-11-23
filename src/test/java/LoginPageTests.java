import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    /**
     * Verifying the login page UI
     */
    @Test
    @Description("This test verifies UI of the login page")
    public void testLoginPageUI(){
        String title = loginPageObjects.getSwagTitle(driver);
        Assert.assertEquals(title, "Swag Labs", "Title is not as expected");
        Assert.assertTrue(loginPageObjects.getUserNameElement(driver).isDisplayed());
        Assert.assertTrue(loginPageObjects.getPasswordElement(driver).isDisplayed());
        Assert.assertTrue(loginPageObjects.getLoginElement(driver).isDisplayed());
    }

    @Test
    @Description("This test validates login functionality")
    public void testLoginScenarios(){
        String path = System.getProperty("user.dir");
        loginPageObjects.loginApplication(driver,userName, password);
    }



}
