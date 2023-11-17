package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPageObjects {

    By productTitleL = By.xpath("//span[text()='Products']");
    By cartTitleL = By.xpath("//a[@class='shopping_cart_link']");
    By filterTitleL = By.xpath("//select[@class='product_sort_container']");
    By addToCartL=By.id("add-to-cart-sauce-labs-backpack");
    By cartIconL =By.xpath("//span[@class='shopping_cart_badge']");
    By checkOutL =By.id("checkout");
    By firstNameL = By.id("first-name");
    By lastNameL = By.id("last-name");
    By pinCodeL=By.id("postal-code");
    By continueBtnL=By.id("continue");
    By checkOutOverViewL =By.xpath("//span[text()='Checkout: Overview']");
    By itemAddedToCartL = By.xpath("//div[@class='inventory_item_name']");
    By finishBtnL = By.id("finish");
    By completeHeaderL = By.xpath("//h2[@class='complete-header']");

    public String productTitle(WebDriver driver)
    {
       return driver.findElement(productTitleL).getText();
    }
    public WebElement cartTitle(WebDriver driver)
    {
        return driver.findElement(cartTitleL);
    }
    public String filterTitle(WebDriver driver)
    {
        return driver.findElement(filterTitleL).getText();
    }
    public void addToCart(WebDriver driver)
    {

        driver.findElement(addToCartL).click();

    }
    public String checkOut(WebDriver driver,String firstname,String lastname,String pincode)
    {
        driver.findElement(cartIconL).click();
        driver.findElement(checkOutL).click();
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
