package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPageObjects {

    By productTitleLocator = By.xpath("//span[text()='Products']");
    By cartTitleLocator = By.xpath("//a[@class='shopping_cart_link']");
    By firstAddToCartButton = By.xpath("//button[text()='Add to cart']");
    By filterTitleL = By.xpath("//select[@class='product_sort_container']");
    By cartIconLocator = By.xpath("//a[@class='shopping_cart_link']");
    By cartItemsLocator = By.xpath("//span[@class='shopping_cart_badge']");


    public String productTitle(WebDriver driver) {
        return driver.findElement(productTitleLocator).getText();
    }

    public WebElement cartTitle(WebDriver driver) {
        return driver.findElement(cartTitleLocator);
    }

    public String filterTitle(WebDriver driver) {
        return driver.findElement(filterTitleL).getText();
    }

    @Step("Adding an item to cart")
    public void addItemToCart(WebDriver driver) {
        driver.findElement(firstAddToCartButton).click();
    }

    public boolean doesItemsAddedToCart(WebDriver driver) {
        return driver.findElement(cartItemsLocator).isDisplayed();
    }

    @Step("Adding multiple prodcuts to cart")
    public void addMultipleProducts(WebDriver driver) {
        List<WebElement> productAddButtons = driver.findElements(firstAddToCartButton);
        for (WebElement button : productAddButtons ) {
            button.click();
        }
    }
    @Step("Getting the cart items count")
    public String getCartItemsCount(WebDriver driver) {
        return driver.findElement(cartItemsLocator).getText();
    }

    @Step("Viewing the cart")
    public CartPageObjects viewCart(WebDriver driver) {
        driver.findElement(cartIconLocator).click();
        return new CartPageObjects();
    }
}


