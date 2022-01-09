package tests;

import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

public class CheckOutPageTest extends BaseTest {
    @Attachment
    @Test(description = "user data fields should be filled to complete your purchase")
    public void checkOutPageTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutButtonClick();
        checkoutStepOnePage.login("adaed", "afeffa", "1255574");
        Assert.assertEquals(checkoutStepOnePage.getCheckoutErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не верно");
    }

    @Attachment
    @Test(description = "Last Name should be required to complete your purchase")
    public void checkOutPageTestWithoutLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutButtonClick();
        checkoutStepOnePage.login("adaed", "", "1255574");
        Assert.assertEquals(checkoutStepOnePage.getCheckoutErrorMessage(),
                "Error: Last Name is required",
                "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver);
    }


    @Test(description = "First Name should be required to complete your purchase")
    public void checkOutPageTestWithoutFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutButtonClick();
        checkoutStepOnePage.login("", "afeffa", "1255574");
        Assert.assertEquals(checkoutStepOnePage.getCheckoutErrorMessage(),
                "Error: First Name is required",
                "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver);

    }

    @Attachment
    @Test(description = "Postal Code should be required to complete your purchase")
    public void checkOutPageTestWithoutZipCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutButtonClick();
        checkoutStepOnePage.login("afafa", "", "12563");
        Assert.assertEquals(checkoutStepOnePage.getCheckoutErrorMessage(),
                "Error: Postal Code is required",
                "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver);
    }
}
