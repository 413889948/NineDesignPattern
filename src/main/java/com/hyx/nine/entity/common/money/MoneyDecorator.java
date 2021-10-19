package com.hyx.nine.entity.common.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 17:15
 * 金额装饰类
 */
public class MoneyDecorator extends MoneyDemo {
    private MoneyDemo moneyDemo;

    public MoneyDecorator(MoneyDemo moneyDemo) {
        this.moneyDemo = moneyDemo;
    }

    @Override
    public BigDecimal getValue() {
        return moneyDemo.getValue().setScale(2, RoundingMode.HALF_UP);
    }
}
