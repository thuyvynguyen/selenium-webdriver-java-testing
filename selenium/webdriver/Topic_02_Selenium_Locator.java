package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Selenium_Locator {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://tiki.vn/");
    }

    @Test
    public void TC_01_ID(){
        driver.findElement(By.id("small-searchterms"));
    }

    @Test
    public void TC_02_Class(){
        // Giá trị trong class mà ko có khoảng trắng (lấy toàn bộ)
        // Giá trị có khoảng trắng (lấy phần nào là duy nhất)
        driver.findElement(By.className("gender"));
    }

    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("DateOfBirthDay"));
        driver.findElement(By.name("DateOfBirthMonth"));
        driver.findElement(By.name("DateOfBirthYear"));
    }

    @Test
    public void TC_04_LinkText(){
        driver.findElement(By.linkText("Sitemap"));
        driver.findElement(By.linkText("New products"));
    }

    @Test
    public void TC_05_PartialLinkText(){
        driver.findElement(By.partialLinkText("downloads"));
    }

    @Test
    public void TC_06_TagName(){
        driver.findElements(By.tagName("a"));
        driver.findElements(By.tagName("input"));
    }

    @Test
    public void TC_07_Css(){
        driver.findElement(By.cssSelector("input[id='LastName']"));
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#FirstName"));

        driver.findElement(By.cssSelector("button.register-next-step-button"));
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));

        driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"));
        driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"));
        driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"));

        driver.findElement(By.cssSelector("a[href='/login?returnUrl=%2Fregister']"));
        driver.findElement(By.cssSelector("a[href*='/login?']"));

        driver.findElements(By.cssSelector("a"));
        driver.findElements(By.cssSelector("input"));
        driver.findElements(By.cssSelector("button"));
    }

    @Test
    public void TC_08_Xpath(){
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//a[@class='ico-register']"));
        driver.findElement(By.xpath("//input[contains(@class,'search-box-text')]"));

        driver.findElement(By.xpath("//select[@name='customerCurrency']"));
        driver.findElement(By.xpath("//a[@href='/apparel']"));
        driver.findElement(By.xpath("//a[contains(@href,'returns')]"));

        driver.findElements(By.xpath("//label"));
        driver.findElements(By.xpath("//input"));
    }

    @Test
    public void TC_09_Relative_Locatior(){
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/login");

        //Element/ By A
        By passwordTextBoxBy = By.cssSelector("input#Password");

        //Element/ By B
        By rememberMeCheckboxBy = By.id("RememberMe");

        //Element/ By C
        By forgotPasswordLinkBy = By.cssSelector("span.forgot-password");

        //Element/ By D
        By loginButtonBy = By.cssSelector("button.login-button");

        //Element/ By E
        driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)
                .below(passwordTextBoxBy)
                .toRightOf(rememberMeCheckboxBy)
                .toLeftOf(forgotPasswordLinkBy));
    }

    @Test
    public void TC_10_Locator_Priority(){
        /*driver = new FirefoxDriver();
        driver.get("");*/

        driver.findElement(By.xpath("//input[@data-view-id='main_search_form_input']"));
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}
