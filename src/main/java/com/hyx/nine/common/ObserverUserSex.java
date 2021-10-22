package com.hyx.nine.common;

/**
 * @Author: huangyx
 * @Date: 2021/10/22 14:36
 *
 */
public class ObserverUserSex implements ObserverUser{
    UserSubject userSubject;
    public ObserverUserSex(UserSubject userSubject) {
        this.userSubject = userSubject;
        userSubject.attach(this);
    }

    @Override
    public void update() {
        userSubject.setSex("保密");
    }
}
