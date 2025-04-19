package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_Alway_Run {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Assert.assertTrue(false);
        System.out.println("--------Pass Before Class-----------");
    }
    @Test
    public void register(){
        System.out.println("Action and Verify");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driver.quit();

        System.out.println("--------Pass After Class-----------");
    }
}
