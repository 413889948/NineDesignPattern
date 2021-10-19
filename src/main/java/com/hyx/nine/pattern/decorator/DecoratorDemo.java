package com.hyx.nine.pattern.decorator;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 15:24
 *
 */
public abstract class DecoratorDemo implements ServiceDemo {
    private final ServiceDemo serviceDemo;
    public DecoratorDemo(ServiceDemo serviceDemo) {
        this.serviceDemo = serviceDemo;
    }

    @Override
    public void run() {
        serviceDemo.run();
    }
}
