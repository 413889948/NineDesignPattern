package com.hyx.nine.pattern.single;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/16 22:45
 * 懒汉模式
 */
public class Lazy {
    private static Lazy lazy;

    private Lazy() {
        LogUtil.info("懒汉的单例创建了");
    }

    public static synchronized Lazy getLazy() {
        if (lazy == null) {
            lazy = new Lazy();
        }
        return lazy;
    }
}
