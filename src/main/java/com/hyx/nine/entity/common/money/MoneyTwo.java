package com.hyx.nine.entity.common.money;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 17:12
 *
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class MoneyTwo extends MoneyDemo {
    private BigDecimal value = new BigDecimal(200.1212);

}
