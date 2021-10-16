package com.hyx.nine.pattern.single;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/16 22:49
 * 静态内部类
 */
public class Static {
    private static class StaticHolder {
        private static final Static STATIC = new Static();
    }

    private Static() {
        LogUtil.info("静态内部类的单例创建了");
    }

    public static final Static getInstance() {
        return StaticHolder.STATIC;
    }
}
