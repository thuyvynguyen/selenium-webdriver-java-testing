package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_Wait {
    WebDriver driver; // declare variable driver, but drive is still null
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait; // Java Generic

    @BeforeClass
    //implicitWait
    public void initialBrowser(){
        driver = new FirefoxDriver(); // initial value for driver
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        //1, Implicit Wait: only use for findEmplement(s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2, Explicit Wait
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //3, Fluent Wait
        fluentWait = new FluentWait<WebDriver>(driver);
    }

    @Test
    public void TC_01(){
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));
        fluentWait = new FluentWait<WebDriver>(driver);
    }

    @Test
    public void TC_02(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
