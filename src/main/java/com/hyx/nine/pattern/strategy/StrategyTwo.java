package com.hyx.nine.pattern.strategy;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/25 20:58
 */
public class StrategyTwo implements Strategy{
    @Override
    public void doSome() {
        LogUtil.info("执行策略2");
    }
}
