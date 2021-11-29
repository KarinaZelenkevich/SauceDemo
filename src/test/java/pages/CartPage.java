package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    public static final String PRODUCT_IN_THE_CART = ".inventory_item_name";
    public static final String PRODUCT_PRICE_IN_THE_CART = ".inventory_item_price";
    public static final By REMOVE_BUTTON_IN_THE_CART = (By.id("remove-sauce-labs-onesie"));


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void itemInTheCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(PRODUCT_IN_THE_CART, nameProduct)));
    }

    public String getProductPriceFromTheShoppingCart(String nameProduct) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE_IN_THE_CART, nameProduct))).getText();
    }

    public void removeButtonInTheCart() {
        driver.findElement(REMOVE_BUTTON_IN_THE_CART).click();

    }
}
