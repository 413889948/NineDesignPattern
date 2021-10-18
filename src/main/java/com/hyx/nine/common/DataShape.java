package com.hyx.nine.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: huangyx
 * @Date: 2021/10/18 16:45
 *
 */
@Data
@Accessors(chain = true)
public class DataShape implements Cloneable {

    private String id;

    @Override
    public DataShape clone() {
        try {
            return (DataShape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
