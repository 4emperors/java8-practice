package com.fouremperors.study.chapter02;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by qianfanyanfa on 16/4/2.
 */
public class Stream02 {

    public static void main(String [] args){
        String[] names =new String[]{"K.F", "Summer", "QiZai","Summer"};
        Stream.of(names).map(String::toLowerCase).forEach(System.out::println);
        Stream.of(names).map(name -> name.charAt(0)).forEach(System.out::println);

        Stream.of(names).flatMap(name -> characterStream(name)).forEach(System.out::println);

        //limit用于返回包含n个元素的新流
        Stream.of(names).limit(2).forEach(System.out::println);
        //与limits相反,丢弃n个元素
        Stream.of(names).skip(2).forEach(System.out::println);

        //组合流,用concat

        long count = Stream.concat(Stream.of(names), Stream.of(names)).count();

        System.out.println(count);

        //有状态的流
        Stream.of(names).distinct().forEach(System.out::println);

        //排序
        Stream.of(names).sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        //返回最大值(Option类型)
        Optional<String> max = Stream.of(names).max(String::compareToIgnoreCase);

        if(max.isPresent())  System.out.print(max.get());

        //寻找第一个
        Stream.of(names).filter(s-> s.startsWith("Q")).findFirst();
        //寻找任意一个,并行非常有效
        Stream.of(names).parallel().filter(s-> s.startsWith("Q")).findAny();

        Stream.of(names).parallel().anyMatch(s-> s.startsWith("Q"));

        //以下代码自行体会
        boolean b = Stream.of(names).parallel().anyMatch(s -> s.length() > 2);

         b = Stream.of(names).parallel().allMatch(s -> s.length() > 4);

         b = Stream.of(names).parallel().noneMatch(s -> s.length() > 7);

    }

    public  static Stream<Character> characterStream(String s){
        List<Character> chars = new ArrayList<>();
        for(char c:s.toCharArray()){chars.add(c);}
        return chars.stream();
    }
}
