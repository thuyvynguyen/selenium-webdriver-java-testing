package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_I_Element_Status {
    WebDriver driver;
    WebElement explicitWait;


    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01(){
        driver.get("https://tiki.vn/");
    }
    @Test
    public void TC_02(){

    }

    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
