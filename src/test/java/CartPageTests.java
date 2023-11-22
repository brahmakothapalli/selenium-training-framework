import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CartPageObjects;
import pageobjects.ProductsPageObjects;

public class CartPageTests extends BaseTest {
    @Test
    public void testRemoveItemInTheCartPage(){
        ProductsPageObjects productsPageObjects = loginPageObjects.loginApplication(driver, userName,password);
        productsPageObjects.addItemToCart(driver);
        Assert.assertTrue(productsPageObjects.doesItemsAddedToCart(driver));
        CartPageObjects cartPageObjects = productsPageObjects.viewCart(driver);
        cartPageObjects.removeItemFromCart(driver);
//        cartPageObjects.checkoutItems(driver);
    }
}
