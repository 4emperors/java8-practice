package com.fouremperors.study.chapter01;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qianfanyanfa on 16/4/2.
 *
 *
 */
public class Lambda3 {


    public static void main(String [] args){
//        接口中的的静态方法

        String[] names=new String[]{"KeithFu","ZenYou","123456789","Pumpkin"};

        //Comparator中添加的静态方法,方便我们进行了比较操作
        Arrays.sort(names,Comparator.comparing(String::length));

        System.out.println(Arrays.toString(names));
    }
}
