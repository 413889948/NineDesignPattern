package com.hyx.nine.pattern.adapter;

import com.hyx.nine.utils.LogUtil;

import org.springframework.stereotype.Service;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 9:11
 * ONE对象
 */
@Service
public class AdapterDemoOne {
    /**
     * 该对象进行play操作，使用字符串作为入参
     * @param str 字符串
     */
    public void play(String str){
        LogUtil.info("ONE:" + str);
    }
}
