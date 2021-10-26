package com.hyx.nine.common;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/26 21:09
 */
public class AreaReport extends ReportDemo {
    @Override
    public void start() {
        LogUtil.info("区级开始上报");

    }

    @Override
    public void check() {
        LogUtil.info("区级审核");

    }

    @Override
    public void end() {
        LogUtil.info("区级结束上报");

    }
}
