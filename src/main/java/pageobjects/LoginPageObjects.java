package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

    By swagLabsTitleLocator = By.xpath("//div[@class='login_logo']");

    By userNameLocator = By.id("user-name");

    By passwordLocator = By.id("password");

    By loginButtonLocator = By.id("login-button");

    public String getSwagTitle(WebDriver driver){
        return driver.findElement(swagLabsTitleLocator).getText();
    }

    public WebElement getUserNameElement(WebDriver driver){
        return driver.findElement(userNameLocator);
    }

    public WebElement getPasswordElement(WebDriver driver){
        return driver.findElement(passwordLocator);
    }

    public WebElement getLoginElement(WebDriver driver){
        return driver.findElement(loginButtonLocator);
    }
    public ProductsPageObjects loginApplication(WebDriver driver,String userName,String passWord)
    {
        getUserNameElement(driver).sendKeys(userName);
        getPasswordElement(driver).sendKeys(passWord);
        getLoginElement(driver).click();
        return new ProductsPageObjects();
    }
}
