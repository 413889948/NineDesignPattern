package com.hyx.nine.common.aop;

import com.hyx.nine.utils.LogUtil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: huangyx
 * @Date: 2021/10/20 10:18
 * aop实现的代理模式
 */
@Component
@Aspect
public class FeedbackProxyAop {
    @Around("within(com.hyx.nine.common.FeedbackProxy)")
    public Object aopAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        if (args != null) {
            args = Arrays.stream(args).map(str -> str + "(已加工)").toArray();
        }
        LogUtil.info("进入反馈前，打上加工标识");
        // 执行
        return pjp.proceed(args);
    }
}
