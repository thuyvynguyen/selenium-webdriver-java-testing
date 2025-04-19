package basic;

import org.testng.annotations.Test;

public class Topic_05_Priority {
    @Test(priority = 1)
    public void TM_01_register(){
        System.out.println("Register new account");
    }
    @Test(priority = 2)
    public void TM_02_login(){
        System.out.println("Login to System");
    }
    @Test(priority = 3)
    public void TM_03_order(){
        System.out.println("Order Product");
    }
    @Test(priority = 4)
    public void TM_04_pay(){
        System.out.println("Pay Product");
    }
    @Test(priority = 5)
    public void TM_05_ship(){
        System.out.println("Ship Product");
    }
}
