package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class CheckOutPageTest extends BaseTest {

    @Test
    public void checkOutPageTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutButtonClick();
        checkoutStepOnePage.login("adaed", "afeffa", "1255574");
//      TODO assert появилась ли след страница
    }

    @Test
    public void checkOutPageTestWithoutLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutButtonClick();
        checkoutStepOnePage.login("adaed", "afeffa", "1255574");
//      TODO assertEquals на ошибку
    }


    @Test
    public void checkOutPageTestWithoutFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutButtonClick();
        checkoutStepOnePage.login("", "afeffa", "1255574");
//      TODO assertEquals на ошибку

    }

    @Test
    public void checkOutPageTestWithoutZipCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.getPriceByName("Sauce Labs Onesie");
        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.checkoutButtonClick();
        checkoutStepOnePage.login("", "afeffa", "1255574");
//      TODO assertEquals на ошибку
    }
}
