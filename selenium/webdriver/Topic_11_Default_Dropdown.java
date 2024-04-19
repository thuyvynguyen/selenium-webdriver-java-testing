package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_11_Default_Dropdown {
    WebDriver driver;
    Select select;
    Random rand;
    String firstName, lastName, email, companyName, password;
    String postfixEmail;
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        rand = new Random();

        firstName = "Sammie";
        lastName = "NG";
        postfixEmail = "@mail.com";
        email = firstName + lastName + rand.nextInt(9999) + postfixEmail;
        password = firstName + lastName + "@" + rand.nextInt(999999);
        companyName = rand.toString();
    }

    @Test
    public void TC_04_HTML_DropdownList_01(){
        driver.get("https://demo.nopcommerce.com/register");

        driver.findElement(By.xpath("//a[text()='Register']")).click();

        driver.findElement(By.cssSelector("input#gender-female")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);

        select = new Select(driver.findElement(By.cssSelector("select[name*=DateOfBirthDay]")));
        select.selectByVisibleText("1");

        select = new Select(driver.findElement(By.cssSelector("select[name*=DateOfBirthMonth]")));
        select.selectByVisibleText("May");

        select = new Select(driver.findElement(By.cssSelector("select[name*=DateOfBirthYear]")));
        select.selectByVisibleText("1980");

        driver.findElement(By.cssSelector("button#register-button")).click();

        Assert.assertTrue(driver.getPageSource().contains("Your registration completed"));

        driver.findElement(By.xpath("//a[text()='Continue']")).click();

//        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
    }
}
