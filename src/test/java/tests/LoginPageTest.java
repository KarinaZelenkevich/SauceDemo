package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.Retry;
import utils.AllureUtils;

public class LoginPageTest extends BaseTest {

    @Attachment
    @Step("Open a website and login to an account with correct user data")
    @Test
    public void loginTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.titleIsDisplayd(), "Не был произведен переход на страницу каталога");
    }
    @Attachment
    @Step("Open a website and login to an account with only a password")
    @Link("http://google.com")
    @Test(description = "Username should be required")
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не верно");

    }
    @Step("Open a website and login to an account specifying only the usernam")
    @Link("http://google.com")
    @Test(retryAnalyzer = Retry.class, description = "Password should be required")
    public void passwordShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver);

    }

    @Attachment
    @Link("http://google.com")
    @Test(description = "User data should be correct")
    public void userDataShouldBeCorrect() {
        loginPage.open();
        loginPage.login("adasda", "adad");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "The account of the blocked user should not be opened")
    public void lockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver);
    }

}
