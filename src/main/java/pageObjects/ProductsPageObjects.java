package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPageObjects {

    By productTitleL = By.xpath("//span[text()='Products']");
    By cartTitleL = By.xpath("//a[@class='shopping_cart_link']");

    By cartItems = By.xpath("//span[@class='shopping_cart_badge']");
    By itemsAddedToCartCount = By.xpath("//button[text()='Add to cart']");
    By filterTitleL = By.xpath("//select[@class='product_sort_container']");
    By addToCartL = By.xpath("//a[@class='shopping_cart_link']");
    By cartIconL = By.xpath("//span[@class='shopping_cart_badge']");


    public String productTitle(WebDriver driver) {
        return driver.findElement(productTitleL).getText();
    }

    public WebElement cartTitle(WebDriver driver) {
        return driver.findElement(cartTitleL);
    }

    public String filterTitle(WebDriver driver) {
        return driver.findElement(filterTitleL).getText();
    }


    public void addItemToCart(WebDriver driver) {
        driver.findElement(addToCartL).click();
    }

    public boolean doesItemsAddedToCart(WebDriver driver) {
        return driver.findElement(cartItems).isDisplayed();
    }

    public int itemsAddedCount(WebDriver driver) {
        List<WebElement> items = driver.findElements(itemsAddedToCartCount);
        return items.size();
    }

    public String getCartItemsCount(WebDriver driver) {
        return driver.findElement(cartItems).getText();
    }

    public CartPageObjects viewCart(WebDriver driver) {
        driver.findElement(addToCartL).click();
        return new CartPageObjects();
    }
}


