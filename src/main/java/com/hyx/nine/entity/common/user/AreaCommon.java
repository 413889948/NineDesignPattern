package com.hyx.nine.entity.common.user;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/15 0:04
 */
public class AreaCommon implements User {
    public AreaCommon() {
        LogUtil.info("区的贫民来了");
    }

    @Override
    public Boolean getUserPermission() {
        return false;
    }
}
