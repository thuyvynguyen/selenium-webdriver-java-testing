package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_14_Checkbox_Radio {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.manage().window().setSize(new Dimension(1366,768));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Telerik(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        //Use for scroll down when screen 1366x768
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)" );

        //Verify checkbox enabled or disable
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isEnabled());

        //Verify checkbox selected or deselected
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isSelected());


        By dualZoneAirBy = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        if(!driver.findElement(dualZoneAirBy).isSelected() && driver.findElement(dualZoneAirBy).isEnabled()){
            driver.findElement(dualZoneAirBy).click();
        }
        Assert.assertTrue(driver.findElement(dualZoneAirBy).isSelected());
        driver.findElement(dualZoneAirBy).click();
        Assert.assertFalse(driver.findElement(dualZoneAirBy).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        //Use for scroll down when screen 1366x768
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)" );

        By twoPetrol = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        if(!driver.findElement(twoPetrol).isSelected() && driver.findElement(twoPetrol).isEnabled()){
            driver.findElement(twoPetrol).click();
        }
        Assert.assertTrue(driver.findElement(twoPetrol).isSelected());


    }
    @Test
    public void TC_02_Multiple(){
        driver.get("https://automationfc.github.io/multiple-fields/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)" );

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("span.form-checkbox-item>input"));
        for (WebElement checkbox: checkboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }
        for (WebElement checkbox: checkboxes){
            Assert.assertTrue(checkbox.isSelected());
        }

        for (WebElement checkbox: checkboxes){
            if(checkbox.isSelected()){
                checkbox.click();
            }
        }
        for (WebElement checkbox: checkboxes){
            Assert.assertFalse(checkbox.isSelected());
        }

        driver.findElement(By.cssSelector("input[value='Hepatitis']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Hepatitis']")).isSelected());

        for (WebElement checkbox: checkboxes){
            if(checkbox.getAttribute("value").equals("Tuberculosis") && !checkbox.isSelected()){
                checkbox.click();
            }
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Tuberculosis']")).isSelected());
        /*for(int i=0;i<checkboxes.size();i++){
            int number = new Random().nextInt(checkboxes.size());
            checkboxes.get(number).click();
            //Assert.assertTrue(driver.findElement(checkboxes.get(number)).isSelected());
        }*/
    }

    @AfterClass
    public void cleanBrowser() {driver.quit();}
}

