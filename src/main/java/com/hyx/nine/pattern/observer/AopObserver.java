package com.hyx.nine.pattern.observer;

import com.hyx.nine.utils.LogUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huangyx
 * @Date: 2021/10/21 17:58
 * 代理观察者
 */
@Component
@Aspect
public class AopObserver {
    private final List<Observer> observers
        = new ArrayList<>();

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
    public void notifyAllObservers(AopSubject aopSubject) {
        for (Observer observer : observers) {
            observer.setAopSubject(aopSubject);
            observer.update();
        }
    }

    @Around("within(com.hyx.nine.pattern.observer.AopSubject)")
    public Object aopAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        AopSubject aopSubject = (AopSubject) pjp.getTarget();
        // 执行
        Object proceed = pjp.proceed(args);
        // 执行观察者
        notifyAllObservers(aopSubject);
        return proceed;
    }

}
