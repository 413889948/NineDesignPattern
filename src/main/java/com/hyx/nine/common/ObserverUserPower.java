package com.hyx.nine.common;

/**
 * @Author: huangyx
 * @Date: 2021/10/22 14:36
 *
 */
public class ObserverUserPower implements ObserverUser{
    UserSubject userSubject;
    public ObserverUserPower(UserSubject userSubject) {
        this.userSubject = userSubject;
        userSubject.attach(this);
    }

    @Override
    public void update() {
        userSubject.setPower("普通用户");
    }
}
