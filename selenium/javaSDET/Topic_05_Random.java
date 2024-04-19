package javaSDET;

import org.testng.annotations.Test;

import java.util.Random;

public class Topic_05_Random {
    String prefixEmail = "abc";
    String postfixEmail = "@mail.com";

    @Test
    public void testEmail(){
        Random rand = new Random();
        System.out.println(prefixEmail + rand.nextInt(9999) + postfixEmail);
        System.out.println(rand.toString());
    }
}
