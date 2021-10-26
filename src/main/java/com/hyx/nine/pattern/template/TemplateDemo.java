package com.hyx.nine.pattern.template;

/**
 * @author hyx
 * @date 2021/10/26 20:25
 */
public abstract class TemplateDemo {
    /**
     * 模板开头
     */
    public abstract void start();

    /**
     * 模板结尾
     */
    public abstract void end();

    public void run() {
        start();
        end();
    }
}
