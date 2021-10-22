package com.hyx.nine.pattern.observer;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @Author: huangyx
 * @Date: 2021/10/21 17:57
 * 利用aop代理模式与观察者模式结合
 */
@Component
@Data
public class AopSubject {
    private int state;
}
