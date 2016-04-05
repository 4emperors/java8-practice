package com.fouremperors.study.chapter03;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by qianfanyanfa on 16/4/5.
 */
public class Lambda01 {

    public static void main(String[] args){
        int x=23;
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.ALL);
        info(logger,() -> "x:"+x);

    }
    /**
     * 延迟记录日志的功能
     * @param logger
     * @param message
     */
    public static void info(Logger logger, Supplier<String> message){
        if(logger.isLoggable(Level.INFO)){
            logger.info(message.get());
        }
    }
}
