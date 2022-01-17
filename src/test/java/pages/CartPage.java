package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public static final String PRODUCT_IN_THE_CART = ".inventory_item_name";
    public static final String PRODUCT_PRICE_IN_THE_CART = ".inventory_item_price";
    public static final By CHECKOUT_BUTTON = (By.cssSelector(".btn.btn_action.btn_medium.checkout_button"));


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void itemInTheCart(String nameProduct) {
        driver.findElement(By.cssSelector(String.format(PRODUCT_IN_THE_CART, nameProduct)));
    }

    public String getProductPriceFromTheShoppingCart(String nameProduct) {
        return driver.findElement(By.cssSelector(String.format(PRODUCT_PRICE_IN_THE_CART, nameProduct))).getText();
    }

    public void checkoutButtonClick() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
