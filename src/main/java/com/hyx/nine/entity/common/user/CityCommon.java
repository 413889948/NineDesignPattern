package com.hyx.nine.entity.common.user;

import com.hyx.nine.entity.common.User;
import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/15 0:02
 */
public class CityCommon implements User {
    public CityCommon() {
        LogUtil.info("接客拉，市用户一位~");
    }

    @Override
    public Boolean getUserPermission() {
        return false;
    }
}
