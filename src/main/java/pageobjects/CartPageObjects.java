package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPageObjects {

    By checkOutButton = By.id("checkout");
    By removeButton = By.id("remove-sauce-labs-bike-light");

    public CheckoutPageObjects checkoutItems(WebDriver driver) {
        driver.findElement(checkOutButton).click();
        return new CheckoutPageObjects();
    }

    public void removeItemFromCart(WebDriver driver) {
        driver.findElement(removeButton).click();
    }



}
