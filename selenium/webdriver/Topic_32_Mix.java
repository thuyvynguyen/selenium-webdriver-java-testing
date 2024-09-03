package webdriver;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_32_Mix {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();
         driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Element_Found(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        //Wait for explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

        //Wait for implicit
        driver.findElement(By.cssSelector("input#email"));
    }
    @Test
    public void TC_02_Element_Not_Found_Only_Implicit(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement((By.cssSelector("input#automaticfc")));
    }
    @Test
    public void TC_03_Element_Not_Found_Only_Explicit(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        //Wait for explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automaticfc")));
    }
    @Test
    public void TC_04_Element_Not_Found(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        //Wait for explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

        //Wait for implicit
        driver.findElement(By.cssSelector("input#automaticfc"));
    }
    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
