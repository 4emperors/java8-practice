package com.fouremperors.study.chapter01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.stream.Stream;

/**
 * Created by K.F on 16/4/1.
 */
public class Lambda01 {

    public void test1(IntToLongFunction intToLongFunction){

    }

    public static void main(String[] args) {

        IntToLongFunction intIncrement= (int x) -> x + 1;

        Comparator<String> stringComparator = (String first, String second) -> {

            if (first.length() < second.length()) {
                return -1;
            } else if (first.length()>second.length()){
                return 1;
            }else {
                return 0;
            }
        };

        String[] names=new String[]{"KeithFu","ZenYou","123456789","Pumpkin"};

        //排序
        Arrays.sort(names,stringComparator);
        //,先转化为steam对象,使用方法引用.打印值
        Arrays.stream(names)
                //过滤名字小于7位的
                .filter(name -> { if(name.length()>=7)return true;return false;})
                .forEach(System.out::println);

        //创建一个空的数组流
        Stream<String> silence = Stream.empty();

        new Programmer().name();

    }

    static class Animal{
        public void name(){
            System.out.println("Animal");
        }
    }

    static class Programmer extends  Animal{

        public void name(){
            Thread thread=new Thread(super::name);
          //thread=new Thread(this::name);//这行代码会产生严重问题吗.
            thread.start();
        }
    }

}
