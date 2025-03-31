package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_Wait_II_FindElement {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
    }

    @Test
    public void TC_01_FindElement(){
        //Tim 1 element - Vao se tim thay, khong dung het timeout cua implicitWait
        driver.findElement(By.cssSelector("input#email"));

    }
    @Test
    public void TC_02_FindElements(){
        //
    }

    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
