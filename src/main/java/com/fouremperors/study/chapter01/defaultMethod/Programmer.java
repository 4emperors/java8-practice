package com.fouremperors.study.chapter01.defaultMethod;

/**
 * Created by qianfanyanfa on 16/4/2.
 */
public interface Programmer {

    default String getName(){

        return "JavaProgrammer";
    }
}
