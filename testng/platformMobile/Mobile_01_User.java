package platformMobile;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Mobile_01_User {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @Test(groups = {"platformMobile"})
    public void User_01_createNewUser(){

    }
    @Test(groups = {"platformMobile"})
    public void User_02_editUser(){

    }
    @Test(groups = {"platformMobile"})
    public void User_03_viewUser(){

    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
}
