package com.hyx.nine.pattern.single;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/16 22:49
 * 双重校验模式,相比懒汉保持了性能
 */
public class DoubleChecked {
    private volatile static DoubleChecked doubleChecked;

    private DoubleChecked() {
        LogUtil.info("双重校验的单例创建了");
    }

    public static DoubleChecked getDoubleChecked() {
        if (doubleChecked == null) {
            synchronized (DoubleChecked.class) {
                if (doubleChecked == null) {
                    doubleChecked = new DoubleChecked();
                }
            }
        }
        return doubleChecked;
    }
}
