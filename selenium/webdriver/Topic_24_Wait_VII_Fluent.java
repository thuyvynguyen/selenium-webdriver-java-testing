package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_24_Wait_VII_Fluent {
    WebDriver driver;
    WebDriverWait explicitWait;

    //Declare
    FluentWait<WebDriver> fluentWaitDriver;
    /*FluentWait fluentWait;
    FluentWait<WebElement> fluentWaitElement;
    FluentWait<Boolean> fluentWaitBoolean;*/

    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();

         //Initial
        /*
        fluentWaitElement = new FluentWait<>(driver.findElement(By.cssSelector("")));
        fluentWaitBoolean = new FluentWait<>(true);*/

    }

    @Test
    public void TC_01(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();

        //Trong vòng 3s cu  moi 1/3s se tim chu HelloWorld hien thi
        fluentWaitDriver = new FluentWait<>(driver);
        fluentWaitDriver.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        String helloText = fluentWaitDriver.until(new com.google.common.base.Function<WebDriver, String>() {
                    @Override
                    public String apply(WebDriver webDriver){
                        System.out.println("-------------Finding element then Get text----------");
                        return webDriver.findElement(By.cssSelector("div#finish>h4")).getText();
                    }
                });

        Assert.assertEquals(helloText,"Hello World!");

        boolean helloStatus = fluentWaitDriver.until(new Function<WebDriver, Boolean>() {
            public  Boolean apply(WebDriver webDriver){
                return driver.findElement(By.cssSelector("div#finish>h4")).getText().equals("Hello World!");
            }
        });
        Assert.assertTrue(helloStatus);
    }
    @Test
    public void TC_02(){
        driver.get("https://automationfc.github.io/fluent-wait/");
        //Count down from 12 to 00
        fluentWaitDriver = new FluentWait<>(driver);
        fluentWaitDriver.withTimeout(Duration.ofSeconds(13))
                .pollingEvery(Duration.ofMillis(112))
                .ignoring(NoSuchElementException.class);
        Assert.assertTrue(fluentWaitDriver.until(new Function<WebDriver, Boolean>() {
            public  Boolean apply(WebDriver webDriver){
                String text = driver.findElement(By.cssSelector("div#javascript_countdown_time")).getText();
                System.out.println(text);
                return text.equals("01:01:00");
            }
        }));
    }
    //Find element return web element
    public WebElement findElement(By by){
        //Declare + Initial
        FluentWait fluentWait = new FluentWait(driver);

        //Config Time //Polling // Exception
        fluentWait.withTimeout(Duration.ofSeconds(15))
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(NoSuchElementException.class);

        //Condition
        return (WebElement) fluentWait.until(new Function<WebDriver,WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }

    //Check visibility of element isDisplay()
    public boolean isElementDisplayed(By by){
        //Declare + Initial
        FluentWait fluentWait = new FluentWait(driver);

        //Config Time //Polling // Exception
        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        return (boolean) fluentWait.until(new Function<WebDriver,Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }

    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
