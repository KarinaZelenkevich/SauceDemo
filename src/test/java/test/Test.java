package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.BaseTest;

public class Test extends BaseTest {

    @org.testng.annotations.Test
    public void findingLocatorsInDifferentWays() {

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement loginButton = driver.findElement(By.name("login-button"));
        WebElement image = driver.findElement(By.tagName("title"));
        WebElement linktext = driver.findElement(By.linkText("https://www.linkedin.com/company/sauce-labs/"));
        WebElement partiallinktext = driver.findElement(By.partialLinkText("linkedin.com/"));
        WebElement menuButton = driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        WebElement loginByAttribute = driver.findElement(By.xpath("//input[@type= 'submit']"));
        WebElement loginLogo = driver.findElement(By.xpath("//div[contains(@class, 'login_lo')]"));
        WebElement cartLogo = driver.findElement(By.xpath("//span[contains(text(), '1')]"));
        WebElement productsLogo = driver.findElement(By.xpath("//span[contains(text(), 'Produ')]"));
        WebElement acceptedUserNamesForLogin = driver.findElement(By.xpath("//*[text()='Accepted usernames are:']//ancestor::div"));
        WebElement errorMessageByDescendant = driver.findElement(By.xpath("[//div/descendant::input[@class='input_error form_input']"));
        WebElement byFollowing = driver.findElement(By.xpath("//div[@id= 'login_credentials']//following::br[4]"));
        WebElement menuByParent = driver.findElement(By.xpath("//button[@id= 'react-burger-menu-btn']//parent::div"));
        WebElement menuByPreceding = driver.findElement(By.xpath("//input[@id = 'login-button']//preceding::div[4]"));
        WebElement loginLogoByClass = driver.findElement(By.cssSelector(".login_logo"));
        WebElement LoginByClass1_Class2 = driver.findElement(By.cssSelector(".login_wrapper .login_wrapper-inner"));
        WebElement SubmitButtonByClass1Class2 = driver.findElement(By.cssSelector(".submit-button.btn_action"));
        WebElement LoginButtonByID = driver.findElement(By.cssSelector("#login-button"));
        WebElement LoginButtonByTagName = driver.findElement(By.cssSelector("input"));
        WebElement LoginButtonByTagNameClass = driver.findElement(By.cssSelector("input.submit-button"));
// 1[attribute=value]
        WebElement RemoveButtonByAttributValue = driver.findElement(By.cssSelector("button[name='remove-sauce-labs-backpack']"));
// 2[attribute~=value]
        WebElement ByAttributValue2 = driver.findElement(By.cssSelector("[class~=title]"));
// 3[attribute|=value]
        WebElement ByAttributValue3 = driver.findElement(By.cssSelector("[lang|=en]"));
// 4[attribute^=value]
        WebElement ByAttributValue4 = driver.findElement(By.cssSelector("footer[class^='fo']"));
// 5[attribute$=value]
        WebElement ByAttributValue5 = driver.findElement(By.cssSelector("footer[class$='ter']"));
// 6[attribute*=value]
        WebElement ByAttributValue6 = driver.findElement(By.cssSelector("div[id*='container']"));


    }
}
