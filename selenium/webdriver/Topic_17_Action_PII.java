package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_17_Action_PII {
    WebDriver driver;
    Actions action;
    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @Test
    public void TC_01_ClickAndHold_Fix(){
        driver.get("https://automationfc.github.io/jquery-selectable/");

        //Click on one number and keep selecting
        // Move mouse to the expected number
        //  Keep highlight these selected numbers
        List<WebElement> numbers = driver.findElements(By.cssSelector("ol#selectable>li"));

        //click(): click and NOT keep select
        //clickAndHold(): click and keep select
        action.clickAndHold(numbers.get(1)) //select from second number
                .pause(Duration.ofSeconds(2))
                .moveToElement(numbers.get(11)) // select to 12th number
                .pause(Duration.ofSeconds(3))
                .release()
                .perform();


    }
    @Test
    public void TC_02_ClickAndHold_Random(){
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> numbers = driver.findElements(By.cssSelector("ol#selectable>li"));

        String osName = System.getProperty("os.name");
        Keys keys = null;

        if (osName.contains("Windows")){
            keys = Keys.CONTROL;
        }else {
            keys = Keys.COMMAND;
        }

        action.keyDown(keys).perform();
        action.click(numbers.get(4))
                .click(numbers.get(11))
                .click(numbers.get(12))
                .click(numbers.get(13))
                .perform();
        action.keyUp(keys).perform();
        List<WebElement> selectedNumbers = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(selectedNumbers.size(),4);
    }

    @Test
    public void TC_03_DoubleClick(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        action.doubleClick((driver.findElement(By.xpath("//button[text()='Double click me']"))))
                .pause(Duration.ofSeconds(4))
                .perform();
    }

    @Test
    public void TC_04_RightClick(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        Assert.assertFalse(driver.findElement(By.cssSelector("")).isDisplayed());
    }

    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
