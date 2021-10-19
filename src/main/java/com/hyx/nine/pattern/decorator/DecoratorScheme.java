package com.hyx.nine.pattern.decorator;

import com.hyx.nine.utils.LogUtil;
import com.mysql.cj.log.Log;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 15:25
 *
 */
public class DecoratorScheme extends DecoratorDemo {

    public DecoratorScheme(ServiceDemo serviceDemo) {
        super(serviceDemo);
    }

    @Override
    public void run() {
        super.run();
        LogUtil.info("装饰者的一些其他处理");

    }
}
