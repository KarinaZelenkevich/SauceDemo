package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    public static final String ADD_PRODUCT_BUTTON = "//div[div[div[a[div[@class='inventory_item_name'][text()=\"%s\"]]]]]//button";
    public static final String GET_PRODUCT_PRICE = "//div[div[div[a[div[@class=\"inventory_item_name\"][text()=\"%s\"]]]]]/div/div/div[@class=\"inventory_item_price\"]";
    public static final String TITLE_PRODUCTS_IS_DISPLAYD = "//span[contains(text(), 'Produ')]";
    public static final String ADD_SECOND_PRODUCT_BUTTON = "//*[@id='add-to-cart-sauce-labs-backpack']";

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/cart.html");
    }


    public void addToCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).click();
    }

    public boolean titleIsDisplayd() {
        return driver.findElement(By.xpath(String.format(TITLE_PRODUCTS_IS_DISPLAYD))).isDisplayed();
    }

    public void addToCartTheSecondProduct(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_SECOND_PRODUCT_BUTTON, nameProduct))).click();
    }

    public String getPriceByName(String nameProduct) {
        return driver.findElement(By.xpath(String.format(GET_PRODUCT_PRICE, nameProduct))).getText();
    }
}
