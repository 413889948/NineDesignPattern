package com.hyx.nine.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 11:30
 * 分隔符场景适配器
 */
@Service
public class SplitAdapter {

    @Autowired
    AdapterOne one;
    @Autowired
    AdapterTwo two;

    public String run(String key, List<String> list) {

        if (one.getKey().equals(key)) {
            return one.run(String.join(",", list));
        } else if (two.getKey().equals(key)) {
            return two.run(String.join("@", list));
        }
        return null;
    }
}
