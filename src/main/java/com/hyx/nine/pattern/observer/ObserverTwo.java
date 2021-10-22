package com.hyx.nine.pattern.observer;

/**
 * @Author: huangyx
 * @Date: 2021/10/21 17:25
 *
 */
public class ObserverTwo extends Observer {
    public ObserverTwo(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public ObserverTwo(AopObserver aopObserver) {
        aopObserver.attach(this);
    }

    @Override
    public void update() {
        if (subject == null) {
            System.out.println("Two进行观察: "
                + Integer.toBinaryString(aopSubject.getState()));
        } else {
            System.out.println("Two进行观察: "
                + Integer.toBinaryString(subject.getState()));
        }
    }

}
