package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_IFrame {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Map(){
        //A include iFrameB
        driver.get("https://embedgooglemap.net/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.gmap_canvas>iframe")));

        //in B
        String addressName = driver.findElement(By.cssSelector("div.place-name")).getText();
    }
    @Test
    public void TC_02_Formsite() throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        Thread.sleep(4000);

        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));

        new Select(driver.findElement(By.xpath("//label[contains(text(),'Year')]/following-sibling::select"))).selectByVisibleText("Junior");
        new Select(driver.findElement(By.xpath("//label[contains(text(),'Residence')]/following-sibling::select"))).selectByVisibleText("West Dorm");


    }

    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
