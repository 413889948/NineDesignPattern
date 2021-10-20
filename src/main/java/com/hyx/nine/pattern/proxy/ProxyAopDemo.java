package com.hyx.nine.pattern.proxy;

import com.hyx.nine.utils.LogUtil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: huangyx
 * @Date: 2021/10/20 10:18
 * aop实现的代理模式
 */
@Component
@Aspect
public class ProxyAopDemo {
    @Before("within(com.hyx.nine.pattern.proxy.ProxyServiceImpl)")
    public void before(JoinPoint point) {
        // 获取入参
        Object[] args = point.getArgs();
        Object target = point.getTarget();
        if (args != null) {
            LogUtil.info("入参:" + Arrays.toString(args));
        }
        LogUtil.info("开始......");
    }

    @After("within(com.hyx.nine.pattern.proxy.ProxyServiceImpl)")
    public void after(JoinPoint point) {
        // 获取入参
        Object[] args = point.getArgs();
        Object target = point.getTarget();
        if (args != null) {
            LogUtil.info("入参:" + Arrays.toString(args));
        }
        LogUtil.info("结束......");
    }
}
