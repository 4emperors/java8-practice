package com.fouremperors.study.chapter02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by qianfanyanfa on 16/4/5.
 */
public class Stream05 {


    public static void main(String[] args){

        //创建
        IntStream.of(1,2,3,4);
        //
        Arrays.stream(new int[]{10,20,30,40,50},1,3).forEach(System.out::println);
        //不包括上限,第一位是0
        IntStream.range(0,100).findFirst().ifPresent(System.out::println);
        //包括上限
        IntStream.rangeClosed(0,100);

        IntStream intStream = Stream.of("Keith", "Lala").mapToInt(String::length);
        //你可以将一个原型流转成对象流
        Stream<Integer> boxed = intStream.boxed();

    }


}
