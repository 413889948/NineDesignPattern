package com.hyx.nine.common;

/**
 * @author hyx
 * @date 2021/10/26 21:07
 * 模板模式，上报模板
 */
public abstract class ReportDemo {
    /**
     * 开始上报
     */
    public abstract void start();

    /**
     * 审核
     */
    public abstract void check();

    /**
     * 结束
     */
    public abstract void end();

    public void run() {
        start();
        check();
        end();
    }

}
