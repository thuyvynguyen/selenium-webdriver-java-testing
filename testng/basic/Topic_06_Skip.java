package basic;

import org.testng.annotations.Test;

public class Topic_06_Skip {
    @Test(enabled = false)
    public void TM_01_register(){
        System.out.println("Register new account");
    }
    @Test(priority = 2)
    public void TM_02_login(){
        System.out.println("Login to System");
    }
}
