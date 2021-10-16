package com.hyx.nine.pattern.single;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/16 22:50
 * 枚举型
 */
public enum EnumSingle {
    /**
     * 枚举单例
     */
    ENUM;

    EnumSingle() {
        LogUtil.info("枚举型的单例创建了");
    }
}
