package com.hyx.nine.entity.common.user;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/15 0:03
 */
public class AreaAdmin implements User {

    public AreaAdmin() {
        LogUtil.info("区的管理员来查房了，垃圾收起来！");
    }

    @Override
    public Boolean getUserPermission() {
        return true;
    }
}
