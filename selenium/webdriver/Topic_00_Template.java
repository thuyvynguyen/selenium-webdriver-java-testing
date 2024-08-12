package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.Duration;

public class Topic_00_Template {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();
         driver.get("https://demo.nopcommerce.com/login");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01(){

    }
    @Test
    public void TC_02(){

    }

    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
