package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_22_JavascriptExecutor {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    String addressEmail;

    @BeforeClass
    public void initialBrowser(){
         driver = new FirefoxDriver();

         //Ep kieu tuong minh
        jsExecutor = (JavascriptExecutor) driver;

        addressEmail = "vyxinhdep" + new Random().nextInt() + "@gmail.com";

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_WorkAround() throws  InterruptedException{
        driver.get("http://live.techpanda.org/index.php");

        //Click by WebElement
        //driver.findElement(By.xpath("//div[@id='header-account']//a[text()='My Account']")).click();

        //Click by Actions
        //new Actions(driver).click(driver.findElement(By.xpath("//div[@id='header-account']//a[text()='My Account']"))).perform();

        //click hidden element
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='header-account']//a[text()='My Account']")));
        Thread.sleep(5000);

        //click element without hover mouse
        driver.get("http://live.techpanda.org/index.php");
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Sách Trong Nước']")));
        Thread.sleep(5000);
    }
    @Test
    public void TC_02_TechPanda() throws  InterruptedException{
        navigateToUrlByJS("http://live.techpanda.org/");
        String techPandaDomain = (String) executeForBrowser("return document.domain;");
        System.out.println(techPandaDomain);

        Assert.assertEquals(techPandaDomain,"live.techpanda.org");

        String homepageUrl = (String) executeForBrowser("return document.URL;");
        System.out.println(homepageUrl);

        Assert.assertEquals(homepageUrl,"http://live.techpanda.org/");

        clickToElementByJS("//a[text()='Mobile']");

        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");

        Assert.assertTrue(isExpectedTextInInnerText("Samsung Galaxy was added to your shopping cart."));

        String innerText = (String) executeForBrowser("return document.documentElement.innerText;");
        Assert.assertTrue(innerText.contains("Samsung Galaxy was added to your shopping cart."));

        Assert.assertEquals(getElementTextByJS("//li[@class='success-msg']//span"),"Samsung Galaxy was added to your shopping cart.");

        clickToElementByJS("//a[text()='Customer Service']");

        String customerServiceTitle = (String) executeForBrowser("return document.title;");
        System.out.println(customerServiceTitle);

        Assert.assertEquals(customerServiceTitle,"Customer Service");

        scrollToElementOnTop("//input[@id = 'newsletter']");
        sendkeyToElementByJS("//input[@id = 'newsletter']",addressEmail);

        Assert.assertEquals(getElementTextByJS("//li[@class='success-msg']//span"),"Thank you for your subscription.");

        navigateToUrlByJS("https://www.youtube.com/");
        String otherDomain = (String) executeForBrowser("return document.domain;");
        System.out.println(otherDomain);

        Assert.assertEquals(otherDomain,"www.youtube.com");
    }

    /*https://login.ubuntu.com/*/

    public void TC_03_TechPanda() throws  InterruptedException{
        navigateToUrlByJS("http://live.techpanda.org/index.php");



    }

    @AfterClass
    public void cleanBrowser() {driver.quit();}

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public String getElementTextByJS(String locator) {
        return (String) jsExecutor.executeScript("arguments[0].textContent;", getElement(locator));
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }
}
