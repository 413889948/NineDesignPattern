package com.hyx.nine.common;

import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 11:32
 * 适配器场景中的方法1
 */
@Data
@Service
public class AdapterOne {
    private String key = "one";

    public String run(String str) {
        return "这是One的处理：" + str;
    }
}
