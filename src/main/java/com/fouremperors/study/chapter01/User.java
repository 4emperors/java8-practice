package com.fouremperors.study.chapter01;

/**
 * Created by qianfanyanfa on 16/4/2.
 */
public class User {

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(Integer age) {
        this.age  = age;
    }
    public User() {
    }
    private String name ="default";

    private Integer age = 0;
}
