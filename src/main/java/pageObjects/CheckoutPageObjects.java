package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageObjects {
    By firstNameL = By.id("first-name");
    By lastNameL = By.id("last-name");
    By pinCodeL = By.id("postal-code");
    By continueBtnL = By.id("continue");
    By checkOutOverViewL = By.xpath("//span[text()='Checkout: Overview']");
    By itemAddedToCartL = By.xpath("//div[@class='inventory_item_name']");
    By finishBtnL = By.id("finish");
    By completeHeaderL = By.xpath("//h2[@class='complete-header']");

    public String checkOut(WebDriver driver, String firstname, String lastname, String pincode) {
        driver.findElement(firstNameL).sendKeys(firstname);
        driver.findElement(lastNameL).sendKeys(lastname);
        driver.findElement(pinCodeL).sendKeys(pincode);
        driver.findElement(continueBtnL).click();
        driver.findElement(checkOutOverViewL).getText();
        driver.findElement(itemAddedToCartL).getText();
        driver.findElement(finishBtnL).click();
        return driver.findElement(completeHeaderL).getText();
    }
}
