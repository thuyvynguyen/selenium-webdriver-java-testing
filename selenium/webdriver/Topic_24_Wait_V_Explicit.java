package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_V_Explicit {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();
         explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test (description = "Implicit Time = 0 ")
    public void TC_01(){
        driver.get("https://automationfc.github.io/dynamic-loading/");



    }   
    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
