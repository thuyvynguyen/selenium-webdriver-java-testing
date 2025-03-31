package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_23_UploadFile {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Single(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By uploadFile = By.xpath("//input[@type='file']");

        driver.findElement(uploadFile).sendKeys("");
    }
    @Test
    public void TC_02(){

    }

    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
