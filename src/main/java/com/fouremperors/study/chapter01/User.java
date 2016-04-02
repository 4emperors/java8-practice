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

    public User(String name,Integer age) {
        this.name = name;
        this.age=age;
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

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age = 0;
}
