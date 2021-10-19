package com.hyx.nine.pattern.adapter;

import javax.swing.plaf.PanelUI;

/**
 * @Author: huangyx
 * @Date: 2021/10/19 9:49
 * 适配器接口类，之所以定义成接口是为了方便后续扩展，可以出现适配器适配适配器的情况（套娃~。~）
 */
public interface AdapterDemo {

    /**
     * 适配器实现接口类
     * @param key 通过该值设定要对参数进行哪种方式的适配与处理
     * @param val 入参，一般通过适配器处理后才会成为正常类入参，但是调用者无法察觉
     */
    void runDemo(String key,String val);
}
