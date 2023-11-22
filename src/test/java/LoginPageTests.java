import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

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

        String path = System.getProperty("user.dir");

        loginPageObjects.loginApplication(driver,userName, password);
    }



}
