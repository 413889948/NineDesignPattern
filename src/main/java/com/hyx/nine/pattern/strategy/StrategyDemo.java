package com.hyx.nine.pattern.strategy;

/**
 * @author hyx
 * @date 2021/10/25 21:10
 * 策略对象
 */
public class StrategyDemo {
    private final Strategy strategy;

    public StrategyDemo(Strategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        strategy.doSome();
    }


}
