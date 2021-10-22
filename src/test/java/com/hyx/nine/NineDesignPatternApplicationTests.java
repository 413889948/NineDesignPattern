package com.hyx.nine;

import com.hyx.nine.common.DataShape;
import com.hyx.nine.common.DictSingle;
import com.hyx.nine.common.DictSingleEnum;
import com.hyx.nine.common.FeedbackProxy;
import com.hyx.nine.common.ObserverUserPower;
import com.hyx.nine.common.ObserverUserSex;
import com.hyx.nine.common.ObserverUserSignature;
import com.hyx.nine.common.SplitAdapter;
import com.hyx.nine.common.UserPlant;
import com.hyx.nine.common.UserSubject;
import com.hyx.nine.entity.common.money.MoneyDecorator;
import com.hyx.nine.entity.common.money.MoneyOne;
import com.hyx.nine.entity.common.money.MoneyTwo;
import com.hyx.nine.entity.common.user.User;
import com.hyx.nine.overall.UserEnum;
import com.hyx.nine.pattern.adapter.AdapterDemo;
import com.hyx.nine.pattern.decorator.DecoratorScheme;
import com.hyx.nine.pattern.decorator.ServiceImplOne;
import com.hyx.nine.pattern.decorator.ServiceImplTwo;
import com.hyx.nine.pattern.observer.AopObserver;
import com.hyx.nine.pattern.observer.AopSubject;
import com.hyx.nine.pattern.observer.ObserverOne;
import com.hyx.nine.pattern.observer.ObserverTwo;
import com.hyx.nine.pattern.observer.Subject;
import com.hyx.nine.pattern.plant.PlantDemo;
import com.hyx.nine.pattern.proxy.ProxyDemoImpl;
import com.hyx.nine.pattern.proxy.ProxyService;
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
        adapterDemo.runDemo("one", "测试测试demo");
        adapterDemo.runDemo("two", "测试测试demo,第二个");
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

    @Autowired
    ProxyService proxyService;

    /**
     * 代理模式demo，装饰者模式与代理模式结构上有点相似，但是实际上，装饰者模式通常能在运行时进行动态的对一些类进行装饰，而代理模式通常在执行时就确定了代理的对象
     * 1. 传统代理模式
     * 2. spring aop代理模式
     */
    @Test
    void proxyDemo() {
        // 普通
        ProxyService proxyDemo = new ProxyDemoImpl();
        proxyDemo.demo();
        // aop
        proxyService.demo();
    }

    @Autowired
    FeedbackProxy feedbackProxy;

    /**
     * 场景：
     * 1. 目前已知原本有一个用户反馈方法
     *
     * 2. 现需要在反馈给用户信息之前对信息与用户信息进行补充处理
     *
     * 3. 结束反馈后需进行记录
     *
     * 4. 使用spring aop方式进行代理
     */
    @Test
    void feedbackDemo() {
        feedbackProxy.feedback("入参", "出参");
    }

    @Autowired
    private AopObserver aopObserver;

    @Autowired
    private AopSubject aopSubject;
    /**
     * 观察者模式
     * 代理模式+观察者模式实现低耦合调用
     */
    @Test
    void observerDemo() {
        Subject subject = new Subject();

        // 进行绑定
        new ObserverOne(subject);
        new ObserverTwo(subject);

        System.out.println("被观察者改变状态：15");
        subject.setState(15);
        System.out.println("被观察者改变状态：10");
        subject.setState(10);
        // aop
        // 进行绑定
        new ObserverOne(aopObserver);
        new ObserverTwo(aopObserver);

        System.out.println("被观察者改变状态：22");
        aopSubject.setState(22);
        System.out.println("被观察者改变状态：11");
        aopSubject.setState(11);

    }

    /**
     * 场景：
     * 1. 目前已知当用户执行设置姓名的方法且没有默认属性的时候，需通过观察者默认给用户默认属性
     *
     * 2. 默认属性有：权限（默认：普通用户），性别（默认：保密），个性签名（默认：无）
     *
     * 3. 要求用户实际只进行了姓名设置，而观察者们进行了各个默认属性的设置，每个属性一个观察者
     */
    @Test
    void feedbackDemo2() {
        UserSubject userSubject = new UserSubject();
        new ObserverUserPower(userSubject);
        new ObserverUserSex(userSubject);
        new ObserverUserSignature(userSubject);
        userSubject.setName("测试用户");
        LogUtil.info(userSubject.toString());
    }

}
