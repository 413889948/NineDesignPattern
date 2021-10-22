package com.hyx.nine.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangyx
 * @Date: 2021/10/21 17:24
 * 被观察对象，需要包含：添加观察者的方法，调用观察者的方法
 */
public class Subject {
    private final List<Observer> observers
        = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    /**
     * 添加观察者的方法
     * @param observer 观察者
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 执行观察者的参数
     */
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
