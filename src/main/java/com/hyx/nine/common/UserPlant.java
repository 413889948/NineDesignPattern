package com.hyx.nine.common;

import com.hyx.nine.entity.common.User;
import com.hyx.nine.entity.common.user.AreaAdmin;
import com.hyx.nine.entity.common.user.AreaCommon;
import com.hyx.nine.entity.common.user.CityAdmin;
import com.hyx.nine.entity.common.user.CityCommon;
import com.hyx.nine.overall.UserEnum;
import org.springframework.stereotype.Service;

/**
 * @author hyx
 * @date 2021/10/15 0:07
 * 工厂模式-用户工厂类
 */
@Service
public class UserPlant {
    public User getUser(UserEnum userEnum){
        if (userEnum == null){
            return null;
        }
        switch (userEnum){
            case CITY_ADMIN:
                return new CityAdmin();
            case CITY_COMMON:
                return new CityCommon();
            case AREA_ADMIN:
                return new AreaAdmin();
            case AREA_COMMON:
                return new AreaCommon();
            default:
            return null;
        }
    }
}
