package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest{
    @Test
    public void fileUpload() {
        driver.get("http://the-internet.herokuapp.com/upload");

        File file = new File("src/test/resources/photo_2021-09-28_09-11-14.jpg");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        assertEquals(driver.findElement(By.xpath("//div[@class='example']/h3")).getText(), "File Uploaded!", "Файл не загружен");
    }
}
