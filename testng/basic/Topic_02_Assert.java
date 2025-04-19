package basic;

import org.testng.annotations.Test;
import org.testng.Assert;

public class Topic_02_Assert {

    @Test
    public void login(){
        // type boolean
        //Selenium: isXXX, eg: isDisplayed/isSelected/isEnabled/isMultiple
        // return value boolean
        //False: when need check returned data is false
        //True: when need check returned data is true
        Assert.assertTrue(5>3);

        boolean status = 5<3;
        System.out.println(status);
        Assert.assertFalse(status);

        //Equals: expected = actual
        // the same datatype
        String studentName = "Nguyen Van A";
        Assert.assertEquals(studentName,"Nguyen Van A");

        Object name = "Nguyen Van A";
        Assert.assertEquals(studentName,name);

        int iNumber = 15;
        float fNumber = 15;
        Assert.assertEquals(iNumber,fNumber);
    }

}
