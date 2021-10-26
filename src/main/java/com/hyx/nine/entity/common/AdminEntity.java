package com.hyx.nine.entity.common;

/**
 * @author hyx
 * @date 2021/10/25 21:45
 */
public class AdminEntity implements UserEntity{
    @Override
    public boolean getPower() {
        return true;
    }
}
