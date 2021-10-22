package com.hyx.nine.common;

/**
 * @Author: huangyx
 * @Date: 2021/10/22 14:36
 *
 */
public class ObserverUserSignature implements ObserverUser{
    UserSubject userSubject;
    public ObserverUserSignature(UserSubject userSubject) {
        this.userSubject = userSubject;
        userSubject.attach(this);
    }

    @Override
    public void update() {
        userSubject.setSignature("无");
    }
}
