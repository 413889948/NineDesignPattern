package com.hyx.nine.pattern.shape;

import com.hyx.nine.utils.LogUtil;

/**
 * @Author: huangyx
 * @Date: 2021/10/18 15:35
 *
 */
public class ShapeSonOne extends ShapeDemo{
    public ShapeSonOne() {
        this.setName("one");
    }

    @Override
    public void every() {
        LogUtil.info(getName()+":"+getPas());
    }
}
