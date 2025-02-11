package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Action_PIII {
    WebDriver driver;
    Actions action;

    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();
         driver.get("https://demo.nopcommerce.com/login");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @Test
    public void TC_01_Scroll() throws InterruptedException{
        //WebElement
        //driver.findElement(By.cssSelector("")).click();

        //Action
        //action.click(driver.findElement(By.cssSelector(""))).perform();

        //JS
        //jsExecutor.executeScript("",driver.findElement(By.cssSelector("")));

        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double click me']"));

        if(driver.toString().contains("Chrome") || driver.toString().contains("Edge")){
            action.scrollToElement(doubleClickButton).perform();
            Thread.sleep(1000);
        }else{
            // scroll by javascript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",doubleClickButton);
            Thread.sleep(1000);
        }
        action.doubleClick(doubleClickButton)
                .pause(Duration.ofSeconds(5))
                .perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");

    }
    @Test
    public void TC_02_Drag_Drop_HTML4(){
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement sourceCircle = driver.findElement(By.cssSelector(""));
        WebElement targetCircle = driver.findElement(By.cssSelector(""));

        //Before drag and drop
        Assert.assertEquals(sourceCircle.getText(),"Drag the small circle here.");

        //Drag and drop
        action.dragAndDrop(sourceCircle,targetCircle)
                .pause(Duration.ofSeconds(2));

        //After drag and drop
        Assert.assertEquals(targetCircle.getText(),"You did great!");
        Assert.assertEquals(targetCircle.getCssValue("background-color"),"");
    }

    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
