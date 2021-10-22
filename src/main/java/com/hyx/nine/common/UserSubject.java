package com.hyx.nine.common;

import com.hyx.nine.pattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @Author: huangyx
 * @Date: 2021/10/22 14:21
 * 被观察的用户对象
 */
@Data
public class UserSubject {
    List<ObserverUser> observers = new ArrayList<>();
    /**
     * 性别
     */
    private String sex;
    /**
     * 用户名
     */
    private String name;
    /**
     * 签名
     */
    private String signature;
    /**
     * 权限
     */
    private String power;

    public void setName(String name) {
        this.name = name;
        notifyAllObservers();
    }

    /**
     * 添加观察者的方法
     * @param observer 观察者
     */
    public void attach(ObserverUser observer) {
        observers.add(observer);
    }

    /**
     * 执行观察者的参数
     */
    public void notifyAllObservers() {
        for (ObserverUser observer : observers) {
            observer.update();
        }
    }

}
