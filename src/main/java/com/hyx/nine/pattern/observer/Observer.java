package com.hyx.nine.pattern.observer;

import lombok.Data;

/**
 * @Author: huangyx
 * @Date: 2021/10/21 17:24
 * 抽象观察者类
 */
@Data
public abstract class Observer {
    protected Subject subject;
    protected AopSubject aopSubject;
    public abstract void update();
}