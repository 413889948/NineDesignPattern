package com.hyx.nine.pattern.observer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @Author: huangyx
 * @Date: 2021/10/21 17:25
 *
 */
public class ObserverOne extends Observer {
    private AopObserver aopObserver;

    public ObserverOne(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public ObserverOne(AopObserver aopObserver) {
        this.aopObserver = aopObserver;
        aopObserver.attach(this);
    }

    @Override
    public void update() {
        if (subject == null) {
            System.out.println("One进行观察: "
                + Integer.toOctalString(aopSubject.getState()));
        } else {
            System.out.println("One进行观察: "
                + Integer.toOctalString(subject.getState()));
        }
    }
}
