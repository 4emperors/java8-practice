package com.fouremperors.study.chapter02;

import com.fouremperors.study.User;

import java.util.*;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by qianfanyanfa on 16/4/5.
 */
public class Stream04 {


    public static void main(String [] args){

        //转成数组
        Object[] objects = Stream.of("Keith", "GuoGuo", "QuQu").toArray();
        //指定数组类型
        //思考一下为什么是IntFunction
        Stream.of("Keith","GuoGuo","QuQu").toArray(String[]::new);

        //收集Map
        HashSet<Object> collect = Stream.of("Keith", "GuoGuo", "QuQu").collect(HashSet::new, HashSet::add, HashSet::addAll);

        collect.forEach(System.out::println);

        //简便写法
        Stream.of("Keith", "GuoGuo", "QuQu").collect(Collectors.toCollection(HashSet::new));


//        Stream.of("Keith", "GuoGuo", "QuQu").collect(Collectors.to);


        //转化成list
        Stream.of("Keith", "GuoGuo", "QuQu").collect(Collectors.toList());
        //转化成set
        Set<String> collect1 = Stream.of("Keith", "GuoGuo", "QuQu").collect(Collectors.toSet());


        Stream.of("Keith", "GuoGuo", "QuQu").collect(Collectors.joining(","));
        //begin_Keith,GuoGuo,QuQuend_
        String collect2 = Stream.of("Keith", "GuoGuo", "QuQu").collect(Collectors.joining(",", "begin_", "end_"));
        System.out.println(collect2);

        String collect3 = Stream.of("Keith", "GuoGuo", new User("Lala")).map(Object::toString).collect(Collectors.joining(","));

        System.out.println(collect3);


        IntSummaryStatistics summary = Stream.of("Keith", "GuoGuo", "QuQu").collect(Collectors.summarizingInt(String::length));

        System.out.println(summary.getMax());
        System.out.println(summary.getMin());
        System.out.println(summary.getAverage());
        System.out.println(summary.getSum());
        System.out.println(summary.getCount());


        //指定key,与value,可以看一下foreach的的参数类型
        Stream.of("Keith","GuoGuo").map(User::new).collect(Collectors.toMap(User::getName,p->p))
                .forEach((s,p )->{System.out.println(p.toString());});

        //看一下Function.identity的源吗,体会一下
        Stream.of("Keith","GuoGuo").map(User::new).collect(Collectors.toMap(User::getName, Function.identity()));

        //解决key重复问题
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        availableLocales.collect(Collectors.toMap(
                Locale::getDisplayLanguage,
                l-> l.getDisplayCountry(Locale.CHINA),
                //第三个函数,解决重复的问题
                (existValue,newValue)-> existValue
        )).forEach((s,l) -> {System.out.println(l);});

        availableLocales = Stream.of(Locale.getAvailableLocales());

        Map<String, Set<String>> collect4 = availableLocales.collect(Collectors.toMap(
                //国家为key
                Locale::getDisplayCountry,
                //将结果,弄成一个集合,用于第三个函数合并
                l -> Collections.singleton(l.getDisplayLanguage()),
                //第三个函数,解决重复的问题
                (existValue, newValue) -> {
                    Set<String> r = new HashSet<String>(existValue);
                    r.addAll(newValue);
                    return r;
                },
                //指定map类型,该参数可略
                TreeMap::new
        ));
        collect4.forEach((s,l) -> {
            System.out.print(s+"--");
            l.forEach(System.out::print);
            System.out.println("--end");
        });

        //感受groupBy魅力
        Map<String, List<Locale>> collect5;
        collect5= Stream.of(Locale.getAvailableLocales()).collect(Collectors.groupingBy(Locale::getCountry));

        collect5.forEach((k,v) ->{ System.out.println(k+"--"+v.size());});

        //分成两组,是否为英语环境,partitioningBy更高效
        //分类函数为Predicate类型
        Stream.of(Locale.getAvailableLocales()).collect(Collectors.partitioningBy(
                l->l.getLanguage().equals("en")
        ));

        //set收集器
        Stream.of(Locale.getAvailableLocales()).
                collect(Collectors.groupingBy(Locale::getCountry,Collectors.toSet()));

        //couting方法会返回收集元素的总个数。例如可以计算每个国家有多不种语言
        Stream.of(Locale.getAvailableLocales()).
                collect(Collectors.groupingBy(Locale::getCountry,Collectors.counting()));


        Stream.of(Locale.getAvailableLocales()).
                collect(Collectors.groupingBy(Locale::getCountry,Collectors.counting()));


        User[] userArray=new User[]{new User("keith", 18), new User("keith", 22), new User("QuQu", 20)};
        //例子可以举得不是很合适,主要看用法（因为User对象我忘了加性别,按性别统计是极好的）
        Stream<User> users = Stream.of(userArray);
        //统计名字（相同）的年龄合
        users.collect(Collectors.groupingBy(User::getName,Collectors.summingInt(User::getAge)))
                .forEach((k,v)->{System.out.println(k+":"+v);});

        //产生每个相同名字中年龄最大的一组人
        users = Stream.of(userArray);

        users.collect(Collectors.groupingBy(User::getName,
                Collectors.maxBy(Comparator.comparing(User::getAge))));



        //mapping方法会将一个函数应用到downstream结果上，并且需要另一个收集器来处理。
        Stream.of(Locale.getAvailableLocales()).collect(
                Collectors.groupingBy(
                        Locale::getDisplayCountry,
                        //再也不需要考虑如果合并单集合的问题
                        Collectors.mapping(Locale::getDisplayLanguage,Collectors.toSet())
         ));

        users = Stream.of(userArray);

        Map<String, IntSummaryStatistics> statics = users.collect(Collectors.groupingBy(User::getName,
                Collectors.summarizingInt(User::getAge)));

        statics.forEach((k,v)->{
            String str="%s: sum-%d,avg-%f,count-%d,min-%d,max-%d";
            System.out.println(String.format(str,k,v.getSum(),v.getAverage(),v.getCount(),v.getMin(),v.getMax()));

        });
    }
}
