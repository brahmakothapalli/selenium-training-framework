import base.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ProductsPageObjects;

public class ProductPageTest extends BaseTest {

    @Test
    @Description("This test validates products page UI")
    public void testValidateProductsPage()    {
        ProductsPageObjects productPageObject=loginPageObjects.loginApplication(driver,userName,password);
        String productPageVariable = productPageObject.productTitle(driver);
        Assert.assertEquals(productPageVariable,"Products","Product title not matched");
        WebElement cartIcon = productPageObject.cartTitle(driver);
        Assert.assertTrue(cartIcon.isDisplayed(),"cart icon not displayed");
    }
    @Test
    @Description("This test validates adding product to cart functionality")
    public void testAddingProductToCart()   {
        ProductsPageObjects productPageObject=loginPageObjects.loginApplication(driver,userName, password);
        productPageObject.addItemToCart(driver);
        Assert.assertTrue(productPageObject.doesItemsAddedToCart(driver), "Items not added to cart");
        String itemsCount = productPageObject.getCartItemsCount(driver);
        System.out.println(itemsCount);

    }
    @Test
    @Description("This test validates adding multiple products functionality")
    public void testAddMultipleProducts()    {
        ProductsPageObjects productPageObject=loginPageObjects.loginApplication(driver,userName,password);
        productPageObject.addMultipleProducts(driver);
        String count = productPageObject.getCartItemsCount(driver);
        System.out.println(count);
    }

}
