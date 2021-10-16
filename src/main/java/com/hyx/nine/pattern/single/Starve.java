package com.hyx.nine.pattern.single;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/16 22:48
 * 饿汉模式
 */
public class Starve {
    private static final Starve STARVE = new Starve();

    private Starve() {
        LogUtil.info("饿汉的单例创建了");
    }

    public static Starve getStarve() {
        return STARVE;
    }
}
