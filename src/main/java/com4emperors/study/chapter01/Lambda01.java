package com4emperors.study.chapter01;

import java.util.Comparator;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;

/**
 * Created by K.F on 16/4/1.
 */
public class Lambda01 {

    public void test1(IntToLongFunction intToLongFunction){

    }

    public static void main(String[] args) {

        IntToLongFunction intIncrement= (int x) -> x + 1;


        System.out.println(intIncrement);

        Comparator<String> stringComparator = (String first, String second) -> {

            if (first.length() < second.length()) {
                return -1;
            } else if (first.length()>second.length()){
                return 1;
            }else {
                return 0;
            }
        };


    }

}
