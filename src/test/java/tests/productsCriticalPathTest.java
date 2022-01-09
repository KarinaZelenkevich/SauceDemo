package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class productsCriticalPathTest extends BaseTest {

    @Test(description = "product should be added into cart")
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        String priceFromInventoryPage = inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        Assert.assertEquals(
                cartPage.getProductPriceFromTheShoppingCart("Sauce Labs Onesie"),
                priceFromInventoryPage, "Цены не равны");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
    }

    @Test(description = "user data fields to continue shopping should be filled")
    public void fieldsForUserDataToContinueShopping() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutButtonClick();
        Assert.assertTrue(checkoutStepOnePage.fieldsForUserData(), "Не был произведен переход на страницу чекаута");

    }

}
