package com.hyx.nine.pattern.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 9:56
 * 适配器实现，目前实现ONE,TWO两个类的适配
 */
@Service
public class AdapterDemoImpl implements AdapterDemo {
    @Autowired
    AdapterDemoOne one;
    @Autowired
    AdapterDemoTwo two;

    @Override
    public void runDemo(String key, String val) {
        if ("one".equalsIgnoreCase(key)) {
            one.play(val);
        } else if ("two".equalsIgnoreCase(key)) {
            two.play(Arrays.stream(val.split(",")).collect(Collectors.toList()));
        }
    }
}
