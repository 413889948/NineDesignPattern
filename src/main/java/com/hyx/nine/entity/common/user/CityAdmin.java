package com.hyx.nine.entity.common.user;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/15 0:00
 */
public class CityAdmin implements User {

    public CityAdmin() {
        LogUtil.info("创建了尊贵的市管理员");
    }

    @Override
    public Boolean getUserPermission() {
        return true;
    }
}
