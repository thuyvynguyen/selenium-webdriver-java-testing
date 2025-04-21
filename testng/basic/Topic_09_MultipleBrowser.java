package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_MultipleBrowser {
    WebDriver driver;
    @Parameters({"browser"})
    @BeforeClass
    public void initialBrowser(String browserName){
        System.out.println("Browser name = "+ browserName);
        switch (browserName.toUpperCase()){
            case "FIREFOX": driver = new FirefoxDriver();
            break;
            case "CHROME": driver = new ChromeDriver();
            break;
            case "EDGE": driver = new EdgeDriver();
            break;
            default: throw new RuntimeException("Browser name does NOT support");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Button() throws InterruptedException{
        driver.get("https://www.fahasa.com/customer/account/create");

        By registerButton = By.cssSelector("button.fhs-btn-register");
        By loginButton = By.cssSelector("button.fhs-btn-login");

        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        //Verify button disabled
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(), "#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("a@mail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456789");
        Thread.sleep(2000);

        //Verify Button enabled
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(), "#C92127");
    }

    @AfterClass
    public void cleanBrowser() { driver.quit();}

}
