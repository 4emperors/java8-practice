package com.fouremperors.study.chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by qianfanyanfa on 16/4/2.
 */
public class Optional01 {


    public static void main(String [] args){

        String[] names =new String[]{"K.F", "Summer", "QiZai","Summer"};
        List<String> results=new ArrayList<>();

        Optional<String> max = Stream.of(names).max(String::compareToIgnoreCase);
        //当值存在执行调用
        max.ifPresent(System.out::println);

        max.ifPresent(v -> results.add(v));
        //or 方法引用
        max.ifPresent(results::add);

        //ifPresent不会有返回值,如何你希望对结果进行
        //以下面的例子来讲,会有三种可能情况,Optional中的tre或false及 .或者是一个空的可选值.
        Optional<Boolean> aBoolean = max.map(results::add);

        //如果max无值时,则为空字符串
        String s = max.orElse("");
        //或者采用代码来计算
        Object o = Stream.empty().findAny().orElseGet(() -> "empty");

        //会打印empty
        System.out.println(o);

        Stream.empty().findAny().orElseThrow(NoSuchElementException::new);
    }
}
