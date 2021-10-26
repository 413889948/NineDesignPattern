package com.hyx.nine.common;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/26 21:09
 */
public class CityReport extends ReportDemo {
    @Override
    public void start() {
        LogUtil.info("市级开始上报");

    }

    @Override
    public void check() {
        LogUtil.info("市级审核");

    }

    @Override
    public void end() {
        LogUtil.info("市级结束上报");

    }
}
