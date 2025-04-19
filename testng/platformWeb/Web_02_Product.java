package platformWeb;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_02_Product {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @Test(groups = {"platformWeb", "product"})
    public void User_01_createNewProduct(){

    }
    @Test(groups = {"platformWeb", "product"})
    public void User_02_editProduct(){

    }
    @Test(groups = {"platformWeb", "product"})
    public void User_03_viewProduct(){

    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
}
