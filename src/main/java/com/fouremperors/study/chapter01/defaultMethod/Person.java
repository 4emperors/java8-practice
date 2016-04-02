package com.fouremperors.study.chapter01.defaultMethod;

/**
 * Created by qianfanyanfa on 16/4/2.
 */
public interface Person {

    long getId();

    /**
     * 默认方法
     * @return
     */
    default String getName(){

        return "K.F";
    }
}
