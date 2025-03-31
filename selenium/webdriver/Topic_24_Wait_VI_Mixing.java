package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_VI_Mixing {
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

    @Test
    public void TC_03_Implicit_And_Explicit(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login");

        //01 - equal: 10s
        //02 - Implicit > Explicit: 12s (12-10)
        //02 - Implicit > Explicit: 12s (12-5)
        //02 - Implicit > Explicit: 10s (10-5)

        //03 - Implicit < Explicit: 20s (10-12)
        //03 - Implicit < Explicit: 16s (5-12)
        //03 - Implicit < Explicit: 11s (5-10)
        driver.manage().timeouts();



    }
    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
