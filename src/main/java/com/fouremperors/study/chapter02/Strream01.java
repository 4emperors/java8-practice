package com.fouremperors.study.chapter02;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by qianfanyanfa on 16/4/2.
 */
public class Strream01 {


    public static void main(String[] args) throws IOException {

//        String contents=new String(Files.readAllBytes(Paths.get("/a.txt")), StandardCharsets.UTF_8);
//        //只要使用parallel就能轻松并发执行
//        long count = Arrays.stream(contents.split("[\\P{L}]+")).parallel().filter(word -> word.length() > 5).count();
//        System.out.println(count);

        //可变参的方式
        Stream.of("K.F", "Summer", "QiZai");
        //不含任何元素的Stream
        Stream.empty();

        //Stream可以接受一个无参的函数
        Stream.generate(() -> "Hello");

        Stream.generate(Math::random);

        //要创建一个形如 0,1,2,3无限序列,你可以使用iterate方法.它接受一个"种子(seed)"和一个函数,并且会对之前的值重复应用该函数.
        Stream.iterate(BigInteger.ZERO,n -> n.add(BigInteger.ONE));



    }
}
