package com.hyx.nine.common;

import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 11:32
 * 适配器场景中的方法2
 */
@Data
@Service
public class AdapterTwo {
    private String key = "two";

    public String run(String str) {
        return "这是Two的处理：" + str;
    }
}
