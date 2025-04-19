package platformWeb;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_01_User {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @Test(groups = {"platformWeb", "user"})
    public void User_01_createNewUser(){

    }
    @Test(groups = {"platformWeb", "user"})
    public void User_02_editUser(){

    }
    @Test(groups = {"platformWeb", "user"})
    public void User_03_viewUser(){

    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
}
