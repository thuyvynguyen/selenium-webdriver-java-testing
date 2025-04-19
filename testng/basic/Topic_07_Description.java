package basic;

import org.testng.annotations.Test;

public class Topic_07_Description {
    @Test(description = "Azure#998 - Register new account")
    public void TM_01_register(){
        System.out.println("Register new account");
    }
    @Test(description = "Azure#998 - Login to System and verify new account")
    public void TM_02_login(){
        System.out.println("Login to System");
    }
}
