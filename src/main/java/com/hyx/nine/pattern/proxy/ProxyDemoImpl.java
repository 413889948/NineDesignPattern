package com.hyx.nine.pattern.proxy;

import com.hyx.nine.utils.LogUtil;

/**
 * @Author: huangyx
 * @Date: 2021/10/20 10:12
 * 代理方法
 */
public class ProxyDemoImpl implements ProxyService{

    @Override
    public void demo() {
        LogUtil.info("进行代理");
        // 执行被代理的方法
       new ProxyServiceImpl().demo();
        LogUtil.info("结束代理");

    }
}
