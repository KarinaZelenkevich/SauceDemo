package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class IFrameTest extends BaseTest {

    @Test
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        WebElement frameGetText= driver.findElement(By.cssSelector(".mce-content-body"));
        String frameText = frameGetText.getText();
        Assert.assertEquals("Your content goes here." , "Your content goes here.", "Текст не совпадает");



    }


}
