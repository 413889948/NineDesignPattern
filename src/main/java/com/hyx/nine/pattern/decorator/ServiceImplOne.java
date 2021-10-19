package com.hyx.nine.pattern.decorator;

import com.hyx.nine.utils.LogUtil;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 15:25
 * 常规接口的第一种实现
 */
public class ServiceImplOne implements ServiceDemo{
    @Override
    public void run() {
        LogUtil.info("第一");
    }
}
