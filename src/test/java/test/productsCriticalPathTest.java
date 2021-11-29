package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class productsCriticalPathTest extends BaseTest {
    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        Assert.assertEquals(inventoryPage.getPriceByName("Sauce Labs Onesie"), cartPage.getProductPriceFromTheShoppingCart("Sauce Labs Onesie"), "Цены не равны");

    }

    @Test
    public void removeButtonClick() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.removeButtonInTheCart();

    }

}
