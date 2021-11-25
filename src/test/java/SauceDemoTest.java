import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {

        String userNameById = "user-name";
        String passwordByXpath = "//*[@id='password']";
        String loginButton = "login-button";
        String itemByContainsText = "//div[contains(text(), 'Sauce Labs Backpack')]";
        String itemPrice = "//div[div[a[@id='item_4_title_link']]]/div[@class='pricebar']/div";
        String addToCartButton = "//*[@id='add-to-cart-sauce-labs-backpack']";
        String shoppingCartLogo = ".shopping_cart_link";
        String itemInTheShoppingCart = "//*[@id='item_4_title_link']/div";
        String itemPriceInTheShoppingCart = ".item_pricebar";


    @Test
    public void sauceDemo() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id(userNameById)).sendKeys("standard_user");
        driver.findElement(By.xpath(passwordByXpath)).sendKeys("secret_sauce");
        driver.findElement(By.name(loginButton)).click();
        driver.findElement(By.xpath(itemByContainsText)).getText();
        String itemPriceValue = driver.findElement(By.xpath(itemPrice)).getText();
        itemPrice = "$\n$29.99";
        driver.findElement(By.xpath(addToCartButton)).click();
        driver.findElement(By.cssSelector(shoppingCartLogo)).click();

        boolean isDisplayed = driver.findElement(By.xpath("//span[contains(text(), 'Your Cart')]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Не перешли на страницу корзины");

        driver.findElement(By.xpath(itemInTheShoppingCart)).getText();
        String itemPriceValueInTheShoppingCart = driver.findElement(By.cssSelector(itemPriceInTheShoppingCart)).getText();
        itemPriceInTheShoppingCart = "$\n$29.99";

        Assert.assertEquals(itemPriceValue, itemPriceValueInTheShoppingCart);


    }
}