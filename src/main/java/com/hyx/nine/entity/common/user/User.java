package com.hyx.nine.entity.common.user;

/**
 * @author hyx
 * @date 2021/10/14 23:55
 */
public interface User {
    /**
     * 获取用户许可，具体实现根据子类实现而定
     * @return string
     */
    Boolean getUserPermission();
}
