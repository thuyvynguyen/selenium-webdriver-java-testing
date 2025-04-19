package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_AAA_Patterns {
    //Arrange
    //Setup/ Initial Data / Browser / Driver / Variable/ DB..
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void register(){
        //------------------Action
        //Open page
        //Fill data to form
        //----------------Assert
        //Verify success message
    }


}
