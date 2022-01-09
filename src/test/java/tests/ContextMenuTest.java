package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest {
    @Attachment
    @Test(description = "Alert text should be the same as expected")
    public void contextMenu() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.id("hot-spot")))
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "You selected a context menu", "Текст алерта неверный");
        alert.dismiss();
        AllureUtils.takeScreenshot(driver);


    }
}




