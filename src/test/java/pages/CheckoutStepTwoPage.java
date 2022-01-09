package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CheckoutStepTwoPage extends BasePage {
    public static final String CHECKOUT_STEP_TWO = "//div[contains(text(),'Payment Information:')]";
    public static final By FINISH_BUTTON = (By.id("finish"));
    public static final By CHECKOUT_ERROR_MESSAGE = (By.cssSelector(".error-message-container"));

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }


    public void finishShopping() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public String getCheckoutErrorMessage() {
        return driver.findElement(CHECKOUT_ERROR_MESSAGE).getText();

    }


    public boolean fieldsForUserData() {
        return driver.findElement(By.xpath(String.format(CHECKOUT_STEP_TWO))).isDisplayed();
    }
}