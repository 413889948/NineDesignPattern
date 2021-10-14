package com.hyx.nine.utils;

import com.hyx.nine.pattern.plant.ReturnDemoOne;
import com.sun.istack.internal.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hyx
 * @date 2021/10/14 23:50
 */

public class LogUtil {
    private final static Logger logger = Logger.getLogger(ReturnDemoOne.class);

    public static void info(String str){
        if (StringUtils.isBlank(str)){
            logger.info("你打印了个寂寞（空）");
        }
        logger.info(str);
    }

    public Logger getLogger(){
        return logger;
    }


}
