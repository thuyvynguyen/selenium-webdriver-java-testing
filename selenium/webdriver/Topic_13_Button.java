package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
public class Topic_13_Button {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Fahasa(){
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        By loginButton = By.cssSelector("button.fhs-btn-login");
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        /*String loginBackgroundColor = driver.findElement(loginButton).getCssValue("background-color");
        Color logicColor = Color.fromString(loginBackgroundColor);
        Assert.assertEquals(logicColor.asHex().toUpperCase(), "#000000");*/
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(), "#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("a@mail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456@A");
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());

        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(), "#C92127");

        driver.findElement(loginButton).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.fhs-login-msg")).getText(),"Số điện thoại/Email hoặc Mật khẩu sai!");
        Assert.assertEquals(driver.findElement(loginButton).getText(),"Đăng nhập");
    }
}
