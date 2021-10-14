package com.hyx.nine;

import com.hyx.nine.common.UserPlant;
import com.hyx.nine.entity.common.User;
import com.hyx.nine.overall.UserEnum;
import com.hyx.nine.pattern.plant.PlantDemo;
import com.hyx.nine.utils.LogUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NineDesignPatternApplicationTests {

    @Test
    void contextLoads() {

    }

    @Autowired
    private PlantDemo plantDemo;

    /**
     * 工厂模式demo
     */
    @Test
    void plantDemo() {
        plantDemo.getReturn("TWO");
        plantDemo.getReturn("ONE");
    }

    @Autowired
    private UserPlant userPlant;

    /**
     * 场景：
     * 目前已知要通过一个角色值获取该角色对象，角色对象里有该角色的详细信息
     * 需要通过这个字符串值去决定创建：市管理对象，市用户对象，区管理对象，区用户对象。
     * 根据角色权限去判断是否能够进入方法
     * 项目内有多处需要使用到该创建方式对象，用以判断用户
     */
    @Test
    void userPlantDemo() {
        User user;
        user = userPlant.getUser(UserEnum.CITY_ADMIN);
        isAdmin(user);
        user = userPlant.getUser(UserEnum.CITY_COMMON);
        isAdmin(user);
        user = userPlant.getUser(UserEnum.AREA_ADMIN);
        isAdmin(user);
        user = userPlant.getUser(UserEnum.AREA_COMMON);
        isAdmin(user);
    }

    /**
     * 判断是否是管理员，实际上是在生成的角色子类内已决定参数
     * @param user 用户类
     */
    private void isAdmin(User user) {
        if (user.getUserPermission()) {
            LogUtil.info("恭喜！是个管理员。~。~");
        } else {
            LogUtil.info("是个普通用户，行吧@。@");
        }
    }


}
