package javaSDET;

import java.util.ArrayList;

public class Topic_06_Generic {
    public static void main(String[] args){
        //Non-generic
        ArrayList studentName = new ArrayList();
        studentName.add("Nguyen A");
        studentName.add("Nguyen B");
        studentName.add(18);
        studentName.add(true);
        studentName.add(25.6);

        //Generic <Type>
        ArrayList<String> students = new ArrayList<String>();
        students.add("Nguyen Thuy Vy");
        //students.add(18);
        //students.add(true);
        //students.add(25.6);
    }
}
