package platformMobile;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Mobile_02_Payment {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @Test(groups = {"platformMobile"})
    public void User_01_cheque(){

    }
    @Test(groups = {"platformMobile"})
    public void User_02_card(){

    }
    @Test(groups = {"platformMobile"})
    public void User_03_cash(){

    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
}
