package com.hyx.nine.pattern.shape;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: huangyx
 * @Date: 2021/10/18 15:18
 *
 */
@Data
@Accessors(chain = true)
public abstract class ShapeDemo implements Cloneable{

    private String name;
    private String pas;

    /**
     * 用于扩展的抽象类
     */
    public abstract void every();
    @Override
    public ShapeDemo clone() {
        try {
            return (ShapeDemo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
