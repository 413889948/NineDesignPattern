package com.hyx.nine;

import com.hyx.nine.common.DataShape;
import com.hyx.nine.common.DictSingle;
import com.hyx.nine.common.DictSingleEnum;
import com.hyx.nine.common.SplitAdapter;
import com.hyx.nine.common.UserPlant;
import com.hyx.nine.entity.common.money.MoneyDecorator;
import com.hyx.nine.entity.common.money.MoneyOne;
import com.hyx.nine.entity.common.money.MoneyTwo;
import com.hyx.nine.entity.common.user.User;
import com.hyx.nine.overall.UserEnum;
import com.hyx.nine.pattern.adapter.AdapterDemo;
import com.hyx.nine.pattern.decorator.DecoratorScheme;
import com.hyx.nine.pattern.decorator.ServiceImplOne;
import com.hyx.nine.pattern.decorator.ServiceImplTwo;
import com.hyx.nine.pattern.plant.PlantDemo;
import com.hyx.nine.pattern.shape.ShapeDemo;
import com.hyx.nine.pattern.shape.ShapeSonOne;
import com.hyx.nine.pattern.shape.ShapeSonTwo;
import com.hyx.nine.pattern.single.*;
import com.hyx.nine.utils.LogUtil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    AdapterDemo adapterDemo;

    /**
     * 适配器模式demo
     * 适配器与工厂模式有点相似，但是适配器注重的是不同对象间类型的适配，而工厂模式注重的是对象的创建
     */
    @Test
    void adapterDemo() {
        adapterDemo.runDemo("one","测试测试demo");
        adapterDemo.runDemo("two","测试测试demo,第二个");
    }

    @Autowired
    SplitAdapter splitAdapter;

    /**
     * 场景：
     * 1. 目前已知有两个方法都需要用到用户名称列表参数
     *
     * 2. 提供的参数统一是List<String>格式的
     *
     * 3. 第一个方法要求入参是","隔开，第二个方法要求入参是"@"隔开
     *
     * 4. 现在要求用适配器模式提供参数给两个方法入参
     */
    @Test
    void splitAdapterDemo() {
        List<String> list = new ArrayList<>();
        list.add("测试");
        list.add("2号任务");
        list.add("9981");
        String one = splitAdapter.run("one", list);
        String two = splitAdapter.run("two", list);
        LogUtil.info(one);
        LogUtil.info(two);
    }

    /**
     * 装饰者模式demo
     * DecoratorScheme装饰者实现类对原类型实现进行装饰操作
     */
    @Test
    void decoratorDemo() {
        DecoratorScheme one = new DecoratorScheme(new ServiceImplOne());
        one.run();
        DecoratorScheme two = new DecoratorScheme(new ServiceImplTwo());
        two.run();
    }


    /**
     * 场景：
     * 1. 目前已知有几个包含金额的实体类
     *
     * 2. 需要对这些实体类内的金额进行统一处理，保留2位小数
     *
     * 3. 几个实例类的金额统一使用get方法调用
     */
    @Test
    void moneyDemo() {
        MoneyDecorator one = new MoneyDecorator(new MoneyOne());
        LogUtil.info(one.toString());
        MoneyDecorator two = new MoneyDecorator(new MoneyTwo());
        LogUtil.info(two.toString());
    }
}
