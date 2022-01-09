package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest {
    @Test
    public void dynamicControls() {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//form[@id='checkbox-example']/button[@autocomplete='off']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        assertEquals(driver.findElement(By.xpath("//form[@id='checkbox-example']/p[@id='message']")).getText(),
                "It's gone!", "Кнопка не прожалась");

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int numberOfElements = driver.findElements(By.xpath("//form/div[@id='checkbox']")).size();

        assertEquals(numberOfElements, 0, "Элемент присутсвует на странице");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertFalse(driver.findElement(By.xpath("//form/input[@type='text']")).isEnabled(),
                "Строка ввода активна");

        driver.findElement(By.xpath("//form[@id='input-example']/button[@autocomplete='off']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        assertEquals(driver.findElement(By.xpath("//form[@id='input-example']/p[@id='message']")).getText(),
                "It's enabled!", "Строка ввода недоступна");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertTrue(driver.findElement(By.xpath("//form/input[@type='text']")).isEnabled(),
                "Input disabled");

    }

}
