package com.hyx.nine.pattern.template;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/26 20:25
 * 模板抽象类
 */
public class TemplateTwo extends TemplateDemo {

    @Override
    public void start() {
        LogUtil.info("two开始了");
    }

    @Override
    public void end() {
        LogUtil.info("two结束了");

    }

}
