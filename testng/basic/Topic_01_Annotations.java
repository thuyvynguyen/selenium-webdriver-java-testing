package basic;

import org.testng.annotations.*;

public class Topic_01_Annotations {
    @BeforeSuite
    public void beforeSuite(){System.out.println("before suite");}
    @BeforeTest
    public void beforeTest(){System.out.println("before test");}
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
    }

    @Test
    public void TC_01(){
        System.out.println("Test 01");
    }
    @Test
    public void TC_02(){
        System.out.println("Test 02");
    }
    @Test
    public void TC_03(){
        System.out.println("Test 03");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
}
