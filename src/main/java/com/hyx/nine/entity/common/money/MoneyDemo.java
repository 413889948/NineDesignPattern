package com.hyx.nine.entity.common.money;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 17:12
 * 需要用到的金额统一父类
 */
@Data
public class MoneyDemo {
    private BigDecimal value = new BigDecimal(0);
}
