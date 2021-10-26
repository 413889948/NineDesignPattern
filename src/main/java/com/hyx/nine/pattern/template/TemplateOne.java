package com.hyx.nine.pattern.template;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/26 20:25
 */
public class TemplateOne extends TemplateDemo {


    @Override
    public void start() {
        LogUtil.info("one开始了");
    }

    @Override
    public void end() {
        LogUtil.info("one结束了");

    }
}
