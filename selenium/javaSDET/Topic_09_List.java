package javaSDET;

import java.util.*;

public class Topic_09_List {
    public static void main(String[] arg){
        List<String> blackPink = new ArrayList<>();
        blackPink.add("Jennie");
        blackPink.add("Jisoo");
        blackPink.add("Rose");
        blackPink.add("Lisa");

        System.out.print("Welcome");
        for (String mems:blackPink ){
            System.out.print(" " +mems);
        }
        System.out.println(" " + "tada :-*" );

        for (int i = 0; i < blackPink.size(); i++) {
            if (blackPink.get(i)=="Jennie"){
                System.out.print(blackPink.get(i) + " " + "is so cute ^^");
            }
        }
    }
}
