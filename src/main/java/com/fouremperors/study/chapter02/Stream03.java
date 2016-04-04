package com.fouremperors.study.chapter02;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by keithfu on 16/4/4.
 */
public class Stream03 {

    public static void main(String[] args){

        //求和,返回的是Optional
        Stream.of(1,3,5,7,9).reduce((x,y) -> x+y).ifPresent(System.out::println);

        Stream.of(1, 3, 5, 7, 9).reduce((Integer::sum)).ifPresent(System.out::println);

        //使用 0 为起始值,不再返回Ootional类型
        Integer reduce = Stream.of(1, 3, 5, 7, 9).reduce(0, (x, y) -> x + y);

        System.out.println(reduce);

        Stream.of("Keith","GuoGuo","QuQu").
                reduce(0,(total,name) -> total+ name.length(), //累加函数
                        Integer::sum ); //

        //简便写法
        Stream.of("Keith","GuoGuo","QuQu").mapToInt(String::length).sum();
    }
}
