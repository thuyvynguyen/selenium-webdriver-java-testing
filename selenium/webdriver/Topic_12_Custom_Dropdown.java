package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Assignment_01_Jquery() throws InterruptedException{
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInCustomDropdown("span#speed-button", "ul#speed-menu>li>div","Medium");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Medium");

        selectItemInCustomDropdown("span#number-button","ul#number-menu>li>div","11");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"11");

        selectItemInCustomDropdown("span#salutation-button","ul#salutation-menu>li>div","Prof.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Prof.");
    }


    @Test
    public void Assignment_02_React() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInCustomDropdown("i.dropdown", "div.item","Matt");
        //System.out.print(driver.findElement(By.cssSelector("div.divider.text")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Matt");
    }

    @Test
    public void Assignment_03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu>li>a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");
    }
    @Test
    public void Assignment_04_Editable() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        enterItemInCustomDropdown("input.search","span.text", "Andorra");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Andorra");

        enterItemInCustomDropdown("input.search","span.text", "Belgium");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Belgium");
    }
    private void selectItemInCustomDropdown (String parentCss, String childCss, String textItem) throws InterruptedException{
        //These steps to work with dropdown
        //1, Wait for icon in dropdown display
        //2, Click on dropdown list to show these values
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();
        //driver.findElement(By.cssSelector(parentCss)).click();
        Thread.sleep(2000);

        //3, Wait for all values of dropdown list presence
        //4, Find expectation value
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss))); //driver.findElements(By.cssSelector(childCss));
        for (WebElement item: allItems){
            if(item.getText().equals(textItem)){
                //5, Choose Medium
                item.click();
                break;
            }
        }
    }

    private void enterItemInCustomDropdown (String parentCss, String childCss, String textItem) throws InterruptedException{
        //These steps to work with dropdown
        //1, Wait for icon in dropdown display
        //2, Input to text box
        WebElement dropbox = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentCss)));
        dropbox.clear();
        dropbox.sendKeys(textItem);
        Thread.sleep(2000);

        //3, Wait for all values of dropdown list presence
        //4, Find expectation value
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss))); //driver.findElements(By.cssSelector(childCss));
        for (WebElement item: allItems){
            if(item.getText().equals(textItem)){
                //5, Choose Medium
                item.click();
                break;
            }
        }
    }



    @AfterClass
    public void cleanBrowser() {driver.quit();}
}
