package com.hyx.nine.pattern.adapter;

import com.hyx.nine.utils.LogUtil;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 9:11
 * TWO对象
 */
@Service
public class AdapterDemoTwo {
    /**
     * 该类进行play操作时需要list入参
     * @param list list
     */
    public void play(List<String> list) {
        LogUtil.info("TWO:" + list.toString());
    }
}
