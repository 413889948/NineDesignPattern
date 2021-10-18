package com.hyx.nine;

import com.hyx.nine.common.DataShape;
import com.hyx.nine.common.DictSingle;
import com.hyx.nine.common.DictSingleEnum;
import com.hyx.nine.common.UserPlant;
import com.hyx.nine.entity.common.User;
import com.hyx.nine.overall.UserEnum;
import com.hyx.nine.pattern.plant.PlantDemo;
import com.hyx.nine.pattern.shape.ShapeDemo;
import com.hyx.nine.pattern.shape.ShapeSonOne;
import com.hyx.nine.pattern.shape.ShapeSonTwo;
import com.hyx.nine.pattern.single.*;
import com.hyx.nine.utils.LogUtil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

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
     *
     * @param user 用户类
     */
    private void isAdmin(User user) {
        if (user.getUserPermission()) {
            LogUtil.info("恭喜！是个管理员。~。~");
        } else {
            LogUtil.info("是个普通用户，行吧@。@");
        }
    }


    /**
     * 单例模式demo
     */
    @Test
    void singleDemo() {
        Lazy lazy = Lazy.getLazy();
        Starve starve = Starve.getStarve();
        DoubleChecked doubleChecked = DoubleChecked.getDoubleChecked();
        Static instance = Static.getInstance();
        LogUtil.info(EnumSingle.ENUM.name());

    }

    /**
     * 场景：
     * 1. 目前已知需获取多个字典表数据（字典表数据在程序运行期间一般不变）
     *
     * 2. 全局项目皆可调用，且需线程安全
     *
     * 3. 普通模式创建会出现重复io问题
     *
     * 4. 进行普通单例类设计，与枚举类设计
     */
    @Test
    void dictSingleDemo() {
        DictSingle.getDictSingle("DM_DW");
        DictSingle.getDictSingle("DM_DD");

        DictSingleEnum.getDictSingle("DM_DW");
        DictSingleEnum.getDictSingle("DM_DD");
    }

    /**
     * 原型模式demo
     */
    @Test
    void shapeDemo() {
        Map<String, ShapeDemo> map = new HashMap<>();
        map.put("one", new ShapeSonOne().setPas("111111"));
        map.put("two", new ShapeSonTwo().setPas("222222"));
        map.get("one").clone().setPas("999").every();
        map.get("one").clone().every();
        map.get("two").clone().every();
    }

    /**
     * 场景：
     * 1. 目前已知有一个业务需要获取数据库数据
     *
     * 2. 且多处都要获取该对象进行自定义数据定制
     *
     * 3. 暂不考虑内部嵌对象需要进行深克隆的情况
     */
    @Test
    void dataShapeDemo() {
        // 代表从数据库获取出来数据注入的对象
        DataShape dataShape = new DataShape();
        // 定制化
        DataShape cloneOne = dataShape.clone().setId("1");
        DataShape cloneTwo = dataShape.clone().setId("2");
        LogUtil.info(cloneOne.toString());
        LogUtil.info(cloneTwo.toString());
    }

}
