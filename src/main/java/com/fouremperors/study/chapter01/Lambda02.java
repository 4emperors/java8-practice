package com.fouremperors.study.chapter01;

/**
 * Created by qianfanyanfa on 16/4/2.
 */
public class Lambda02 {


    public static void repeatMessage(String text,int count){

        new Thread(() -> {
            for(int i=0;i<count;i++){
                //访问了,表达式未定义的变量
                System.out.println(text);
            }
        }).start();
    }

    public static void main(String [] args){
        repeatMessage("Hello",10);
        new Lambda02().doSomeThings();
    }

    public void  doSomeThings(){
        //表达式与方法有着相同的作用域
        Runnable r=()-> {
            //这里打印的是 Lambda02的toString方法,并非是 Runnable
            System.out.println(this.toString());
        };
        new Thread(r).start();
    }
}
