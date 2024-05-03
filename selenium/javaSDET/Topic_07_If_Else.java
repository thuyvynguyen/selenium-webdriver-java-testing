package javaSDET;

import org.bouncycastle.oer.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_07_If_Else {
    public static void main(String[] args){
        WebDriver driver;
        String osName = System.getProperty("os.name");
        String browserName = "Chrome";

        // If Type 1
        if(browserName.equals("IE")){
            System.out.println("Click to Submit button");
        }

        //If Type 2
        if(osName.startsWith("Windows")){
            System.out.println("Windows OS");
        } else{
            System.out.println("MAC or Linux OS");
        }

        //If Type 3
        if(browserName.equals("Chrome")){
            driver = new ChromeDriver();
        }else if(browserName.equals("Firefox")){
            driver = new FirefoxDriver();
        }else {
            driver = new EdgeDriver();
        }

        //Switch - case
        switch(browserName){
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver = new EdgeDriver();
                break;
        }
    }
}
