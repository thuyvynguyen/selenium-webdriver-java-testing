package javaSDET;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For {
    public static void main (String[] arg){
        // for classic - generic
        int n = 112;
        for (int i = 0; i < n; i++) {
            System.out.println(i+5);
        }

        //for-each
        List<String> typeofkittens = new ArrayList<String>();
        typeofkittens.add("American Shorthair");
        typeofkittens.add("British Shorthair");
        typeofkittens.add("Abyssinian Cats");
        typeofkittens.add("Maine Coon Cats");
        typeofkittens.add("Bombay Cats");
        typeofkittens.add("Exotic Cats");

        for(String cats:typeofkittens ){
            if (cats.equals("Bombay Cats")){
                System.out.println("Crazy Lim");
            }else{
                System.out.println(cats);
            }
        }

        int i = 0;
        //while
        while (i <= n){
            System.out.println(i);
            i++;
        }

        do{
            System.out.println(i);
            i++;
        }while (i <= n-7);

    }
}
