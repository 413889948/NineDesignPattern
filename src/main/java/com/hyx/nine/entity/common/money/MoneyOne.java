package com.hyx.nine.entity.common.money;

import java.math.BigDecimal;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 17:11
 *
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class MoneyOne extends MoneyDemo {
    private BigDecimal value = new BigDecimal(100.9999);
}
