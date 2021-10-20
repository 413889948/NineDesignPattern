package com.hyx.nine.pattern.proxy;

import com.hyx.nine.utils.LogUtil;

import org.springframework.stereotype.Service;

/**
 * @Author: huangyx
 * @Date: 2021/10/20 10:11
 * 被代理的方法的实现
 */
@Service("proxyServiceImpl")
public class ProxyServiceImpl implements ProxyService{
    @Override
    public void demo() {
        LogUtil.info("方法执行了");
    }
}
