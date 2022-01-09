package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;


public class IFrameTest extends BaseTest {

    @Test(description = "The text within the paragraph must be equal to “Your content goes here.")
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        WebElement frameGetText = driver.findElement(By.cssSelector(".mce-content-body"));
        String frameText = frameGetText.getText();
        Assert.assertEquals("Your content goes here.", "Your content goes here.", "Текст не совпадает");
        AllureUtils.takeScreenshot(driver);

    }


}
