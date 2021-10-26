package com.hyx.nine.common;

import com.hyx.nine.entity.common.UserEntity;

/**
 * @author hyx
 * @date 2021/10/25 21:47
 * 获取策略对象
 */
public class UserStrategy {
    private final UserEntity user;

    public UserStrategy(UserEntity user) {
        this.user = user;
    }

    public boolean getPower() {
        return user.getPower();
    }
}
