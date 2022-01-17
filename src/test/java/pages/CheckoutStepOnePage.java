package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {
    public static final String CHECKOUT_STEP_ONE = "//div[@class='checkout_info']";
    public static final By FIRSTNAME_INPUT = (By.id("first-name"));
    public static final By LASTNAME_INPUT = (By.id("last-name"));
    public static final By ZIP_CODE_INPUT = (By.id("postal-code"));
    public static final By CONTINUE_BUTTON = (By.id("continue"));
    public static final By CHECKOUT_ERROR_MESSAGE = (By.cssSelector(".error-message-container"));


    public void login(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstName);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getCheckoutErrorMessage() {
        return driver.findElement(CHECKOUT_ERROR_MESSAGE).getText();

    }

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkOutStepOneIsDisplayed() {
        return driver.findElement(By.xpath(String.format(CHECKOUT_STEP_ONE))).isDisplayed();
    }
}
